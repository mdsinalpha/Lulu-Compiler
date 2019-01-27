package lulu.model;

import lulu.model.types.LuluType;

/**
 *
 * @author mdsinalpha
 */
public class LuluEntry {
    
    public enum aModifier{public_, protected_, private_};
   
    private final aModifier accessModifier;
    private final boolean isConst;
    private final LuluType type;
    
    private Object data;
    private Integer size;
    private Integer offset;
    
    public LuluEntry(aModifier accessModifier, boolean isConst, LuluType type){
        this(accessModifier, isConst, type, null, 0);
    }
   
    
    public LuluEntry(aModifier accessModifier, boolean isConst, LuluType type,
            Object data, Integer size){
        this.accessModifier = accessModifier;
        this.isConst = isConst;
        this.type = type;
        this.data = data;
        this.size = size;
    }
    
    public aModifier getAccessModifier(){
        return accessModifier;
    }
    
    public boolean isConst(){
        return isConst;
    }
    
    public LuluType getType(){
        return type;
    }
    
    public void setData(Object data){
        this.data = data;
    }
    
    public Object getData(){
        return data;
    }
    
    public void setSize(Integer size){
        this.size = size;
    }
    
    public Integer getSize(){
        return size;
    }
    
    public void setOffset(Integer offset){
        this.offset = offset;
    }
    
    public Integer getOffset(){
        return offset;
    }
    
}
