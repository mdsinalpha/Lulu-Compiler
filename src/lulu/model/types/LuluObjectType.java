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
    
    private Integer superTypeCode;
    private boolean defined;
   
    public LuluObjectType(String tag){
        super(aModifier.public_, false);
        typeCode = LuluTypeSystem.getNextObjectTypeCode();
        this.tag = tag;
        superTypeCode = LuluTypeSystem.OBJECT;
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
    
    public void setSuperTypeCode(Integer superTypeCode){
        this.superTypeCode = superTypeCode;
    }
    
    public Integer getSuperTypeCode(){
        return superTypeCode;
    }
    
    public void define(){
        defined = true;
    }
    
    @Override
    public boolean isDefined(){
        return defined;
    }
    
    //TODO convertable()
    @Override
    public boolean convertable(Object o){
        if(o instanceof LuluObjectType)
            return typeCode.equals(((LuluObjectType) o).getTypeCode());
        return false;
    }
    
}
