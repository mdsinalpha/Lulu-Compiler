
import java.util.ArrayList;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 *
 * @author mdsinalpha
 */
public class LuluSemanticAnalyzer extends LuluBaseListener {
    
    public LuluMemoryLayout memory;
    private ParseTreeProperty<String> values;
    private ParseTreeProperty<Integer> types;
    
    private LuluLableGenerator lable;
    private LuluLableGenerator var;
    
    private String currentLable;
    
    public LuluSemanticAnalyzer(){
        memory = new LuluMemoryLayout();
        values = new ParseTreeProperty<>();
        types = new ParseTreeProperty<>();
        
        lable = new LuluLableGenerator("L");
        var = new LuluLableGenerator("T");
        
        currentLable = "main";
        memory.code.put(currentLable, new ArrayList<>());
        
    }
    
    @Override 
    public void exitINT(LuluParser.INTContext ctx){
        String variable = var.getNextLable();
        memory.code.get(currentLable).add(String.format("%s = %s", variable, ctx.INT_CONST().getText()));
        values.put(ctx, variable);
        types.put(ctx, ctx.INT_CONST().getSymbol().getType());
    }
    
    @Override
    public void exitCONST(LuluParser.CONSTContext ctx){
        values.put(ctx, values.get(ctx.const_val()));
        types.put(ctx, types.get(ctx.const_val()));
    }
    
    @Override 
    public void exitARIT_P1(LuluParser.ARIT_P1Context ctx){
        Integer type = LuluTypeSystem.type(types.get(ctx.expr(0)), types.get(ctx.expr(1)), 
                ctx.ARIT_P1().getSymbol().getType());
        if(type==LuluTypeSystem.UNDEFINED)
                System.out.println("Error!"); //TODO throw exception
        
        String variable = var.getNextLable();
        memory.code.get(currentLable).add(String.format("%s = %s %s %s", variable, values.get(ctx.expr(0)), 
                ctx.ARIT_P1().getText(), values.get(ctx.expr(1))));
        values.put(ctx, variable);
        types.put(ctx, type);
    }
    

}
