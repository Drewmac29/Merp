package Nodes;
import Util.SymbolTable;

/**
 * file: MultiplicationNode.java
 * created: 3-2-17
 * author: Andrew Gingras
 */

public class MultiplicationNode extends BinaryOperatorNode {

    /**
     * Constructs a Multiplication node
     * @param left - the MerpNode representing the left child
     * @param right - the MerpNode representing the right child
     */
    public MultiplicationNode(MerpNode left, MerpNode right){
        super(left, right, Precedence.MULT_DIVIDE, "*");
    }

    /**
     * Evaluates the node to determine its integer value
     * @param symbolTable the symbol table to use for variable processing
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable){
        return 0;
        //TODO
    }

}
