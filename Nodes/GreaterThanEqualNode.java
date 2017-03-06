package Nodes;
import Util.SymbolTable;

/**
 * file: GreaterThanEqualNode.java
 * created: 3-2-17
 * author: Andrew Gingras
 */

public class GreaterThanEqualNode extends BooleanOperatorNode {

    /**
     * Constructs a GreaterThanEqual node
     * @param left
     * @param right
     */
    public GreaterThanEqualNode(MerpNode left, MerpNode right){
        super(left, right, ">=");
    }

    /**
     * Evaluates the node to determine its integer value
     * @param symbolTable the symbol table to use for variable processing
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable){
        if (leftChild.evaluate(symbolTable) >= rightChild.evaluate(symbolTable))
            return 1;
        return 0;
    }


}
