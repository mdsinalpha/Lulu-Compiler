package lulu.model;

import lulu.model.types.LuluType;

/**
 *
 * @author mdsinalpha
 */
public class LuluEntry {
    
    public enum aModifier{public_, protected_, private_};
   
    private final String ID;
    private final aModifier accessModifier;
    private final Boolean isConst;
    private final LuluType type;
    
    private Object data;
    private Integer size;
    private Integer offset;
    
    public LuluEntry(String ID, aModifier accessModifier, Boolean isConst, LuluType type){
        this(ID, accessModifier, isConst, type, null, 0);
    }
   
    
    public LuluEntry(String ID, aModifier accessModifier, Boolean isConst, LuluType type,
            Object data, Integer size){
        this.ID = ID;
        this.accessModifier = accessModifier;
        this.isConst = isConst;
        this.type = type;
        this.data = data;
        this.size = size;
    }
    
    public String getID(){
        return ID;
    }
    
    public aModifier getAccessModifier(){
        return accessModifier;
    }
    
    public Boolean getIsConst(){
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
