/**
 * 
 */
package com.haresh.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

/*
	Binary Tree Preorder Traversal
	
	Solution
	Given the root of a binary tree, return the preorder traversal of its nodes' values.
	
	Example 1:
	Input: root = [1,null,2,3]
	Output: [1,2,3]
	
	Example 2:
	Input: root = []
	Output: []
	
	Example 3:
	Input: root = [1]
	Output: [1]
	
	Example 4:
	Input: root = [1,2]
	Output: [1,2]
	
	Example 5:
	Input: root = [1,null,2]
	Output: [1,2]
	
	Constraints:
		The number of nodes in the tree is in the range [0, 100].
		-100 <= Node.val <= 100
	 
	
	Follow up: Recursive solution is trivial, could you do it iteratively?
 */

/**
 * @author Haresh Shaha
 * @since 05-Jul-2021
 *
 */
public class Program01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new Program01().new TreeNode(1);
		root.right = new Program01().new TreeNode(2);
		root.right.left = new Program01().new TreeNode(3);

		List<Integer> result = preorderTraversal(root);
		System.out.println(result);
	}

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

	public static List<Integer> preorderTraversal(TreeNode root) {
		return preorder(root, new ArrayList<>());
	}

	public static List<Integer> preorder(TreeNode root, List<Integer> result) {
		if (root == null)
			return result;

		result.add(root.val);
		preorder(root.left, result);
		preorder(root.right, result);

		return result;
	}
}
