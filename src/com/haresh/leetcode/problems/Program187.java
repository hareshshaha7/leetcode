package com.haresh.leetcode.problems;

/*
    99. [Medium] Recover Binary Search Tree
    https://leetcode.com/problems/recover-binary-search-tree/

    You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake.
    Recover the tree without changing its structure.

    Example 1:
            1                      3
          /                       /
         3         -->           1
          \                       \
           2                       2
    Input: root = [1,3,null,null,2]
    Output: [3,1,null,null,2]
    Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.

    Example 2:
            3                        2
          /   \                    /   \
         1     4   -->            1     4
              /                        /
            2                         3
    Input: root = [3,1,4,null,null,2]
    Output: [2,1,4,null,null,3]
    Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.

    Constraints:
        The number of nodes in the tree is in the range [2, 1000].
        -231 <= Node.val <= 231 - 1
 */

/**
 * @author Haresh Shaha
 * @since 19-APR-2022
 */
public class Program187 {
    //Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // root = [3,1,4,null,null,2]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        System.out.println("Original BST: ");
        printBST(root);
        recoverTree(root);
        System.out.println("\nResult BST: ");
        printBST(root);
    }

    public static void printBST(TreeNode node) {
        if (node == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(node.val + " ");
        printBST(node.left);
        printBST(node.right);
    }

    static TreeNode firstElement = null;
    static TreeNode secondElement = null;
    // The reason for this initialization is to avoid null pointer exception in the first comparison when prevElement has not been initialized
    static TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

    public static void recoverTree(TreeNode root) {

        // In order traversal to find the two elements
        traverse(root);

        // Swap the values of the two nodes
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private static void traverse(TreeNode node) {

        if (node == null)
            return;

        traverse(node.left);

        // Start of "do some business",
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (firstElement == null && prevElement.val > node.val) {
            firstElement = prevElement;
        }

        // If first element is found, assign the second element to the node (refer to 2 in the example above)
        if (firstElement != null && prevElement.val > node.val) {
            secondElement = node;
        }
        prevElement = node;

        // End of "do some business"

        traverse(node.right);
    }
}
