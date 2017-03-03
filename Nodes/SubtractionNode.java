package Nodes;
import Util.SymbolTable;

/**
 * file: SubtractionNode.java
 * created: 3-2-17
 * author: Andrew Gingras
 */

public class SubtractionNode extends BinaryOperatorNode{

    /**
     * Constructs a Subtraction node
     * @param left - the MerpNode representing the left child
     * @param right - the MerpNode representing the right child
     */
    public SubtractionNode(MerpNode left, MerpNode right){
        super(left, right, Precedence.ADD_SUBTRACT, "-");
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
