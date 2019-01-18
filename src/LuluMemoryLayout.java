import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author mdsinalpha
 */
public class LuluMemoryLayout {
    
    public ArrayList<String> code;
    public ArrayList<Object> data;
    public int offset;
    public Stack<LuluSymbolTable> stack;
    
    public LuluMemoryLayout(){
        code = new ArrayList<>();
        data = new ArrayList<>();
        offset = 0;
        stack = new Stack<>();
    }
    
}
