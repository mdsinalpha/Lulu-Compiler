
import java.util.ArrayList;

/**
 *
 * @author mdsinalpha
 */
public class LuluSemanticAnalyzer extends LuluBaseListener {
    
    public ArrayList<String> test;
    
    public LuluSemanticAnalyzer(){
        test = new ArrayList<>();
    }
    
    @Override 
    public void exitExpr(LuluParser.ExprContext ctx){
        try{
            if(ctx.children.size()==3){
                test.add(ctx.expr(0).const_val().INT_CONST().getText()+
                         ctx.ARIT_P1().getText()+
                         ctx.expr(1).const_val().INT_CONST().getText());
            }else test.add(ctx.const_val().REAL_CONST().getText());
        }
        catch(Exception e){
            
        }
    }
    
    
}
