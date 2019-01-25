package lulu;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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
    
    public Set<String> typeDeclare;
    public Map<String, LuluObjectType> type; 
    
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
        
        typeDeclare = new HashSet<>();
        typeDeclare.add(LuluTypeSystem.OBJECT_TAG);
        type = new HashMap<>();
        
        error = new ArrayList<>();
        
        scopes = new ParseTreeProperty<>();
        typeScopes = new HashMap<>();
        
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
    }
    
    @Override
    public void exitFunc_dcl(LuluParser.Func_dclContext ctx){
        //TODO @pooriazmn
    }
    
    @Override
    public void exitType_dcl(LuluParser.Type_dclContext ctx){
        Token t = ctx.ID().getSymbol();
        if(typeDeclare.contains(t.getText())){
            error(String.format("Type %s already declared.", t.getText()), t);
            return;
        }
        typeDeclare.add(ctx.ID().getText());
    }
    
    @Override
    public void exitVar_def(LuluParser.Var_defContext ctx){
        //TODO @hashemi
    }
    
    
    @Override 
    public void enterType_def(LuluParser.Type_defContext ctx){
        Token t = ctx.ID(0).getSymbol();
        if(!typeDeclare.contains(t.getText())){
            error(String.format("Type %s not declared.", t.getText()), t);
            return;
        }
        if(type.containsKey(t.getText())){
            error(String.format("Type %s already defined.", t.getText()), t);
            return;
        }
        if(ctx.ID(1)==null){
            type.put(t.getText(), new LuluObjectType(t.getText()));
            LuluSymbolTable tType = new LuluSymbolTable(t.getText(), currentScope);
            typeScopes.put(t.getText(), tType);
            saveScope(ctx, tType);
            return;
        }
        //Ambiguity
        Token s = ctx.ID(1).getSymbol();
        if(!typeDeclare.contains(s.getText())){
            error(String.format("Type %s not declared.", s.getText()), s);
            return;
        }
        if(!type.containsKey(s.getText())){
            error(String.format("Type %s not defined.", s.getText()), s);
            return;
        }
        type.put(t.getText(), new LuluObjectType(t.getText(), s.getText()));
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
        //TODO
        Integer value = 1;
        values.put(ctx, value);
        types.put(ctx, LuluLexer.INT_CONST);
    }
    
    @Override
    public void exitREAL(LuluParser.REALContext ctx){
        //TODO
        Double value = 1.5;
        values.put(ctx, value);
        types.put(ctx, LuluLexer.REAL_CONST);
    }
    
    @Override
    public void exitBOOL(LuluParser.BOOLContext ctx){
        values.put(ctx, ctx.BOOL_CONST().getText().equals("true"));
        types.put(ctx, LuluParser.BOOL_CONST);  
    }
    
    @Override
    public void exitSTRING(LuluParser.STRINGContext ctx){
        
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
    
}
