import java.util.ArrayList;

public class AST {

    class Node {

        Node parent;
        int nodeId;

        public Node() {
            this.parent = null;
        }

        public Node(Node parent) {
            this.parent = parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public void addChild(Node child) { }

        public String getText() {
            return "getText wasn't implemented";
        }

        public String getText(int regNum) {
            return "getText wasn't implemented";
        }
    }

    class Program extends Node {
        ArrayList<Node> children;
        public Program() {
            super();
            this.nodeId = 1;
            children = new ArrayList<Node>();
            System.out.println("Initialized Program node");
        }

        @Override public void addChild(Node child) {
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
        Node leftChild;
        Node rightChild;
    }

    class AddOp extends Op {
        public AddOp() {
            super();
            this.nodeId = 3;
        }

        public void addChild(Node child) {
            if (this.leftChild == null)
                this.leftChild = child;
            else if (this.rightChild == null)
                this.rightChild = child;
            else
                System.out.println("AddOp -> addChild() -> error");
                System.out.println("Tried to add third child to AddOp");
        }
    }

    class MulOp extends Op {
        public MulOp() {
            super();
            this.nodeId = 4;
        }
        
        public void addChild(Node child) {
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
        
        @Override public void addChild(Node child) {
            if (this.leftChild == null)
                this.leftChild = child;
            else if (this.rightChild == null)
                this.rightChild = child;
            else {
                System.out.println("EqOp -> addChild() -> error");
                System.out.println("Tried to add third child to EqOp");
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
}
