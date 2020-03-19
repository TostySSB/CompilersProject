import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
// import java.util.List;
// import java.io.FileWriter;
// import java.util.ListIterator;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
// import org.antlr.v4.runtime.*;
// import java.io.FileWriter;
import org.antlr.v4.runtime.ParserRuleContext;

public class Main {
    public static void main(String[] args) throws IOException {

        // Variable declarations
        String INPUT_FILE = args[0];
        FileInputStream fileInputStream;
        GLexer lexer;
        GParser parser;
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

        parser.program();

        fileInputStream.close();
    }
}
