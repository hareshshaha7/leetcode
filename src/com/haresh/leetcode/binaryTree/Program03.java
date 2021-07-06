/**
 * 
 */
package com.haresh.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

/*
	Binary Tree Postorder Traversal
	
	Given the root of a binary tree, return the postorder traversal of its nodes' values.
	
	Example 1:
	Input: root = [1,null,2,3]
	Output: [3,2,1]
	
	Example 2:
	Input: root = []
	Output: []
	
	Example 3:
	Input: root = [1]
	Output: [1]
	
	Example 4:
	Input: root = [1,2]
	Output: [2,1]
	
	Example 5:
	Input: root = [1,null,2]
	Output: [2,1]
	
	Constraints:
		The number of the nodes in the tree is in the range [0, 100].
		-100 <= Node.val <= 100
	
	Follow up: Recursive solution is trivial, could you do it iteratively?
 */

/**
 * @author Haresh Shaha
 * @since 06-Jul-2021
 *
 */
public class Program03 {

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
		TreeNode root = new Program03().new TreeNode(1);
		root.right = new Program03().new TreeNode(2);
		root.right.left = new Program03().new TreeNode(3);

		List<Integer> result = postorderTraversal(root);
		System.out.println(result);
	}

	public static List<Integer> postorderTraversal(TreeNode root) {
		return postorder(root, new ArrayList<Integer>());
	}

	public static List<Integer> postorder(TreeNode root, List<Integer> result) {
		if (root == null) {
			return result;
		}

		postorder(root.left, result);
		postorder(root.right, result);
		result.add(root.val);

		return result;
	}
}
