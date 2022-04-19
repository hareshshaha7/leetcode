package com.haresh.leetcode.problems;

/*
    897. [Easy] Increasing Order Search Tree
    https://leetcode.com/problems/increasing-order-search-tree/

    Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.

    Example 1:
           5                      1
          /  \                     \
        3      6                    2
       / \      \           -->      \
      2   4      8                    3
     /          / \                    \
    1          7   9                    4
                                         \
                                          5
                                           \
                                            6
                                             \
                                              7
                                               \
                                                8
                                                 \
                                                  9
    Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
    Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

    Example 2:
    Input: root = [5,1,7]
    Output: [1,null,5,null,7]

    Constraints:
        The number of nodes in the given tree will be in the range [1, 100].
        0 <= Node.val <= 1000
 */

/**
 * @author Haresh Shaha
 * @since 19-APR-2022
 */
public class Program186 {

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
        // root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        System.out.println("Original BST: ");
        printBST(root);
        TreeNode result = increasingBST(root);
        System.out.println("\nResult BST: ");
        printBST(result);
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

    static TreeNode cur;
    public static TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    public static void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }
}
