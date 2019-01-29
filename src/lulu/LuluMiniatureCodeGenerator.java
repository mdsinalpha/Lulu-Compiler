package lulu;

import java.util.ArrayList;
import java.util.Map;
import lulu.model.LuluSymbolTable;
import lulu.parser.LuluBaseListener;
import lulu.parser.LuluParser;
import lulu.util.LuluLableGenerator;
import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 *
 * @author mdsinalpha
 */
public class LuluMiniatureCodeGenerator extends LuluBaseListener {
    
    private final LuluSemanticAnalyzer analyzer;
    
    public Map<String, ArrayList<String>> codeMap;
    
    public static LuluSymbolTable currentScope;
    
    private final LuluLableGenerator lableGenerator;
    private final LuluLableGenerator variableGenerator;
    
    private final ParseTreeProperty<String> variables;
    
     
    private void generateCode(String fCode, Object ... args){
        codeMap.get(currentScope.getTag()).add(String.format(fCode, args));
    }
    
    private void saveScope(LuluSymbolTable scope){
        // Entering an scope.
        currentScope = scope;
        codeMap.put(currentScope.getTag(), new ArrayList<>());
    }
    
    private void releaseScope(){
        // Exiting an scope.
        currentScope = currentScope.getParent();
    }
    
    @Override
    public void enterProgram(LuluParser.ProgramContext ctx){
        saveScope(analyzer.getScope(ctx));
    }
    
    @Override
    public void exitProgram(LuluParser.ProgramContext ctx){
        releaseScope();
    }
    
    
    public LuluMiniatureCodeGenerator(LuluSemanticAnalyzer analyzer){
        this.analyzer = analyzer;
        
        codeMap = new OrderedHashMap<>();
        
        lableGenerator = new LuluLableGenerator("L");
        variableGenerator = new LuluLableGenerator("T");
        
        variables = new ParseTreeProperty<>();
    }
    
    public String getCode(){
        StringBuilder builder = new StringBuilder();
        codeMap.entrySet().stream().map((block) -> {
            builder.append(block.getKey()).append(" ");
            return block;
        }).forEachOrdered((block) -> {
            block.getValue().forEach((line) -> {
                builder.append(line).append("\n");
            });
        });
        return builder.toString();
    }
    
    @Override
    public void exitPARENTHESES(LuluParser.PARENTHESESContext ctx){
        variables.put(ctx, variables.get(ctx.expr()));
    }
    
    @Override
    public void exitUNARY_OP(LuluParser.UNARY_OPContext ctx){
        String var = variableGenerator.getNextLable();
        variables.put(ctx, var); 
        generateCode("%s = %s %s", var, ctx.UNARY_OP().getText(), variables.get(ctx.expr()));
    }
    
    @Override
    public void exitBITWISE_NOT(LuluParser.BITWISE_NOTContext ctx){
        String var = variableGenerator.getNextLable();
        variables.put(ctx, var); 
        generateCode("%s = %s %s", var, ctx.BITWISE_NOT().getText(), variables.get(ctx.expr()));
    }
    
    @Override
    public void exitMINUS(LuluParser.MINUSContext ctx){
        String var = variableGenerator.getNextLable();
        variables.put(ctx, var);
        int expr_count = ctx.expr().size();
        if(expr_count == 2)
            generateCode("%s = %s %s %s", var, variables.get(ctx.expr(0)),
                ctx.MINUS().getText(), variables.get(ctx.expr(1)));
        else generateCode("%s = %s %s", var, ctx.MINUS().getText(), variables.get(ctx.expr(0)));
    }
    
    
    @Override
    public void exitARIT_P1(LuluParser.ARIT_P1Context ctx){
        String var = variableGenerator.getNextLable();
        variables.put(ctx, var);
        generateCode("%s = %s %s %s", var, variables.get(ctx.expr(0)),
                ctx.ARIT_P1().getText(), variables.get(ctx.expr(1)));
    }
    
    @Override
    public void exitARIT_P2(LuluParser.ARIT_P2Context ctx){
        String var = variableGenerator.getNextLable();
        variables.put(ctx, var);
        generateCode("%s = %s %s %s", var, variables.get(ctx.expr(0)),
                ctx.ARIT_P2().getText(), variables.get(ctx.expr(1)));
    }
    
    @Override
    public void exitBITWISE_AND(LuluParser.BITWISE_ANDContext ctx){
        String var = variableGenerator.getNextLable();
        variables.put(ctx, var);
        generateCode("%s = %s %s %s", var, variables.get(ctx.expr(0)),
                ctx.BITWISE_AND().getText(), variables.get(ctx.expr(1)));
    }
    
    @Override
    public void exitBITWISE_XOR(LuluParser.BITWISE_XORContext ctx){
        String var = variableGenerator.getNextLable();
        variables.put(ctx, var);
        generateCode("%s = %s %s %s", var, variables.get(ctx.expr(0)),
                ctx.BITWISE_XOR().getText(), variables.get(ctx.expr(1)));
    }
    
    @Override
    public void exitBITWISE_OR(LuluParser.BITWISE_ORContext ctx){
        String var = variableGenerator.getNextLable();
        variables.put(ctx, var);
        generateCode("%s = %s %s %s", var, variables.get(ctx.expr(0)),
                ctx.BITWISE_OR().getText(), variables.get(ctx.expr(1)));
    }
    
    @Override
    public void exitREL(LuluParser.RELContext ctx){
        String var = variableGenerator.getNextLable();
        variables.put(ctx, var);
        generateCode("%s = %s %s %s", var, variables.get(ctx.expr(0)),
                ctx.REL().getText(), variables.get(ctx.expr(1)));
    }
    
    @Override
    public void exitREL_EQ(LuluParser.REL_EQContext ctx){
        String var = variableGenerator.getNextLable();
        variables.put(ctx, var);
        generateCode("%s = %s %s %s", var, variables.get(ctx.expr(0)),
                ctx.REL_EQ().getText(), variables.get(ctx.expr(1)));
        
    }
    
    @Override
    public void exitLOGICAL_AND(LuluParser.LOGICAL_ANDContext ctx){
        String var = variableGenerator.getNextLable();
        variables.put(ctx, var);
        generateCode("%s = %s %s %s", var, variables.get(ctx.expr(0)),
                ctx.LOGICAL_AND().getText(), variables.get(ctx.expr(1)));
    }
    
    @Override
    public void exitLOGICAL_OR(LuluParser.LOGICAL_ORContext ctx){
        String var = variableGenerator.getNextLable();
        variables.put(ctx, var);
        generateCode("%s = %s %s %s", var, variables.get(ctx.expr(0)),
                ctx.LOGICAL_OR().getText(), variables.get(ctx.expr(1)));
    }
    
    @Override
    public void exitCONST(LuluParser.CONSTContext ctx){
        String var = variableGenerator.getNextLable();
        variables.put(ctx, var);
        generateCode("%s = %s", var, analyzer.getValue(ctx.const_val()));
    }
    
}
