package Processors;
import Nodes.BinaryOperatorNode;
import Nodes.MerpNode;
import Nodes.UnaryOperatorNode;

/**
 * file: MerpPostfixProcessor.java
 * created: 3-2-17
 * author: Andrew Gingras
 */

public class MerpPostfixProcessor extends MerpProcessor {

    public MerpPostfixProcessor(){}

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
        if (tokens.size() > 0) {
            MerpNode next = createMerpNode(tokens.get(0));
            tokens.remove(0);
            if (next.getNodeType() == MerpNode.NodeType.UnaryOperation){
                ((UnaryOperatorNode)node).setChild(next);

            }


        }
    }



}
