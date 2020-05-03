import java.util.ArrayList;

public class AST {

    public boolean debug = true;

    public static int regNum = 0;
    public static int tempNum = 1;

    public String generateTemp() {
        return "$T" + tempNum++;
    }

    public String getCodeType(AST.Node node, String dataType) {
        String rv = "";

        if (node.getNodeType().equals("AddOp")) {
            if (node.getText().equals("+"))
                rv += ";ADD";
            else if (node.getText().equals("-"))
                rv += ";SUB";
        }

        else if (node.getNodeType().equals("MulOp")) {
            if (node.getText().equals("*"))
                rv += ";MUL";
            else if (node.getText().equals("/"))
                rv += ";DIV";
        }

        else if (node.getNodeType().equals("EpOp")) {
            rv += ";STORE";
        }

        else {
            System.out.println("\n\n----------------------------------");
            System.out.println("getCodeType() --> bad node given");
            System.out.println("nodeType = " + node.getNodeType());
            System.out.println("Acceptable node types");
            System.out.println("AddOp, MulOp, EqOp");
            System.out.println("----------------------------------\n\n");
        }

        // Add I, F, or S based on INT, FLOAT, or STRING
        rv += dataType.toCharArray()[0];

        if (debug == true)
            System.out.println("getCodeType() --> generated data type = " + rv);

        return rv;
    }


    class Node {

        Node parent;
        int nodeId;
        String nodeType;
        String dataType;
        ArrayList<AST.Node> children;

        public Node() {
            this.parent = null;
            children = new ArrayList<AST.Node>();
        }

        public Node(AST.Node parent) {
            this();
            this.parent = parent;
        }

        public void addChild(AST.Node child) {
            if (children.size() < 2)
                children.add(child);
            else {
                System.out.println("\n\n----------------------------------");
                System.out.println(
                    "Tried to add third child to " + this.nodeType
                );
                System.out.println(
                    "leftChild type --> "
                    + children.get(0).getNodeType()
                    + " --> " + children.get(0).getText()
                );
                System.out.println(
                    "rightChild type --> "
                    + children.get(1).getNodeType()
                    + " --> " + children.get(1).getText()
                );
                System.err.println(
                    "third child type --> "
                    + child.getNodeType()
                    + " --> " + child.getText()
                );
                System.out.println("----------------------------------\n\n");
            }
        }

        public AST.Node getChildAtIndex(int i) {
            try {
                return this.children.get(i);
            }

            catch (IndexOutOfBoundsException e) {
                System.out.println("\n\n----------------------------------");
                System.out.println("getChildAtIndex() --> IndexOutOfBoundsException");
                System.out.println("input index = " + i);
                System.out.println("this.children.size = " + this.children.size());
                System.out.println("----------------------------------\n\n");
                return null;
            }
        }

        public String getText() {
            return "getText wasn't implemented for " + this.nodeType;
        }

        public String getNodeType() {
            return this.nodeType;
        }

        public ArrayList<AST.Node> getChildren() {
            return this.children;
        }

        public void deleteAllChildren() {
            this.children.clear();
        }

        public String getDataType() {
            return this.dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public IRCode getIRCode() {
            System.out.println("\n\n----------------------------------");
            System.out.println(
                "getIRCode() wasn't implemented for " + this.getNodeType()
            );
            System.out.println("Children nodes of this " + this.getNodeType() + ":");
            for (AST.Node node : this.children) {
                System.out.print(node.getNodeType() + " ");
            }
            System.out.println("\n----------------------------------\n\n");
            return null;
        }
    }

    class IRCode {
        private String codeAsString;
        private String location;
        private String dataType;

        public IRCode(String codeAsString, String location, String dataType) {
            this.codeAsString = codeAsString;
            this.location = location;
            this.dataType = dataType;
        }

        public String getCodeAsString() {
            return this.codeAsString;
        }

        public String getLocation() {
            return this.location;
        }

        public String getDataType() {
            return this.dataType;
        }
    }

    //class IRCode {
        //private ArrayList<AST.IRCode> code;

        //public IRCode() {
            //this.code = new ArrayList<IRCode>();
        //}

        //public void addText(String inputText) {
            //this.code.add(inputText);
        //}

        //public ArrayList<String> getCode() {
            //return this.code;
        //}

        //public void printCode() {
            //for (String statement : this.code) {
                //System.out.println(statement);
            //}
        //}

        //// Appends inputCode to the end of this.code
        //public void appendCode(IRCode inputCode) {
            //this.code.addAll(inputCode.getCode());
        //}
    //}

    class Program extends Node {
        public Program() {
            super();
            this.nodeId = 1;
            this.nodeType = "Program";
            this.children = new ArrayList<AST.Node>();
            System.out.println("AST.Program initalized");
        }

        @Override public void addChild(AST.Node child) {
            children.add(child);
        }

        @Override public IRCode getIRCode() {
            ArrayList<AST.IRCode> code_list = new ArrayList<AST.IRCode>();

            for (AST.Node statement : this.children) {
                code_list.add(statement.getIRCode());
            }

            String output = "";

            for (AST.IRCode code : code_list) {
                output += code.getCodeAsString();
            }

            return new IRCode(output, null, null);
        }
    }

    class VarDecl extends Node {
        public VarDecl() {
            super();
            this.nodeId = 2;
            this.nodeType = "VarDecl";
            this.children = new ArrayList<AST.Node>();
            System.out.println("AST.VarDecl initalized");
        }

        public IRCode getIRCode() {
            return null;
        }
    }

    class AddOp extends Node {

        String operator;

        public AddOp() {
            super();
            this.nodeId = 3;
            this.nodeType = "AddOp";
            System.out.println("AST.AddOp initalized");
        }

        public AddOp(String operator) {
            this();
            this.operator = operator;
        }

        @Override public String getText() {
            return this.operator;
        }

        @Override public IRCode getIRCode() {
            String currDataType = this.getChildAtIndex(0).getDataType();

            IRCode leftCode = this.getChildAtIndex(0).getIRCode();
            IRCode rightCode = this.getChildAtIndex(1).getIRCode();

            String codeTillNow = "";
            codeTillNow += leftCode.getCodeAsString();
            codeTillNow += rightCode.getCodeAsString();

            String location = generateTemp();

            String newCode = "";
            newCode += getCodeType(this, currDataType);
            newCode += " " + leftCode.getLocation();
            newCode += " " + rightCode.getLocation();
            newCode += " " + location + "\n";

            codeTillNow += newCode;

            return new IRCode(codeTillNow, location, dataType);
        }
    }

    class MulOp extends Node {
        String operator;

        public MulOp() {
            super();
            this.nodeId = 4;
            this.nodeType = "MulOp";
            System.out.println("AST.MulOp initalized");
        }

        public MulOp(String operator) {
            this();
            this.operator = operator;
        }

        public String getText() {
            return this.operator;
        }

        @Override public IRCode getIRCode() {
            String currDataType = this.getChildAtIndex(0).getDataType();

            IRCode leftCode = this.getChildAtIndex(0).getIRCode();
            IRCode rightCode = this.getChildAtIndex(1).getIRCode();

            String codeTillNow = "";
            codeTillNow += leftCode.getCodeAsString();
            codeTillNow += rightCode.getCodeAsString();

            String location = generateTemp();

            String newCode = "";
            newCode += getCodeType(this, currDataType);
            newCode += " " + leftCode.getLocation();
            newCode += " " + rightCode.getLocation();
            newCode += " " + location + "\n";

            codeTillNow += newCode;

            return new IRCode(codeTillNow, location, dataType);
        }
    }

    class EqOp extends Node {

        String identifier;

        public EqOp() {
            super();
            this.nodeId = 5;
            this.nodeType = "EqOp";
            System.out.println("AST.EqOp initalized");
        }

        public EqOp(String identifier) {
            this();
            this.identifier = identifier;
        }

        @Override public IRCode getIRCode() {
            String currDataType = this.getChildAtIndex(0).getDataType();

            IRCode leftCode = this.getChildAtIndex(0).getIRCode();
            IRCode rightCode = this.getChildAtIndex(1).getIRCode();

            String codeTillNow = "";
            codeTillNow += leftCode.getCodeAsString();
            codeTillNow += rightCode.getCodeAsString();

            String newCode = "";
            newCode += getCodeType(this, currDataType);
            newCode += " " + rightCode.getLocation();
            newCode += " " + leftCode.getLocation() + "\n";

            codeTillNow += newCode;

            return new IRCode(codeTillNow, leftCode.getLocation(), dataType);
        }
    }

    class Id extends Node {
        String name;

        public Id() {
            super();
            this.nodeId = 6;
            this.nodeType = "Id";
            this.dataType = null;
            System.out.println("AST.Id initalized");
        }

        public Id(String name, String dataType) {
            this();
            this.name = name;
            this.dataType = dataType;
        }

        @Override public String getText() {
            return this.name;
        }

        @Override public IRCode getIRCode() {
            return new IRCode("", this.name, this.dataType);
        }
    }

    class Literal extends Node {
        String val;

        public Literal() {
            super();
            this.nodeId = 7;
            this.nodeType = "Literal";
            this.dataType = null;
            System.out.println("AST.Literal initalized");
        }

        public Literal(String val) {
            this();
            this.val = val;
            if (val.contains("."))
                this.dataType = "FLOAT";
            else
                this.dataType = "INT";
        }

        @Override public String getText() {
            return this.val;
        }

        @Override public IRCode getIRCode() {
            return new IRCode("", this.val, this.dataType);
        }
    }

    class WriteStmt extends Node {
        public WriteStmt() {
            super();
            this.nodeId = 8;
            this.nodeType = "WriteStmt";
            children = new ArrayList<AST.Node>();
            System.out.println("AST.WriteStmt initalized");
        }
    }

    class ReadStmt extends Node {
        public ReadStmt() {
            super();
            this.nodeId = 9;
            this.nodeType = "ReadStmt";
            children = new ArrayList<AST.Node>();
            System.out.println("AST.ReadStmt initalized");
        }
    }

    class Expr extends Node {
        public Expr() {
            super();
            this.nodeId = 10;
            this.nodeType = "Expr";
            children = new ArrayList<Node>();
            System.out.println("AST.Expr initalized");
        }
    }

    class Factor extends Node {
        public Factor() {
            super();
            this.nodeId = 11;
            this.nodeType = "Factor";
            children = new ArrayList<AST.Node>();
            System.out.println("AST.Factor initalized");
        }
    }
}
