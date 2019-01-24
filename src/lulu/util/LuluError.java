package lulu.util;

/**
 *
 * @author mdsinalpha
 */
public class LuluError{
    
    private final String message;
    private final int line;
    
    public LuluError(String message, int line){
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
