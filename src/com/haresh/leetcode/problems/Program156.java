package com.haresh.leetcode.problems;

/*
783. [Easy] Minimum Distance Between BST Nodes
https://leetcode.com/problems/minimum-distance-between-bst-nodes/

Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.

Example 1:
         4
       /   \
      2     6
     / \
    1   3
Input: root = [4,2,6,1,3]
Output: 1

Example 2:
        1
       / \
      0  48
        /  \
       12  49
Input: root = [1,0,48,null,null,12,49]
Output: 1

Constraints:
    The number of nodes in the tree is in the range [2, 100].
    0 <= Node.val <= 105
 */

/**
 * @author Haresh Shaha
 * @since 15-Feb-2022
 */
public class Program156 {

    //  Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int minimumDifference = minDiffInBST(root);
        System.out.println(minimumDifference);
    }

    static Integer res = Integer.MAX_VALUE, pre = null;
    public static int minDiffInBST(TreeNode root) {
        if (root.left != null) {
            minDiffInBST(root.left);
        }

        if (pre != null) {
            res = Math.min(res, root.val - pre);
        }

        pre = root.val;
        if (root.right != null) {
            minDiffInBST(root.right);
        }
        return res;
    }
}
