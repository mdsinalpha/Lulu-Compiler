package lulu.util;


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
        counter += 1;
        return String.format("%s%d", starter, counter);
    }
}
