package lulu.model.types;

/**
 *
 * @author mdsinalpha
 */
public class LuluPrimitiveType implements LuluType {
    
    private final Integer typeCode;
    private final aModifier accessModifier;
    private final Object data;
    private final boolean isConst;
    
    public LuluPrimitiveType(Integer typeCode, Object data){
        this(typeCode, aModifier.public_ ,data, false);
    }
    
    public LuluPrimitiveType(Integer typeCode, aModifier accessModifier, Object data){
        this(typeCode, accessModifier, data, false);
    }
    
    public LuluPrimitiveType(Integer typeCode, Object data, boolean isConst){
        this(typeCode, aModifier.public_, data, isConst);
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
    
    public Object getData(){
        return data;
    }
    
}
