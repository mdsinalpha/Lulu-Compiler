package lulu;

import java.util.ArrayList;
import java.util.Map;
import lulu.model.LuluSymbolTable;
import lulu.util.LuluLableGenerator;
import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 *
 * @author mdsinalpha
 */
public class LuluMiniatureCodeGenerator {
    
    private final LuluSemanticAnalyzer analyzer;
    
    public Map<String, ArrayList<String>> codeMap;
    
    public static LuluSymbolTable currentScope;
    
    private final LuluLableGenerator variableGenerator;
    
    private final ParseTreeProperty<String> variables;
    
     
    private void generateCode(String tCode){
        codeMap.get(currentScope.getTag()).add(tCode);
    }
    
    private void saveScope(LuluSymbolTable scope){
        // Entering an scope.
        currentScope = scope;
        codeMap.put(currentScope.getTag(), new ArrayList<>());
    }
    
    private void releaseScope(){
        // Exiting an scope.
        currentScope = currentScope.getParent();
    }
    
    
    public LuluMiniatureCodeGenerator(LuluSemanticAnalyzer analyzer){
        this.analyzer = analyzer;
        
        codeMap = new OrderedHashMap<>();
        
        variableGenerator = new LuluLableGenerator("T");
        
        variables = new ParseTreeProperty<>();
    }
    
    public String getCode(){
        StringBuilder builder = new StringBuilder();
        codeMap.entrySet().stream().map((block) -> {
            builder.append(block.getKey()).append(" ");
            return block;
        }).forEachOrdered((block) -> {
            block.getValue().forEach((line) -> {
                builder.append(line).append("\n");
            });
        });
        return builder.toString();
    }
}
