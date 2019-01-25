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
    }
    
    public Integer getSize(){
        return data.length;
    }
    
    public void setElement(Integer [] dimensions, T datum){
        Integer index = 0;
        data[index] = datum;
    }
    
    public T getElement(Integer [] dimensions){
        Integer index = 0;
        return (T) data[index];
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
