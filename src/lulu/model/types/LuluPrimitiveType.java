package lulu.model.types;

import lulu.util.LuluTypeSystem;

/**
 *
 * @author mdsinalpha
 */
public class LuluPrimitiveType implements LuluType {
    
    private final Integer typeCode;
    
    public LuluPrimitiveType(Integer typeCode){
        this.typeCode = typeCode;
    }

    @Override
    public Integer getTypeCode() {
        return typeCode;
    }
        
    @Override
    public boolean isDefined(){
        return true;
    }
    
    @Override
    public boolean convertable(Object o){
        if(o instanceof LuluPrimitiveType)
            return LuluTypeSystem.convertable(this, ((LuluPrimitiveType) o));
        return false;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof LuluPrimitiveType)
            return typeCode.equals(((LuluPrimitiveType) o).getTypeCode());
        return false;
    }
    
}
