package lulu.model.types;

/**
 *
 * @author mdsinalpha
 */
public interface LuluType {
    
    public Integer getTypeCode();
    public Integer getSize();
    public boolean isDefined();
    public boolean convertable(Object o);
    
}
