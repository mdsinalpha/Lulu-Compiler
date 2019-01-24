package lulu;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import lulu.parser.LuluLexer;
import lulu.parser.LuluParser;
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
             File input = new File("program.lulu");
            //File input = new File(args[0]);
            StringBuilder program = new StringBuilder();
            Scanner scan = new Scanner(input);
            while(scan.hasNextLine())
                program.append(scan.nextLine()).append("\n");
            LuluLexer lexer = new LuluLexer(new ANTLRInputStream(program.toString()));
            LuluParser parser = new LuluParser(new CommonTokenStream(lexer));
            ParseTreeWalker walker = new ParseTreeWalker();
            LuluSemanticAnalyzer loader = new LuluSemanticAnalyzer();
            walker.walk(loader, parser.program());
            loader.code.keySet().stream().map((tag) -> {
                System.out.printf("%s:\n", tag);
                return tag;
            }).forEachOrdered((tag) -> {
                loader.code.get(tag).forEach((code) -> {
                    System.out.println(code);
                 });
            }); /*LuluMiniatureCodeGenerator generator = new LuluMiniatureCodeGenerator(loader);
            File output = new File(args[1]);
            FileWriter writer = new FileWriter(output);
            while(generator.hasNextLine())
            writer.write(generator.nextLine()+"\n");
            writer.flush();
            writer.close();*/
        }catch(Exception e){
            //TODO Make log file
            e.printStackTrace();
        }
        
    }
    
}
