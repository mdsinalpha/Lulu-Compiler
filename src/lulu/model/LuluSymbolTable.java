package lulu.model;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lulu.model.types.LuluFunctionType;
import lulu.model.types.LuluType;
import org.antlr.v4.runtime.misc.MultiMap;

/**
 *
 * @author mdsinalpha
 */
public class LuluSymbolTable{
      
   private final String tag;
   private final Map<String, LuluType> table;
   private final MultiMap<String, LuluFunctionType> ftable;
   private final LuluSymbolTable parent;
   
   public LuluSymbolTable(String tag){
       this(tag ,null);
   }
   
   public LuluSymbolTable(String tag, LuluSymbolTable parent){
       this.tag = tag;
       table = new HashMap<>();
       ftable = new MultiMap<>();
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
   
   public List<LuluFunctionType> resolvef(String id){
       if(ftable.containsKey(id))
           return ftable.get(id);
       if(parent!=null)
           return parent.resolvef(id);
       return null;
   }
   
   public void define(String id, LuluType type){
       table.put(id, type);
   }
   
   public void definef(String id, LuluFunctionType function){
       ftable.map(id, function);
   }
    
}