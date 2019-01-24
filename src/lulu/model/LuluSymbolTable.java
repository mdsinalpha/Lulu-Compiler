package lulu.model;


import java.util.HashMap;
import java.util.Map;
import lulu.model.types.LuluType;

/**
 *
 * @author mdsinalpha
 */
public class LuluSymbolTable{
      
   private final Map<String, LuluType> table;
   private final LuluSymbolTable parent;
   
   public LuluSymbolTable(){
       this(null);
   }
   
   public LuluSymbolTable(LuluSymbolTable parent){
       table = new HashMap<>();
       this.parent = parent;
   }
   
   public LuluSymbolTable getParent(){
       return parent;
   }
   
   public boolean find(String id){
       return table.containsKey(id);
   }
   
   public LuluType resolve(String id){
       return table.get(id);
   }
   
   public void define(String id, LuluType type){
       table.put(id, type);
   }
    
}
