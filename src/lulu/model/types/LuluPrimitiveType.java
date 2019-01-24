package lulu.model.types;

/**
 *
 * @author mdsinalpha
 */
public class LuluPrimitiveType implements LuluType {
    
    private final Integer typeCode;
    private final Object data;
    private final boolean isConst;
    
    public LuluPrimitiveType(Integer typeCode, Object data){
        this(typeCode, data, false);
    }
    
    public LuluPrimitiveType(Integer typeCode, Object data, boolean isConst){
        this.typeCode = typeCode;
        this.data = data;
        this.isConst = isConst;
    }

    @Override
    public Integer getTypeCode() {
        return typeCode;
    }
    
    @Override
    public boolean isConst() {
       return isConst;
    }
    
    public Object getData(){
        return data;
    }

  
    
}
