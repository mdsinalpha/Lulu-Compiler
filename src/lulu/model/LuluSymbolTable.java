package lulu.model;

import lulu.model.types.LuluFunctionType;
import lulu.model.types.LuluType;
import org.antlr.v4.runtime.misc.MultiMap;

/**
 *
 * @author mdsinalpha
 */
public class LuluSymbolTable{
      
   private final String tag;
   private final MultiMap<String, LuluType> table;
   private final LuluSymbolTable parent;
   
   public LuluSymbolTable(String tag){
       this(tag ,null);
   }
   
   public LuluSymbolTable(String tag, LuluSymbolTable parent){
       this.tag = tag;
       table = new MultiMap<>();
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
           return table.get(id).get(0);
       if(parent!=null)
           return parent.resolve(id);
       return null;
   }
    
   public LuluFunctionType resolvef(String id, LuluFunctionType type){
       if(table.containsKey(id))
           for(LuluType function:table.get(id))
               if(function instanceof LuluFunctionType)
                   if(function.equals(type))
                       return (LuluFunctionType) function;
       if(parent!=null)
           return parent.resolvef(id, type);
       return null;
   }
     
   public void define(String id, LuluType type){
       table.map(id, type);
   }
    
}