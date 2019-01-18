
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mdsinalpha
 */
public class LuluSymbolTable {
   
   class Pair<T,E>{
       
       public final T first;
       public final E second;
       
       public Pair(T first, E second){
           this.first = first;
           this.second = second;
       }
   }
   
   private final Map<String, Pair<Integer, Integer> > table;
   
   public LuluSymbolTable(){
       table = new HashMap<>();
   }
   
   public boolean has(String id){
       return table.containsKey(id);
   }
   
   public Pair<Integer, Integer> get(String id){
       return table.get(id);
   }
   
   public void put(String id, Integer type, Integer offset){
       table.put(id, new Pair<>(type, offset));
   }
    
}
