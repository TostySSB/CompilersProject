import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.io.FileWriter;
import java.util.ListIterator;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.*;
import java.io.FileWriter;


public class Main {
    public static void main(String[] args) {
        // String INPUT_FILE = "./inputs/" + args[0];
        String INPUT_FILE = args[0];
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(INPUT_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Input file not found.");
            return;
        }

        GLexer lexer;
        GParser parser;
        GListener listener;

        try {
            lexer = new GLexer(CharStreams.fromFileName(INPUT_FILE));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            parser = new GParser(tokenStream);
            listener = new GListener();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        ParserRuleContext tree = parser.program();
        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(listener, tree);
    }
}
