package lulu;

import java.util.*;

import lulu.model.LuluSymbolTable;
import lulu.model.types.LuluObjectType;
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
    
    public Map<String, ArrayList<String>> code;
    
    public Map<String, LuluObjectType> typeMap; 
    
    public ArrayList<LuluError> error;
    
    private ParseTreeProperty<LuluSymbolTable> scopes;
    private Map<String, LuluSymbolTable> typeScopes;
    private LuluSymbolTable currentScope;
     
    private LuluLableGenerator lableG;
    private LuluLableGenerator varG;
    
    private ParseTreeProperty<Object> values;
    private ParseTreeProperty<Integer> types;
    private ParseTreeProperty<String> lables;
    
    
    public LuluSemanticAnalyzer(){
        code = new OrderedHashMap<>();
        
        typeMap = new HashMap<>();
        typeMap.put("object", new LuluObjectType("object"));
        
        error = new ArrayList<>();
        
        scopes = new ParseTreeProperty<>();
        typeScopes = new HashMap<>();
        currentScope = null;
        
        lableG = new LuluLableGenerator("L");
        varG = new LuluLableGenerator("T");    
        
        values = new ParseTreeProperty<>();
        lables = new ParseTreeProperty<>();
        types = new ParseTreeProperty<>();
    }
       
    private void generateCode(String tCode){
        code.get(currentScope.getTag()).add(tCode);
    }
    
    private void error(String message, Token token){
        error.add(new LuluError(message, token.getLine()));
    }
    
    private void saveScope(ParserRuleContext ctx, LuluSymbolTable scope){
        currentScope = scope;
        scopes.put(ctx, currentScope);
        code.put(currentScope.getTag(), new ArrayList<>());
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
        if(typeMap.containsKey(t.getText())){
            error(String.format("Type %s already declared.", t.getText()), t);
            return;
        }
        typeMap.put(t.getText(), new LuluObjectType(t.getText()));
    }
    
    @Override
    public void exitVar_def(LuluParser.Var_defContext ctx){
        
        //TODO @hashemi
    }
    
    
    @Override 
    public void enterType_def(LuluParser.Type_defContext ctx){
        Token t = ctx.ID(0).getSymbol();
        if(!typeMap.containsKey(t.getText())){
            error(String.format("Type %s not declared.", t.getText()), t);
            return;
        }
        LuluObjectType tObject = typeMap.get(t.getText());
        if(tObject.isDefined()){
            error(String.format("Type %s already defined.", t.getText()), t);
            return;
        }
        if(ctx.ID(1)==null){
            tObject.define();
            LuluSymbolTable tType = new LuluSymbolTable(t.getText(), currentScope);
            typeScopes.put(t.getText(), tType);
            saveScope(ctx, tType);
            return;
        }
        //@TODO Ambiguity
        Token s = ctx.ID(1).getSymbol();
        if(!typeMap.containsKey(s.getText())){
            error(String.format("Type %s not declared.", s.getText()), s);
            return;
        }
        tObject.setSuperTag(s.getText());
        tObject.define();
        LuluSymbolTable tType = new LuluSymbolTable(t.getText(), typeScopes.get(s.getText()));
        typeScopes.put(t.getText(), tType);
        saveScope(ctx, tType);
    }
    
    @Override
    public void exitType_def(LuluParser.Type_defContext ctx){
        releaseScope();
    }
    
    
    @Override
    public void enterBlock(LuluParser.BlockContext ctx){
        saveScope(ctx, new LuluSymbolTable(lableG.getNextLable(), currentScope));
    }
    
    @Override
    public void exitBlock(LuluParser.BlockContext ctx){
        releaseScope();
    }
    
    @Override
    public void exitCONST(LuluParser.CONSTContext ctx){
        lables.put(ctx, lables.get(ctx.const_val()));
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
        String variable = varG.getNextLable();
        generateCode(String.format("%s = %s %s %s", variable, lables.get(ctx.expr(0)), 
                ctx.ARIT_P1().getText(), lables.get(ctx.expr(1))));
        lables.put(ctx, variable);
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
        String var = varG.getNextLable();
        generateCode(String.format("%s = %s %s %s", var, lables.get(ctx.expr(0)),
                ctx.ARIT_P2().getText(), lables.get(ctx.expr(1))));
        lables.put(ctx, var);
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
        if(!typeMap.containsKey(t.getText())){
            error(String.format("Type %s not declared.", t.getText()), t);
            return;
        }
        types.put(ctx, typeMap.get(t.getText()).getTypeCode());
    }

}
