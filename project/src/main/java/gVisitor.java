// Generated from /Users/admin/Desktop/2020 Spring Semester/Compilers/CompilersProject/project/src/main/java/g.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link gParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface gVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link gParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(gParser.RContext ctx);
}