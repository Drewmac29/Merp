package Nodes;
import Util.SymbolTable;

/**
 * file: AbsValueNode.java
 * created: 3-2-17
 * author: Andrew Gingras
 */

public class AbsValueNode extends UnaryOperatorNode {

    /**
     * Constructs an AbsValueNode
     * @param child - MerpNode that is the child of this node
     */
    public AbsValueNode (MerpNode child){
        super(child, Precedence.MULT_DIVIDE, "|");
    }

    /**
     * Evaluates the node to determine it's integer value
     * @param symbolTable - the symbol table to use for variable processing
     * @return an integer value of this node
     */
    public int evaluate(SymbolTable symbolTable){
        return java.lang.Math.abs(child.evaluate(symbolTable));
    }
}


