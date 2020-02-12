import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.io.FileWriter;
import java.util.ListIterator;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.*;

public class Main {
    public static void main(String[] args) {
        String INPUT_FILE = args[0];
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

        String ruleNames[] = lexer.getTokenNames();
        try {
        FileWriter myWriter = new FileWriter("output.txt");
        for (int i = 0; i < tokens.size(); i++) {
            Token t = tokens.get(i);
            int ruleIdx = t.getType();;
            appendUsingFileWriter("Token Type: " + ruleNames[ruleIdx]);
            myWriter.write("Value: " + t.getText());
        }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
