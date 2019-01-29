package lulu.model;

import lulu.LuluSemanticAnalyzer;
import lulu.model.types.LuluFunctionType;
import org.antlr.v4.runtime.misc.MultiMap;

/**
 *
 * @author mdsinalpha
 */
public class LuluSymbolTable{
    
   public enum stType{normal, type, function, conditional, loop};
      
   private final String tag;
   private final stType tableType;
   private final MultiMap<String, LuluEntry> table;
   private final LuluSymbolTable parent;
   
   private Integer offset;
   private Integer scopeSizes;
   
   public LuluSymbolTable(String tag){
       this(tag , stType.normal, LuluSemanticAnalyzer.currentScope);
   }
   
   public LuluSymbolTable(String tag, stType tableType){
       this(tag, tableType, LuluSemanticAnalyzer.currentScope);
   }
   
   public LuluSymbolTable(String tag, stType tableType, LuluSymbolTable parent){
       this.tag = tag;
       this.tableType = tableType;
       table = new MultiMap<>();
       this.parent = parent;
       offset = 0;
       scopeSizes = 0;
   }
  
   public String getTag(){
       return tag;
   }
   
   public stType getTableType(){
       return tableType;
   }
   
   public LuluSymbolTable getParent(){
       return parent;
   }
  
   public boolean has(String id){
        return table.containsKey(id) && !(table.get(id) instanceof LuluFunctionType);
   }
   
   public LuluEntry resolve(String id){
       if(table.containsKey(id))
           return table.get(id).get(0);
       if(parent!=null)
           return parent.resolve(id);
       return null;
   }
   
   public boolean hasf(String id, LuluFunctionType type){
       if(table.containsKey(id))
           if(table.get(id).stream().filter((function) -> 
                   (function.getType() instanceof LuluFunctionType)).anyMatch((function) -> 
                           (function.getType().equals(type)))) {
                return true;
       }
       return false;
   }
    
   public LuluEntry resolvef(String id, LuluFunctionType type){
       if(table.containsKey(id)){
           for(LuluEntry function:table.get(id))
                if(function.getType() instanceof LuluFunctionType){
                    if(type.convertable(function.getType()))
                        return function;
                }
       }
       if(parent!=null)
           return parent.resolvef(id, type);
       return null;
   }
     
   public void define(String id, LuluEntry entry){
       entry.setOffset(offset);
       offset += entry.getSize();
       table.map(id, entry);
   }
   
   public void increaseOffset(Integer size){
       /* Nested inside scopes sizes are needed for:
          1-Whole scope size 
          2-Increasing offset
       */
       /* TODO
       offset += size;
       scopeSizes += size;*/
   }
      
   public Integer getSize(){
        return 10 + (parent!=null&&tableType==stType.type?parent.getSize():0) + scopeSizes +
                table.values().stream().mapToInt(a -> a.stream().mapToInt(LuluEntry::getSize).sum()).sum();
   }
    
    public boolean hasUndefinedFields() {
        return table.values().stream().anyMatch((typeList) -> 
                (typeList.stream().anyMatch((type) ->
                        (!type.getType().isDefined()))));
    }
    
    public MultiMap<String, LuluEntry> getTable(){
        return table;
    }
    
    @Override
    public String toString(){
        return tag + " - " + tableType +(tableType.equals(stType.type)&&parent!=null&&
                parent.getTableType().equals(stType.type)?" : "+parent.getTag():"");
    }
   
}