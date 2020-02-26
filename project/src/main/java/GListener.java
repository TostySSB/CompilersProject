// Generated from g.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gParser}.
 */
public interface gListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(gParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(gParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(gParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(gParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#pgm_body}.
	 * @param ctx the parse tree
	 */
	void enterPgm_body(gParser.Pgm_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#pgm_body}.
	 * @param ctx the parse tree
	 */
	void exitPgm_body(gParser.Pgm_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(gParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(gParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#string_decl}.
	 * @param ctx the parse tree
	 */
	void enterString_decl(gParser.String_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#string_decl}.
	 * @param ctx the parse tree
	 */
	void exitString_decl(gParser.String_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#str}.
	 * @param ctx the parse tree
	 */
	void enterStr(gParser.StrContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#str}.
	 * @param ctx the parse tree
	 */
	void exitStr(gParser.StrContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(gParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(gParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#var_type}.
	 * @param ctx the parse tree
	 */
	void enterVar_type(gParser.Var_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#var_type}.
	 * @param ctx the parse tree
	 */
	void exitVar_type(gParser.Var_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#any_type}.
	 * @param ctx the parse tree
	 */
	void enterAny_type(gParser.Any_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#any_type}.
	 * @param ctx the parse tree
	 */
	void exitAny_type(gParser.Any_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#id_list}.
	 * @param ctx the parse tree
	 */
	void enterId_list(gParser.Id_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#id_list}.
	 * @param ctx the parse tree
	 */
	void exitId_list(gParser.Id_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#id_tail}.
	 * @param ctx the parse tree
	 */
	void enterId_tail(gParser.Id_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#id_tail}.
	 * @param ctx the parse tree
	 */
	void exitId_tail(gParser.Id_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#param_decl_list}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl_list(gParser.Param_decl_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#param_decl_list}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl_list(gParser.Param_decl_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#param_decl}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl(gParser.Param_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#param_decl}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl(gParser.Param_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#param_decl_tail}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl_tail(gParser.Param_decl_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#param_decl_tail}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl_tail(gParser.Param_decl_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#func_declarations}.
	 * @param ctx the parse tree
	 */
	void enterFunc_declarations(gParser.Func_declarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#func_declarations}.
	 * @param ctx the parse tree
	 */
	void exitFunc_declarations(gParser.Func_declarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void enterFunc_decl(gParser.Func_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void exitFunc_decl(gParser.Func_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#func_body}.
	 * @param ctx the parse tree
	 */
	void enterFunc_body(gParser.Func_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#func_body}.
	 * @param ctx the parse tree
	 */
	void exitFunc_body(gParser.Func_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void enterStmt_list(gParser.Stmt_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void exitStmt_list(gParser.Stmt_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(gParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(gParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#base_stmt}.
	 * @param ctx the parse tree
	 */
	void enterBase_stmt(gParser.Base_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#base_stmt}.
	 * @param ctx the parse tree
	 */
	void exitBase_stmt(gParser.Base_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(gParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(gParser.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign_expr(gParser.Assign_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign_expr(gParser.Assign_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void enterRead_stmt(gParser.Read_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void exitRead_stmt(gParser.Read_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWrite_stmt(gParser.Write_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWrite_stmt(gParser.Write_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(gParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(gParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(gParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(gParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#expr_prefix}.
	 * @param ctx the parse tree
	 */
	void enterExpr_prefix(gParser.Expr_prefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#expr_prefix}.
	 * @param ctx the parse tree
	 */
	void exitExpr_prefix(gParser.Expr_prefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(gParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(gParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#factor_prefix}.
	 * @param ctx the parse tree
	 */
	void enterFactor_prefix(gParser.Factor_prefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#factor_prefix}.
	 * @param ctx the parse tree
	 */
	void exitFactor_prefix(gParser.Factor_prefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#postfix_expr}.
	 * @param ctx the parse tree
	 */
	void enterPostfix_expr(gParser.Postfix_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#postfix_expr}.
	 * @param ctx the parse tree
	 */
	void exitPostfix_expr(gParser.Postfix_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#call_expr}.
	 * @param ctx the parse tree
	 */
	void enterCall_expr(gParser.Call_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#call_expr}.
	 * @param ctx the parse tree
	 */
	void exitCall_expr(gParser.Call_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list(gParser.Expr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list(gParser.Expr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#expr_list_tail}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list_tail(gParser.Expr_list_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#expr_list_tail}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list_tail(gParser.Expr_list_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#addop}.
	 * @param ctx the parse tree
	 */
	void enterAddop(gParser.AddopContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#addop}.
	 * @param ctx the parse tree
	 */
	void exitAddop(gParser.AddopContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#mulop}.
	 * @param ctx the parse tree
	 */
	void enterMulop(gParser.MulopContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#mulop}.
	 * @param ctx the parse tree
	 */
	void exitMulop(gParser.MulopContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(gParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(gParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(gParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(gParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#else_part}.
	 * @param ctx the parse tree
	 */
	void enterElse_part(gParser.Else_partContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#else_part}.
	 * @param ctx the parse tree
	 */
	void exitElse_part(gParser.Else_partContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(gParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(gParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#compop}.
	 * @param ctx the parse tree
	 */
	void enterCompop(gParser.CompopContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#compop}.
	 * @param ctx the parse tree
	 */
	void exitCompop(gParser.CompopContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(gParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(gParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#inputFile}.
	 * @param ctx the parse tree
	 */
	void enterInputFile(gParser.InputFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#inputFile}.
	 * @param ctx the parse tree
	 */
	void exitInputFile(gParser.InputFileContext ctx);
}