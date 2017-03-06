package Nodes;
import Util.SymbolTable;

/**
 * file: NegationNode.java
 * created: 3-2-17
 * author: Andrew Gingras
 */

public class NegationNode extends UnaryOperatorNode {

    /**
     * Constructs a Negation node
     * @param child - MerpNode that is the child of this node
     */
    public NegationNode(MerpNode child){
        super(child, Precedence.MULT_DIVIDE, "_");
    }

    /**
     * Evaluates the node to determine its integer value
     * @param symbolTable the symbol table to use for variable processing
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable){
        return (0 - child.evaluate(symbolTable));
    }



}
