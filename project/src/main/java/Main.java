import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
<<<<<<< HEAD
import java.util.List;
import java.io.FileWriter;
import java.util.ListIterator;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
=======

>>>>>>> ad02f84395e0b51394a9a1b1c08fdad65ba89584
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;


public class Main {
    public static void main(String[] args) throws IOException {

        // Variable declarations
        String INPUT_FILE = args[0];
        FileInputStream fileInputStream;
        GLexer lexer;
        GParser parser;
        Listener listener;
        ParseTree tree;
        ParseTreeWalker walker;
        CommonTokenStream tokenStream;

        // Initialize the FileInputStream object.
        try {
            fileInputStream = new FileInputStream(INPUT_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Input file not found.");
            return;
        }

<<<<<<< HEAD
        GLexer lexer;
        GParser parser;
        GListener listener;

=======
        // Initialize the lexer, parser, and token stream.
>>>>>>> ad02f84395e0b51394a9a1b1c08fdad65ba89584
        try {
            lexer = new GLexer(CharStreams.fromFileName(INPUT_FILE));
            tokenStream = new CommonTokenStream(lexer);
            parser = new GParser(tokenStream);
            listener = new GListener();
        } catch (IOException e) {
            e.printStackTrace();
            fileInputStream.close();
            return;
        }

<<<<<<< HEAD
        ParserRuleContext tree = parser.program();
        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(listener, tree);
=======
        // Initialize the tree, listener, and walker
        tree = parser.program();
        listener = new Listener();
        walker = new ParseTreeWalker();
        walker.walk(listener, tree);
        fileInputStream.close();
>>>>>>> ad02f84395e0b51394a9a1b1c08fdad65ba89584
    }
}
