package lulu;


import java.util.ArrayList;
import lulu.model.LuluMemoryLayout;
import lulu.model.LuluSymbolTable;
import lulu.parser.LuluBaseListener;
import lulu.parser.LuluParser;
import lulu.util.LuluLableGenerator;
import lulu.util.LuluTypeSystem;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 *
 * @author mdsinalpha
 */
public class LuluSemanticAnalyzer extends LuluBaseListener {
    
    public LuluMemoryLayout memory;
    private ParseTreeProperty<LuluSymbolTable> scopes;
    private ParseTreeProperty<String> lables;
    private ParseTreeProperty<Integer> types;
    
    private LuluLableGenerator lable;
    private LuluLableGenerator var;
    
    private LuluSymbolTable currentScope;
    
    public LuluSemanticAnalyzer(){
        memory = new LuluMemoryLayout();
        scopes = new ParseTreeProperty<>();
        lables = new ParseTreeProperty<>();
        types = new ParseTreeProperty<>();
        
        lable = new LuluLableGenerator("L");
        var = new LuluLableGenerator("T");        
    }
    
    @Override
    public void enterProgram(LuluParser.ProgramContext ctx){
        LuluSymbolTable main = new LuluSymbolTable("main");
        scopes.put(ctx, main);
        currentScope = main;
        memory.code.put(currentScope.getTag(), new ArrayList<>());
    }
    
    @Override
    public void exitFunc_dcl(LuluParser.Func_dclContext ctx){
        //TODO @pooriazmn
    }
    
    @Override
    public void exitType_dcl(LuluParser.Type_dclContext ctx){
        //TODO @hashemi
    }
    
    @Override
    public void exitVar_def(LuluParser.Var_defContext ctx){
        //TODO @mdsinalpha
    }
    
    
    @Override
    public void enterBlock(LuluParser.BlockContext ctx){
        LuluSymbolTable block = new LuluSymbolTable(lable.getNextLable(), currentScope);
        scopes.put(ctx, block);
        currentScope = block;
        memory.code.put(currentScope.getTag(), new ArrayList<>());
    }
    
    @Override
    public void exitBlock(LuluParser.BlockContext ctx){
        currentScope = currentScope.getParent();
    }
    
    @Override 
    public void exitINT(LuluParser.INTContext ctx){
        String variable = var.getNextLable();
        memory.code.get(currentScope.getTag()).add(String.format("%s = %s", variable, ctx.INT_CONST().getText()));
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
        memory.code.get(currentScope.getTag()).add(String.format("%s = %s %s %s", variable, lables.get(ctx.expr(0)), 
                ctx.ARIT_P1().getText(), lables.get(ctx.expr(1))));
        lables.put(ctx, variable);
        types.put(ctx, type);
    }
    

}
