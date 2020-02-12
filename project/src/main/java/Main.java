import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.*;
import java.io.FileWriter;

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

        gLexer lexer;
        try {
            lexer = new gLexer(CharStreams.fromFileName(INPUT_FILE));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        List<? extends Token> tokens = lexer.getAllTokens();
        System.out.println(tokens.size());

        String ruleNames[] = lexer.getTokenNames();

        String outputFileName = INPUT_FILE.substring(0, INPUT_FILE.length()-6) + ".out";
        System.out.println(outputFileName);

        FileWriter w;
        try{
            w = new FileWriter(outputFileName);
            for (int i = 0; i < tokens.size(); i++) {
                Token t = tokens.get(i);
                int ruleIdx = t.getType();
                w.write("Token Type: " + ruleNames[ruleIdx] + "\n");
                w.write("Value: "+t.getText()+"\n");
            }
            w.close();
        }catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
