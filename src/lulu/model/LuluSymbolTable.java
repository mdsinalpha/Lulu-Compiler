package lulu.model;


import java.util.HashMap;
import java.util.Map;
import lulu.model.types.LuluType;

/**
 *
 * @author mdsinalpha
 */
public class LuluSymbolTable{
      
   private final String tag;
   private final Map<String, LuluType> table;
   private final LuluSymbolTable parent;
   
   public LuluSymbolTable(String tag){
       this(tag ,null);
   }
   
   public LuluSymbolTable(String tag, LuluSymbolTable parent){
       this.tag = tag;
       table = new HashMap<>();
       this.parent = parent;
   }
   
   public String getTag(){
       return tag;
   }
   
   public LuluSymbolTable getParent(){
       return parent;
   }
    
   public LuluType resolve(String id){
       if(table.containsKey(id))
           return table.get(id);
       if(parent!=null)
           return parent.resolve(id);
       return null;
   }
   
   public void define(String id, LuluType type){
       table.put(id, type);
   }
    
}
