package Processors;
import Nodes.MerpNode;
import Nodes.BinaryOperatorNode;

/**
 * file: MerpPrefixProcessor.java
 * created: 3-2-17
 * author: Andrew Gingras
 */

public class MerpPrefixProcessor extends MerpProcessor{

    public MerpPrefixProcessor(){}

    /**
     * Constructs and assigns a Merp tree from the provided list of MerpNode tokens using infix notation
     * @param tokens list of MerpNodes used to create the pares tree
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
        if (node.getNodeType() == MerpNode.NodeType.Constant || node.getNodeType() == MerpNode.NodeType.UnaryOperation)
            return node;
        //General Case
        if (node.getNodeType() == MerpNode.NodeType.BinaryOperation){
            MerpNode left = constructTreeHelper(tokens);
            MerpNode right = constructTreeHelper(tokens);
            ((BinaryOperatorNode) node).setLeftChild(left);
            ((BinaryOperatorNode) node).setRightChild(right);
            return node;
        }
        //TODO
        return null;
    }




}
