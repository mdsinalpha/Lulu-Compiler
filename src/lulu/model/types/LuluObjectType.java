package lulu.model.types;

import lulu.util.LuluTypeSystem;

/**
 *
 * @author mdsinalpha
 */
public class LuluObjectType implements LuluType {
    
    private final Integer typeCode;
    private final String tag;
    private String superTag;
    private boolean defined;
   
    public LuluObjectType(String tag){
        typeCode = LuluTypeSystem.getNextObjectTypeCode();
        this.tag = tag;
        superTag = LuluTypeSystem.OBJECT_TAG;
        defined = false;
    }
    
    @Override
    public Integer getTypeCode() {
        return typeCode;
    }
    
    public String getTag(){
        return tag;
    }
    
    public void setSuperTag(String superTag){
        this.superTag = superTag;
    }
    
    public String getSuperTag(){
        return superTag;
    }
    
    public void define(){
        defined = true;
    }
    
    public boolean isDefined(){
        return defined;
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
