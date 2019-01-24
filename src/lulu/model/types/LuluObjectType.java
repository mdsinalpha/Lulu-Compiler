package lulu.model.types;


import java.util.HashMap;
import java.util.Map;
import lulu.util.LuluTypeSystem;

/**
 *
 * @author mdsinalpha
 */
public class LuluObjectType implements LuluType {
    
    private final Integer typeCode;
    private final Integer superTypeCode;
    private final String tag;
    public Map<String, LuluType> fields; 
    
    public LuluObjectType(String tag){
        this(LuluTypeSystem.OBJECT, tag);
    }
    
    public LuluObjectType(Integer superTypeCode, String tag){
        typeCode = LuluTypeSystem.getNextObjectTypeCode();
        this.superTypeCode = superTypeCode;
        this.tag = tag;
        fields = new HashMap<>();
    }
    
    public String getTag(){
        return tag;
    }
    
    public Integer getSuperTypeCode(){
        return superTypeCode;
    }
    
    @Override
    public Integer getTypeCode() {
        return typeCode;
    }

    @Override
    public boolean isConst() {
       return false;
    }
    
}
