package lulu.model.types;

import lulu.model.LuluSymbolTable;
import lulu.util.LuluTypeSystem;

/**
 *
 * @author mdsinalpha
 */
public class LuluObjectType extends LuluType {
    
    private final Integer typeCode;
    private final String tag;
    
    private String superTag;
    private boolean defined;
   
    public LuluObjectType(String tag){
        super(aModifier.public_, false);
        typeCode = LuluTypeSystem.getNextObjectTypeCode();
        this.tag = tag;
        superTag = LuluTypeSystem.OBJECT_TAG;
        defined = false;
    }
    
    @Override
    public Integer getTypeCode() {
        return typeCode;
    }
    
    @Override
    public Integer getSize() {
        return 4;
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
    public boolean equals(Object o){
        if(o instanceof LuluObjectType)
            return typeCode.equals(((LuluObjectType) o).getTypeCode());
        return false;
    }
    
}
