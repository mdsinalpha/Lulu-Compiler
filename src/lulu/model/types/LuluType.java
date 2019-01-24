package lulu.model.types;

/**
 *
 * @author mdsinalpha
 */
public interface LuluType {
    
    public enum aModifier{public_, protected_, private_};

    public Integer getTypeCode();
    public aModifier getAccessModifier();
    public boolean isConst();
    
}
