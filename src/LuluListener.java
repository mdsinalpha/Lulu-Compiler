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
	 * Enter a parse tree produced by {@link LuluParser#ft_def}.
	 * @param ctx the parse tree
	 */
	void enterFt_def(LuluParser.Ft_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#ft_def}.
	 * @param ctx the parse tree
	 */
	void exitFt_def(LuluParser.Ft_defContext ctx);
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
	 * Enter a parse tree produced by {@link LuluParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(LuluParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(LuluParser.StmtContext ctx);
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
	 * Enter a parse tree produced by {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LuluParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LuluParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LuluParser#func_call}.
	 * @param ctx the parse tree
	 */
	void enterFunc_call(LuluParser.Func_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#func_call}.
	 * @param ctx the parse tree
	 */
	void exitFunc_call(LuluParser.Func_callContext ctx);
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
	 * Enter a parse tree produced by {@link LuluParser#cond_stmt}.
	 * @param ctx the parse tree
	 */
	void enterCond_stmt(LuluParser.Cond_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#cond_stmt}.
	 * @param ctx the parse tree
	 */
	void exitCond_stmt(LuluParser.Cond_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LuluParser#loop_stmt}.
	 * @param ctx the parse tree
	 */
	void enterLoop_stmt(LuluParser.Loop_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#loop_stmt}.
	 * @param ctx the parse tree
	 */
	void exitLoop_stmt(LuluParser.Loop_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LuluParser#const_val}.
	 * @param ctx the parse tree
	 */
	void enterConst_val(LuluParser.Const_valContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#const_val}.
	 * @param ctx the parse tree
	 */
	void exitConst_val(LuluParser.Const_valContext ctx);
	/**
	 * Enter a parse tree produced by {@link LuluParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(LuluParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LuluParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(LuluParser.TypeContext ctx);
}