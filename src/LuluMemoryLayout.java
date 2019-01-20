import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.antlr.v4.misc.OrderedHashMap;

/**
 *
 * @author mdsinalpha
 */
public class LuluMemoryLayout {
    
    public Map<String, ArrayList<String>> code;
    public ArrayList<Object> data;
    public Stack<LuluSymbolTable> stack;
    public Map<String, LuluTypeData> heap;
    
    public LuluMemoryLayout(){
        code = new OrderedHashMap<>();
        data = new ArrayList<>();
        stack = new Stack<>();
        heap = new HashMap<>();
    }
    
}
