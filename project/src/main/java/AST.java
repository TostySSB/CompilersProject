import java.util.ArrayList;

public class AST {

    class Node {

        Node parent;
        int nodeId;
        String value; // Actuall value stored by the node
        /* Constructors */
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

        public String getText(int regNum) {
            return "getText wasn't implemented";
        }
    }

    class Program extends Node {
        ArrayList<AST.Node> children;
        public Program() {
            super();
            this.nodeId = 1;
            children = new ArrayList<AST.Node>();
            System.out.println("Initialized Program node");
        }

        @Override public void addChild(AST.Node child) {
            this.children.add(child);
        }
    }

    class VarDecl extends Node {
        public VarDecl() {
            super();
            this.nodeId = 2;
        }
    }

    abstract class Op extends Node {
        AST.Node leftChild;
        AST.Node rightChild;
    }

    class AddOp extends Op {

        String operator;

        public AddOp() {
            super();
            this.nodeId = 3;
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
                System.out.println("AddOp -> addChild() -> error");
                System.out.println("Tried to add third child to AddOp");
            }
        }
    }

    // public AST.Node genAddExp {
    //     //Basically if we encounter an add_op
    //     if (expression is an add_op){
    //         AddExpr = new AST.Node();
    //         AddExpr.leftChild = null; // Basically this exists but is uninitialiuzed
    //         AddExpr.rightChild = null; //Same as above
    //         AddExpr.expr = plus or minus;
    //         return AddExpr;
    //     }
    // }

    class MulOp extends Op {
        public MulOp() {
            super();
            this.nodeId = 4;
        }

        public void addChild(AST.Node child) {
            if (this.leftChild == null)
                this.leftChild = child;
            else if (this.rightChild == null)
                this.rightChild = child;
            else
                System.out.println("MulOp -> addChild() -> error");
                System.out.println("Tried to add third child to MulOp");
        }
    }

    class EqOp extends Op {
        public EqOp() {
            super();
            this.nodeId = 5;
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

        @Override public String getText(int regNum) {

            // if right child is literal,
            // e.g. a := 20
            if (this.rightChild.nodeId == 7) {
                String rv = "\n;STOREI " + rightChild.getText() + " $T" + regNum;
                rv += "\n;STOREI $T" + regNum + " " + leftChild.getText();
                return rv;
            }
            return "Found unexpected case in EqOp -> getText()";
        }
    }

    class Id extends Node {
        String name;

        public Id() {
            super();
            this.nodeId = 6;
            this.name = null;
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
            this.val = null;
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
            children = new ArrayList<AST.Node>();
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
            children = new ArrayList<AST.Node>();
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
            children = new ArrayList<Node>();
        }

        @Override public void addChild(Node child) {
            children.add(child);
        }
    }
}
