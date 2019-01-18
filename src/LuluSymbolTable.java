
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
    
    
}
