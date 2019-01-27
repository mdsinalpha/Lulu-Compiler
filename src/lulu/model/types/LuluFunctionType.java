package lulu.model.types;

import java.util.ArrayList;
import lulu.util.LuluTypeSystem;

/**
 *
 * @author mdsinalpha
 */
public class LuluFunctionType implements LuluType {
    
    private final boolean isNative;
    
    public final ArrayList<LuluType> inputTypes;
    public final ArrayList<LuluType> outputTypes;
    
    private boolean defined;
    
    public LuluFunctionType(boolean isNative,
            ArrayList<LuluType> inputTypes, ArrayList<LuluType> outputTypes){
        this.isNative = isNative;
        this.inputTypes = inputTypes;
        this.outputTypes = outputTypes;
        this.defined = false;
    }
    
    @Override
    public Integer getTypeCode() {
        return LuluTypeSystem.FUNCTION;
    } 
        
    public boolean isNative(){
        return isNative;
    }
       
    public void define(){
        defined = true;
    }
    
    @Override
    public boolean isDefined(){
        return defined;
    }
    
    @Override
    public boolean convertable(Object o){
        if(o instanceof LuluFunctionType)
            return LuluTypeSystem.convertable(this, (LuluFunctionType)o);
        return false;
    }
    
}
