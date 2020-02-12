// Generated from G.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GParser}.
 */
public interface GListener extends ParseTreeListener {
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