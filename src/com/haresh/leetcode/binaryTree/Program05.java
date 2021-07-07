/**
 * 
 */
package com.haresh.leetcode.binaryTree;

/*
	Maximum Depth of Binary Tree
	https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/535/

	Given the root of a binary tree, return its maximum depth.
	
	A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	
	Example 1:
	Input: root = [3,9,20,null,null,15,7]
	Output: 3
	
	Example 2:
	Input: root = [1,null,2]
	Output: 2
	
	Example 3:
	Input: root = []
	Output: 0
	
	Example 4:
	Input: root = [0]
	Output: 1
	
	Constraints:
		The number of nodes in the tree is in the range [0, 104].
		-100 <= Node.val <= 100
 */

/**
 * @author Haresh Shaha
 * @since 07-Jul-2021
 *
 */
public class Program05 {

	// Definition for a binary tree node.
	class TreeNode {
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

		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new Program05().new TreeNode(3);
		root.left = new Program05().new TreeNode(9);
		root.right = new Program05().new TreeNode(20);
		root.left.left = new Program05().new TreeNode(10);
		root.right.left = new Program05().new TreeNode(15);
		root.right.right = new Program05().new TreeNode(7);

		answer = 0;
		maximumDepthTopDown(root, 1);
		System.out.println("Top down Approach: " + answer);

		answer = maximumDepthBottomUp(root);
		System.out.println("Bottom Up Approach:" + answer);
	}

	private static int answer; // don't forget to initialize answer before call maximum_depth

	private static void maximumDepthTopDown(TreeNode root, int depth) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			answer = Math.max(answer, depth);
		}

		maximumDepthTopDown(root.left, depth + 1);
		maximumDepthTopDown(root.right, depth + 1);
	}

	public static int maximumDepthBottomUp(TreeNode root) {
		if (root == null) {
			return 0; // return 0 for null node
		}

		int left_depth = maximumDepthBottomUp(root.left);
		int right_depth = maximumDepthBottomUp(root.right);

		return Math.max(left_depth, right_depth) + 1; // return depth of the subtree rooted at root
	}
}
