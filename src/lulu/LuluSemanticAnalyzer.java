package lulu;

import java.util.*;

import lulu.model.LuluSymbolTable;
import lulu.model.types.LuluArrayType;
import lulu.model.types.LuluFunctionType;
import lulu.model.types.LuluObjectType;
import lulu.model.types.LuluPrimitiveType;
import lulu.model.types.LuluType;
import lulu.parser.LuluBaseListener;
import lulu.parser.LuluLexer;
import lulu.parser.LuluParser;
import lulu.util.LuluError;
import lulu.util.LuluLableGenerator;
import lulu.util.LuluTypeSystem;
import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 *
 * @author mdsinalpha
 */
public class LuluSemanticAnalyzer extends LuluBaseListener {
    
    //public Map<String, ArrayList<String>> codeMap;
    
    public Map<Integer, LuluPrimitiveType> primMap;
    public Map<Integer, LuluObjectType> typeMap;
    
    public ArrayList<LuluError> errorList;
    
    private final ParseTreeProperty<LuluSymbolTable> scopes;
    private LuluSymbolTable currentScope;
    private LuluSymbolTable currentTypeScope;
     
    private final LuluLableGenerator lableGenerator;
    //private LuluLableGenerator variableGenerator;
    
    private final ParseTreeProperty<Object> values;
    private final ParseTreeProperty<Integer> types;
    private final ParseTreeProperty<ArrayList<LuluType>> argsTypes;
    //private ParseTreeProperty<String> variables;
    
    public static final String GLOBAL_TAG = "main";
    public static final String MAIN_TAG = "start";
    
    
    public LuluSemanticAnalyzer(){
        //codeMap = new OrderedHashMap<>();
            
        primMap = new HashMap<>();
        primMap.put(LuluParser.INT_CONST, new LuluPrimitiveType(LuluType.aModifier.public_,
                                        false, LuluParser.INT_CONST));
        primMap.put(LuluParser.REAL_CONST, new LuluPrimitiveType(LuluType.aModifier.public_,
                                        false, LuluParser.REAL_CONST));
        primMap.put(LuluParser.BOOL_CONST, new LuluPrimitiveType(LuluType.aModifier.public_,
                                        false, LuluParser.BOOL_CONST));
        primMap.put(LuluParser.STRING_CONST, new LuluPrimitiveType(LuluType.aModifier.public_,
                                        false, LuluParser.STRING_CONST));
        typeMap = new HashMap<>();
        
        errorList = new ArrayList<>();
        
        scopes = new ParseTreeProperty<>();
        
        lableGenerator = new LuluLableGenerator("L");
        //variableGenerator = new LuluLableGenerator("T");    
        
        values = new ParseTreeProperty<>();
        types = new ParseTreeProperty<>();
        argsTypes = new ParseTreeProperty<>();
        //variables = new ParseTreeProperty<>();
    }
     
    /*
    private void generateCode(String tCode){
        codeMap.get(currentScope.getTag()).add(tCode);
    }*/
    
    private void error(String message, Token token){
        // Adding an error with it's occurence position inside list of compile errors:
        errorList.add(new LuluError(message, token.getLine(), token.getStartIndex(), token.getStopIndex()));
    }
    
    private void saveScope(ParserRuleContext ctx, LuluSymbolTable scope){
        // Entering an scope.
        currentScope = scope;
        scopes.put(ctx, currentScope);
        //codeMap.put(currentScope.getTag(), new ArrayList<>());
    }
    
    private void releaseScope(){
        // Exiting an scope.
        currentScope = currentScope.getParent();
    }
        
    @Override
    public void enterProgram(LuluParser.ProgramContext ctx){
        // Program needs a root scope for globals:
        saveScope(ctx, new LuluSymbolTable(GLOBAL_TAG));
        // Type 'object' is reserved by Lulu compiler:)
        LuluObjectType object = new LuluObjectType(LuluTypeSystem.OBJECT_TAG);
        currentScope.define(LuluTypeSystem.OBJECT_TAG, object);
        typeMap.put(LuluTypeSystem.OBJECT, object);
    }
    
    @Override
    public void exitProgram(LuluParser.ProgramContext ctx){
        //DONE @hashemi Check if all types are defined.
        if(currentScope.hasUndefinedFields()){
            error("Undefined fields inside declare block.", ctx.getStop());
        }
        //DONE @hashemi Check wether start function is defined.
        ArrayList<LuluType> out = new ArrayList<>();
        out.add(new LuluPrimitiveType(LuluType.aModifier.public_, false, LuluParser.INT_CONST));
        LuluFunctionType start = new LuluFunctionType(LuluType.aModifier.public_,
                false, new ArrayList<>(), out);
        LuluType tType = currentScope.resolvef(MAIN_TAG, start);
        if(tType == null){
            error("Expecting start function definition.", ctx.getStop());
            return;
        }
        releaseScope();
    }
    
    @Override
    public void enterFunc_dcl(LuluParser.Func_dclContext ctx){
        // Each function has input/output LuluType lists, making the lists ready for args/args_var:
        ctx.args().forEach((arg) -> {
            argsTypes.put(arg, new ArrayList<>());
        });
        if(ctx.args_var() != null)
           argsTypes.put(ctx.args_var(), new ArrayList<>());
        
    }

    @Override
    public void exitFunc_dcl(LuluParser.Func_dclContext ctx){
        // Declaring a function with given sinature:
        Token t = ctx.ID().getSymbol();
        ArrayList<LuluType> input = ctx.args(0)!=null?argsTypes.get(ctx.args(0)):new ArrayList<>();
        ArrayList<LuluType> output = ctx.args(1)!=null?argsTypes.get(ctx.args(1)):new ArrayList<>();
        LuluFunctionType fType = new LuluFunctionType(LuluType.aModifier.public_, 
                ctx.getToken(7, 0)!=null, input, output);
        LuluType tType = currentScope.resolve(t.getText());
        if(tType != null && !(tType instanceof LuluFunctionType)){
            // This ID is taken!
            error(String.format("Function name %s is already taken by another field.", t.getText()), t);
            return;
        }
        if(currentScope.resolvef(t.getText(), fType) != null){
            // This function is declared once!
            error(String.format("Function %s already declared.", t.getText()), t);
            return;
        }
        currentScope.define(t.getText(), fType);
    }
    
    @Override
    public void enterArgs(LuluParser.ArgsContext ctx){
        // Moving parent's LuluType list to child's context, so when args exits we can add a LuluType inside it!
        ArrayList<LuluType> tArgsTypes = argsTypes.get(ctx.getParent());
        if(tArgsTypes != null)
            argsTypes.put(ctx, tArgsTypes);
    }
    
    @Override
    public void exitArgs(LuluParser.ArgsContext ctx){
        // Counting brackets([) to determine array dimensions.
        Integer brackets = ctx.getTokens(9).size();
        if(brackets == 0){
            // This is not an array!
            Integer tCode = types.get(ctx.type());
            argsTypes.get(ctx).add(primMap.containsKey(tCode)?primMap.get(tCode):typeMap.get(tCode));
        }else{
            LuluArrayType array = new LuluArrayType(LuluType.aModifier.public_, false, 
                    types.get(ctx.type()), new Integer[brackets]);
            argsTypes.get(ctx).add(array);
        }
    }
    
    @Override 
    public void enterArgs_var(LuluParser.Args_varContext ctx){
        // Moving parent's LuluType list to child's context, so when args exits we can add a LuluType inside it!
        ArrayList<LuluType> tArgsTypes = argsTypes.get(ctx.getParent());
        if(tArgsTypes != null)
            argsTypes.put(ctx, tArgsTypes);
    }
    
    @Override
    public void exitArgs_var(LuluParser.Args_varContext ctx){
        // Counting brackets([) to determine array dimensions.
        Integer brackets = ctx.getTokens(9).size();
        if(brackets == 0){
            // This is not an array!
            Integer tCode = types.get(ctx.type());
            argsTypes.get(ctx).add(primMap.containsKey(tCode)?primMap.get(tCode):typeMap.get(tCode));
        }else{
            LuluArrayType array = new LuluArrayType(LuluType.aModifier.public_, false, 
                    types.get(ctx.type()), new Integer[brackets]);
            argsTypes.get(ctx).add(array);
        }
    }
    
    @Override
    public void exitType_dcl(LuluParser.Type_dclContext ctx){
        Token t = ctx.ID().getSymbol();
        LuluType tType = currentScope.resolve(t.getText());
        if(tType != null && tType instanceof LuluObjectType){
            // This type is declared once!
            error(String.format("Type %s already declared.", t.getText()), t);
            return;
        }
        else if(tType != null){
            // This ID is taken!
            error(String.format("Type name %s is already taken by another field.", t.getText()), t);
        }
        // Declare a new type with given ID:
        LuluObjectType tObject = new LuluObjectType(t.getText());
        currentScope.define(t.getText(), tObject);
        typeMap.put(tObject.getTypeCode(), tObject);
    }
    
    @Override
    public void exitVar_def(LuluParser.Var_defContext ctx){
        // Define a variable inside current scope's symbol table:
        if(!(ctx.getParent() instanceof LuluParser.Type_defContext) &&
                ctx.ACCSSMOD() != null){
            error("Access modifiers are only allowed inside a type block.", ctx.ACCSSMOD().getSymbol());
            return;
        }
        LuluType.aModifier tAM = LuluType.aModifier.public_;
        if(ctx.ACCSSMOD() != null)
            switch(ctx.ACCSSMOD().getText()){
                case "private":
                    tAM = LuluType.aModifier.private_;
                    break;
                case "protected":
                    tAM = LuluType.aModifier.protected_;
                    break;
                case "public":
                    tAM = LuluType.aModifier.public_;
                    break;
        }
        boolean tConst = ctx.getToken(12, 0) != null;
        Integer tCode = types.get(ctx.type());
        for(LuluParser.Var_valContext v: ctx.var_val()){
            Token tID = v.ref().ID().getSymbol();
            if(currentScope.has(tID.getText())){
                // This ID is taken!
                error(String.format("Variable name %s is already taken by another field.", tID.getText()), tID);
                return;
            }
            LuluType tType;
            if(types.get(v) == LuluTypeSystem.ARRAY)
                tType = new LuluArrayType(tAM, tConst, tCode, new Integer[(Integer)values.get(v)]);
            else if(primMap.containsKey(tCode))
                tType = new LuluPrimitiveType(tAM, tConst, tCode);
            //TODO @mdsinalpha check here!
            else tType = new LuluObjectType(typeMap.get(tCode).getTag());
            //TODO Type checking:
            if(v.expr() != null){
                
            }
            currentScope.define(tID.getText(), tType);
        }
    }
    
    
    @Override 
    public void enterType_def(LuluParser.Type_defContext ctx){
        Token t = ctx.ID(0).getSymbol();
        LuluType tType = currentScope.resolve(t.getText());
        LuluObjectType tObject;
        if(tType == null){
            // This type is not declared but also only defined!
            tObject = new LuluObjectType(t.getText());
            currentScope.define(t.getText(), tObject);
            typeMap.put(tObject.getTypeCode(), tObject);
        } else if(!(tType instanceof LuluObjectType)){
            // This ID is taken!
            error(String.format("Type name %s is already taken by another field.", t.getText()), t);
            return;
        }
        else tObject = (LuluObjectType) tType;
        if(tObject.isDefined()){
            // This type is defined once!
            error(String.format("Type %s already defined.", t.getText()), t);
            return;
        }
        if(ctx.ID(1)==null){
            // There is no super class definition for this definition:)
            LuluSymbolTable tData = new LuluSymbolTable(t.getText(), currentScope);
            tObject.setData(tData);
            tObject.define();
            currentTypeScope = tData;
            saveScope(ctx, tData);
            return;
        }
        Token s = ctx.ID(1).getSymbol();
        LuluType sType = currentScope.resolve(s.getText());
        if(sType == null){
            // Super type not found!
            error(String.format("Type %s not declared.", s.getText()), s);
            return;
        }
        else if(!(sType instanceof LuluObjectType)){
            // This ID is taken!
            error(String.format("Type name %s is already taken by another field.", s.getText()), s);
            return;
        }
        // Finally, this type should inherit another type!
        LuluObjectType sObject = (LuluObjectType) currentScope.resolve(s.getText());
        tObject.setSuperTypeCode(sObject.getTypeCode());
        LuluSymbolTable tData = new LuluSymbolTable(t.getText(), (LuluSymbolTable) sObject.getData());
        tObject.setData(tData);
        tObject.define();
        currentTypeScope = tData;
        saveScope(ctx, tData);
    }
    
    @Override
    public void exitType_def(LuluParser.Type_defContext ctx){
        releaseScope();
        currentTypeScope = null;
    }
    
    
    @Override
    public void enterBlock(LuluParser.BlockContext ctx){
        // Cheking wether block's symbol talbe is saved by block's parent or not:
        if(!(ctx.getParent() instanceof LuluParser.WHILEContext) &&
           !(ctx.getParent() instanceof LuluParser.FORContext) &&
           !(ctx.getParent() instanceof LuluParser.IFContext && ctx.getParent().getChild(0).equals(ctx)) &&
           !(ctx.getParent() instanceof LuluParser.Func_defContext))
            saveScope(ctx, new LuluSymbolTable(lableGenerator.getNextLable(), currentScope));
    }
    
    @Override
    public void exitBlock(LuluParser.BlockContext ctx){
        releaseScope();
    }

    @Override
    public void exitPARENTHESES(LuluParser.PARENTHESESContext ctx){
        types.put(ctx, types.get(ctx.expr()));
    }
    
    
    @Override
    public void exitCONST(LuluParser.CONSTContext ctx){
        types.put(ctx, types.get(ctx.const_val()));
    }
    
    @Override 
    public void exitINT(LuluParser.INTContext ctx){
        String text = ctx.INT_CONST().getText();
        Integer value;
        if(text.length()>2&&text.substring(0, 2).toLowerCase().equals("0x"))
            value = Integer.parseInt(text.substring(2), 16);
        else value = Integer.parseInt(text);
        values.put(ctx, value);
        types.put(ctx, LuluLexer.INT_CONST);
    }
    
    @Override
    public void exitREAL(LuluParser.REALContext ctx){
        //TODO @mdsinalpha Implement hex real
        values.put(ctx, Double.parseDouble(ctx.REAL_CONST().getText()));
        types.put(ctx, LuluLexer.REAL_CONST);
    }
    
    @Override
    public void exitBOOL(LuluParser.BOOLContext ctx){
        values.put(ctx, ctx.BOOL_CONST().getText().equals("true"));
        types.put(ctx, LuluParser.BOOL_CONST);  
    }
    
    @Override
    public void exitSTRING(LuluParser.STRINGContext ctx){
        values.put(ctx, ctx.STRING_CONST().getText());
        types.put(ctx, LuluParser.STRING_CONST);
    }
    
    @Override 
    public void exitARIT_P1(LuluParser.ARIT_P1Context ctx){
        Token operation = ctx.ARIT_P1().getSymbol();
        Integer rType = LuluTypeSystem.type(types.get(ctx.expr(0)), 
                types.get(ctx.expr(1)), operation.getType());
        if(rType==LuluTypeSystem.UNDEFINED){
                error(String.format("Incompatible types on operation %s.",
                        operation.getText()), operation);
                return;
        }
        types.put(ctx, rType);
    }

    @Override
    public void exitARIT_P2(LuluParser.ARIT_P2Context ctx){
        Token operation = ctx.ARIT_P2().getSymbol();
        Integer rType = LuluTypeSystem.type(types.get(ctx.expr(0)), 
                types.get(ctx.expr(1)), operation.getType());
        if(rType==LuluTypeSystem.UNDEFINED){
            error(String.format("Incompatible types on operation %s.",
                    operation.getText()), operation);
            return;
        }
        types.put(ctx, rType);
    }

    @Override
    public void exitMINUS(LuluParser.MINUSContext ctx){
        Token operation = ctx.MINUS().getSymbol();
        int expr_count = ctx.expr().size();
        Integer rType;
        if (expr_count == 1){
            rType = LuluTypeSystem.type(types.get(ctx.expr(0)), operation.getType());
        }else {
            rType = LuluTypeSystem.type(types.get(ctx.expr(0)), types.get(ctx.expr(1)),
                    operation.getType());
        }
        if(rType== LuluTypeSystem.UNDEFINED) {
            error(String.format("Incompatible types on operation %s.", operation.getText()), operation);
            return;
        }
        types.put(ctx, rType);
    }
    
    
    @Override
    public void exitRef(LuluParser.RefContext ctx){
        // Checking array indexing validation:
        for(LuluParser.ExprContext e: ctx.expr())
            if(types.get(e) == null || ! primMap.containsKey(types.get(e)) ||
                    ! primMap.get(types.get(e)).convertable(primMap.get(LuluParser.INT_CONST))){
                error("Invalid array indexing.", e.getStart());
                return;
            }
        // Refrence has array dimensions as it's value:
        values.put(ctx, ctx.expr().size());
        // Refrence can be array refrence or not:
        types.put(ctx, ctx.expr().isEmpty()?LuluTypeSystem.OBJECT:LuluTypeSystem.ARRAY);
    }
    
    @Override
    public void exitVar(LuluParser.VarContext ctx){
       //TODO @hashemi
       LuluSymbolTable varScope = currentScope;
       Token t = ctx.getStart();
       if(t!=null&&t.getText().equals("this")){
           if(currentTypeScope==null){
               error("Unresolved refrence to keyword 'this'.", t);
               return;
           }
           varScope = currentTypeScope;
       }
       else if(t!=null&&t.getText().equals("super")){
           if(currentTypeScope==null||
                   ((LuluObjectType)currentScope.resolve(currentTypeScope.getTag())).getSuperTypeCode().equals(LuluTypeSystem.OBJECT)){
               error("Unresolved refrence to keyword 'super'.", t);
               return;
           }
           varScope = currentTypeScope.getParent();
       }
       
       LuluType it = null;
       for(LuluParser.RefContext r:ctx.ref()){
           String id = values.get(r).toString();
           it = varScope.resolve(id);
           if(it==null){
               error(String.format("Undefined field %s inside type %s.", id, varScope.getTag()), r.getStart());
               return;
           }
           if(it instanceof LuluArrayType){
               
           }
           
           //varScope = typeScopes.get(((LuluObjectType)it).getTag());
       }
    }
    
    @Override
    public void exitIF(LuluParser.IFContext ctx){
        // TODO @hashmei expr type checking
    }
    
    @Override
    public void exitCASE(LuluParser.CASEContext ctx){
        // TODO @hashemi var type checking
    }
    
    @Override
    public void enterFOR(LuluParser.FORContext ctx){
        // TODO @hashemi expr type checking
        saveScope(ctx, new LuluSymbolTable(lableGenerator.getNextLable(), currentScope));
    }
    
    @Override
    public void enterWHILE(LuluParser.WHILEContext ctx){
        // TODO @hashemi expr type checking
        saveScope(ctx, new LuluSymbolTable(lableGenerator.getNextLable(), currentScope));
    }
    
    @Override
    public void exitPRIM(LuluParser.PRIMContext ctx){
        Integer type = LuluTypeSystem.UNDEFINED;
        switch(ctx.PRIM_TYPE().getText()){
            case "int":
                type = LuluParser.INT_CONST;
                break;
            case "bool":
                type = LuluParser.BOOL_CONST;
                break;
            case "float":
                type = LuluParser.REAL_CONST;
                break;
            case "string":
                type = LuluParser.STRING_CONST;
        }
        types.put(ctx, type);
    }
    
    @Override
    public void exitID(LuluParser.IDContext ctx){
        Token t = ctx.ID().getSymbol();
        LuluType tType = currentScope.resolve(t.getText());
        if(tType == null){
            // Since we are sure this ID is not a PRIM keyword, null result of resolve means:
            error(String.format("Type %s not declared.", t.getText()), t);
            return;
        }else if(!(tType instanceof LuluObjectType)){
            // This ID is taken!
            error(String.format("Type name %s is already taken by another field.", t.getText()), t);
            return;
        }
        types.put(ctx, tType.getTypeCode());
    }
}
