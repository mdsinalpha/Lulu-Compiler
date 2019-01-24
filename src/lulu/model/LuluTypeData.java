package lulu.model;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mdsinalpha
 */
public class LuluTypeData {
    
    public final String tag;
    public final Map<String, Object> fields;
    
    public LuluTypeData(String tag){
        this.tag = tag;
        fields = new HashMap<>();
    }
    
}
