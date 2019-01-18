import java.io.File;
import java.util.Scanner;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 *
 * @author mdsinalpha
 */
public class LuluRun {
    
    public static void main(String[] args){
        try{
            File input = new File(args[0]);
            StringBuilder program = new StringBuilder();
            Scanner scan = new Scanner(input);
            while(scan.hasNextLine())
                program.append(scan.nextLine()).append("\n");
            LuluLexer lexer = new LuluLexer(new ANTLRInputStream(program.toString()));
            LuluParser parser = new LuluParser(new CommonTokenStream(lexer));
            ParseTreeWalker walker = new ParseTreeWalker();
            LuluSemanticAnalyzer loader = new LuluSemanticAnalyzer();
            walker.walk(loader, parser.program());
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
