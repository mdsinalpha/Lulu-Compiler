// Generated from Lulu.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LuluParser}.
 */
public interface LuluListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LuluParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LuluParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LuluParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LuluParser#ft_dcl}.
	 * @param ctx the parse tree
	 */
	void enterFt_dcl(LuluParser.Ft_dclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#ft_dcl}.
	 * @param ctx the parse tree
	 */
	void exitFt_dcl(LuluParser.Ft_dclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LuluParser#func_dcl}.
	 * @param ctx the parse tree
	 */
	void enterFunc_dcl(LuluParser.Func_dclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#func_dcl}.
	 * @param ctx the parse tree
	 */
	void exitFunc_dcl(LuluParser.Func_dclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LuluParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(LuluParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(LuluParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LuluParser#args_var}.
	 * @param ctx the parse tree
	 */
	void enterArgs_var(LuluParser.Args_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#args_var}.
	 * @param ctx the parse tree
	 */
	void exitArgs_var(LuluParser.Args_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link LuluParser#type_dcl}.
	 * @param ctx the parse tree
	 */
	void enterType_dcl(LuluParser.Type_dclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#type_dcl}.
	 * @param ctx the parse tree
	 */
	void exitType_dcl(LuluParser.Type_dclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LuluParser#var_def}.
	 * @param ctx the parse tree
	 */
	void enterVar_def(LuluParser.Var_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#var_def}.
	 * @param ctx the parse tree
	 */
	void exitVar_def(LuluParser.Var_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link LuluParser#var_val}.
	 * @param ctx the parse tree
	 */
	void enterVar_val(LuluParser.Var_valContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#var_val}.
	 * @param ctx the parse tree
	 */
	void exitVar_val(LuluParser.Var_valContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TYPE}
	 * labeled alternative in {@link LuluParser#ft_def}.
	 * @param ctx the parse tree
	 */
	void enterTYPE(LuluParser.TYPEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TYPE}
	 * labeled alternative in {@link LuluParser#ft_def}.
	 * @param ctx the parse tree
	 */
	void exitTYPE(LuluParser.TYPEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FUNC}
	 * labeled alternative in {@link LuluParser#ft_def}.
	 * @param ctx the parse tree
	 */
	void enterFUNC(LuluParser.FUNCContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FUNC}
	 * labeled alternative in {@link LuluParser#ft_def}.
	 * @param ctx the parse tree
	 */
	void exitFUNC(LuluParser.FUNCContext ctx);
	/**
	 * Enter a parse tree produced by {@link LuluParser#type_def}.
	 * @param ctx the parse tree
	 */
	void enterType_def(LuluParser.Type_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#type_def}.
	 * @param ctx the parse tree
	 */
	void exitType_def(LuluParser.Type_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link LuluParser#component}.
	 * @param ctx the parse tree
	 */
	void enterComponent(LuluParser.ComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#component}.
	 * @param ctx the parse tree
	 */
	void exitComponent(LuluParser.ComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LuluParser#func_def}.
	 * @param ctx the parse tree
	 */
	void enterFunc_def(LuluParser.Func_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#func_def}.
	 * @param ctx the parse tree
	 */
	void exitFunc_def(LuluParser.Func_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link LuluParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(LuluParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(LuluParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ASSIGN}
	 * labeled alternative in {@link LuluParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterASSIGN(LuluParser.ASSIGNContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ASSIGN}
	 * labeled alternative in {@link LuluParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitASSIGN(LuluParser.ASSIGNContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FUNCTIONC}
	 * labeled alternative in {@link LuluParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterFUNCTIONC(LuluParser.FUNCTIONCContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FUNCTIONC}
	 * labeled alternative in {@link LuluParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitFUNCTIONC(LuluParser.FUNCTIONCContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CONDITION}
	 * labeled alternative in {@link LuluParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterCONDITION(LuluParser.CONDITIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CONDITION}
	 * labeled alternative in {@link LuluParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitCONDITION(LuluParser.CONDITIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LOOP}
	 * labeled alternative in {@link LuluParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterLOOP(LuluParser.LOOPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LOOP}
	 * labeled alternative in {@link LuluParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitLOOP(LuluParser.LOOPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RETURN}
	 * labeled alternative in {@link LuluParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterRETURN(LuluParser.RETURNContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RETURN}
	 * labeled alternative in {@link LuluParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitRETURN(LuluParser.RETURNContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BREAK}
	 * labeled alternative in {@link LuluParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBREAK(LuluParser.BREAKContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BREAK}
	 * labeled alternative in {@link LuluParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBREAK(LuluParser.BREAKContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CONTINUE}
	 * labeled alternative in {@link LuluParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterCONTINUE(LuluParser.CONTINUEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CONTINUE}
	 * labeled alternative in {@link LuluParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitCONTINUE(LuluParser.CONTINUEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DESTRUCTION}
	 * labeled alternative in {@link LuluParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterDESTRUCTION(LuluParser.DESTRUCTIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DESTRUCTION}
	 * labeled alternative in {@link LuluParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitDESTRUCTION(LuluParser.DESTRUCTIONContext ctx);
	/**
	 * Enter a parse tree produced by {@link LuluParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(LuluParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(LuluParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link LuluParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(LuluParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(LuluParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link LuluParser#ref}.
	 * @param ctx the parse tree
	 */
	void enterRef(LuluParser.RefContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#ref}.
	 * @param ctx the parse tree
	 */
	void exitRef(LuluParser.RefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BITWISE_NOT}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBITWISE_NOT(LuluParser.BITWISE_NOTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BITWISE_NOT}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBITWISE_NOT(LuluParser.BITWISE_NOTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VAR}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVAR(LuluParser.VARContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VAR}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVAR(LuluParser.VARContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BITWISE_OR}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBITWISE_OR(LuluParser.BITWISE_ORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BITWISE_OR}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBITWISE_OR(LuluParser.BITWISE_ORContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LOGICAL_AND}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLOGICAL_AND(LuluParser.LOGICAL_ANDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LOGICAL_AND}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLOGICAL_AND(LuluParser.LOGICAL_ANDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ARIT_P1}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterARIT_P1(LuluParser.ARIT_P1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code ARIT_P1}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitARIT_P1(LuluParser.ARIT_P1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code BITWISE_AND}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBITWISE_AND(LuluParser.BITWISE_ANDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BITWISE_AND}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBITWISE_AND(LuluParser.BITWISE_ANDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ARIT_P2}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterARIT_P2(LuluParser.ARIT_P2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code ARIT_P2}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitARIT_P2(LuluParser.ARIT_P2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code LOGICAL_OR}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLOGICAL_OR(LuluParser.LOGICAL_ORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LOGICAL_OR}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLOGICAL_OR(LuluParser.LOGICAL_ORContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ALLOCATION}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterALLOCATION(LuluParser.ALLOCATIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ALLOCATION}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitALLOCATION(LuluParser.ALLOCATIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FUNCTION}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFUNCTION(LuluParser.FUNCTIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FUNCTION}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFUNCTION(LuluParser.FUNCTIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BITWISE_XOR}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBITWISE_XOR(LuluParser.BITWISE_XORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BITWISE_XOR}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBITWISE_XOR(LuluParser.BITWISE_XORContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MINUS}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMINUS(LuluParser.MINUSContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MINUS}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMINUS(LuluParser.MINUSContext ctx);
	/**
	 * Enter a parse tree produced by the {@code REL_EQ}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterREL_EQ(LuluParser.REL_EQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code REL_EQ}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitREL_EQ(LuluParser.REL_EQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NIL}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNIL(LuluParser.NILContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NIL}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNIL(LuluParser.NILContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UNARY_OP}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUNARY_OP(LuluParser.UNARY_OPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UNARY_OP}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUNARY_OP(LuluParser.UNARY_OPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PARENTHESES}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPARENTHESES(LuluParser.PARENTHESESContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PARENTHESES}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPARENTHESES(LuluParser.PARENTHESESContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CONST}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCONST(LuluParser.CONSTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CONST}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCONST(LuluParser.CONSTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code REL}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterREL(LuluParser.RELContext ctx);
	/**
	 * Exit a parse tree produced by the {@code REL}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitREL(LuluParser.RELContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LIST}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLIST(LuluParser.LISTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LIST}
	 * labeled alternative in {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLIST(LuluParser.LISTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HANDLE}
	 * labeled alternative in {@link LuluParser#func_call}.
	 * @param ctx the parse tree
	 */
	void enterHANDLE(LuluParser.HANDLEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HANDLE}
	 * labeled alternative in {@link LuluParser#func_call}.
	 * @param ctx the parse tree
	 */
	void exitHANDLE(LuluParser.HANDLEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code READ}
	 * labeled alternative in {@link LuluParser#func_call}.
	 * @param ctx the parse tree
	 */
	void enterREAD(LuluParser.READContext ctx);
	/**
	 * Exit a parse tree produced by the {@code READ}
	 * labeled alternative in {@link LuluParser#func_call}.
	 * @param ctx the parse tree
	 */
	void exitREAD(LuluParser.READContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WRITE}
	 * labeled alternative in {@link LuluParser#func_call}.
	 * @param ctx the parse tree
	 */
	void enterWRITE(LuluParser.WRITEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WRITE}
	 * labeled alternative in {@link LuluParser#func_call}.
	 * @param ctx the parse tree
	 */
	void exitWRITE(LuluParser.WRITEContext ctx);
	/**
	 * Enter a parse tree produced by {@link LuluParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(LuluParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(LuluParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link LuluParser#handle_call}.
	 * @param ctx the parse tree
	 */
	void enterHandle_call(LuluParser.Handle_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#handle_call}.
	 * @param ctx the parse tree
	 */
	void exitHandle_call(LuluParser.Handle_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link LuluParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(LuluParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(LuluParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IF}
	 * labeled alternative in {@link LuluParser#cond_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIF(LuluParser.IFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IF}
	 * labeled alternative in {@link LuluParser#cond_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIF(LuluParser.IFContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CASE}
	 * labeled alternative in {@link LuluParser#cond_stmt}.
	 * @param ctx the parse tree
	 */
	void enterCASE(LuluParser.CASEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CASE}
	 * labeled alternative in {@link LuluParser#cond_stmt}.
	 * @param ctx the parse tree
	 */
	void exitCASE(LuluParser.CASEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FOR}
	 * labeled alternative in {@link LuluParser#loop_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFOR(LuluParser.FORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FOR}
	 * labeled alternative in {@link LuluParser#loop_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFOR(LuluParser.FORContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WHILE}
	 * labeled alternative in {@link LuluParser#loop_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWHILE(LuluParser.WHILEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WHILE}
	 * labeled alternative in {@link LuluParser#loop_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWHILE(LuluParser.WHILEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code INT}
	 * labeled alternative in {@link LuluParser#const_val}.
	 * @param ctx the parse tree
	 */
	void enterINT(LuluParser.INTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code INT}
	 * labeled alternative in {@link LuluParser#const_val}.
	 * @param ctx the parse tree
	 */
	void exitINT(LuluParser.INTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code REAL}
	 * labeled alternative in {@link LuluParser#const_val}.
	 * @param ctx the parse tree
	 */
	void enterREAL(LuluParser.REALContext ctx);
	/**
	 * Exit a parse tree produced by the {@code REAL}
	 * labeled alternative in {@link LuluParser#const_val}.
	 * @param ctx the parse tree
	 */
	void exitREAL(LuluParser.REALContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BOOL}
	 * labeled alternative in {@link LuluParser#const_val}.
	 * @param ctx the parse tree
	 */
	void enterBOOL(LuluParser.BOOLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BOOL}
	 * labeled alternative in {@link LuluParser#const_val}.
	 * @param ctx the parse tree
	 */
	void exitBOOL(LuluParser.BOOLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code STRING}
	 * labeled alternative in {@link LuluParser#const_val}.
	 * @param ctx the parse tree
	 */
	void enterSTRING(LuluParser.STRINGContext ctx);
	/**
	 * Exit a parse tree produced by the {@code STRING}
	 * labeled alternative in {@link LuluParser#const_val}.
	 * @param ctx the parse tree
	 */
	void exitSTRING(LuluParser.STRINGContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PRIM}
	 * labeled alternative in {@link LuluParser#type}.
	 * @param ctx the parse tree
	 */
	void enterPRIM(LuluParser.PRIMContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PRIM}
	 * labeled alternative in {@link LuluParser#type}.
	 * @param ctx the parse tree
	 */
	void exitPRIM(LuluParser.PRIMContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ID}
	 * labeled alternative in {@link LuluParser#type}.
	 * @param ctx the parse tree
	 */
	void enterID(LuluParser.IDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ID}
	 * labeled alternative in {@link LuluParser#type}.
	 * @param ctx the parse tree
	 */
	void exitID(LuluParser.IDContext ctx);
}