
/**
 *
 * @author hashemi
 */
public class LuluLableGenerator {
    
    private final String starter;
    private int counter;
    
    public LuluLableGenerator(String starter){
        this.starter = starter;
        counter = -1;
    }
    
    public String getNextLable(){
        counter = (counter + 1) % 1000000007;
        return String.format("%s%d%d", starter, System.currentTimeMillis()%10000, counter);
    }
}
