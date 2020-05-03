import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.HashMap;
import java.util.Iterator;


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

        // Initialize the lexer, parser, and token stream.
        try {
            lexer = new GLexer(CharStreams.fromFileName(INPUT_FILE));
            tokenStream = new CommonTokenStream(lexer);
            parser = new GParser(tokenStream);
        } catch (IOException e) {
            e.printStackTrace();
            fileInputStream.close();
            return;
        }

        // Initialize the tree, listener, and walker
        tree = parser.program();
        listener = new Listener();
        walker = new ParseTreeWalker();
        walker.walk(listener, tree);

        HashMap<String, String> hm = listener.dataTypesOfVars;
        Iterator it = hm.keySet().iterator();
        System.out.println("VARS:");
        while (it.hasNext()) {
            System.out.println(it.next());
        }


        fileInputStream.close();
    }
}
