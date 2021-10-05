package com.haresh.leetcode.binaryTree;

/*
	Path Sum
	
	Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
	
	A leaf is a node with no children.
	
	Example 1:
		       5
		      / \
		     /   \
		    4 	  8
		   / 	 / \
		  11 	13	4
	     / \		 \
	    7   2		  1
	Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
	Output: true
	
	Example 2:
		  1
		 / \
		2	3
	Input: root = [1,2,3], targetSum = 5
	Output: false
	
	Example 3:
	Input: root = [1,2], targetSum = 0
	Output: false
	
	Constraints:
		The number of nodes in the tree is in the range [0, 5000].
		-1000 <= Node.val <= 1000
		-1000 <= targetSum <= 1000
 */

/**
 * @author Haresh Shaha
 * @since 27-Sep-2021
 *
 */
public class Program07 {

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
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new Program07().new TreeNode(5);
		root.left = new Program07().new TreeNode(4);
		root.right = new Program07().new TreeNode(8);
		root.left.left = new Program07().new TreeNode(11);
		root.left.left.left = new Program07().new TreeNode(7);
		root.left.left.right = new Program07().new TreeNode(2);
		
		root.right.left = new Program07().new TreeNode(13);
		root.right.right = new Program07().new TreeNode(4);
		root.right.right.right = new Program07().new TreeNode(1);

		int targetSum = 22;
		System.out.println(hasPathSum(root, targetSum));
	}

	public static boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null && targetSum - root.val == 0)
			return true;

		return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
	}
}
