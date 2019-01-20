
/**
 *
 * @author hashemi
 */
public class LuluLableGenerator {
    
    private final String starter;
    
    public LuluLableGenerator(String starter){
        this.starter = starter;
    }
    
    public String getNextLable(){
        return String.format("%s%f", starter, System.currentTimeMillis());
    }
}
