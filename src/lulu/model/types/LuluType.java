package lulu.model.types;

/**
 *
 * @author mdsinalpha
 */
public interface LuluType {
    
    public enum aModifier{public_, protected_, private_};

    public Integer getTypeCode();
    public Integer getSize();
    public Object getData();
    public void setData(Object data);
    
    public aModifier getAccessModifier();
    public boolean isConst();
    
}
