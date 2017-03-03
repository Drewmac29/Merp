package Nodes;
import Util.SymbolTable;
import Util.Errors;

/**
 * file: DivisionNode.java
 * created: 3-2-17
 * author: Andrew Gingras
 */

public class DivisionNode extends BinaryOperatorNode {

    /**
     * Constructs a division node
     * @param left - the MerpNode representing the left child
     * @param right - the MerpNode representing the right child
     */
    public DivisionNode(MerpNode left, MerpNode right){
        super(left, right, Precedence.MULT_DIVIDE, "//");
    }

    /**
     * Evaluates the node to determine its integer value Errors if the right child evaluates to zero
     * @param symbolTable the symbol table to use for variable processing
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable){
        if (rightChild.evaluate(symbolTable) == 0)
            Errors.error("Division by Zero", this.toString());
        return (leftChild.evaluate(symbolTable) / rightChild.evaluate(symbolTable));
    }


}
