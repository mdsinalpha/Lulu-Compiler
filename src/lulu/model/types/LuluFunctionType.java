package lulu.model.types;

import java.util.ArrayList;
import lulu.util.LuluTypeSystem;

/**
 *
 * @author mdsinalpha
 */
public class LuluFunctionType implements LuluType {
    
    public final ArrayList<LuluType> inputTypes;
    public final ArrayList<LuluType> outputTypes;
    private final aModifier accessModifier;
    private final boolean isNative;
    
    private String codeLable;
    
    public LuluFunctionType(ArrayList<LuluType> inputTypes, ArrayList<LuluType> outputTypes){
        this(inputTypes, outputTypes, aModifier.private_, false);
    }
    
    public LuluFunctionType(ArrayList<LuluType> inputTypes, ArrayList<LuluType> outputTypes, aModifier accessModifier){
        this(inputTypes, outputTypes, accessModifier, false);
    }
    
    public LuluFunctionType(ArrayList<LuluType> inputTypes, ArrayList<LuluType> outputTypes, boolean isNative){
        this(inputTypes, outputTypes, aModifier.private_, isNative);
    }
    
    public LuluFunctionType(ArrayList<LuluType> inputTypes, ArrayList<LuluType> outputTypes, 
            aModifier accessModifier, boolean isNative){
        this.inputTypes = inputTypes;
        this.outputTypes = outputTypes;
        this.accessModifier = accessModifier;
        this.isNative = isNative;
    }
    
    public boolean isNative(){
        return isNative;
    }
    
    @Override
    public void setData(Object codeLable){
        if(codeLable instanceof String)
            this.codeLable = codeLable.toString();
    }
    
    @Override
    public String getData(){
        return codeLable;
    }
    
    @Override
    public Integer getTypeCode() {
        return LuluTypeSystem.FUNCTION;
    } 
    
    @Override
    public aModifier getAccessModifier() {
        return accessModifier;
    }
    
    @Override
    public boolean isConst() {
       return true;
    }

    @Override
    public Integer getSize() {
        return 4;
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
