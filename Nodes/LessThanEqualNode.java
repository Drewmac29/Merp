package Nodes;
import Util.SymbolTable;

/**
 * file: LessThanEqualNode.java
 * created: 3-2-17
 * author: Andrew Gingras
 */

public class LessThanEqualNode extends BooleanOperatorNode {

    /**
     * Constructs a LessThanEqual node
     * @param left - the MerpNode representing the left child
     * @param right - the MerpNode representing the right child
     */
    public LessThanEqualNode(MerpNode left, MerpNode right){
        super(left, right, "<=");
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
