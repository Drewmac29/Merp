package Processors;
import Nodes.MerpNode;
import Nodes.BinaryOperatorNode;
import Nodes.UnaryOperatorNode;
import java.util.Stack;

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
        //Converts the tokens into Postfix notation using the shunting-yard algorithm
        Stack<String> opStack = new Stack<>();
        java.util.ArrayList<java.lang.String> postfix = new java.util.ArrayList<>();
        for (String token : tokens){
            MerpNode node = createMerpNode(token);
            if (node.getNodeType() == MerpNode.NodeType.Constant || node.getNodeType() == MerpNode.NodeType.Variable)
                postfix.add(token);
            else {
                while (opStack.size() > 0){
                    MerpNode check = createMerpNode(opStack.firstElement());
                    if (node.getPrecedence() > check.getPrecedence())
                        postfix.add(opStack.pop());
                    else
                        break;
                }
                opStack.push(token);
            }
        }
        while (opStack.size() > 0)
            postfix.add(opStack.pop());
        //Calls tree to be created using PostFix Reverse Polish
        tree = processStack(postfix, new Stack<>());
    }


    /**
     * Processes a stack of MerpNodes to create a Merp Parse Tree
     * @param stack - the list of nodes to process
     * @return the root of the parse tree
     */
    private MerpNode processStack(java.util.ArrayList<java.lang.String> tokens, Stack<MerpNode> stack){
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
