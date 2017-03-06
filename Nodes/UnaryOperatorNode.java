package Nodes;

/**
 * file: UnaryOperatorNode.java
 * created: 3-2-17
 * author: Andrew Gingras
 */

public abstract class UnaryOperatorNode implements MerpNode{

    protected MerpNode child;
    protected java.lang.String operator;
    protected Precedence precedence;

    /**
     * Create a unary operator object
     * @param child - child node
     * @param precedence - precedence type
     * @param operator - operator type
     */
    public UnaryOperatorNode(MerpNode child, Precedence precedence, java.lang.String operator){
        this.child = child;
        this.precedence = precedence;
        this.operator = operator;
    }

    /**
     * Sets the child of this node
     * @param child - the MerpNode representing the child
     */
    public void setChild(MerpNode child){
        this.child = child;
    }

    /**
     * Displays this node as prefix notation expression string
     * @return string representing the node as prefix notation
     */
    public java.lang.String toPrefixString(){
        return (operator + " " + child.toPrefixString());
    }

    /**
     * Displays this node as infix notation expression string
     * @return string representing the node as infix notation
     */
    public java.lang.String toInfixString(){
        return ("(" + operator + " " + child.toInfixString()+ ")");
    }

    /**
     * Displays this node as postfix notation expression string
     * @return string representing the node as postfix notation
     */
    public java.lang.String toPostfixString(){
        return (child.toPostfixString() + " " + operator);
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
        return NodeType.UnaryOperation;
    }
}
