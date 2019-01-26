package lulu.model.types;

/**
 *
 * @author mdsinalpha
 */
public abstract class LuluType {
    
    public enum aModifier{public_, protected_, private_};
   
    protected final aModifier accessModifier;
    protected final boolean isConst;
    
    protected Object data;
    protected Integer offset;
    
    public LuluType(aModifier accessModifier, boolean isConst){
        this.accessModifier = accessModifier;
        this.isConst = isConst;
    }
    
    public abstract Integer getTypeCode();
    public abstract Integer getSize();
    public abstract boolean isDefined();
    public abstract boolean convertable(Object o);
    
    public aModifier getAccessModifier(){
        return accessModifier;
    }
    
    public boolean isConst(){
        return isConst;
    }
        
    public void setData(Object data){
        this.data = data;
    }
    
    public Object getData(){
        return data;
    }
    
    public void setOffset(Integer offset){
        this.offset = offset;
    }
    
    public Integer getOffset(){
        return offset;
    }
    
}
