package lulu.model.types;

/**
 *
 * @author mdsinalpha
 */
public interface LuluType {
    
    public abstract Integer getTypeCode();
    public abstract boolean isDefined();
    public abstract boolean convertable(Object o);
    
}
