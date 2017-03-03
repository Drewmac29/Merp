package Nodes;

/**
 * file: UnaryOperatorNode.java
 * created: 3-2-17
 * author: Andrew Gingras
 */

public abstract class BinaryOperatorNode implements MerpNode {

    protected MerpNode leftChild;
    protected MerpNode rightChild;
    protected Precedence precedence;
    protected java.lang.String operator;

    /**
     * Binary node constructor
     * @param leftChild - MerpNode representing left child
     * @param rightChild - MerpNode representing right child
     * @param precedence - Precedence of the operator
     * @param operator - String representing the operator
     */
    public BinaryOperatorNode(MerpNode leftChild, MerpNode rightChild, Precedence precedence,
                              java.lang.String operator){
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.precedence = precedence;
        this.operator = operator;
    }

    /**
     * Setter for left child
     * @param leftChild - the MerpNode to be set at this node's left child
     */
    public void setLeftChild(MerpNode leftChild){
        //TODO
    }

    /**
     * Setter for right child
     * @param rightChild - the MerpNode to be set at this node's right child
     */
    public void setRightChild(MerpNode rightChild){
        //TODO
    }

    /**
     * Displays this node as prefix notation expression string
     * @return string representing the node as prefix notation
     */
    public java.lang.String toPrefixString(){
        return null;
        //TODO
    }

    /**
     * Displays this node as infix notation expression string
     * @return string representing the node as infix notation
     */
    public java.lang.String toInfixString(){
        return "{" + leftChild.toInfixString() + " " + operator + " " + rightChild.toInfixString() + "}";
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
     * @return the precedence as an int value
     */
    public int getPrecedence(){
        return precedence.getPrecedence();
    }

    /**
     * Determines if the node is an operation node
     * @return true if an operation node, false otherwise
     */
    public boolean isOperation(){
        return true;
    }

    /**
     * Determines the node type
     * @return the type of node
     */
    public MerpNode.NodeType getNodeType(){
        return NodeType.BinaryOperation;
    }
}
