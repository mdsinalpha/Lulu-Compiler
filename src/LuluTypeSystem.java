
import org.antlr.v4.runtime.ParserRuleContext;


/**
 *
 * @author hashemi
 */
public class LuluTypeSystem{
    
    public static int UNDEFINED = -10;
    
    public static Integer type(Integer operand, Integer operator){
         switch(operator){
             case LuluLexer.UNARY_OP:
                 if(operand==LuluLexer.BOOL_CONST||operand==LuluLexer.INT_CONST)
                     return LuluLexer.BOOL_CONST;
                 break;
             case LuluLexer.MINUS:
                 if(operand==LuluLexer.INT_CONST||operand==LuluLexer.REAL_CONST)
                     return operand;
                 break;
             case LuluLexer.BITWISE_NOT:
                 if(operand==LuluLexer.BOOL_CONST||operand==LuluLexer.INT_CONST)
                     return LuluLexer.INT_CONST;
         }
        return UNDEFINED;
    }
   
    public static Integer type(Integer operand1, Integer operand2, Integer operator){
        //TODO
        return 0;
    }
}
