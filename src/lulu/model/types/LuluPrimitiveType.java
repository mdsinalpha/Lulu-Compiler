package lulu.model.types;

import lulu.parser.LuluParser;

/**
 *
 * @author mdsinalpha
 */
public class LuluPrimitiveType implements LuluType {
    
    private final Integer typeCode;
    private final aModifier accessModifier;
    private final boolean isConst;
    
    private Object data;
    
    public LuluPrimitiveType(Integer typeCode, Object data){
        this(typeCode, aModifier.private_ ,data, false);
    }
    
    public LuluPrimitiveType(Integer typeCode, aModifier accessModifier, Object data){
        this(typeCode, accessModifier, data, false);
    }
    
    public LuluPrimitiveType(Integer typeCode, Object data, boolean isConst){
        this(typeCode, aModifier.private_, data, isConst);
    }
    
    public LuluPrimitiveType(Integer typeCode, aModifier accessModifier, Object data, boolean isConst){
        this.typeCode = typeCode;
        this.accessModifier = accessModifier;
        this.data = data;
        this.isConst = isConst;
    }

    @Override
    public Integer getTypeCode() {
        return typeCode;
    }
    
    @Override
    public aModifier getAccessModifier() {
        return accessModifier;
    }
    
    @Override
    public boolean isConst() {
       return isConst;
    }
    
    @Override
    public Object getData(){
        return data;
    }

    @Override
    public void setData(Object data) {
        this.data = data;
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
    public boolean equals(Object o){
        if(o instanceof LuluPrimitiveType)
            return typeCode.equals(((LuluPrimitiveType) o).getTypeCode());
        return false;
    }
}
