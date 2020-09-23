package com.akpg.custom;

import com.akpg.model.Node_nary;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an N-ary tree, find the subtree with the maximum average. Return the root of the subtree.
 * A subtree of a tree is the node which have at least 1 child plus all its descendants. The average value of a subtree
 * is the sum of its values, divided by the number of nodes.
 *
 * Input:
 * 		     20
 * 	     /      \
 * 	    12      18
 *   /  |  \   / \
 * 11   2   3 15  8
 *
 * Output: 18
 * Explanation:
 * There are 3 nodes which have children in this tree:
 * 12 => (11 + 2 + 3 + 12) / 4 = 7
 * 18 => (18 + 15 + 8) / 3 = 13.67
 * 20 => (12 + 11 + 2 + 3 + 18 + 15 + 8 + 20) / 8 = 11.125
 *
 * 18 has the maximum average so output 18.
 */
public class Graph_max_avg_subtree_root {

    public static void main(String[] args) {
        Node_nary left = new Node_nary(12, new ArrayList<Node_nary>(
                List.of(new Node_nary(11), new Node_nary(2), new Node_nary(3))
        ));

        Node_nary right = new Node_nary(18, new ArrayList<Node_nary>(
                List.of(new Node_nary(15), new Node_nary(8))
        ));

        Node_nary root = new Node_nary(20, new ArrayList<Node_nary>(
                List.of(left, right)
        ));

        getMaxAvgSubtree(root);
        System.out.println(maxNode.val + " | " + maxAvg);
    }

    public static double maxAvg;
    public static Node_nary maxNode;

    private static Node_nary getMaxAvgSubtree(Node_nary root) {
        maxAvg = Double.MIN_VALUE;
        maxNode = null;

        helper(root);
        return maxNode;
    }

    /**
     * [num_nodes, sum] off a post-order traversal and if num_nodes > 1 then not a leaf so we
     * can check avg
     *
     * @param root
     * @return
     */
    private static double[] helper(Node_nary root) {
        // Do post order traversal
        double num_nodes = 1;
        double sum = root.val;

        if (!root.children.isEmpty()) {
            for (Node_nary node : root.children) {
                double[] child = helper(node);
                num_nodes += child[0];
                sum += child[1];
            }
        }

        double avg = sum/num_nodes;
        if (num_nodes > 1 && avg > maxAvg) {
            maxAvg = avg;
            maxNode = root;
        }
        return new double[]{num_nodes, sum};
    }

}
