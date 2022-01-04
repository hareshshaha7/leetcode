package com.haresh.leetcode.problems;
/*
    653. Two Sum IV - Input is a BST
    https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

    Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.

    Example 1:
             5
           /  \
          3     6
         / \     \
        2   4     7
    Input: root = [5,3,6,2,4,null,7], k = 9
    Output: true

    Example 2:
    Input: root = [5,3,6,2,4,null,7], k = 28
    Output: false

    Constraints:
        The number of nodes in the tree is in the range [1, 104].
        -104 <= Node.val <= 104
        root is guaranteed to be a valid binary search tree.
        -105 <= k <= 105
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author Haresh Shaha
 * @since 04-Jan-2022
 */
public class Program99 {

    // Definition for a binary tree node.
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

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        int target = 9;
        boolean isTargetPresent = findTarget(root, target);
        System.out.println(isTargetPresent);
    }

    public static boolean findTarget(TreeNode root, int k) {
        return dfs(root, k, new HashSet<>());
    }

    public static boolean dfs(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }

        if (set.contains(k - root.val)) {
            return true;
        }

        set.add(root.val);
        return dfs(root.left, k, set) || dfs(root.right, k, set);
    }
}
