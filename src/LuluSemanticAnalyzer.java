
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 *
 * @author mdsinalpha
 */
public class LuluSemanticAnalyzer extends LuluBaseListener {
    
    public LuluMemoryLayout memory;
    public ParseTreeProperty<Integer> values;
    
    public LuluSemanticAnalyzer(){
        memory = new LuluMemoryLayout();
        values = new ParseTreeProperty<>();
    }

}
