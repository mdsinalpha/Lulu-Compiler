
import java.util.ArrayList;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 *
 * @author mdsinalpha
 */
public class LuluSemanticAnalyzer extends LuluBaseListener {
    
    public LuluMemoryLayout memory;
    public ParseTreeProperty<String> values;
    
    public LuluLableGenerator lable;
    public LuluLableGenerator var;
    
    private String currentLable;
    
    public LuluSemanticAnalyzer(){
        memory = new LuluMemoryLayout();
        values = new ParseTreeProperty<>();
        
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
    }
    
    @Override
    public void exitCONST(LuluParser.CONSTContext ctx){
        values.put(ctx, values.get(ctx.const_val()));
    }
    
    @Override 
    public void exitARIT_P1(LuluParser.ARIT_P1Context ctx){
        //TODO Type Checking!
        String variable = var.getNextLable();
        memory.code.get(currentLable).add(String.format("%s = %s %s %s", variable, values.get(ctx.expr(0)), 
                ctx.ARIT_P1().getText(), values.get(ctx.expr(1))));
        values.put(ctx, variable);
    }
    

}
