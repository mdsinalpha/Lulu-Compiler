package lulu;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import lulu.model.LuluSymbolTable;
import lulu.model.types.LuluObjectType;
import lulu.model.types.LuluType;
import lulu.parser.LuluBaseListener;
import lulu.parser.LuluParser;
import lulu.util.LuluException;
import lulu.util.LuluLableGenerator;
import lulu.util.LuluTypeSystem;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 *
 * @author mdsinalpha
 */
public class LuluSemanticAnalyzer extends LuluBaseListener {
    
    public Map<String, ArrayList<String>> code;
    
    public Set<String> typeDeclare;
    public Map<String, LuluType> type; 
    
    public ArrayList<LuluException> error;
    
    private ParseTreeProperty<LuluSymbolTable> scopes;
    private Map<String, LuluSymbolTable> typeScopes;
    private LuluSymbolTable currentScope;
     
    private LuluLableGenerator lable;
    private LuluLableGenerator var;
    
    private ParseTreeProperty<String> lables;
    private ParseTreeProperty<Integer> types;
    
   

   
    
    public LuluSemanticAnalyzer(){
        code = new HashMap<>();
        
        typeDeclare = new HashSet<>();
        type = new HashMap<>();
        
        error = new ArrayList<>();
        
        scopes = new ParseTreeProperty<>();
        typeScopes = new HashMap<>();
        
        lable = new LuluLableGenerator("L");
        var = new LuluLableGenerator("T");    
        
        lables = new ParseTreeProperty<>();
        types = new ParseTreeProperty<>();
        
            
    }
    
    @Override
    public void enterProgram(LuluParser.ProgramContext ctx){
        LuluSymbolTable main = new LuluSymbolTable("main");
        scopes.put(ctx, main);
        currentScope = main;
        code.put(currentScope.getTag(), new ArrayList<>());
    }
    
    @Override
    public void exitFunc_dcl(LuluParser.Func_dclContext ctx){
        //TODO @pooriazmn
    }
    
    @Override
    public void exitType_dcl(LuluParser.Type_dclContext ctx){
        Token t = ctx.ID().getSymbol();
        if(typeDeclare.contains(t.getText())){
            error.add(new LuluException(String.format("Type %s already declared.", t.getText()), t.getLine()));
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
            error.add(new LuluException(String.format("Type %s not declared.", t.getText()), t.getLine()));
            return;
        }
        if(type.containsKey(t.getText())){
            error.add(new LuluException(String.format("Type %s already defined.", t.getText()), t.getLine()));
            return;
        }
        if(ctx.ID(1)==null){
            type.put(t.getText(), new LuluObjectType(t.getText()));
            LuluSymbolTable type = new LuluSymbolTable(t.getText(), currentScope);
            scopes.put(ctx, type);
            typeScopes.put(t.getText(), type);
            currentScope = type;
            return;
        }
        //Ambiguity
        Token s = ctx.ID(1).getSymbol();
        if(!typeDeclare.contains(s.getText())){
            error.add(new LuluException(String.format("Type %s not declared.", s.getText()), s.getLine()));
            return;
        }
        if(!type.containsKey(s.getText())){
            error.add(new LuluException(String.format("Type %s not defined.", s.getText()), s.getLine()));
            return;
        }
        type.put(t.getText(), new LuluObjectType(type.get(s.getText()).getTypeCode(), t.getText()));
        LuluSymbolTable type = new LuluSymbolTable(t.getText(), typeScopes.get(s.getText()));
        scopes.put(ctx, type);
        typeScopes.put(t.getText(), type);
        currentScope = type;
    }
    
    @Override
    public void exitType_def(LuluParser.Type_defContext ctx){
        currentScope = currentScope.getParent();
    }
    
    
    @Override
    public void enterBlock(LuluParser.BlockContext ctx){
        LuluSymbolTable block = new LuluSymbolTable(lable.getNextLable(), currentScope);
        scopes.put(ctx, block);
        currentScope = block;
        code.put(currentScope.getTag(), new ArrayList<>());
    }
    
    @Override
    public void exitBlock(LuluParser.BlockContext ctx){
        currentScope = currentScope.getParent();
    }
    
    @Override 
    public void exitINT(LuluParser.INTContext ctx){
        String variable = var.getNextLable();
        code.get(currentScope.getTag()).add(String.format("%s = %s", variable, ctx.INT_CONST().getText()));
        lables.put(ctx, variable);
        types.put(ctx, ctx.INT_CONST().getSymbol().getType());
    }
    
    @Override
    public void exitCONST(LuluParser.CONSTContext ctx){
        lables.put(ctx, lables.get(ctx.const_val()));
        types.put(ctx, types.get(ctx.const_val()));
    }
    
    @Override 
    public void exitARIT_P1(LuluParser.ARIT_P1Context ctx){
        Integer type = LuluTypeSystem.type(types.get(ctx.expr(0)), types.get(ctx.expr(1)), 
                ctx.ARIT_P1().getSymbol().getType());
        if(type==LuluTypeSystem.UNDEFINED)
                System.out.println("Error!"); //TODO throw exception
        
        String variable = var.getNextLable();
        code.get(currentScope.getTag()).add(String.format("%s = %s %s %s", variable, lables.get(ctx.expr(0)), 
                ctx.ARIT_P1().getText(), lables.get(ctx.expr(1))));
        lables.put(ctx, variable);
        types.put(ctx, type);
    }
    

}
