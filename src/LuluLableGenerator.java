
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
        return String.format("%s%d", starter, System.currentTimeMillis());
    }
}
