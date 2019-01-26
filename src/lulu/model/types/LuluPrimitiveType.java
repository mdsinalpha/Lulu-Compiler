package lulu.model.types;

import lulu.parser.LuluParser;
import lulu.util.LuluTypeSystem;

/**
 *
 * @author mdsinalpha
 */
public class LuluPrimitiveType extends LuluType {
    
    private final Integer typeCode;
         
    public LuluPrimitiveType(aModifier accessModifier, boolean isConst, Integer typeCode){
        super(accessModifier, isConst);
        this.typeCode = typeCode;
    }

    @Override
    public Integer getTypeCode() {
        return typeCode;
    }
    
    @Override
    public Integer getSize() {
        switch(typeCode){
            case LuluParser.BOOL_CONST:
                return 1;
            case LuluParser.INT_CONST:
                return 4;
            case LuluParser.REAL_CONST:
                return 8;
            case LuluParser.STRING_CONST:
                return 2*data.toString().length()+2;
        }
        return 0;
    }
    
    @Override
    public boolean isDefined(){
        return true;
    }
    
    @Override
    public boolean convertable(Object o){
        if(o instanceof LuluPrimitiveType)
            return LuluTypeSystem.convertable(typeCode, ((LuluPrimitiveType) o).getTypeCode());
        return false;
    }
    
    
}
