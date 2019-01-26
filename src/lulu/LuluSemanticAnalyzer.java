package lulu;

import java.util.*;

import lulu.model.LuluSymbolTable;
import lulu.model.types.LuluArrayType;
import lulu.model.types.LuluObjectType;
import lulu.model.types.LuluType;
import lulu.parser.LuluBaseListener;
import lulu.parser.LuluLexer;
import lulu.parser.LuluParser;
import lulu.util.LuluError;
import lulu.util.LuluLableGenerator;
import lulu.util.LuluTypeSystem;
import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 *
 * @author mdsinalpha
 */
public class LuluSemanticAnalyzer extends LuluBaseListener {
    
    public Map<String, ArrayList<String>> codeMap;
    
    public Map<String, LuluObjectType> typeMapS; 
    public Map<Integer, LuluObjectType> typeMapI;
    
    public ArrayList<LuluError> errorList;
    
    private ParseTreeProperty<LuluSymbolTable> scopes;
    private LuluSymbolTable currentScope;
    private LuluSymbolTable currentTypeScope;
     
    private LuluLableGenerator lableGenerator;
    private LuluLableGenerator variableGenerator;
    
    private ParseTreeProperty<Object> values;
    private ParseTreeProperty<Integer> types;
    private ParseTreeProperty<String> variables;
    
    
    public LuluSemanticAnalyzer(){
        codeMap = new OrderedHashMap<>();
        
        typeMapS = new HashMap<>();
        typeMapI = new HashMap<>();
        LuluObjectType object = new LuluObjectType(LuluTypeSystem.OBJECT_TAG);
        typeMapS.put(LuluTypeSystem.OBJECT_TAG, object);
        typeMapI.put(LuluTypeSystem.OBJECT, object);
        
        errorList = new ArrayList<>();
        
        scopes = new ParseTreeProperty<>();
        
        lableGenerator = new LuluLableGenerator("L");
        variableGenerator = new LuluLableGenerator("T");    
        
        values = new ParseTreeProperty<>();
        variables = new ParseTreeProperty<>();
        types = new ParseTreeProperty<>();
    }
       
    private void generateCode(String tCode){
        codeMap.get(currentScope.getTag()).add(tCode);
    }
    
    private void error(String message, Token token){
        errorList.add(new LuluError(message, token.getLine()));
    }
    
    private void saveScope(ParserRuleContext ctx, LuluSymbolTable scope){
        currentScope = scope;
        scopes.put(ctx, currentScope);
        codeMap.put(currentScope.getTag(), new ArrayList<>());
    }
    
    private void releaseScope(){
        currentScope = currentScope.getParent();
    }
        
   
    @Override
    public void enterProgram(LuluParser.ProgramContext ctx){
        saveScope(ctx, new LuluSymbolTable("main"));
    }
    
    @Override
    public void exitProgram(LuluParser.ProgramContext ctx){
        releaseScope();
        //TODO Check if all types are defined.
    }

    @Override
    public void exitFunc_dcl(LuluParser.Func_dclContext ctx){
        List<LuluParser.ArgsContext> args = ctx.args();

        //TODO @pooriazmn
    }
    
    @Override
    public void exitType_dcl(LuluParser.Type_dclContext ctx){
        Token t = ctx.ID().getSymbol();
        if(typeMapS.containsKey(t.getText())){
            error(String.format("Type %s already declared.", t.getText()), t);
            return;
        }
        LuluObjectType object = new LuluObjectType(t.getText());
        typeMapS.put(t.getText(), object);
        typeMapI.put(object.getTypeCode(), object);
    }
    
    @Override
    public void exitVar_def(LuluParser.Var_defContext ctx){
        
        //TODO @hashemi
    }
    
    
    @Override 
    public void enterType_def(LuluParser.Type_defContext ctx){
        Token t = ctx.ID(0).getSymbol();
        if(!typeMapS.containsKey(t.getText())){
            error(String.format("Type %s not declared.", t.getText()), t);
            return;
        }
        LuluObjectType tObject = typeMapS.get(t.getText());
        if(tObject.isDefined()){
            error(String.format("Type %s already defined.", t.getText()), t);
            return;
        }
        if(ctx.ID(1)==null){
            LuluSymbolTable tType = new LuluSymbolTable(t.getText(), currentScope);
            tObject.setData(tType);
            tObject.define();
            currentTypeScope = tType;
            saveScope(ctx, tType);
            return;
        }
        Token s = ctx.ID(1).getSymbol();
        if(!typeMapS.containsKey(s.getText())){
            error(String.format("Type %s not declared.", s.getText()), s);
            return;
        }
        tObject.setSuperTag(s.getText());
        LuluSymbolTable tType = new LuluSymbolTable(t.getText(), (LuluSymbolTable) typeMapS.get(s.getText()).getData());
        tObject.setData(t);
        tObject.define();
        currentTypeScope = tType;
        saveScope(ctx, tType);
    }
    
    @Override
    public void exitType_def(LuluParser.Type_defContext ctx){
        releaseScope();
        currentTypeScope = null;
    }
    
    
    @Override
    public void enterBlock(LuluParser.BlockContext ctx){
        saveScope(ctx, new LuluSymbolTable(lableGenerator.getNextLable(), currentScope));
    }

    @Override
    public void exitPARENTHESES(LuluParser.PARENTHESESContext ctx){
        variables.put(ctx, variables.get(ctx.expr()));
        types.put(ctx, types.get(ctx.expr()));
    }
    
    @Override
    public void exitBlock(LuluParser.BlockContext ctx){
        releaseScope();
    }
    
    @Override
    public void exitCONST(LuluParser.CONSTContext ctx){
        String variable = variableGenerator.getNextLable();
        generateCode(String.format("%s = %s", variable, values.get(ctx.const_val())));
        variables.put(ctx, variable);
        types.put(ctx, types.get(ctx.const_val()));
    }
    
    @Override 
    public void exitINT(LuluParser.INTContext ctx){
        String text = ctx.INT_CONST().getText();
        Integer value;
        if(text.length()>2&&text.substring(0, 2).toLowerCase().equals("0x"))
            value = Integer.parseInt(text.substring(2), 16);
        else value = Integer.parseInt(text);
        values.put(ctx, value);
        types.put(ctx, LuluLexer.INT_CONST);
    }
    
    @Override
    public void exitREAL(LuluParser.REALContext ctx){
        //TODO @mdsinalpha Implement hex real
        values.put(ctx, Double.parseDouble(ctx.REAL_CONST().getText()));
        types.put(ctx, LuluLexer.REAL_CONST);
    }
    
    @Override
    public void exitBOOL(LuluParser.BOOLContext ctx){
        values.put(ctx, ctx.BOOL_CONST().getText().equals("true"));
        types.put(ctx, LuluParser.BOOL_CONST);  
    }
    
    @Override
    public void exitSTRING(LuluParser.STRINGContext ctx){
        values.put(ctx, ctx.STRING_CONST().getText());
        types.put(ctx, LuluParser.STRING_CONST);
    }
    
    @Override 
    public void exitARIT_P1(LuluParser.ARIT_P1Context ctx){
        Token operation = ctx.ARIT_P1().getSymbol();
        Integer rType = LuluTypeSystem.type(types.get(ctx.expr(0)), types.get(ctx.expr(1)), operation.getType());
        if(rType==LuluTypeSystem.UNDEFINED){
                error(String.format("Incompatible types on operation %s.", operation.getText()), operation);
                return;
        }
        String variable = variableGenerator.getNextLable();
        generateCode(String.format("%s = %s %s %s", variable, variables.get(ctx.expr(0)), 
                ctx.ARIT_P1().getText(), variables.get(ctx.expr(1))));
        variables.put(ctx, variable);
        types.put(ctx, rType);
    }

    @Override
    public void exitARIT_P2(LuluParser.ARIT_P2Context ctx){
        Token operation = ctx.ARIT_P2().getSymbol();
        Integer rType = LuluTypeSystem.type(types.get(ctx.expr(0)), types.get(ctx.expr(1)), operation.getType());
        if(rType==LuluTypeSystem.UNDEFINED){
            error(String.format("Incompatible types on operation %s.", operation.getText()), operation);
            return;
        }
        String var = variableGenerator.getNextLable();
        generateCode(String.format("%s = %s %s %s", var, variables.get(ctx.expr(0)),
                ctx.ARIT_P2().getText(), variables.get(ctx.expr(1))));
        variables.put(ctx, var);
        types.put(ctx, rType);
    }

    @Override
    public void exitMINUS(LuluParser.MINUSContext ctx){
        Token operation = ctx.MINUS().getSymbol();
        int expr_count = ctx.expr().size();
        Integer rType;
        if (expr_count == 1){
            rType = LuluTypeSystem.type(types.get(ctx.expr(0)), operation.getType());
            String var = variableGenerator.getNextLable();
            generateCode(String.format("%s = %s %s", var, operation.getText(), variables.get(ctx.expr(0))));
            variables.put(ctx, var);
        }else {
            rType = LuluTypeSystem.type(types.get(ctx.expr(0)), types.get(ctx.expr(1)), operation.getType());
            String var = variableGenerator.getNextLable();
            generateCode(String.format("%s = %s %s %s", var, variables.get(ctx.expr(0)), operation.getText(),
                    variables.get(ctx.expr(1))));
            variables.put(ctx, var);
        }
        if(rType== LuluTypeSystem.UNDEFINED) {
            error(String.format("Incompatible types on operation %s.", operation.getText()), operation);
            return;
        }
        types.put(ctx, rType);
    }
    
    @Override
    public void exitPRIM(LuluParser.PRIMContext ctx){
        Integer value = LuluTypeSystem.UNDEFINED;
        switch(ctx.PRIM_TYPE().getText()){
            case "int":
                value = LuluParser.INT_CONST;
                break;
            case "bool":
                value = LuluParser.BOOL_CONST;
                break;
            case "float":
                value = LuluParser.REAL_CONST;
                break;
            case "string":
                value = LuluParser.STRING_CONST;
        }
        types.put(ctx, value);
    }
    
    @Override
    public void exitID(LuluParser.IDContext ctx){
        Token t = ctx.ID().getSymbol();
        if(!typeMapS.containsKey(t.getText())){
            error(String.format("Type %s not declared.", t.getText()), t);
            return;
        }
        types.put(ctx, typeMapS.get(t.getText()).getTypeCode());
    }
    
    @Override
    public void exitRef(LuluParser.RefContext ctx){
        boolean hasError = false;
        for(LuluParser.ExprContext e:ctx.expr())
            if(types.get(e)==null||types.get(e)!=LuluParser.INT_CONST){
                hasError = true;
                error("Invalid array indexing.", e.getStart());
            }
        if(hasError) return;
        values.put(ctx, ctx.ID().getText());
        types.put(ctx, ctx.expr().isEmpty()?LuluTypeSystem.OBJECT:LuluTypeSystem.ARRAY);
    }
    
    @Override
    public void exitVar(LuluParser.VarContext ctx){
       LuluSymbolTable varScope = currentScope;
       Token t = ctx.getStart();
       if(t!=null&&t.getText().equals("this")){
           if(currentTypeScope==null){
               error("Unresolved refrence to keyword 'this'.", t);
               return;
           }
           varScope = currentTypeScope;
       }
       else if(t!=null&&t.getText().equals("super")){
           if(currentTypeScope==null||typeMapS.get(currentTypeScope.getTag()).getSuperTag().equals(LuluTypeSystem.OBJECT_TAG)){
               error("Unresolved refrence to keyword 'super'.", t);
               return;
           }
           varScope = currentTypeScope.getParent();
       }
       
       LuluType it = null;
       for(LuluParser.RefContext r:ctx.ref()){
           String id = values.get(r).toString();
           it = varScope.resolve(id);
           if(it==null){
               error(String.format("Undefined field %s inside type %s.", id, varScope.getTag()), r.getStart());
               return;
           }
           if(it instanceof LuluArrayType){
               
           }
           
           //varScope = typeScopes.get(((LuluObjectType)it).getTag());
       }
    }
}
