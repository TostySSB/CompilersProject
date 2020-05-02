import java.util.ArrayList;

public class AST {

    public static int regNum = 0;
    public static int tempNum = 1;

    public String generateTemp() {
        return "$T" + tempNum++;
    }

    class Node {

        Node parent;
        int nodeId;
        String nodeType;
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
                    + children.get(0).getType()
                    + " --> " + children.get(0).getText()
                );
                System.out.println(
                    "rightChild type --> "
                    + children.get(1).getType()
                    + " --> " + children.get(1).getText()
                );
                System.err.println(
                    "third child type --> "
                    + child.getType()
                    + " --> " + child.getText()
                );
            }
        }

        public String getText() {
            return "getText wasn't implemented";
        }

        public String getType() {
            return this.nodeType;
        }

        public IRCode getIRCode() {
            System.out.println("getIRCode wasn't implemented for " + this.getType());
            return null;
        }

        public void printNode() {

        }
    }

    class IRCode {
        private ArrayList<String> code;

        public IRCode() {
            this.code = new ArrayList<String>();
        }

        public void addText(String inputText) {
            this.code.add(inputText);
        }

        public ArrayList<String> getCode() {
            return this.code;
        }

        public void printCode() {
            for (String statement : this.code) {
                System.out.println(statement);
            }
        }

        // Appends inputCode to the end of this.code
        public void appendCode(IRCode inputCode) {
            this.code.addAll(inputCode.getCode());
        }
    }

    class Program extends Node {
        IRCode code;

        public Program() {
            super();
            this.nodeId = 1;
            this.nodeType = "Program";
            this.children = new ArrayList<AST.Node>();
            System.out.println("\nAST.Program initalized");
        }

        @Override public IRCode getIRCode() {
            this.code = new IRCode();

            this.code.addText(";IR code");
            this.code.addText(";LABEL main");
            this.code.addText(";LINK");

            for (AST.Node child : children) {
                this.code.appendCode(child.getIRCode());
            }

            return this.code;
        }
    }

    //class VarDecl extends Node {
        //public VarDecl() {
            //super();
            //this.nodeId = 2;
            //this.nodeType = "VarDecl";
            //System.out.println("\nAST.VarDecl initalized");
        //}
    //}

    class AddOp extends Node {

        String operator;

        public AddOp() {
            super();
            this.nodeId = 3;
            this.nodeType = "AddOp";
            System.out.println("\nAST.AddOp initalized");
        }

        public AddOp(String operator) {
            this();
            this.operator = operator;
        }

        @Override public String getText() {
            return this.operator;
        }
    }

    class MulOp extends Node {
        String operator;

        public MulOp() {
            super();
            this.nodeId = 4;
            this.nodeType = "MulOp";
            System.out.println("\nAST.MulOp initalized");
        }

        public MulOp(String operator) {
            this();
            this.operator = operator;
        }

        public String getText() {
            return this.operator;
        }
    }

    class EqOp extends Node {

        String identifier;

        public EqOp() {
            super();
            this.nodeId = 5;
            this.nodeType = "EqOp";
            System.out.println("\nAST.EqOp initalized");
        }

        public EqOp(String identifier) {
            this();
            this.identifier = identifier;
        }

        //@Override public String getText(int regNum) {

            //// if right child is literal,
            //// e.g. a := 20
            //if (this.rightChild.nodeId == 7) {
                //String rv = "\n;STOREI " + rightChild.getText() + " $T" + regNum;
                //rv += "\n;STOREI $T" + regNum + " " + leftChild.getText();
                //return rv;
            //}
            //return "Found unexpected case in EqOp -> getText()";
        //}
    }

    class Id extends Node {
        String name;

        public Id() {
            super();
            this.nodeId = 6;
            this.nodeType = "Id";
            System.out.println("\nAST.Id initalized");
        }

        public Id(String name) {
            this();
            this.name = name;
        }

        @Override public String getText() {
            return this.name;
        }

    }

    class Literal extends Node {
        String val;

        public Literal() {
            super();
            this.nodeId = 7;
            this.nodeType = "Literal";
            System.out.println("\nAST.Literal initalized");
        }

        public Literal(String val) {
            this();
            this.val = val;
        }

        @Override public String getText() {
            return this.val;
        }
    }

    class WriteStmt extends Node {

        public WriteStmt() {
            super();
            this.nodeId = 8;
            this.nodeType = "WriteStmt";
            children = new ArrayList<AST.Node>();
            System.out.println("\nAST.WriteStmt initalized");
        }
    }

    class ReadStmt extends Node {

        public ReadStmt() {
            super();
            this.nodeId = 9;
            this.nodeType = "ReadStmt";
            children = new ArrayList<AST.Node>();
            System.out.println("\nAST.ReadStmt initalized");
        }
    }

    class Expr extends Node {

        public Expr() {
            super();
            this.nodeId = 10;
            this.nodeType = "Expr";
            children = new ArrayList<Node>();
            System.out.println("\nAST.Expr initalized");
        }
    }

    class Factor extends Node {

        public Factor() {
            super();
            this.nodeId = 11;
            this.nodeType = "Factor";
            children = new ArrayList<AST.Node>();
            System.out.println("\nAST.Factor initalized");
        }
    }
}
