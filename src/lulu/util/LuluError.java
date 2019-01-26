package lulu.util;

/**
 *
 * @author mdsinalpha
 */
public class LuluError{
    
    private final String message;
    private final int line;
    private final int start;
    private final int end;
    
    public LuluError(String message, int line, int start, int end){
        this.message = message;
        this.line = line;
        this.start = start;
        this.end = end;
    }
    
    public String getMessage(){
        return message;
    }
    
    public int getLine(){
        return line;
    }
    
    public int getStart(){
        return start;
    }
    
    public int getEnd(){
        return end;
    }
    
    @Override
    public String toString(){
        return String.format("Compile error at line %d: %s", line, message);
    }
    
}
