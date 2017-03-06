package Nodes;
import Util.SymbolTable;

/**
 * file: PowerNode.java
 * created: 3-2-17
 * author: Andrew Gingras
 */

public class PowerNode extends BinaryOperatorNode {

    /**
     * Constructs a PowerNode node
     * @param left - the MerpNode representing the base
     * @param right - the MerpNode representing the power
     */
    public PowerNode(MerpNode left, MerpNode right){
        super(left, right, Precedence.POWER, "^");
    }

    /**
     * Evaluates the node to determine its integer value
     * @param symbolTable the symbol table to use for variable processing
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable){
        return (int) java.lang.Math.pow(leftChild.evaluate(symbolTable), rightChild.evaluate(symbolTable));
    }


}
