/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	Deepest Leaves Sum
	https://leetcode.com/problems/deepest-leaves-sum/

	Given the root of a binary tree, return the sum of values of its deepest leaves.
	
	Example 1:
	
		  1
		 /  \
		2    3
	   / \    \
	  4   5    6
	 /			\
	7			 8
	
	Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
	Output: 15
	
	Example 2:
	Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
	Output: 19
	
	Constraints:
		The number of nodes in the tree is in the range [1, 104].
		1 <= Node.val <= 100
 */

/**
 * @author Haresh Shaha
 * @since 20-May-2021
 *
 */
public class Program17 {

	private static TreeNode m_root;

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

		// Function to insert nodes in level order
		public TreeNode insertLevelOrder(int[] arr, TreeNode root, int i) {
			// Base case for recursion
			if (i < arr.length) {
				TreeNode temp = new TreeNode(arr[i]);
				root = temp;

				// insert left child
				root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

				// insert right child
				root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
			}
			return root;
		}

		// Function to print tree nodes in InOrder fashion
		public void inOrder(TreeNode root) {
			if (root != null) {
				inOrder(root.left);
				System.out.print(root.val + " ");
				inOrder(root.right);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		m_root = new Program17().new TreeNode(1);
		m_root.left = new Program17().new TreeNode(2);
		m_root.right = new Program17().new TreeNode(3);
		m_root.left.left = new Program17().new TreeNode(4);
		m_root.left.right = new Program17().new TreeNode(5);
		m_root.right.right = new Program17().new TreeNode(6);
		m_root.left.left.left = new Program17().new TreeNode(7);
		m_root.right.right.right = new Program17().new TreeNode(8);

		TreeNode node = new Program17().new TreeNode();
//		int[] nodes = { 1, 2, 3, 4, 5, -1, 6, 7, -1, -1, -1, -1, 8 };
//		m_root = node.insertLevelOrder(nodes, m_root, 0); // In this problem we do not use level order or other standard ordering
		node.inOrder(m_root);
		System.out.println();

		int result = deepestLeavesSum(m_root);
		System.out.println(result);
	}

	public static int deepestLeavesSum(TreeNode root) {
		int depth = maxLevel(root);
		int sum = getDeepestLeavesSum(root, depth);

		return sum;
	}

	private static int maxLevel(TreeNode root) {
		if (root == null)
			return 0;

		int l_depth = maxLevel(root.left);
		int r_depth = maxLevel(root.right);

		return 1 + Math.max(l_depth, r_depth);
	}

	private static int getDeepestLeavesSum(TreeNode root, int k) {
		if (root == null)
			return 0;
		
		if (k == 1)
			return root.val;

		return getDeepestLeavesSum(root.left, k - 1) + getDeepestLeavesSum(root.right, k - 1);
	}

}
