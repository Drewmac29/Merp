package Nodes;
import Util.SymbolTable;

/**
 * file: EqualityNode.java
 * created: 3-2-17
 * author: Andrew Gingras
 */

public class EqualityNode extends BooleanOperatorNode {

    /**
     * Constructs an equality node
     * @param left - the MerpNode representing the left child
     * @param right - the MerpNode representing the right child
     */
    public EqualityNode(MerpNode left, MerpNode right){
        super(left, right, "==");
    }

    /**
     * Evaluates the node to determine its integer value
     * @param symbolTable the symbol table to use for variable processing
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable){
        if (leftChild.evaluate(symbolTable) == rightChild.evaluate(symbolTable))
            return 1;
        return 0;
    }
}
