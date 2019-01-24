package lulu.util;

/**
 *
 * @author mdsinalpha
 */
public class LuluException{
    
    private final String message;
    private final int line;
    
    public LuluException(String message, int line){
        this.message = message;
        this.line = line;
    }
    
    public String getMessage(){
        return message;
    }
    
    public int getLine(){
        return line;
    }
    
    @Override
    public String toString(){
        return String.format("Compile error at line %d: %s", line, message);
    }
    
}
