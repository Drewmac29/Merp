package Processors;
import Nodes.MerpNode;
import Nodes.BinaryOperatorNode;
import Nodes.UnaryOperatorNode;

/**
 * file: MerpPrefixProcessor.java
 * created: 3-2-17
 * author: Andrew Gingras
 */

public class MerpPrefixProcessor extends MerpProcessor{

    public MerpPrefixProcessor(){}

    /**
     * Constructs and assigns a Merp tree from the provided list of MerpNode tokens using infix notation
     * @param tokens list of MerpNodes used to create the parse tree
     */
    public void constructTree(java.util.ArrayList<java.lang.String> tokens){
        tree = constructTreeHelper(tokens);
    }

    /**
     * Helper to recursively contstruct the parse tree
     * @param tokens - list of MerpNodes to process
     * @return current root of the parse tree
     */
    private MerpNode constructTreeHelper(java.util.ArrayList<java.lang.String> tokens){
        MerpNode node = createMerpNode(tokens.get(0));
        tokens.remove(0);
        //Base Case
        if (node.getNodeType() == MerpNode.NodeType.Constant || node.getNodeType() == MerpNode.NodeType.Variable)
            return node;
        //Binary Case
        else if (node.getNodeType() == MerpNode.NodeType.BinaryOperation){
            MerpNode left = constructTreeHelper(tokens);
            MerpNode right = constructTreeHelper(tokens);
            ((BinaryOperatorNode) node).setLeftChild(left);
            ((BinaryOperatorNode) node).setRightChild(right);
            return node;
        }
        //Unary Case
        else if (node.getNodeType() == MerpNode.NodeType.UnaryOperation){
            MerpNode child = constructTreeHelper(tokens);
            ((UnaryOperatorNode) node).setChild(child);
            return node;
        }
        return node;
    }

}
