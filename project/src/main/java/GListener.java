// Generated from G.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GParser}.
 */
public interface GListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(GParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(GParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#pgm_body}.
	 * @param ctx the parse tree
	 */
	void enterPgm_body(GParser.Pgm_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#pgm_body}.
	 * @param ctx the parse tree
	 */
	void exitPgm_body(GParser.Pgm_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(GParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(GParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#string_decl}.
	 * @param ctx the parse tree
	 */
	void enterString_decl(GParser.String_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#string_decl}.
	 * @param ctx the parse tree
	 */
	void exitString_decl(GParser.String_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#str}.
	 * @param ctx the parse tree
	 */
	void enterStr(GParser.StrContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#str}.
	 * @param ctx the parse tree
	 */
	void exitStr(GParser.StrContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(GParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(GParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#var_type}.
	 * @param ctx the parse tree
	 */
	void enterVar_type(GParser.Var_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#var_type}.
	 * @param ctx the parse tree
	 */
	void exitVar_type(GParser.Var_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#any_type}.
	 * @param ctx the parse tree
	 */
	void enterAny_type(GParser.Any_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#any_type}.
	 * @param ctx the parse tree
	 */
	void exitAny_type(GParser.Any_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#id_list}.
	 * @param ctx the parse tree
	 */
	void enterId_list(GParser.Id_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#id_list}.
	 * @param ctx the parse tree
	 */
	void exitId_list(GParser.Id_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#id_tail}.
	 * @param ctx the parse tree
	 */
	void enterId_tail(GParser.Id_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#id_tail}.
	 * @param ctx the parse tree
	 */
	void exitId_tail(GParser.Id_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#param_decl_list}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl_list(GParser.Param_decl_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#param_decl_list}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl_list(GParser.Param_decl_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#param_decl}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl(GParser.Param_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#param_decl}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl(GParser.Param_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#param_decl_tail}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl_tail(GParser.Param_decl_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#param_decl_tail}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl_tail(GParser.Param_decl_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#func_declarations}.
	 * @param ctx the parse tree
	 */
	void enterFunc_declarations(GParser.Func_declarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#func_declarations}.
	 * @param ctx the parse tree
	 */
	void exitFunc_declarations(GParser.Func_declarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void enterFunc_decl(GParser.Func_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void exitFunc_decl(GParser.Func_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#func_body}.
	 * @param ctx the parse tree
	 */
	void enterFunc_body(GParser.Func_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#func_body}.
	 * @param ctx the parse tree
	 */
	void exitFunc_body(GParser.Func_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void enterStmt_list(GParser.Stmt_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void exitStmt_list(GParser.Stmt_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(GParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(GParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#base_stmt}.
	 * @param ctx the parse tree
	 */
	void enterBase_stmt(GParser.Base_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#base_stmt}.
	 * @param ctx the parse tree
	 */
	void exitBase_stmt(GParser.Base_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(GParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(GParser.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign_expr(GParser.Assign_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign_expr(GParser.Assign_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void enterRead_stmt(GParser.Read_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void exitRead_stmt(GParser.Read_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWrite_stmt(GParser.Write_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWrite_stmt(GParser.Write_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(GParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(GParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(GParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(GParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#expr_prefix}.
	 * @param ctx the parse tree
	 */
	void enterExpr_prefix(GParser.Expr_prefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#expr_prefix}.
	 * @param ctx the parse tree
	 */
	void exitExpr_prefix(GParser.Expr_prefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(GParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(GParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#factor_prefix}.
	 * @param ctx the parse tree
	 */
	void enterFactor_prefix(GParser.Factor_prefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#factor_prefix}.
	 * @param ctx the parse tree
	 */
	void exitFactor_prefix(GParser.Factor_prefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#postfix_expr}.
	 * @param ctx the parse tree
	 */
	void enterPostfix_expr(GParser.Postfix_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#postfix_expr}.
	 * @param ctx the parse tree
	 */
	void exitPostfix_expr(GParser.Postfix_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#call_expr}.
	 * @param ctx the parse tree
	 */
	void enterCall_expr(GParser.Call_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#call_expr}.
	 * @param ctx the parse tree
	 */
	void exitCall_expr(GParser.Call_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list(GParser.Expr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list(GParser.Expr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#expr_list_tail}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list_tail(GParser.Expr_list_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#expr_list_tail}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list_tail(GParser.Expr_list_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#addop}.
	 * @param ctx the parse tree
	 */
	void enterAddop(GParser.AddopContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#addop}.
	 * @param ctx the parse tree
	 */
	void exitAddop(GParser.AddopContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#mulop}.
	 * @param ctx the parse tree
	 */
	void enterMulop(GParser.MulopContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#mulop}.
	 * @param ctx the parse tree
	 */
	void exitMulop(GParser.MulopContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(GParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(GParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(GParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(GParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#else_part}.
	 * @param ctx the parse tree
	 */
	void enterElse_part(GParser.Else_partContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#else_part}.
	 * @param ctx the parse tree
	 */
	void exitElse_part(GParser.Else_partContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(GParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(GParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#compop}.
	 * @param ctx the parse tree
	 */
	void enterCompop(GParser.CompopContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#compop}.
	 * @param ctx the parse tree
	 */
	void exitCompop(GParser.CompopContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(GParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(GParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GParser#inputFile}.
	 * @param ctx the parse tree
	 */
	void enterInputFile(GParser.InputFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GParser#inputFile}.
	 * @param ctx the parse tree
	 */
	void exitInputFile(GParser.InputFileContext ctx);
}