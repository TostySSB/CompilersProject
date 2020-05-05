import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Listener extends GBaseListener {

    boolean debug = false;

    // Keeps track of whether a parent
    // is a read/write statement
    boolean parent_is_RW = false;

    // IDs to keep track of relevant grammar rules
    final int string_decl_ID = 4;
    final int id_list_ID = 9;
    final int id_tail_ID = 10;
    final int param_decl_ID = 12;
    final int read_stmt_ID = 22;
    final int write_stmt_ID = 23;

    // Tracks our CLI symbolTableOutput
    String symbolTableOutput = "";

    // Scope-related variables
    HashMap<String, ArrayList<HashMap<String, Object>>> scopes = new HashMap<String, ArrayList<HashMap<String, Object>>>();

    String currentScope = "";
    int blockNum = 1;
    final int typeIdx = 0;
    final int valueIdx = 1;

    // Keeps tracks of the current
    // variable's information
    String name = "";
    String type = "";
    String value = "";

    // AST-related variables
    AST AST = new AST();
    AST.Node rootNode;
    AST.Node currentNode;
    HashMap<String, String> dataTypesOfVars = new HashMap<String, String>();

    // AST functions
    public String getTypeByID(String id) {
        for (Map.Entry<String, String> currID : dataTypesOfVars.entrySet()) {
            if (currID.getKey().equals(id))
                return currID.getValue();
        }

        System.out.println("\n\n----------------------------------");
        System.out.println("getTypeByID() --> couldn't find given ID");
        System.out.println("given ID = " + id);
        System.out.println("list of known IDs:");
        for (Map.Entry<String, String> currID : dataTypesOfVars.entrySet()) {
            System.out.print(currID.getKey() + " ");
        }
        System.out.println("\n----------------------------------\n\n");

        return null;
    }

    // Scope functions
    public void addScope(String scopeName) {
        if (scopes.containsKey(scopeName) == false) {
            scopes.put(scopeName, new ArrayList<HashMap<String, Object>>());
        }
    }

    public void addVar(String varID, String varType) {
        addVar(varID, varType, "");
    }

    public void addVar(String varID, String varType, String varValue) {

        // Check the current scope to see if there
        // is a declaration error.
        if (getVarByID(varID) != null) {
            System.out.println("DECLARATION ERROR " + varID);
            System.exit(1);
        }

        // Make a new HashMap to add into the current scope
        HashMap<String, Object> newVar = new HashMap<String, Object>();

        // Add the ID and Type
        newVar.put("id", varID);
        newVar.put("type", varType);

        // Add the Value
        Object newValue;

        if (varType.equals("STRING")) {
            newValue = varValue;
        } else {
            newValue = null;
        }

        newVar.put("value", newValue);

        scopes.get(currentScope).add(newVar);
    }

    // Gets the variable of a particular ID in the current scope
    public HashMap<String, Object> getVarByID(String varID) {

        // Loop through every variable in the current scope
        ArrayList<HashMap<String, Object>> scope = scopes.get(currentScope);
        for (HashMap<String, Object> currVar : scope) {
            String currID = (String) currVar.get("id");
            if (currID.equals(varID)) {
                return currVar;
            }
        }

        return null;
    }

    public void printScopes() {
        System.out.println("\nprintScopes():");

        for (Map.Entry<String, ArrayList<HashMap<String, Object>>> scope : scopes.entrySet()) {
            System.out.println("\nSCOPE --> " + (String) scope.getKey());
            ArrayList<HashMap<String, Object>> var = scope.getValue();

            for (HashMap<String, Object> currVar : var) {
                System.out.print("   id " + currVar.get("id").toString() + " type " + currVar.get("type").toString());

                if (currVar.get("value") == null)
                    System.out.println();
                else
                    System.out.println(" value " + currVar.get("value"));
            }
        }
    }

    // Program

    @Override
    public void enterProgram(GParser.ProgramContext ctx) {

        // Scope
        symbolTableOutput += "Symbol table GLOBAL";
        currentScope = "GLOBAL";
        if (scopes.containsKey(currentScope) == false) {
            scopes.put(currentScope, new ArrayList<HashMap<String, Object>>());
        }

        // AST
        rootNode = AST.new Program();
        currentNode = rootNode;

        if (debug == true) {
            System.out.println("enterProgram() --> rootNode = " + rootNode.getNodeType());
            System.out.println("enterProgram() --> currentNode = " + currentNode.getNodeType());
        }
    }

    @Override
    public void exitProgram(GParser.ProgramContext ctx) {
        // System.out.println(symbolTableOutput);

        if (debug == true) {
            System.out.println("\n\n----------------------------------");
            System.out.println("AST:\n");
            System.out.println(rootNode.toString());
        }
        AST.IRCode programIRCode = rootNode.getIRCode();

        if (debug == true) {
            System.out.println("\n\n----------------------------------");
            System.out.println("3AC code:");
        }
        // System.out.println(programIRCode.getCodeAsString());
        String irCode = programIRCode.getCodeAsString();
        ArrayList<String> irLines = CodeConverter.makeStrArrayList(irCode);
        ArrayList<String> tinyLines = CodeConverter.convertToTiny(irLines);
        
        // Following code prints tiny code to the terminal
        // First print vars
        for (String s : dataTypesOfVars.keySet()) {
            if (s.matches("newline"))
                continue;
            System.out.println("var " + s);
        }
        // Print newline
        System.out.println("str newline \"\\n\"");
        // Print tiny code directly converted from IR code
        for (String s : tinyLines) {
            System.out.println(s);
        }
        // Print final line of code: sys halt
        System.out.println("sys halt");
    }

    // Id

    @Override
    public void enterId(GParser.IdContext ctx) {

        // Scope stuff
        name = ctx.getText();
    }

    @Override
    public void exitId(GParser.IdContext ctx) {
        int i = ctx.getParent().getRuleIndex();

        if (i == string_decl_ID || i == id_list_ID || i == id_tail_ID || i == param_decl_ID) {
            int i2 = ctx.getParent().getParent().getRuleIndex();
            if (parent_is_RW == false && i2 != read_stmt_ID && i2 != write_stmt_ID) {
                symbolTableOutput += "\n" + "name " + name + " type " + type;
                if (type.equals("STRING") == false) {
                    addVar(name, type);
                }
            }
        }
    }

    // Pgm_body

    @Override
    public void enterPgm_body(GParser.Pgm_bodyContext ctx) {
    }

    @Override
    public void exitPgm_body(GParser.Pgm_bodyContext ctx) {
    }

    // decl

    @Override
    public void enterDecl(GParser.DeclContext ctx) {
    }

    @Override
    public void exitDecl(GParser.DeclContext ctx) {
    }

    // String_decl

    @Override
    public void enterString_decl(GParser.String_declContext ctx) {
        // Scope stuff
        type = "STRING";

        // AST stuff
        String currID = ctx.getChild(1).getText();
        dataTypesOfVars.put(currID, "STRING");
        if (debug == true)
            System.out.println("enterString_decl() --> ID = " + currID);
    }

    @Override
    public void exitString_decl(GParser.String_declContext ctx) {
        // Scope stuff
        symbolTableOutput += " value " + value;
        addVar(name, type, value);
    }

    // Str

    @Override
    public void enterStr(GParser.StrContext ctx) {
        value = ctx.getText();
    }

    @Override
    public void exitStr(GParser.StrContext ctx) {
    }

    // Var_decl

    @Override
    public void enterVar_decl(GParser.Var_declContext ctx) {

        // Scope stuff
        value = "";

        // AST stuff
        String dataType = ctx.getChild(0).getText();

        // ParseTree is the the data type for ctx-variables
        ParseTree currCtx = ctx.getChild(1);
        String currId = currCtx.getChild(0).getText();
        dataTypesOfVars.put(currId, dataType);
        currCtx = currCtx.getChild(1);

        while (currCtx.getChildCount() != 0) {
            currId = currCtx.getChild(1).getText();
            dataTypesOfVars.put(currId, dataType);
            currCtx = currCtx.getChild(2);
        }
    }

    @Override
    public void exitVar_decl(GParser.Var_declContext ctx) {
    }

    // Var_type

    @Override
    public void enterVar_type(GParser.Var_typeContext ctx) {
        type = ctx.getText();
    }

    @Override
    public void exitVar_type(GParser.Var_typeContext ctx) {
    }

    // Any_type

    @Override
    public void enterAny_type(GParser.Any_typeContext ctx) {
    }

    @Override
    public void exitAny_type(GParser.Any_typeContext ctx) {
    }

    // Id_list

    @Override
    public void enterId_list(GParser.Id_listContext ctx) {
        int i = ctx.getParent().getRuleIndex();

        if (i == read_stmt_ID || i == write_stmt_ID)
            parent_is_RW = true;
    }

    @Override
    public void exitId_list(GParser.Id_listContext ctx) {
        parent_is_RW = false;
    }

    // Id_tail

    @Override
    public void enterId_tail(GParser.Id_tailContext ctx) {
    }

    @Override
    public void exitId_tail(GParser.Id_tailContext ctx) {
    }

    // Param_decl_list

    @Override
    public void enterParam_decl_list(GParser.Param_decl_listContext ctx) {
    }

    @Override
    public void exitParam_decl_list(GParser.Param_decl_listContext ctx) {
    }

    // Param_decl

    @Override
    public void enterParam_decl(GParser.Param_declContext ctx) {
    }

    @Override
    public void exitParam_decl(GParser.Param_declContext ctx) {
    }

    // Param_decl_tail

    @Override
    public void enterParam_decl_tail(GParser.Param_decl_tailContext ctx) {
    }

    @Override
    public void exitParam_decl_tail(GParser.Param_decl_tailContext ctx) {
    }

    // Func_declarations

    @Override
    public void enterFunc_declarations(GParser.Func_declarationsContext ctx) {
    }

    @Override
    public void exitFunc_declarations(GParser.Func_declarationsContext ctx) {
    }

    // Func_decl

    @Override
    public void enterFunc_decl(GParser.Func_declContext ctx) {

        // Scope
        currentScope = ctx.children.get(2).getText();
        symbolTableOutput += "\n\nSymbol table " + currentScope;
        addScope(currentScope);
    }

    @Override
    public void exitFunc_decl(GParser.Func_declContext ctx) {
    }

    @Override
    public void enterFunc_body(GParser.Func_bodyContext ctx) {
    }

    // While_stmt

    @Override
    public void enterWhile_stmt(GParser.While_stmtContext ctx) {
        currentScope = "BLOCK " + blockNum;
        blockNum++;
        symbolTableOutput += "\n\nSymbol table " + currentScope;
        addScope(currentScope);
    }

    @Override
    public void exitWhile_stmt(GParser.While_stmtContext ctx) {
    }

    // If_stmt

    @Override
    public void enterIf_stmt(GParser.If_stmtContext ctx) {
        currentScope = "BLOCK " + blockNum;
        blockNum++;
        symbolTableOutput += "\n\nSymbol table " + currentScope;
        addScope(currentScope);
    }

    @Override
    public void exitIf_stmt(GParser.If_stmtContext ctx) {
    }

    // Else_part

    @Override
    public void enterElse_part(GParser.Else_partContext ctx) {
        if (ctx.getText().equals("") == false) {
            currentScope = "BLOCK " + blockNum;
            blockNum++;
            symbolTableOutput += "\n\nSymbol table " + currentScope;
            addScope(currentScope);
        }
    }

    @Override
    public void exitElse_part(GParser.Else_partContext ctx) {
    }

    @Override
    public void enterAssign_expr(GParser.Assign_exprContext ctx) {

        // TODO remove this if
        if (debug == true) {
            System.out.println("enterAssign_expr() --> currentNode (before reset) = " + currentNode.getNodeType());
        }

        // Make ID node for the EqOp node
        String inputID = ctx.getChild(0).getText();
        AST.Id inputIdNode = AST.new Id(inputID, getTypeByID(inputID));

        // Make the EqOp node
        AST.EqOp newNode = AST.new EqOp();
        inputIdNode.addParent(newNode);
        newNode.addChild(inputIdNode);

        // Reset currentNode
        newNode.addParent(currentNode);
        currentNode.addChild(newNode);
        currentNode = newNode;

        // TODO remove
        if (debug == true) {
            System.out.println("enterAssign_expr() --> identifier = " + ctx.getChild(0).getText());
            System.out.println("enterAssign_expr() --> currentNode (after reset) = " + currentNode.getNodeType());
            System.out.println();
        }
    }

    @Override
    public void exitAssign_expr(GParser.Assign_exprContext ctx) {
        if (debug == true) { // TODO remove
            System.out.println("exitAssign_expr() --> currentNode (before reset) = " + currentNode.getNodeType());
            System.out.println();
        }

        currentNode = currentNode.getParent();

        if (debug == true) { // TODO remove
            System.out.println("exitAssign_expr() --> currentNode (after reset) = " + currentNode.getNodeType());
            System.out.println();
        }
    }

    @Override
    public void enterPrimary(GParser.PrimaryContext ctx) {

        // If the primary isn't in the form of '( expr )'
        if (ctx.getChildCount() != 3) {

            AST.Node newNode = null;

            // If this primary is in the form of
            // primary --> id --> some_string
            if (ctx.getChild(0).getChildCount() == 1) {
                String inputID = ctx.getText();
                newNode = AST.new Id(inputID, getTypeByID(inputID));
            }

            // If this primary is in the form of, e.g.,
            // primary --> 10.0
            else {
                String inputLiteral = ctx.getText();
                newNode = AST.new Literal(inputLiteral);
            }

            // TODO remove
            if (debug == true) {
                System.out.println("enterPrimary() --> context = " + ctx.getText());
                System.out.println("enterPrimary() --> child count = " + ctx.getChildCount());
                System.out.println("enterPrimary() --> currentNode = " + currentNode.getNodeType()
                        + " (this should remain the same as last time)");
            }

            // Add the newNode as a child of the assign_expr
            currentNode.addChild(newNode);
            newNode.addParent(currentNode);
        }
    }

    @Override
    public void exitPrimary(GParser.PrimaryContext ctx) {

        // Like enterPrimary,
        // we only care about cases where primary isn't ( expr )

        // TODO double check if this should be uncommented
        // if (ctx.getChildCount() != 3)
        // currentNode = currentNode.parent;
    }

    /*
     * ----------------------------- AST GENERATION CODE
     * ---------------------------------------
     */

    // TODO: Make sure this is bueno
    @Override
    public void enterExpr(GParser.ExprContext ctx) {

        AST.Node newNode = AST.new Expr();

        if (debug == true) { // TODO remove this if
            System.out.println("enterExpr() --> currentNode (before initalization) = " + currentNode.getNodeType());
        }

        newNode.addParent(currentNode);
        currentNode.addChild(newNode);
        currentNode = newNode;

        // TODO remove
        if (debug == true) {
            System.out.println("enterExpr() --> currentNode (after initalization) = " + currentNode.getNodeType());
            System.out.println();
        }
    }

    @Override
    public void exitExpr(GParser.ExprContext ctx) {

        if (debug == true) { // TODO remove
            System.out.println("exitExpr() --> currentNode (before reset) = " + currentNode.getNodeType());
            System.out.println("exitExpr() --> currentNode.children types:");
            for (AST.Node child : currentNode.getChildren()) {
                System.out.println(child.getNodeType() + " " + child.getText());
            }
            System.out.println("exitExpr() --> currentNode's parent nodeType = " + currentNode.getParent().getNodeType()
                    + " " + currentNode.getParent().getText());
        }

        AST.Node nodeToMoveTo;
        AST.Node oldLocationNode = currentNode;

        // // If the expr_prefix isn't empty
        // // the this expr is in the form ( expr )
        // if (currentNode.getChildren().size() == 2) {
        // nodeToMoveTo = currentNode.getChildAtIndex(0);
        // oldLocationNode = currentNode.getChildAtIndex(0);
        //
        // // Go to right-most child of the left child
        // while (nodeToMoveTo.getChildren().size() == 2) {
        // nodeToMoveTo = nodeToMoveTo.getChildAtIndex(1);
        // }
        //
        // if (debug == true) {
        // //System.out.println("\n\n----------------------------------");
        // System.out.println("exitExpr() first stitching:\n");
        // System.out.println(
        // "nodeToMoveTo.nodeType = " + nodeToMoveTo.getNodeType() + " " +
        // nodeToMoveTo.getText());
        // System.out.println(
        // "oldLocationNode.nodeType = " + oldLocationNode.getNodeType() + " " +
        // oldLocationNode.getText());
        // System.out.println(
        // "currentNode.getChildAtIndex(1).nodeType = " +
        // currentNode.getChildAtIndex(1).getNodeType());
        // //System.out.println("----------------------------------\n\n");
        // }
        //
        // nodeToMoveTo.addChild(currentNode.getChildAtIndex(1));
        // currentNode.getChildAtIndex(1).addParent(nodeToMoveTo);
        // currentNode.deleteAllChildren();
        // currentNode.addChild(oldLocationNode);
        // oldLocationNode.addParent(currentNode);
        //
        // // Move currentNode over left
        // nodeToMoveTo = currentNode.getParent().getChildAtIndex(0);
        // oldLocationNode = currentNode.getParent().getChildAtIndex(0);
        //
        // // Go to right-most child of the left child
        // while (nodeToMoveTo.getChildren().size() == 2) {
        // nodeToMoveTo = nodeToMoveTo.getChildAtIndex(1);
        // }
        //
        // // Remove old parent-child associate of currentNode
        // nodeToMoveTo.addChild(currentNode);
        // currentNode.getParent().deleteAllChildren();
        // currentNode.getParent().addChild(oldLocationNode);
        // oldLocationNode.addParent(currentNode.getParent());
        // currentNode.addParent(nodeToMoveTo);
        // }

        currentNode = oldLocationNode.getParent();

        if (debug == true) { // TODO remove
            System.out.println("exitExpr() --> currentNode (after reset) = " + currentNode.getNodeType());
            System.out.println("exitExpr() --> currentNode.children types:");
            for (AST.Node child : currentNode.getChildren()) {
                System.out.println(child.getNodeType() + " " + child.getText());
            }
            System.out.println("exitExpr() --> currentNode's parent nodeType = " + currentNode.getParent().getNodeType()
                    + " " + currentNode.getParent().getText());
        }
    }

    @Override
    public void enterExpr_prefix(GParser.Expr_prefixContext ctx) {

        // Sometimes the expr_prefix is empty,
        // otherwise child at index 2 is an AddOp
        if (ctx.getChildCount() != 0) {
            String operator = ctx.getChild(2).getText();
            AST.Node newNode = AST.new AddOp(operator);

            // TODO remove this if
            if (debug == true) {
                System.out.println(
                        "enterExpr_prefix() --> currentNode (before initalization) = " + currentNode.getNodeType());
            }

            newNode.addParent(currentNode);
            currentNode.addChild(newNode);
            currentNode = newNode;

            // TODO remove
            if (debug == true) {
                System.out.println(
                        "enterExpr_prefix() --> currentNode (after initalization) = " + currentNode.getNodeType());
                System.out.println("enterExpr_prefix() --> operator = " + operator);
                System.out.println();
            }
        }
    }

    @Override
    public void exitExpr_prefix(GParser.Expr_prefixContext ctx) {
        if (debug == true && ctx.getChildCount() > 0) { // TODO remove
            System.out.println("exitExpr_prefix() --> currentNode (before reset) = " + currentNode.getNodeType() + " "
                    + currentNode.getText());
        }

        if (ctx.getChildCount() > 0) {
            currentNode = currentNode.getParent();
        }

        if (debug == true && ctx.getChildCount() > 0) { // TODO remove
            System.out.println("exitExpr_prefix() --> currentNode (after reset) = " + currentNode.getNodeType() + " "
                    + currentNode.getText());
            System.out.println();
        }
    }

    @Override
    public void enterFactor_prefix(GParser.Factor_prefixContext ctx) {

        if (ctx.getChildCount() != 0) {
            String operator = ctx.getChild(2).getText();

            AST.Node newNode = AST.new MulOp(operator);

            if (debug == true) {
                System.out.println(
                        "enterFactor_prefix() --> currentNode (before initalization) = " + currentNode.getNodeType());
            }

            newNode.addParent(currentNode);
            currentNode.addChild(newNode);
            currentNode = newNode;

            // TODO remove
            if (debug == true) {
                System.out.println(
                        "enterFactor_prefix() --> currentNode (after initalization) = " + currentNode.getNodeType());
                System.out.println("enterFactor_prefix() --> operator = " + operator);
                System.out.println();
            }
        }
    }

    @Override
    public void exitFactor_prefix(GParser.Factor_prefixContext ctx) {
        if (debug == true && ctx.getChildCount() != 0) { // TODO remove
            System.out.println("exitFactor_prefix() --> currentNode (before reset) = " + currentNode.getNodeType());
        }

        if (ctx.getChildCount() != 0) {
            currentNode = currentNode.getParent();
        }

        if (debug == true && ctx.getChildCount() != 0) { // TODO remove
            System.out.println("exitFactor_prefix() --> currentNode (after reset) = " + currentNode.getNodeType());
            System.out.println();
        }
    }

    // TODO: implement
    @Override
    public void enterFactor(GParser.FactorContext ctx) {
        AST.Node newNode = AST.new Factor();

        if (debug == true) { // TODO remove this if
            System.out.println("enterFactor() --> currentNode (before initalization) = " + currentNode.getNodeType()
                    + " " + currentNode.getText());
        }

        newNode.addParent(currentNode);
        currentNode.addChild(newNode);
        currentNode = newNode;

        // TODO remove
        if (debug == true) {
            System.out.println("enterFactor() --> currentNode (after initalization) = " + currentNode.getNodeType());
            System.out.println();
        }
    }

    @Override
    public void exitFactor(GParser.FactorContext ctx) {

        // TODO remove
        if (debug == true) {
            System.out.println("exitFactor() --> currentNode (before reset) = " + currentNode.getNodeType());
        }

        AST.Node nodeToMove = currentNode.getChildAtIndex(0);
        AST.Node oldLocationNode = currentNode;

        if (currentNode.getChildren().size() == 2 && nodeToMove.getChildren().size() == 1) {

            // Make Factor's right child the right child of its left child
            nodeToMove.addChild(currentNode.getChildAtIndex(1));
            currentNode.getChildAtIndex(1).addParent(nodeToMove);
            currentNode.deleteAllChildren();
            currentNode.addChild(nodeToMove);
        }

        // If the Factor's sibling has children
        if (currentNode.getParent().getChildAtIndex(0).getChildren().size() > 0) {

            if (currentNode.getParent().getChildren().size() == 2) {
                nodeToMove.addParent(currentNode.getParent().getChildAtIndex(0));
                nodeToMove.getParent().getParent().getChildAtIndex(0).addChild(nodeToMove);
                nodeToMove.getParent().getParent().deleteAllChildren();
                nodeToMove.getParent().getParent().addChild(nodeToMove.getParent());
            } else {
                nodeToMove.addParent(currentNode.getParent());
                currentNode.getParent().deleteAllChildren();
                currentNode.getParent().addChild(nodeToMove);
            }
        }

        if (debug == true) {
            System.out
                    .println("exitFactor() --> nodeToMove = " + nodeToMove.getNodeType() + " " + nodeToMove.getText());
            System.out.println("exitFactor() --> nodeToMove's parent = " + nodeToMove.getParent().getNodeType() + " "
                    + nodeToMove.getParent().getText());
        }

        currentNode = oldLocationNode.getParent();

        // TODO remove
        if (debug == true) {
            System.out.println("exitFactor() --> currentNode (after reset) = " + currentNode.getNodeType());
        }
    }

    @Override
    public void enterRead_stmt(GParser.Read_stmtContext ctx) {
        AST.Node newNode = AST.new ReadStmt();
        newNode.addParent(currentNode);
        currentNode.addChild(newNode);

        // Get the inital ID from the beginning of id_list
        String initalID = ctx.getChild(2).getChild(0).getText();
        String dataType = getTypeByID(initalID);
        AST.Node initalIDNode = AST.new Id(initalID, dataType);
        newNode.addChild(initalIDNode);
        initalIDNode.addParent(newNode);

        // Get the remaining IDs from all the id_tails
        // (similar to enterVar_decl)
        ParseTree currCtx = ctx.getChild(2).getChild(1);

        while (currCtx.getChildCount() != 0) {
            String currID = currCtx.getChild(1).getText();
            String currDataType = getTypeByID(currID);
            AST.Node currIDNode = AST.new Id(currID, currDataType);
            newNode.addChild(currIDNode);
            currIDNode.addParent(newNode);
            currCtx = currCtx.getChild(2);
        }
    }

    @Override
    public void enterWrite_stmt(GParser.Write_stmtContext ctx) {
        AST.Node newNode = AST.new WriteStmt();
        newNode.addParent(currentNode);
        currentNode.addChild(newNode);

        // Get the inital ID from the beginning of id_list
        String initalID = ctx.getChild(2).getChild(0).getText();
        String dataType = getTypeByID(initalID);
        AST.Node initalIDNode = AST.new Id(initalID, dataType);
        newNode.addChild(initalIDNode);
        initalIDNode.addParent(newNode);

        // Get the remaining IDs from all the id_tails
        // (similar to enterVar_decl)
        ParseTree currCtx = ctx.getChild(2).getChild(1);

        while (currCtx.getChildCount() != 0) {
            String currID = currCtx.getChild(1).getText();
            String currDataType = getTypeByID(currID);
            AST.Node currIDNode = AST.new Id(currID, currDataType);
            newNode.addChild(currIDNode);
            currIDNode.addParent(newNode);
            currCtx = currCtx.getChild(2);
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */

    // We don't do anything below here
    // (at least for the moment)

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitFunc_body(GParser.Func_bodyContext ctx) {
        // System.out.println("Exiting " + currentScope);
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterStmt(GParser.StmtContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitStmt(GParser.StmtContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterBase_stmt(GParser.Base_stmtContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitBase_stmt(GParser.Base_stmtContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterAssign_stmt(GParser.Assign_stmtContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitAssign_stmt(GParser.Assign_stmtContext ctx) {
    }

    @Override
    public void exitRead_stmt(GParser.Read_stmtContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitWrite_stmt(GParser.Write_stmtContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterReturn_stmt(GParser.Return_stmtContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitReturn_stmt(GParser.Return_stmtContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterPostfix_expr(GParser.Postfix_exprContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitPostfix_expr(GParser.Postfix_exprContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterCall_expr(GParser.Call_exprContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitCall_expr(GParser.Call_exprContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterExpr_list(GParser.Expr_listContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitExpr_list(GParser.Expr_listContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterExpr_list_tail(GParser.Expr_list_tailContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitExpr_list_tail(GParser.Expr_list_tailContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterAddop(GParser.AddopContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitAddop(GParser.AddopContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterMulop(GParser.MulopContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitMulop(GParser.MulopContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterCond(GParser.CondContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitCond(GParser.CondContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterCompop(GParser.CompopContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitCompop(GParser.CompopContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterInputFile(GParser.InputFileContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitInputFile(GParser.InputFileContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void visitTerminal(TerminalNode node) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    @Override
    public void visitErrorNode(ErrorNode node) {
    }

}
