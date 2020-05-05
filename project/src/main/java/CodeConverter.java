import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

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
            lines.add(s);
        }
        
        return lines;
    }

    public static String convertRegister(String register) {
        String newReg = "";
        if (register.matches("[a-z]+")) {
            newReg = register;
        }
        else if (register.matches("(\\$T)([0-9]+)")) {
            int regNum = Integer.parseInt(register.substring(2));
            newReg = "r" + --regNum;
        }
        else {
            newReg = register;
        }
        return newReg;
    }

    public static ArrayList<String> convertToTiny(ArrayList<String> irCode) {
        Iterator iter = irCode.iterator();

        ArrayList<String> tinyCode = new ArrayList<String>();
        
        while (iter.hasNext()) {
            String currentLine = iter.next().toString();
            // System.out.println("CURRENT INSTRUCTION: " + currentLine);
            String[] tokens = currentLine.split(" ");
            String inst = tokens[0];
            
            if (inst.matches("(ADD|SUB|MULT|DIV)(I|F)")) {
                if (inst.matches("MULTI") || inst.matches("MULTF")) {
                    char lastChar = inst.charAt(inst.length()-1);
                    System.out.println("LAST CHAR: " + lastChar);
                    String newInst = lastChar == 'I' ? "muli" : "mulf";
                    tinyCode.add("move " + convertRegister(tokens[1]) + " " + convertRegister(tokens[3]));
                    tinyCode.add(newInst + " " + convertRegister(tokens[2]) + " " + convertRegister(tokens[3]));
                }
                else {
                    tinyCode.add("move " + convertRegister(tokens[1]) + " " + convertRegister(tokens[3]));
                    tinyCode.add(inst.toLowerCase() + " " + convertRegister(tokens[2]) + " " + convertRegister(tokens[3]));
                }
                
            }
            if (inst.matches("(ADD|SUB|MULT|DIV)(F)"))
            else if (inst.matches("(STORE)(I|F)")) {
                tinyCode.add("move " + convertRegister(tokens[1]) + " " + convertRegister(tokens[2]));
            }
            else if (inst.matches("(READ|WRITE)(I|F)")) {
                if (inst.matches("READF") || inst.matches("WRITEF")) {
                    tinyCode.add("sys " + inst.substring(0, inst.length()-1).toLowerCase() + "r " + tokens[1]);
                }
                else {
                    tinyCode.add("sys " + inst.toLowerCase() + " " + tokens[1]);
                }
            }
            else if (inst.matches("WRITES")) {
                tinyCode.add("sys writes newline");
            }
        }

        return tinyCode;
    }
    
    public static void main(String[] args) {
        String INPUT_FILE = args[0];
        File input_file = new File(INPUT_FILE);
        String str = makeString(input_file);
        ArrayList<String> strs = makeStrArrayList(str);

        for(String s: strs) {
            System.out.println(s);
        }
        
        // ArrayList<String> test = new ArrayList<String>();
        // test.add("READI c");
        // test.add("READF c");
        // test.add("WRITEF c");
        // test.add("WRITEI c");
        // test.add("WRITES newline");

        ArrayList<String> tinyCode = convertToTiny(strs);
        for(int i = 0; i < tinyCode.size(); i++) {
            System.out.println(tinyCode.get(i));
        }
    }
    
}