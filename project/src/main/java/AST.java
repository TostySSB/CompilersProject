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

        public Node() {
            this.parent = null;
        }

        public Node(AST.Node parent) {
            this.parent = parent;
        }

        public void setParent(AST.Node parent) {
            this.parent = parent;
        }

        public void addChild(AST.Node child) { }

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

        // Appends inputCode to the end of this.code
        public void appendCode(IRCode inputCode) {
            this.code.addAll(inputCode.getCode());
        }
    }

    class Program extends Node {
        ArrayList<AST.Node> children;
        IRCode code;

        public Program() {
            super();
            this.nodeId = 1;
            this.nodeType = "Program";
            children = new ArrayList<AST.Node>();
            System.out.println("\nAST.Program initalized");
        }

        @Override public void addChild(AST.Node child) {
            this.children.add(child);
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

    abstract class Op extends Node {
        AST.Node leftChild;
        AST.Node rightChild;
    }

    class AddOp extends Op {

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

        public void addChild(AST.Node child) {
            if (this.leftChild == null)
                this.leftChild = child;
            else if (this.rightChild == null)
                this.rightChild = child;
            else {
                System.out.println("\n\n----------------------------------");
                System.out.println("AddOp -> addChild() -> error");
                System.out.println("Tried to add third child to AddOp");
                System.out.println("leftChild type --> " + leftChild.getType());
                System.out.println("rightChild type --> " + rightChild.getType());
                System.err.println("third child type --> " + child.getType());
                System.out.println("----------------------------------\n\n");
            }
        }

        @Override public String getText() {
            return null;
        }
    }

    class MulOp extends Op {
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

        public void addChild(AST.Node child) {
            if (this.leftChild == null)
                this.leftChild = child;
            else if (this.rightChild == null)
                this.rightChild = child;
            else {
                System.out.println("MulOp -> addChild() -> error");
                System.out.println("Tried to add third child to MulOp");
            }
        }
    }

    class EqOp extends Op {

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

        @Override public void addChild(AST.Node child) {
            if (this.leftChild == null)
                this.leftChild = child;
            else if (this.rightChild == null)
                this.rightChild = child;
            else {
                System.out.println("EqOp -> addChild() -> error");
                System.out.println("Tried to add third child to EqOp");
                System.exit(1);
            }
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
        ArrayList<AST.Node> children;

        public WriteStmt() {
            super();
            this.nodeId = 8;
            this.nodeType = "WriteStmt";
            children = new ArrayList<AST.Node>();
            System.out.println("\nAST.WriteStmt initalized");
        }

        @Override public void addChild(AST.Node child) {
            this.children.add(child);
        }
    }

    class ReadStmt extends Node {
        ArrayList<AST.Node> children;

        public ReadStmt() {
            super();
            this.nodeId = 9;
            this.nodeType = "ReadStmt";
            children = new ArrayList<AST.Node>();
            System.out.println("\nAST.ReadStmt initalized");
        }

        @Override public void addChild(AST.Node child) {
            this.children.add(child);
        }
    }

    class Expr extends Node {

        ArrayList<Node> children;

        public Expr() {
            super();
            this.nodeId = 10;
            this.nodeType = "Expr";
            children = new ArrayList<Node>();
            System.out.println("\nAST.Expr initalized");
        }

        @Override public void addChild(AST.Node child) {
            this.children.add(child);
        }
    }
}
