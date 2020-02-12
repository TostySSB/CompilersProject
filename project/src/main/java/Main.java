import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.*;

public class Main {
    public static void main(String[] args) {
        String INPUT_FILE = args[0];
        System.out.println(INPUT_FILE);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(INPUT_FILE);
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found.");
            return;
        }

        GLexer lexer;
        try {
            lexer = new GLexer(CharStreams.fromFileName(INPUT_FILE));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        List<? extends Token> tokens = lexer.getAllTokens();
        System.out.println(tokens.size());

//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        tokens.fill();
//        System.out.println();
//        System.out.println(tokens.size());
//        ListIterator<Token> iter = tokens.getTokens().listIterator();


//        while(iter.hasNext()) {
//            Token t = iter.next();
//            System.out.println(t.getLine());
//            System.out.println(t.getText());
//            System.out.println(t.getType());
//            System.out.println("--------------------");
//        }

    }
}
