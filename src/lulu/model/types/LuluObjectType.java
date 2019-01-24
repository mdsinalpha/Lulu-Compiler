package lulu.model.types;

import lulu.util.LuluTypeSystem;

/**
 *
 * @author mdsinalpha
 */
public class LuluObjectType implements LuluType {
    
    private final Integer typeCode;
    private final String superTag;
    private final String tag;
    
    public LuluObjectType(String tag){
        this(tag, LuluTypeSystem.OBJECT_TAG);
    }
    
    public LuluObjectType(String tag, String superTag){
        typeCode = LuluTypeSystem.getNextObjectTypeCode();
        this.tag = tag;
        this.superTag = superTag;
    }
    
    public String getTag(){
        return tag;
    }
    
    @Override
    public Integer getTypeCode() {
        return typeCode;
    }
    
    public String getSuperTag(){
        return superTag;
    }
    
     @Override
    public aModifier getAccessModifier() {
        return aModifier.public_;
    }

    @Override
    public boolean isConst() {
       return false;
    }
    
}
