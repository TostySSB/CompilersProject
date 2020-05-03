import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class CodeConverter {

    public static String makeString(File textFile) {
        String str = "";
        try {
            Scanner scanner = new Scanner(textFile);
            while (scanner.hasNextLine()) {
                str += scanner.nextLine();
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("Nah.");
        }
        return str;
    }

    public static ArrayList<String> makeStrArrayList(String str) {
        ArrayList<String> lines = new ArrayList<String>();

        String[] strs = str.split(";");
        
        for (String s : strs) {
            System.out.println(s);
        }
        
        return lines;
    }
    
    public static void main(String[] args) {
        String INPUT_FILE = args[0];
        File input_file = new File(INPUT_FILE);
        String str = makeString(input_file);
        ArrayList<String> strs = makeStrArrayList(str);

    }
    
}