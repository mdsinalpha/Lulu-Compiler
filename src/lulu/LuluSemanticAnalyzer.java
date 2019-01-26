package lulu;

import java.util.*;

import lulu.model.LuluSymbolTable;
import lulu.model.types.LuluArrayType;
import lulu.model.types.LuluFunctionType;
import lulu.model.types.LuluObjectType;
import lulu.model.types.LuluPrimitiveType;
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
    
    //public Map<String, ArrayList<String>> codeMap;
    
    public Map<Integer, LuluObjectType> typeMap;
    
    public ArrayList<LuluError> errorList;
    
    private final ParseTreeProperty<LuluSymbolTable> scopes;
    private LuluSymbolTable currentScope;
    private LuluSymbolTable currentTypeScope;
     
    private LuluLableGenerator lableGenerator;
    //private LuluLableGenerator variableGenerator;
    
    private final ParseTreeProperty<Object> values;
    private final ParseTreeProperty<Integer> types;
    //private ParseTreeProperty<String> variables;
    
    public static final String GLOBAL_TAG = "main";
    public static final String MAIN_TAG = "start";
    
    
    public LuluSemanticAnalyzer(){
        //codeMap = new OrderedHashMap<>();
            
        typeMap = new HashMap<>();
        
        errorList = new ArrayList<>();
        
        scopes = new ParseTreeProperty<>();
        
        lableGenerator = new LuluLableGenerator("L");
        //variableGenerator = new LuluLableGenerator("T");    
        
        values = new ParseTreeProperty<>();
        types = new ParseTreeProperty<>();
        //variables = new ParseTreeProperty<>();
    }
     
    /*
    private void generateCode(String tCode){
        codeMap.get(currentScope.getTag()).add(tCode);
    }*/
    
    private void error(String message, Token token){
        // Adding an error with it's occurence position inside list of compile errors:
        errorList.add(new LuluError(message, token.getLine(), token.getStartIndex(), token.getStopIndex()));
    }
    
    private void saveScope(ParserRuleContext ctx, LuluSymbolTable scope){
        // Entering an scope.
        currentScope = scope;
        scopes.put(ctx, currentScope);
        //codeMap.put(currentScope.getTag(), new ArrayList<>());
    }
    
    private void releaseScope(){
        // Exiting an scope.
        currentScope = currentScope.getParent();
    }
        
    @Override
    public void enterProgram(LuluParser.ProgramContext ctx){
        // Program needs a root scope for globals:
        saveScope(ctx, new LuluSymbolTable(GLOBAL_TAG));
        // Type 'object' is reserved by Lulu compiler:)
        LuluObjectType object = new LuluObjectType(LuluTypeSystem.OBJECT_TAG);
        currentScope.define(LuluTypeSystem.OBJECT_TAG, object);
        typeMap.put(LuluTypeSystem.OBJECT, object);
    }
    
    @Override
    public void exitProgram(LuluParser.ProgramContext ctx){
        //DONE @hashemi Check if all types are defined.
        if(currentScope.hasUndefinedFields()){
            error("Undefined fields inside declare block.", ctx.getStop());
        }
        //DONE @hashemi Check wether start function is defined.
        ArrayList<LuluType> out = new ArrayList<>();
        out.add(new LuluPrimitiveType(LuluType.aModifier.public_, false, LuluParser.INT_CONST));
        LuluFunctionType start = new LuluFunctionType(LuluType.aModifier.public_,
                false, new ArrayList<>(), out);
        LuluType tType = currentScope.resolvef(MAIN_TAG, start);
        if(tType == null){
            error("Expecting start function definition.", ctx.getStop());
            return;
        }
        releaseScope();
    }

    @Override
    public void exitFunc_dcl(LuluParser.Func_dclContext ctx){
        //TODO @pooriazmn
    }
    
    @Override
    public void exitType_dcl(LuluParser.Type_dclContext ctx){
        Token t = ctx.ID().getSymbol();
        LuluType tType = currentScope.resolve(t.getText());
        if(tType != null && tType instanceof LuluObjectType){
            // This type is declared once!
            error(String.format("Type %s already declared.", t.getText()), t);
            return;
        }
        else if(tType != null){
            // This ID is taken by a variable!
            error(String.format("Type name %s is already taken by a variable.", t.getText()), t);
        }
        // Declare a new type with given ID:
        LuluObjectType tObject = new LuluObjectType(t.getText());
        currentScope.define(t.getText(), tObject);
        typeMap.put(tObject.getTypeCode(), tObject);
    }
    
    @Override
    public void exitVar_def(LuluParser.Var_defContext ctx){
        //TODO @hashemi
    }
    
    
    @Override 
    public void enterType_def(LuluParser.Type_defContext ctx){
        Token t = ctx.ID(0).getSymbol();
        LuluType tType = currentScope.resolve(t.getText());
        LuluObjectType tObject;
        if(tType == null){
            // This type is not declared but also only defined!
            tObject = new LuluObjectType(t.getText());
            currentScope.define(t.getText(), tObject);
            typeMap.put(tObject.getTypeCode(), tObject);
        } else if(!(tType instanceof LuluObjectType)){
            // This ID is taken by a variable!
            error(String.format("Type name %s is already taken by a variable.", t.getText()), t);
            return;
        }
        else tObject = (LuluObjectType) tType;
        if(tObject.isDefined()){
            // This type is defined once!
            error(String.format("Type %s already defined.", t.getText()), t);
            return;
        }
        if(ctx.ID(1)==null){
            // There is no super class definition for this definition:)
            LuluSymbolTable tData = new LuluSymbolTable(t.getText(), currentScope);
            tObject.setData(tData);
            tObject.define();
            currentTypeScope = tData;
            saveScope(ctx, tData);
            return;
        }
        Token s = ctx.ID(1).getSymbol();
        LuluType sType = currentScope.resolve(s.getText());
        if(sType == null){
            // Super type not found!
            error(String.format("Type %s not declared.", s.getText()), s);
            return;
        }
        else if(!(sType instanceof LuluObjectType)){
            // This ID is taken by a variable!
            error(String.format("Type name %s is already taken by a variable.", s.getText()), s);
            return;
        }
        // Finally, this type should inherit another type!
        tObject.setSuperTag(s.getText());
        LuluSymbolTable tData = new LuluSymbolTable(t.getText(), (LuluSymbolTable) currentScope.resolve(s.getText()).getData());
        tObject.setData(tData);
        tObject.define();
        currentTypeScope = tData;
        saveScope(ctx, tData);
    }
    
    @Override
    public void exitType_def(LuluParser.Type_defContext ctx){
        releaseScope();
        currentTypeScope = null;
    }
    
    
    @Override
    public void enterBlock(LuluParser.BlockContext ctx){
        //TODO @hashemi check skip saving scope for if for and function 
        saveScope(ctx, new LuluSymbolTable(lableGenerator.getNextLable(), currentScope));
    }
    
    @Override
    public void exitBlock(LuluParser.BlockContext ctx){
        releaseScope();
    }

    @Override
    public void exitPARENTHESES(LuluParser.PARENTHESESContext ctx){
        types.put(ctx, types.get(ctx.expr()));
    }
    
    
    @Override
    public void exitCONST(LuluParser.CONSTContext ctx){
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
        Integer rType = LuluTypeSystem.type(types.get(ctx.expr(0)), 
                types.get(ctx.expr(1)), operation.getType());
        if(rType==LuluTypeSystem.UNDEFINED){
                error(String.format("Incompatible types on operation %s.",
                        operation.getText()), operation);
                return;
        }
        types.put(ctx, rType);
    }

    @Override
    public void exitARIT_P2(LuluParser.ARIT_P2Context ctx){
        Token operation = ctx.ARIT_P2().getSymbol();
        Integer rType = LuluTypeSystem.type(types.get(ctx.expr(0)), 
                types.get(ctx.expr(1)), operation.getType());
        if(rType==LuluTypeSystem.UNDEFINED){
            error(String.format("Incompatible types on operation %s.",
                    operation.getText()), operation);
            return;
        }
        types.put(ctx, rType);
    }

    @Override
    public void exitMINUS(LuluParser.MINUSContext ctx){
        Token operation = ctx.MINUS().getSymbol();
        int expr_count = ctx.expr().size();
        Integer rType;
        if (expr_count == 1){
            rType = LuluTypeSystem.type(types.get(ctx.expr(0)), operation.getType());
        }else {
            rType = LuluTypeSystem.type(types.get(ctx.expr(0)), types.get(ctx.expr(1)),
                    operation.getType());
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
        LuluType tType = currentScope.resolve(t.getText());
        if(tType == null || !(tType instanceof LuluObjectType)){
            error(String.format("Type %s not declared.", t.getText()), t);
            return;
        }
        types.put(ctx, tType.getTypeCode());
    }
    
    @Override
    public void exitRef(LuluParser.RefContext ctx){
        //TODO Int error checking
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
       //TODO @hashemi
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
           if(currentTypeScope==null||
                   ((LuluObjectType)currentScope.resolve(currentTypeScope.getTag())).getSuperTag().equals(LuluTypeSystem.OBJECT_TAG)){
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
