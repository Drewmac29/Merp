package Processors;
import Nodes.BinaryOperatorNode;
import Nodes.MerpNode;
import Nodes.UnaryOperatorNode;
import java.util.Stack;

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
        //Create a new token array so original is not destroyed. Allows equation processor to check the loop correctly
        java.util.ArrayList<java.lang.String> tokens2 = new java.util.ArrayList<>();
        for (String token : tokens){
            tokens2.add(token);
        }
        tree = constructTreeHelper(tokens2, new Stack<>());
    }

    /**
     * Helper to recursively contstruct the parse tree
     * @param tokens - list of MerpNodes to process
     * @return current root of the parse tree
     */
    private MerpNode constructTreeHelper(java.util.ArrayList<java.lang.String> tokens, Stack<MerpNode> stack){
        //Uses Reverse Polish Notation to create the parse tree
        while (tokens.size() > 0){
            MerpNode node = createMerpNode(tokens.get(0));
            tokens.remove(0);
            if (node.getNodeType() == MerpNode.NodeType.Constant || node.getNodeType() == MerpNode.NodeType.Variable)
                stack.push(node);
            else if (node.getNodeType() == MerpNode.NodeType.BinaryOperation){
                MerpNode right = stack.pop();
                MerpNode left = stack.pop();
                ((BinaryOperatorNode) node).setLeftChild(left);
                ((BinaryOperatorNode) node).setRightChild(right);
                stack.push(node);
            }
            else if(node.getNodeType() == MerpNode.NodeType.UnaryOperation){
                MerpNode child = stack.pop();
                ((UnaryOperatorNode) node).setChild(child);
                stack.push(node);
            }
        }
        return stack.pop();
    }
}
