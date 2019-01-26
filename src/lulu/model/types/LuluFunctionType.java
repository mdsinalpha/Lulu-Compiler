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
    
}
