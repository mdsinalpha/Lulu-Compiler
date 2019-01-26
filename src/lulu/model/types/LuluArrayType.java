package lulu.model.types;

import lulu.util.LuluTypeSystem;

/**
 *
 * @author hashemi
 */
public class LuluArrayType<T> implements LuluType{
    
    
    private final Object[] data;
    private final aModifier accessModifier;
    private final boolean isConst;
    private final Integer[] sizes;
    public LuluArrayType(Integer[] sizes){
        this(sizes, aModifier.private_, true);
    }
    
    public LuluArrayType(Integer[] sizes, aModifier accessModifier){
        this(sizes, accessModifier, true);
    }
    
    public LuluArrayType(Integer[] sizes, boolean isConst){
        this(sizes, aModifier.private_, isConst);
    }

    public LuluArrayType(Integer[] sizes, aModifier accessModifier, boolean isConst){
        Integer size = sizes[0];
        for(int i=1;i<sizes.length;i++)
            size *= sizes[i];
        data = new Object[size];
        this.accessModifier = accessModifier;
        this.isConst = isConst;
        this.sizes= sizes;
    }
    
    @Override
    public Integer getSize(){
        return 4;
    }
    
    public Integer getLength(){
        return data.length;
    }
    
    public Integer index (Integer [] dimensions){
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
    public void setElement(Integer [] dimensions, T datum){
        data[index(dimensions)] = datum;
    }
    
    public T getElement(Integer [] dimensions){
        return (T) data[index(dimensions)];
    }

    @Override
    public Integer getTypeCode() {
        return LuluTypeSystem.ARRAY;
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
    public Object getData() {
       return data;
    }

    @Override
    public void setData(Object data) {}
    
}
