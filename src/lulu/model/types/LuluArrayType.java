package lulu.model.types;

import lulu.util.LuluTypeSystem;

/**
 *
 * @author hashemi
 */
public class LuluArrayType extends LuluType{
    
    private final Integer elementTypeCode;
    private final Integer[] sizes;
    private final Object[] elements;
    
    public LuluArrayType(aModifier accessModifier, boolean isConst,
            Integer elementTypeCode, Integer[] sizes){
        super(accessModifier, isConst);
        this.elementTypeCode = elementTypeCode;
        this.sizes = sizes;
        Integer size = sizes[0];
        for(int i=1;i<sizes.length;i++)
            size *= sizes[i];
        elements = new Object[size];
    }
    
    @Override
    public Integer getTypeCode() {
        return LuluTypeSystem.ARRAY;
    }
    
    @Override
    public Integer getSize(){
        return 4;
    }
    
    public Integer getElementTypeCode(){
        return elementTypeCode;
    }
    
    public Integer getLength(){
        return elements.length;
    }
    
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
    }
    
    public void setElement(Integer [] dimensions, Object datum){
        elements[index(dimensions)] = datum;
    }
    
    public Object getElement(Integer [] dimensions){
        return elements[index(dimensions)];
    }
    
}
