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
       
    public LuluFunctionType(aModifier accessModifier, boolean isConst, boolean isNative,
            ArrayList<LuluType> inputTypes, ArrayList<LuluType> outputTypes){
        super(accessModifier, isConst);
        this.isNative = isNative;
        this.inputTypes = inputTypes;
        this.outputTypes = outputTypes;
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
         
    @Override
    public boolean equals(Object o){
        if(o instanceof LuluFunctionType){
            LuluFunctionType other = (LuluFunctionType) o;
            if(inputTypes.size()!=other.inputTypes.size()) return false;
            if(outputTypes.size()!=other.outputTypes.size()) return false;
            for(int i=0;i<inputTypes.size();i++)
                if(!inputTypes.get(i).equals(other.inputTypes.get(i)))
                    return false;
            for(int i=0;i<outputTypes.size();i++)
                if(!outputTypes.get(i).equals(other.outputTypes.get(i)))
                    return false;
            return true;
        }
        return false;
    }
    
}
