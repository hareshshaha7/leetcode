package com.haresh.leetcode.problems;

/*
530. [Easy] Minimum Absolute Difference in BST
https://leetcode.com/problems/minimum-absolute-difference-in-bst/

Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

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
    The number of nodes in the tree is in the range [2, 104].
    0 <= Node.val <= 105
 */

/**
 * @author Haresh Shaha
 * @since 15-Feb-2022
 */
public class Program155 {

    //  Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int minimumDifference = getMinimumDifference(root);
        System.out.println(minimumDifference);
    }

    static Integer diff = Integer.MAX_VALUE, prev = null;

    public static int getMinimumDifference(TreeNode root) {
        if (root.left != null) {
            getMinimumDifference(root.left);
        }

        if (prev != null) {
            diff = Math.min(diff, root.val - prev);
        }
        prev = root.val;

        if (root.right != null) {
            getMinimumDifference(root.right);
        }
        return diff;
    }
}
