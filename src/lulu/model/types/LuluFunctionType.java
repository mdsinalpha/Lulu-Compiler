package lulu.model.types;

import java.util.ArrayList;
import lulu.util.LuluTypeSystem;

/**
 *
 * @author mdsinalpha
 */
public class LuluFunctionType extends LuluType {
    
    private final boolean isNative;
    
    public final ArrayList<LuluType> inputTypes;
    public final ArrayList<LuluType> outputTypes;
    
    private boolean defined;
    
    public LuluFunctionType(aModifier accessModifier, boolean isNative,
            ArrayList<LuluType> inputTypes, ArrayList<LuluType> outputTypes){
        super(accessModifier, false);
        this.isNative = isNative;
        this.inputTypes = inputTypes;
        this.outputTypes = outputTypes;
        this.defined = false;
    }
    
    @Override
    public Integer getTypeCode() {
        return LuluTypeSystem.FUNCTION;
    } 
    
    @Override
    public Integer getSize() {
        return 4;
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
            if(LuluTypeSystem.convertable(this, (LuluFunctionType)o, null))//TODO
                return true;
        
        return false;
    }
    
}
