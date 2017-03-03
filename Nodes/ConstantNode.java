package Nodes;

import Util.SymbolTable;

/**
 * file: ConstantNode.java
 * created: 3-2-17
 * author: Andrew Gingras
 */

public class ConstantNode implements MerpNode {

    private int value;

    /**
     * Constructor that sets the value of this node
     * @param value - integer value of this node
     */
    public ConstantNode(int value){
        this.value = value;
    }

    /**
     * Returns the value of this node
     * @param symbolTable the symbol table to use for variable processing
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable){
        return 0;
        //TODO
    }

    /**
     * Displays this node as prefix notation expression string
     * @return string representing the node as prefix notation
     */
    public java.lang.String toPrefixString(){
        //TODO
        return null;
    }

    /**
     * Displays this node as infix notation expression string
     * @return string representing the node as infix notation
     */
    public java.lang.String toInfixString(){
        //TODO
        return null;
    }

    /**
     * Displays this node as postfix notation expression string
     * @return string representing the node as postfix notation
     */
    public java.lang.String toPostfixString(){
        //TODO
        return null;
    }

    /**
     * Returns the precedence of this node
     * @return the precedence of CONSTANT
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
        return NodeType.Constant;
    }



}
