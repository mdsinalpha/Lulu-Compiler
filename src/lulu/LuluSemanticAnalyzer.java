package lulu;


import java.util.*;
import javafx.scene.control.TreeItem;
import lulu.gui.LuluRun;
import lulu.model.LuluEntry;

import lulu.model.LuluSymbolTable;
import lulu.model.types.LuluArrayType;
import lulu.model.types.LuluFunctionType;
import lulu.model.types.LuluObjectType;
import lulu.model.types.LuluPrimitiveType;
import lulu.model.types.LuluType;
import lulu.parser.LuluBaseListener;
import lulu.parser.LuluParser;
import lulu.util.LuluError;
import lulu.util.LuluLableGenerator;
import lulu.util.LuluTypeSystem;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 *
 * @author mdsinalpha
 */
public class LuluSemanticAnalyzer extends LuluBaseListener {
        
    public ArrayList<LuluError> errorList;
    
    public static LuluSymbolTable currentScope;
    private LuluSymbolTable currentTypeScope;
    private LuluSymbolTable lastReleasedScope;
    private LuluSymbolTable globalScope;
    private final Map<String, LuluSymbolTable> typeTagToSTMap;
    
    private final ParseTreeProperty<LuluSymbolTable> scopes;
    private final ParseTreeProperty<Object> values;
    private final ParseTreeProperty<LuluType> types;
    private final ParseTreeProperty<ArrayList<String>> argsIDs;
    private final ParseTreeProperty<ArrayList<LuluType>> argsTypes;
    
    private final LuluLableGenerator tagGenerator;
    
    public static final String GLOBAL_TAG = "global";
    public static final String MAIN_TAG = "start";
    
    
    public LuluSemanticAnalyzer(){
        typeTagToSTMap = new HashMap<>();
        errorList = new ArrayList<>();
               
        scopes = new ParseTreeProperty<>();
        values = new ParseTreeProperty<>();
        types = new ParseTreeProperty<>();
        argsIDs = new ParseTreeProperty<>();
        argsTypes = new ParseTreeProperty<>();
        
        tagGenerator = new LuluLableGenerator("S");
    }
     
   
    
    private void error(String message, Token token){
        // Adding an error with it's occurence position inside list of compile errors:
        errorList.add(new LuluError(message, token.getLine(), token.getStartIndex(), token.getStopIndex()));
    }
    
    private void saveScope(ParserRuleContext ctx, LuluSymbolTable scope){
        // Entering an scope.
        currentScope = scope;
        scopes.put(ctx, scope);
        
        // Maintain gui tree:
        TreeItem currentTreeItem = new TreeItem(currentScope.toString());
        LuluRun.scopeDataMap.put(currentTreeItem, currentScope);
        LuluRun.rootItem.getChildren().add(currentTreeItem);
        LuluRun.rootItem = currentTreeItem;
    }
    
    private void releaseScope(){
        // Exiting an scope.
        LuluSymbolTable parent = currentScope.getParent();
        if(parent != null)
            parent.increaseOffset(currentScope.getSize());
        currentScope = parent;
        
        // Maintain gui tree:
        LuluRun.rootItem = LuluRun.rootItem.getParent();
    }
    
    public LuluSymbolTable getScope(ParserRuleContext ctx){
        return scopes.get(ctx);
    }
    
    public Object getValue(ParserRuleContext ctx){
        return values.get(ctx);
    }
     
    @Override
    public void enterProgram(LuluParser.ProgramContext ctx){
        // Program needs a root scope for globals:
        globalScope = new LuluSymbolTable(GLOBAL_TAG);
        saveScope(ctx, globalScope);
        
        /**TEST
        saveScope(ctx, new LuluSymbolTable(MAIN_TAG, LuluSymbolTable.stType.loop));
        currentScope.define("average", new LuluEntry("average", LuluEntry.aModifier.public_, true, 
            new LuluArrayType(new LuluPrimitiveType(LuluParser.REAL_CONST), 5), 17.95, 40));
        releaseScope();
      
        saveScope(ctx, new LuluSymbolTable("animal", LuluSymbolTable.stType.type));
        saveScope(ctx, new LuluSymbolTable("getSound", LuluSymbolTable.stType.conditional));
        releaseScope();
        releaseScope();*/
       
        // Type 'object' is reserved by Lulu compiler:)
        LuluEntry object = new LuluEntry(LuluTypeSystem.OBJECT_TAG, 
                LuluEntry.aModifier.private_, true, new LuluPrimitiveType(LuluTypeSystem.OBJECT), null);
        currentScope.define(LuluTypeSystem.OBJECT_TAG, object);
    }
    
    @Override
    public void exitProgram(LuluParser.ProgramContext ctx){
        // Check if all types are defined.
        if(currentScope.hasUndefinedFields()){
            error("Undefined fields inside declare block.", ctx.getStop());
            return;
        }
        // Check wether start function is defined.
        ArrayList<LuluType> out = new ArrayList<>();
        out.add(new LuluPrimitiveType(LuluParser.INT_CONST));
        LuluFunctionType start = new LuluFunctionType(false, new ArrayList<>(), out);
        LuluEntry entry = currentScope.resolvef(MAIN_TAG, start);
        if(entry == null){
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
        if(ctx.args_var() != null){
           argsTypes.put(ctx.args_var(), new ArrayList<>());
           argsIDs.put(ctx.args_var(), new ArrayList<>());
        }      
    }

    
    @Override
    public void exitFunc_dcl(LuluParser.Func_dclContext ctx){
        // Declaring a function with given signature:
        Token t = ctx.ID().getSymbol();
        ArrayList<LuluType> output = new ArrayList<>();
        ArrayList<LuluType> input = new ArrayList<>();
        if(ctx.args_var() != null){
            if(ctx.args(0) != null)
                output = argsTypes.get(ctx.args(0));
            input = argsTypes.get(ctx.args_var());
        }
        else{
            if(ctx.args().size() == 2){
                output = argsTypes.get(ctx.args(0));
                input = argsTypes.get(ctx.args(1));
            }
            else if(!ctx.args().isEmpty()){
                if(ctx.args(0).getStart().getCharPositionInLine() < t.getCharPositionInLine())
                    output = argsTypes.get(ctx.args(0));
                else input = argsTypes.get(ctx.args(0));
            }
        }
        LuluFunctionType fType = new LuluFunctionType(ctx.getToken(7, 0)!=null, input, output);
        
        if(currentScope.hasf(t.getText(), fType)){
            // This function is declared once!
            error(String.format("Function %s already declared.", t.getText()), t);
            return;
        }
        if(currentScope.has(t.getText())){
            // This ID is taken!
            error(String.format("Function name %s is already taken by another field.", t.getText()), t);
            return;
        }
        LuluEntry entry = new LuluEntry(t.getText(), LuluEntry.aModifier.public_, false, fType);
        currentScope.define(t.getText(), entry);
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
        if(brackets != 0){
            // This is an array!
            LuluArrayType aType = new LuluArrayType(types.get(ctx.type()), brackets);
            argsTypes.get(ctx).add(aType);
        }else{
            argsTypes.get(ctx).add(types.get(ctx.type()));
        }
    }
    
    
    @Override 
    public void enterArgs_var(LuluParser.Args_varContext ctx){
        // Moving parent's LuluType list to child's context, so when args exits we can add a LuluType inside it!
        ArrayList<LuluType> tArgsTypes = argsTypes.get(ctx.getParent());
        ArrayList<String> tArgsIDs = argsIDs.get(ctx.getParent());
        if(tArgsTypes != null)
            argsTypes.put(ctx, tArgsTypes);
        if(tArgsIDs != null)
            argsIDs.put(ctx, tArgsIDs);
    }
    
    @Override
    public void exitArgs_var(LuluParser.Args_varContext ctx){
        // Counting brackets([) to determine array dimensions.
        Integer brackets = ctx.getTokens(9).size();
        if(brackets != 0){
            // This is an array!
            LuluArrayType aType = new LuluArrayType(types.get(ctx.type()), brackets);
            argsTypes.get(ctx).add(aType);
        }else{
            argsTypes.get(ctx).add(types.get(ctx.type()));
        }
        argsIDs.get(ctx).add(ctx.ID().getText());
        
        // Function definition args_var properties:
        if(ctx.getParent() instanceof LuluParser.Func_defContext){
            for(int i=0;i<argsTypes.get(ctx).size();i++){
                if(!currentScope.has(argsIDs.get(ctx).get(i))){
                    String ID = argsIDs.get(ctx).get(i);
                    currentScope.define(ID, 
                            new LuluEntry(ID, LuluEntry.aModifier.public_,
                                false, argsTypes.get(ctx).get(i)));
                }else{
                    error("Duplicate variable name in function definition.", ctx.getStart());
                    return;
                }
            }
        }
    }
    
    @Override
    public void exitType_dcl(LuluParser.Type_dclContext ctx){
        Token t = ctx.ID().getSymbol();
        LuluEntry entry = currentScope.resolve(t.getText());
        if(entry != null && entry.getType() instanceof LuluObjectType){
            // This type is declared once!
            error(String.format("Type %s already declared.", t.getText()), t);
            return;
        }
        else if(entry != null){
            // This ID is taken!
            error(String.format("Type name %s is already taken by another field.", t.getText()), t);
            return;
        }
        // Declare a new type with given ID:
        entry = new LuluEntry(t.getText(), LuluEntry.aModifier.public_, 
                true, new LuluObjectType(t.getText()));
        currentScope.define(t.getText(), entry);
    }
    
    @Override
    public void exitVar_def(LuluParser.Var_defContext ctx){
        types.put(ctx, new LuluPrimitiveType(LuluTypeSystem.UNDEFINED));
        // Define a variable inside current scope's symbol table:
        if(!(ctx.getParent() instanceof LuluParser.Type_defContext) &&
                ctx.ACCSSMOD() != null){
            error("Access modifiers are only allowed inside a type block.", ctx.ACCSSMOD().getSymbol());
            return;
        }
        LuluEntry.aModifier tAM;
        if(ctx.getParent() instanceof LuluParser.Type_defContext){
            tAM = LuluEntry.aModifier.private_;
        }else{
            tAM = LuluEntry.aModifier.public_;
        }
        if(ctx.ACCSSMOD() != null)
            switch(ctx.ACCSSMOD().getText()){
                case "private":
                    tAM = LuluEntry.aModifier.private_;
                    break;
                case "protected":
                    tAM = LuluEntry.aModifier.protected_;
                    break;
                case "public":
                    tAM = LuluEntry.aModifier.public_;
                    break;
        }
        boolean tConst = ctx.getToken(12, 0) != null;
        LuluType tType = types.get(ctx.type());
        for(LuluParser.Var_valContext v: ctx.var_val()){
            Token tID = v.ref().ID().getSymbol();
            if(currentScope.has(tID.getText())){
                // This ID is taken!
                error(String.format("Variable name %s is already taken by another field.", tID.getText()), tID);
                return;
            }
            Integer dimensions = (Integer) values.get(v.ref());
            if(dimensions != 0)
                tType = new LuluArrayType(tType, dimensions);
            if(v.expr() != null){
                LuluType expType = types.get(v.expr());
                if(!expType.convertable(tType)){
                    // Auto cast error in auto cast assignment.
                    error(String.format("Cannot auto cast %s to %s.", expType, tType), 
                            v.getToken(6, 0).getSymbol());
                    return;
                }
            }
            currentScope.define(tID.getText(), 
                    new LuluEntry(tID.getText(), tAM, tConst, tType));
        }
    }
   
    @Override
    public void exitRef(LuluParser.RefContext ctx){
        // Checking array indexing validation:
        for(LuluParser.ExprContext exp: ctx.expr())
            if(types.get(exp).convertable(new LuluPrimitiveType(LuluParser.INT_CONST))){
                error("Invalid array indexing.", exp.getStart());
                return;
            }
        // Refrence can be array refrence or not:
        values.put(ctx, ctx.expr().size());
    }
    
    @Override 
    public void enterType_def(LuluParser.Type_defContext ctx){
        Token t = ctx.ID(0).getSymbol();
        LuluEntry entry = currentScope.resolve(t.getText());
        if(entry == null){
            // This type is not declared but also only defined!
            entry = new LuluEntry(t.getText(), LuluEntry.aModifier.public_,
                        true, new LuluObjectType(t.getText()));
        } else if(!(entry.getType() instanceof LuluObjectType)){
            // This ID is taken!
            error(String.format("Type name %s is already taken by another field.", t.getText()), t);
            return;
        } else if(entry.getType().isDefined()){
            // This type is defined once!
            error(String.format("Type %s already defined.", t.getText()), t);
            return;
        }
        if(ctx.ID(1)==null){
            // There is no super class definition for this definition:)
            LuluSymbolTable tData = new LuluSymbolTable(t.getText(), LuluSymbolTable.stType.type);
            typeTagToSTMap.put(t.getText(), tData);
            entry.setData(tData);
            ((LuluObjectType)entry.getType()).define();
            currentScope.define(t.getText(), entry);
            currentTypeScope = tData;
            LuluEntry defaultConstructor = new LuluEntry(t.getText(),
                    LuluEntry.aModifier.public_, true,
                    new LuluFunctionType(false,
                new ArrayList<>(), new ArrayList<>()));
            currentTypeScope.define(t.getText(), defaultConstructor);
            saveScope(ctx, tData);
            return;
        }
        
        Token s = ctx.ID(1).getSymbol();
        LuluEntry superEntry = currentScope.resolve(s.getText());
        if(superEntry == null){
            // Super type not found!
            error(String.format("Type %s not declared.", s.getText()), s);
            return;
        }
        else if(!(superEntry.getType() instanceof LuluObjectType)){
            // This ID is taken!
            error(String.format("Super name %s must be a type.", s.getText()), s);
            return;
        }else if(!superEntry.getType().isDefined()){
            // Super type is not defined yet.
            error(String.format("Super type %s must be defined before using an inheritance relation.",
                    s.getText()), s);
            return;
        }
        // Finally, this type should inherit another type!
        LuluSymbolTable tData = new LuluSymbolTable(t.getText(), LuluSymbolTable.stType.type,
                (LuluSymbolTable)superEntry.getData());
        entry.setData(tData);
        typeTagToSTMap.put(t.getText(), tData);
        ((LuluObjectType)entry.getType()).setSuperType(superEntry.getType());
        ((LuluObjectType)entry.getType()).define();
        currentScope.define(t.getText(), entry);
        currentTypeScope = tData;
        LuluEntry defaultConstructor = new LuluEntry(t.getText(),
                    LuluEntry.aModifier.public_, true,
                    new LuluFunctionType(false,
                    new ArrayList<>(), new ArrayList<>()));
        currentTypeScope.define(t.getText(), defaultConstructor);
        saveScope(ctx, tData);
    }
    
    @Override
    public void exitType_def(LuluParser.Type_defContext ctx){
        releaseScope();
        currentTypeScope = null;
        currentScope = globalScope;
    }
    
    @Override
    public void enterFunc_def(LuluParser.Func_defContext ctx){
        // Define a function inside current scope's symbol table:
        if(!(ctx.getParent() instanceof LuluParser.Type_defContext) &&
                ctx.ACCSSMOD() != null){
            error("Access modifiers are only allowed inside a type block.", ctx.ACCSSMOD().getSymbol());
            return;
        }
        ctx.args_var().forEach(args -> {argsTypes.put(args, new ArrayList<>());
                                        argsIDs.put(args, new ArrayList<>());});
        saveScope(ctx, new LuluSymbolTable(
                (currentTypeScope!=null?currentTypeScope.getTag()+"_":"")+
                        ctx.ID().getText(), LuluSymbolTable.stType.function));
    }
    
    @Override
    public void exitFunc_def(LuluParser.Func_defContext ctx){
        Token t = ctx.ID().getSymbol();
        if(currentScope.has(t.getText())){
            // This ID is taken!
            error(String.format("Function name %s is already taken by another field.", t.getText()), t);
            return;
        }
        ArrayList<LuluType> output = new ArrayList<>();
        ArrayList<LuluType> input = new ArrayList<>();
        if(ctx.args_var().size() == 2){
            output = argsTypes.get(ctx.args_var(0));
            input = argsTypes.get(ctx.args_var(1));
        }else if(!ctx.args_var().isEmpty()){
            if(ctx.args_var(0).getStart().getCharPositionInLine() 
                    < t.getCharPositionInLine())
                output = argsTypes.get(ctx.args_var(0));
            else input = argsTypes.get(ctx.args_var(0));
                
        }
        LuluFunctionType fType = new LuluFunctionType(false, input, output);
        LuluEntry entry;
        if(currentScope.hasf(t.getText(), fType)){
            entry = currentScope.resolvef(t.getText(), fType);
            if(!entry.getType().isDefined()){
                // This function is defined once!
                error(String.format("Function %s already defined.", t.getText()), t);
                return;
            }
            ((LuluFunctionType)entry.getType()).define();
        }
        else{
            LuluEntry.aModifier tAM = LuluEntry.aModifier.public_;
            if(ctx.ACCSSMOD() != null)
            switch(ctx.ACCSSMOD().getText()){
                case "private":
                    tAM = LuluEntry.aModifier.private_;
                    break;
                case "protected":
                    tAM = LuluEntry.aModifier.protected_;
                    break;
                case "public":
                    tAM = LuluEntry.aModifier.public_;
                    break;
           }
           entry = new LuluEntry(t.getText(), tAM, true, fType);
           ((LuluFunctionType)entry.getType()).define();
        }
        entry.setData(lastReleasedScope);
        currentScope.define(t.getText(), entry);
    }
    
    @Override
    public void enterBlock(LuluParser.BlockContext ctx){
        // Cheking wether block's symbol talbe is saved by block's parent or not:
        if(!(ctx.getParent() instanceof LuluParser.WHILEContext) &&
           !(ctx.getParent() instanceof LuluParser.FORContext) &&
           !(ctx.getParent() instanceof LuluParser.IFContext && ctx.getParent().getChild(0).equals(ctx)) &&
           !(ctx.getParent() instanceof LuluParser.Func_defContext))
            saveScope(ctx, new LuluSymbolTable(tagGenerator.getNextLable()));
    }
    
    @Override
    public void exitBlock(LuluParser.BlockContext ctx){
        lastReleasedScope = currentScope;
        releaseScope();
    }
    
    public void assignToVar(LuluParser.AssignContext ctx, int ind){
        if(!types.get(ctx.expr()).convertable(types.get(ctx.var(ind)))){
            error(String.format("Cannot assign %s to %s.", ctx.expr().getText(),
                        ctx.var(ind).getText()), ctx.getToken(6, 0).getSymbol());
            return;
        }
        LuluEntry entry = (LuluEntry) values.get(ctx.var(ind));
        if(entry.getIsConst()){
            error(String.format("Cannot assign to a const variable %s.",
                    ctx.var(ind).getText()), ctx.getToken(6, 0).getSymbol());
            return;
        }
        if(entry.getAccessModifier() == LuluEntry.aModifier.private_ &&
                entry.getScope() != currentTypeScope){
            error(String.format("Assigning value to a private variable %s"
                    + " outside of Type Scope", ctx.var(ind).getText()),
                    ctx.getToken(6, 0).getSymbol());
        }else if(entry.getAccessModifier() == LuluEntry.aModifier.protected_){
            LuluSymbolTable sc = currentScope;
            while(sc != null && sc != entry.getScope()){
                sc = sc.getParent();
            }
            if(sc == null){
                error(String.format("Assigning value to a protocted variable %s"
                    + " outside of Inhreited Type Scopes", ctx.var(ind).getText()),
                    ctx.getToken(6, 0).getSymbol());
            }
        }
    }
    
    @Override
    public void exitAssign(LuluParser.AssignContext ctx){
        if(ctx.var().size()==1){
            assignToVar(ctx, 0);
        }else{
            if(!(types.get(ctx.expr()) instanceof LuluFunctionType)){
                error("multiple assignment only allowed on function calls",
                        ctx.getToken(6, 0).getSymbol());
            }else{
                LuluFunctionType expr_t = (LuluFunctionType) types.get(ctx.expr());
                for(int i=0; i<ctx.var().size(); i++){
                    assignToVar(ctx, i);
                }
            }
        }
    }
    
    @Override
    public void exitRETURN(LuluParser.RETURNContext ctx){
        LuluSymbolTable temp = currentScope;
        boolean error = true;
        while(temp != null){
            if(temp.getTableType().equals(LuluSymbolTable.stType.function)){
                error = false;
                break;
            }
            temp = temp.getParent();
        }
        if(error) error("No function block found for statement 'return'.", ctx.getStart());
    }
    
    @Override
    public void exitBREAK(LuluParser.BREAKContext ctx){
        LuluSymbolTable temp = currentScope;
        boolean error = true;
        while(temp != null){
            if(temp.getTableType().equals(LuluSymbolTable.stType.loop)){
                error = false;
                break;
            }
            temp = temp.getParent();
        }
        if(error) error("No loop block found for statement 'break'.", ctx.getStart());
    }
    
    @Override
    public void exitCONTINUE(LuluParser.CONTINUEContext ctx){
        LuluSymbolTable temp = currentScope;
        boolean error = true;
        while(temp != null){
            if(temp.getTableType().equals(LuluSymbolTable.stType.loop)){
                error = false;
                break;
            }
            temp = temp.getParent();
        }
        if(error) error("No loop block found for statement 'continue'.", ctx.getStart());
    }
    
    @Override
    public void exitVar(LuluParser.VarContext ctx){
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
           if(currentTypeScope==null||currentTypeScope.getParent()==null){
               error("Unresolved refrence to keyword 'super'.", t);
               return;
           }
           varScope = currentTypeScope.getParent();
       }
       Token r = ctx.ref(0).ID().getSymbol();
       LuluEntry entry = null;
       LuluType entry_t = null;
       for(LuluParser.RefContext ref:ctx.ref()){
           if (varScope == null){
                error(String.format("Cannot access a field of %s since it is not a type", r.getText()), r);
                return;
           }
           r = ref.ID().getSymbol();
           entry = varScope.resolve(r.getText());
           if(entry == null){
               error(String.format("Unresolved refrence %s", r.getText()), r);
               return;
           }
           if((Integer) values.get(ref) > 0){
               if(!(entry.getType() instanceof LuluArrayType)){
                   error("[] not expected.", r);
                   return;
               }
               else if(!((LuluArrayType)entry.getType()).getDimensions().equals(values.get(ref))){
                   error("Incorrect number of dimensions.", r);
                   return;
               }else{
                   entry_t = ((LuluArrayType) entry.getType()).getElementType();
               }
           }else{
               entry_t = entry.getType();
           }
           if(entry_t instanceof LuluObjectType){
               String type_tag = ((LuluObjectType) entry_t).getTag();
               varScope = typeTagToSTMap.get(type_tag);
           }else{
               varScope = null;
           }
       }
       types.put(ctx, entry_t);
       values.put(ctx, entry);
    }
    
    @Override
    public void enterIF(LuluParser.IFContext ctx){
        saveScope(ctx, new LuluSymbolTable(tagGenerator.getNextLable(), 
                LuluSymbolTable.stType.conditional));
    }
    
    @Override
    public void exitIF(LuluParser.IFContext ctx){
        if(!types.get(ctx.expr()).convertable(new LuluPrimitiveType(LuluParser.BOOL_CONST))){
            error(String.format("Can not evaluate %s to boolean.",ctx.expr().getText()),
                    ctx.expr().getStart());
        }    
    }
    
    @Override
    public void exitCASE(LuluParser.CASEContext ctx){
        if(!types.get(ctx.var()).convertable(new LuluPrimitiveType(LuluParser.INT_CONST))){
            error(String.format("Can not evaluate %s to integer.",ctx.var().getText()),
                    ctx.var().getStart());
        }
    }
    
    @Override
    public void enterFOR(LuluParser.FORContext ctx){
        saveScope(ctx, new LuluSymbolTable(tagGenerator.getNextLable(), 
                LuluSymbolTable.stType.loop));
    }
    
    @Override
    public void exitFOR(LuluParser.FORContext ctx){
        if(!types.get(ctx.expr()).convertable(new LuluPrimitiveType(LuluParser.BOOL_CONST))){
            error(String.format("Can not evaluate %s to boolean.",ctx.expr().getText()),
                    ctx.expr().getStart());
        }
    }
    
    @Override
    public void enterWHILE(LuluParser.WHILEContext ctx){
        saveScope(ctx, new LuluSymbolTable(tagGenerator.getNextLable(), 
                LuluSymbolTable.stType.loop));
    }
    
    @Override
    public void exitWHILE(LuluParser.WHILEContext ctx){
        if(!types.get(ctx.expr()).convertable(new LuluPrimitiveType(LuluParser.BOOL_CONST))){
            error(String.format("Can not evaluate %s to boolean.",ctx.expr().getText()),
                    ctx.expr().getStart());
        }
    }
        
    
    @Override
    public void exitPARENTHESES(LuluParser.PARENTHESESContext ctx){
        types.put(ctx, types.get(ctx.expr()));
    }
    
    @Override
    public void exitUNARY_OP(LuluParser.UNARY_OPContext ctx){
        Token operation = ctx.UNARY_OP().getSymbol();
        LuluType rType = LuluTypeSystem.type(types.get(ctx.expr()), operation.getType());
        if(rType.getTypeCode()== LuluTypeSystem.UNDEFINED) {
            error(String.format("Incompatible types on operation %s.", operation.getText()), operation);
            return;
        }
        types.put(ctx, rType);
    }
    
    @Override
    public void exitBITWISE_NOT(LuluParser.BITWISE_NOTContext ctx){
        Token operation = ctx.BITWISE_NOT().getSymbol();
        LuluType rType = LuluTypeSystem.type(types.get(ctx.expr()), operation.getType());
        if(rType.getTypeCode()== LuluTypeSystem.UNDEFINED) {
            error(String.format("Incompatible types on operation %s.", operation.getText()), operation);
            return;
        }
        types.put(ctx, rType);
    }
    
    @Override 
    public void exitARIT_P1(LuluParser.ARIT_P1Context ctx){
        Token operation = ctx.ARIT_P1().getSymbol();
        LuluType rType = LuluTypeSystem.type(types.get(ctx.expr(0)), 
                types.get(ctx.expr(1)), operation.getType());
        if(rType.getTypeCode()==LuluTypeSystem.UNDEFINED){
                error(String.format("Incompatible types on operation %s.",
                        operation.getText()), operation);
                return;
        }
        types.put(ctx, rType);
    }

    @Override
    public void exitARIT_P2(LuluParser.ARIT_P2Context ctx){
        Token operation = ctx.ARIT_P2().getSymbol();
        LuluType rType = LuluTypeSystem.type(types.get(ctx.expr(0)), 
                types.get(ctx.expr(1)), operation.getType());
        if(rType.getTypeCode()==LuluTypeSystem.UNDEFINED){
            error(String.format("Incompatible types on operation %s.",
                    operation.getText()), operation);
            return;
        }
        types.put(ctx, rType);
    }

    @Override
    public void exitMINUS(LuluParser.MINUSContext ctx){
        Token operation = ctx.MINUS().getSymbol();
        // There is two kind of MINUS rules depending on expr count!
        int expr_count = ctx.expr().size();
        LuluType rType;
        if (expr_count == 1){
            rType = LuluTypeSystem.type(types.get(ctx.expr(0)), operation.getType());
        }else {
            rType = LuluTypeSystem.type(types.get(ctx.expr(0)), types.get(ctx.expr(1)),
                    operation.getType());
        }
        if(rType.getTypeCode()== LuluTypeSystem.UNDEFINED) {
            error(String.format("Incompatible types on operation %s.", operation.getText()), operation);
            return;
        }
        types.put(ctx, rType);
    }
    
    @Override
    public void exitBITWISE_AND(LuluParser.BITWISE_ANDContext ctx){
        Token operation = ctx.BITWISE_AND().getSymbol();
        LuluType rType = LuluTypeSystem.type(types.get(ctx.expr(0)), 
                types.get(ctx.expr(1)), operation.getType());
        if(rType.getTypeCode()==LuluTypeSystem.UNDEFINED){
                error(String.format("Incompatible types on operation %s.",
                        operation.getText()), operation);
                return;
        }
        types.put(ctx, rType);
    }
    
    @Override
    public void exitBITWISE_XOR(LuluParser.BITWISE_XORContext ctx){
        Token operation = ctx.BITWISE_XOR().getSymbol();
        LuluType rType = LuluTypeSystem.type(types.get(ctx.expr(0)), 
                types.get(ctx.expr(1)), operation.getType());
        if(rType.getTypeCode()==LuluTypeSystem.UNDEFINED){
                error(String.format("Incompatible types on operation %s.",
                        operation.getText()), operation);
                return;
        }
        types.put(ctx, rType);
    }
    
    @Override
    public void exitBITWISE_OR(LuluParser.BITWISE_ORContext ctx){
        Token operation = ctx.BITWISE_OR().getSymbol();
        LuluType rType = LuluTypeSystem.type(types.get(ctx.expr(0)), 
                types.get(ctx.expr(1)), operation.getType());
        if(rType.getTypeCode()==LuluTypeSystem.UNDEFINED){
                error(String.format("Incompatible types on operation %s.",
                        operation.getText()), operation);
                return;
        }
        types.put(ctx, rType);
    }
    
    @Override
    public void exitREL(LuluParser.RELContext ctx){
        Token operation = ctx.REL().getSymbol();
        LuluType rType = LuluTypeSystem.type(types.get(ctx.expr(0)), 
                types.get(ctx.expr(1)), operation.getType());
        if(rType.getTypeCode()==LuluTypeSystem.UNDEFINED){
                error(String.format("Incompatible types on operation %s.",
                        operation.getText()), operation);
                return;
        }
        types.put(ctx, rType);
    }
    
    @Override
    public void exitREL_EQ(LuluParser.REL_EQContext ctx){
        Token operation = ctx.REL_EQ().getSymbol();
        LuluType rType = LuluTypeSystem.type(types.get(ctx.expr(0)), 
                types.get(ctx.expr(1)), operation.getType());
        if(rType.getTypeCode()==LuluTypeSystem.UNDEFINED){
                error(String.format("Incompatible types on operation %s.",
                        operation.getText()), operation);
                return;
        }
        types.put(ctx, rType);
    }       
    
    @Override
    public void exitLOGICAL_AND(LuluParser.LOGICAL_ANDContext ctx){
        Token operation = ctx.LOGICAL_AND().getSymbol();
        LuluType rType = LuluTypeSystem.type(types.get(ctx.expr(0)), 
                types.get(ctx.expr(1)), operation.getType());
        if(rType.getTypeCode()==LuluTypeSystem.UNDEFINED){
                error(String.format("Incompatible types on operation %s.",
                        operation.getText()), operation);
                return;
        }
        types.put(ctx, rType);
    }
    
    @Override
    public void exitLOGICAL_OR(LuluParser.LOGICAL_ORContext ctx){
        Token operation = ctx.LOGICAL_OR().getSymbol();
        LuluType rType = LuluTypeSystem.type(types.get(ctx.expr(0)), 
                types.get(ctx.expr(1)), operation.getType());
        if(rType.getTypeCode()==LuluTypeSystem.UNDEFINED){
                error(String.format("Incompatible types on operation %s.",
                        operation.getText()), operation);
                return;
        }
        types.put(ctx, rType);
    }
    
    @Override
    public void exitDESTRUCTION(LuluParser.DESTRUCTIONContext ctx){
        Token t = ctx.ID().getSymbol();
        LuluEntry entry = currentScope.resolve(t.getText());
        if(entry == null || !(entry.getType() instanceof LuluObjectType))
            error(String.format("Destruction on %s not allowed.", t.getText()), t);
    }
    
    @Override
    public void exitALLOCATION(LuluParser.ALLOCATIONContext ctx){
        Token t = ctx.handle_call().ID().getSymbol();
        LuluEntry entry = currentScope.resolve(ctx.handle_call().ID().getText());
        if(entry == null || !(entry.getType() instanceof LuluObjectType)){
            error(String.format("Allocation on non class type %s not allowed.", t.getText()), t);
            return;
        } 
        types.put(ctx, entry.getType());
    }
    
    @Override
    public void exitFUNCTION(LuluParser.FUNCTIONContext ctx){
        types.put(ctx, types.get(ctx.func_call()));
    }
    
    @Override
    public void exitVARC(LuluParser.VARCContext ctx){
        types.put(ctx, types.get(ctx.var()));
    }
    
    @Override
    public void exitLISTC(LuluParser.LISTCContext ctx){
        types.put(ctx, types.get(ctx.list()));
    }
    
    @Override
    public void exitNIL(LuluParser.NILContext ctx){
        types.put(ctx, new LuluPrimitiveType(LuluTypeSystem.NIL));
    }
    
    @Override
    public void exitCONST(LuluParser.CONSTContext ctx){
        types.put(ctx, types.get(ctx.const_val()));
    }
    
    @Override 
    public void exitINT(LuluParser.INTContext ctx){
        types.put(ctx, new LuluPrimitiveType(LuluParser.INT_CONST));
        String text = ctx.INT_CONST().getText();
        Integer value;
        if(text.length()>2&&text.substring(0, 2).toLowerCase().equals("0x"))
            // It's hexadecimal!
            value = Integer.parseInt(text.substring(2), 16);
        else value = Integer.parseInt(text);
        values.put(ctx, value);
    }
    
    @Override
    public void exitREAL(LuluParser.REALContext ctx){
        types.put(ctx, new LuluPrimitiveType(LuluParser.REAL_CONST));
        try{
            values.put(ctx, Double.parseDouble(ctx.REAL_CONST().getText()));
        }catch(NumberFormatException e){
            values.put(ctx, ctx.REAL_CONST().getText());
        }
    }
    
    @Override
    public void exitBOOL(LuluParser.BOOLContext ctx){
        types.put(ctx, new LuluPrimitiveType(LuluParser.BOOL_CONST));  
        values.put(ctx, ctx.BOOL_CONST().getText().equals("true"));
        
    }
    
    @Override
    public void exitSTRING(LuluParser.STRINGContext ctx){
        types.put(ctx, new LuluPrimitiveType(LuluParser.STRING_CONST));
        values.put(ctx, ctx.STRING_CONST().getText());
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
        types.put(ctx, new LuluPrimitiveType(type));
    }
    
    
    @Override
    public void exitID(LuluParser.IDContext ctx){
        Token t = ctx.ID().getSymbol();
        LuluEntry entry = currentScope.resolve(t.getText());
        if(entry == null){
            // Since we are sure this ID is not a PRIM keyword, null result of resolve means:
            error(String.format("Type %s not declared.", t.getText()), t);
            return;
        }else if(!(entry.getType() instanceof LuluObjectType)){
            // This ID is taken!
            error(String.format("Type name %s is already taken by another field.", t.getText()), t);
            return;
        }
        types.put(ctx, entry.getType());
    }
    
    @Override
    public void exitWRITE(LuluParser.WRITEContext ctx){
        types.put(ctx, new LuluPrimitiveType(LuluParser.INT_CONST));
    }
    
    @Override
    public void exitREAD(LuluParser.READContext ctx){
        types.put(ctx, types.get(ctx.var()));
    }
    
    @Override
    public void exitList(LuluParser.ListContext ctx){
        types.put(ctx, new LuluPrimitiveType(LuluTypeSystem.ARRAY));
    }
    
    @Override
    public void enterParams(LuluParser.ParamsContext ctx){
        if(argsTypes.get(ctx.parent) != null){
            argsTypes.put(ctx, argsTypes.get(ctx.parent));
        }else{
            argsTypes.put(ctx, new ArrayList<>());
        }
    }
    
    @Override
    public void exitParams(LuluParser.ParamsContext ctx){
        ArrayList<LuluType> params = argsTypes.get(ctx);
        params.add(types.get(ctx.expr()));
    }
    
    @Override
    public void exitHandle_call(LuluParser.Handle_callContext ctx){
        ArrayList<LuluType> paramsTypes;
        if(ctx.params() != null){
            paramsTypes = argsTypes.get(ctx.params());
        }else{
            paramsTypes = new ArrayList<>();
        }
        values.put(ctx, paramsTypes);
    }
    
    @Override
    public void exitHANDLE(LuluParser.HANDLEContext ctx){
        if (ctx.var() != null){
            if(!(types.get(ctx.var()) instanceof LuluObjectType)){
                error(String.format("%s type can not be dereferenced", ctx), ctx.getStart());
            }else{
                LuluObjectType varType = (LuluObjectType) types.get(ctx.var());
                LuluSymbolTable varTypeST = typeTagToSTMap.get(varType.getTag());
                LuluEntry func_entry = varTypeST.resolvef(ctx.handle_call().ID().getText(),
                        new LuluFunctionType(false,
                        (ArrayList<LuluType>) values.get(ctx.handle_call()),
                        new ArrayList<>()));
                types.put(ctx,(LuluFunctionType) func_entry.getType());
            }
        }else{
            Collections.reverse((ArrayList<LuluType>) values.get(ctx.handle_call()));
            LuluEntry func_entry = currentScope.resolvef(ctx.handle_call().ID().getText(),
                        new LuluFunctionType(false,
                        (ArrayList<LuluType>) values.get(ctx.handle_call()),
                        new ArrayList<>()));
            if (func_entry == null){
                error(String.format("cannot resolve function %s", ctx.handle_call().getText()),
                        ctx.getStart());
                types.put(ctx, new LuluPrimitiveType(LuluTypeSystem.UNDEFINED));
            }else{
                types.put(ctx,(LuluFunctionType) func_entry.getType());
            }
        }
    }
    
}
