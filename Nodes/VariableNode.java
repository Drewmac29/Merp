package Nodes;
import Util.SymbolTable;

/**
 * file: VariableNode.java
 * created: 3-2-17
 * author: Andrew Gingras
 */

public class VariableNode implements MerpNode {

    private java.lang.String name;

    /**
     * Constructs a Variable node
     * @param name - variable name
     */
    public VariableNode(java.lang.String name){
        this.name = name;
    }

    /**
     * Evaluates the node to determine its integer value
     * @param symbolTable the symbol table to use for variable processing
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable){
        return symbolTable.get(name);
    }

    /**
     * Displays this node as prefix notation expression string
     * @return string representing the node as prefix notation
     */
    public java.lang.String toPrefixString(){
        return name;
    }

    /**
     * Displays this node as infix notation expression string
     * @return string representing the node as infix notation
     */
    public java.lang.String toInfixString(){
        return name;
    }

    /**
     * Displays this node as postfix notation expression string
     * @return string representing the node as postfix notation
     */
    public java.lang.String toPostfixString(){
        return name;
    }

    /**
     * Returns the precedence of this node
     * @return the precedence as an int value
     */
    public int getPrecedence(){
        return Precedence.CONSTANT.getPrecedence();
    }

    /**
     * Determines if the node is an operation node
     * @return true if an operation node, false otherwise
     */
    public boolean isOperation(){
        return false;
    }

    /**
     * Determines the node type
     * @return the type of node
     */
    public MerpNode.NodeType getNodeType(){
        return NodeType.Variable;
    }




}
