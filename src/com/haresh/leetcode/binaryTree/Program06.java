/**
 * 
 */
package com.haresh.leetcode.binaryTree;

/*
	Symmetric Tree
	
	Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
	
	Example 1:
	       1
	      / \
	     /   \
	    2 	  2
	   / \	 / \
	  3	  4	4	3
	Input: root = [1,2,2,3,4,4,3]
	Output: true
	
	Example 2:
	       1
	      / \
	     /   \
	    2 	  2
	     \	   \
	  	  3		3
	Input: root = [1,2,2,null,3,null,3]
	Output: false
	
	Constraints:
		The number of nodes in the tree is in the range [1, 1000].
		-100 <= Node.val <= 100
	
	Follow up: Could you solve it both recursively and iteratively?
*/

/**
 * @author Haresh Shaha
 * @since 01-Sep-2021
 *
 */
public class Program06 {

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
		TreeNode root = new Program06().new TreeNode(1);
		root.left = new Program06().new TreeNode(2);
		root.right = new Program06().new TreeNode(2);
		root.left.left = new Program06().new TreeNode(3);
		root.left.right = new Program06().new TreeNode(4);
		root.right.left = new Program06().new TreeNode(4);
		root.right.right = new Program06().new TreeNode(3);

		System.out.println(isSymmetric(root));
	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;

		return isSymmetric(root.left, root.right);
	}

	public static boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}

		if (left == null || right == null) {
			return false;
		}

		if (left.val == right.val)
			return isSymmetric(left.left, right.right) && isSymmetric(right.left, left.right);
		else
			return false;

	}

}
