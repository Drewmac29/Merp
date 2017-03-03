package Nodes;

/**
 * file: BooleanOperatorNode.java
 * created: 3-2-17
 * author: Andrew Gingras
 */

public abstract class BooleanOperatorNode extends BinaryOperatorNode {

    /**
     * Constructor for boolean operation nodes
     * @param left - the left child for this operation
     * @param right - the right child for this operation
     * @param operator - the string representing the operation for this node
     */
    public BooleanOperatorNode (MerpNode left, MerpNode right, java.lang.String operator){
        super(left, right, Precedence.BOOLEAN, operator);
    }

    /**
     * Returns the precedence of this node
     * @return the precedence of boolean
     */
    public int getPrecedence(){
        return Precedence.BOOLEAN.getPrecedence();
    }
}
