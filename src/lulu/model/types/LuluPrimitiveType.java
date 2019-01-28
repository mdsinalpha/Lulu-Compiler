package lulu.model.types;

import lulu.parser.LuluParser;
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
    public Integer getTypeCode(){
        return typeCode;
    }
    
    @Override
    public Integer getSize(){
        switch(typeCode){
            case LuluParser.BOOL_CONST:
                return 1;
            case LuluParser.INT_CONST:
                return 4;
            case LuluParser.STRING_CONST:
                return 4;
            case LuluParser.REAL_CONST:
                return 8;
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
            return LuluTypeSystem.convertable(this, ((LuluPrimitiveType) o));
        return false;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof LuluPrimitiveType)
            return typeCode.equals(((LuluPrimitiveType) o).getTypeCode());
        return false;
    }
    
    @Override
    public String toString(){
        String primText = "UNDEFINED";
        switch(typeCode){
            case LuluParser.INT_CONST:
                primText = "INT";
                break;
            case LuluParser.REAL_CONST:
                primText = "REAL";
                break;
            case LuluParser.BOOL_CONST:
                primText = "BOOL";
                break;
            case LuluParser.STRING_CONST:
                primText = "STRING";
        }
        return primText;
    }
    
}
