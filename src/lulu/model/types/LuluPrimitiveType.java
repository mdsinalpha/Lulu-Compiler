package lulu.model.types;

/**
 *
 * @author mdsinalpha
 */
public class LuluPrimitiveType implements LuluType {
    
    private final Integer typeCode;
    private final Object data;
    
    public LuluPrimitiveType(Integer typeCode, Object data){
        this.typeCode = typeCode;
        this.data = data;
    }

    @Override
    public Integer getTypeCode() {
        return typeCode;
    }
    
    public Object getData(){
        return data;
    }
    
}
