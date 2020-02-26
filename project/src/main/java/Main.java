import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.io.FileWriter;
import java.util.ListIterator;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.*;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        String INPUT_FILE = "./inputs/" + args[0];
        System.out.println(INPUT_FILE);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(INPUT_FILE);
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found.");
            return;
        }

        GLexer lexer;
        GParser parser;

        try {
            lexer = new GLexer(CharStreams.fromFileName(INPUT_FILE));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            parser = new GParser(tokenStream);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        
        // List<? extends Token> tokens = lexer.getAllTokens();
        // String ruleNames[] = lexer.getRuleNames();

        String outputFileName = INPUT_FILE.substring(0, INPUT_FILE.length()-6) + ".out";

        FileWriter w;
        try{
            w = new FileWriter(outputFileName);
            // for (int i = 0; i < tokens.size(); i++) {
            //     Token t = tokens.get(i);
            //     int ruleIdx = t.getType();
            //     w.write("Token Type: " + ruleNames[ruleIdx] + "\n");
            //     w.write("Value: "+t.getText()+"\n");
            // }
            w.close();
        }catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
