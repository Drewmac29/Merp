package Nodes;
import Util.SymbolTable;

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
        return 0;
        //TODO
    }




}
