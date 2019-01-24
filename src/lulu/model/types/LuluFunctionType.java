package lulu.model.types;

import java.util.ArrayList;
import lulu.util.LuluTypeSystem;

/**
 *
 * @author mdsinalpha
 */
public class LuluFunctionType implements LuluType {
    
    public ArrayList<LuluType> inputTypes;
    public ArrayList<LuluType> outputTypes;
    private final boolean isNative;
    private String codeLable;
    
    public LuluFunctionType(ArrayList<LuluType> inputTypes, ArrayList<LuluType> outputTypes){
        this(inputTypes, outputTypes, false);
    }
    
    public LuluFunctionType(ArrayList<LuluType> inputTypes, ArrayList<LuluType> outputTypes, boolean isNative){
        this.inputTypes = inputTypes;
        this.outputTypes = outputTypes;
        this.isNative = isNative;
    }
    
    public boolean isNative(){
        return isNative;
    }
    
    public void setCodeLable(String codeLable){
        this.codeLable = codeLable;
    }
    
    public String getCodeLable(){
        return codeLable;
    }
    
    @Override
    public Integer getTypeCode() {
        return LuluTypeSystem.FUNCTION;
    } 
    
    @Override
    public boolean isConst() {
       return true;
    }
    
}
