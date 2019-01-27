package lulu.model.types;

import lulu.util.LuluTypeSystem;

/**
 *
 * @author hashemi
 */
public class LuluArrayType implements LuluType{
    
    private final LuluType elementType;
    private final Integer dimensions;
    
    public LuluArrayType(LuluType elementType, Integer dimensions){
        this.elementType = elementType;
        this.dimensions = dimensions;
    }
    
    @Override
    public Integer getTypeCode() {
        return LuluTypeSystem.ARRAY;
    }
    
    public LuluType getElementType(){
        return elementType;
    }
    
    public Integer getDimensions(){
        return dimensions;
    }
    
    @Override
    public boolean isDefined(){
        return true;
    }
    
    @Override
    public boolean convertable(Object o){
        if(o instanceof LuluArrayType)
            return LuluTypeSystem.convertable(this, (LuluArrayType)o);
        return false;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof LuluArrayType)
            return dimensions.equals(((LuluArrayType) o).dimensions) &&
                    elementType.equals(((LuluArrayType) o).getElementType());
        return false;
    }
    
    /*
    private Integer index(Integer [] dimensions){
        Integer index = 0;
        Integer c =1;
        for(int i=0; i<this.sizes.length;i++){
            c = dimensions[i];
            for (int j = i+1; j < this.sizes.length; j++) {
                c *= this.sizes[j]; 
            }
            index+=c;
        }
        return index;
    }*/
}
