package Processors;
import Nodes.MerpNode;
import Nodes.BinaryOperatorNode;
import Nodes.UnaryOperatorNode;

/**
 * file: MerpInfixProcessor.java
 * created: 3-2-17
 * author: Andrew Gingras
 */

public class MerpInfixProcessor extends MerpProcessor {

    public MerpInfixProcessor(){}

    /**
     * Constructs and assigns a Merp tree from the provided list of MerpNode tokens using infix notation
     * @param tokens list of MerpNodes used to create the pares tree
     */
    public void constructTree(java.util.ArrayList<java.lang.String> tokens){
        java.util.ArrayList<MerpNode> stack = new java.util.ArrayList<>();
        for (int i = 0 ; i < tokens.size() ; i++)
            stack.add(createMerpNode(tokens.get(i)));
        tree = processStack(stack);
    }

    /**
     * Processes a stack of MerpNodes to create a Merp Parse Tree
     * @param stack - the list of nodes to process
     * @return the root of the parse tree
     */
    private MerpNode processStack(java.util.ArrayList<MerpNode> stack){
        MerpNode node = stack.get(0);
        stack.remove(0);
        //Base Case
        if (node.getNodeType() == MerpNode.NodeType.Constant || node.getNodeType() == MerpNode.NodeType.Variable)
            stack.add(node);
        //Binary Case
        else if (node.getNodeType() == MerpNode.NodeType.BinaryOperation){
            MerpNode left = processStack(stack);
            MerpNode right = processStack(stack);
            ((BinaryOperatorNode) node).setLeftChild(left);
            ((BinaryOperatorNode) node).setRightChild(right);
            stack.add(node);
        }
        //Unary Case
        else if (node.getNodeType() == MerpNode.NodeType.UnaryOperation){
            MerpNode child = processStack(stack);
            ((UnaryOperatorNode) node).setChild(child);
            stack.add(node);
        }
        return node;
    }




}
