package Nodes;
import Util.SymbolTable;
import Util.Errors;

/**
 * file: SquareRootNode.java
 * created: 3-2-17
 * author: Andrew Gingras
 */

public class SquareRootNode extends UnaryOperatorNode {

    /**
     * Constructs a SquareRoot node
     * @param child - MerpNode that is the child of this node
     */
    public SquareRootNode(MerpNode child){
        super(child, Precedence.POWER, "@");
    }

    /**
     * Evaluates the node to determine its integer value
     * @param symbolTable the symbol table to use for variable processing
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable){
        if (child.evaluate(symbolTable) < 0)
            Errors.error("Square Root of Negative Number", this.toString());
        return (int) java.lang.Math.sqrt(child.evaluate(symbolTable));
    }



}
