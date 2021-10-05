package com.haresh.leetcode.binaryTree;

import java.util.HashMap;
import java.util.Map;

/*
	Construct Binary Tree from Inorder and Postorder Traversal
	
	Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, 
	construct and return the binary tree.
	
	Example 1:
	Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
	Output: [3,9,20,null,null,15,7]
	
	Example 2:
	Input: inorder = [-1], postorder = [-1]
	Output: [-1]
	
	Constraints:
		1 <= inorder.length <= 3000
		postorder.length == inorder.length
		-3000 <= inorder[i], postorder[i] <= 3000
		inorder and postorder consist of unique values.
		Each value of postorder also appears in inorder.
		inorder is guaranteed to be the inorder traversal of the tree.
		postorder is guaranteed to be the postorder traversal of the tree.
 */

/**
 * @author Haresh Shaha
 * @since 05-Oct-2021
 *
 */
public class Program08 {

	// Definition for a binary tree node.
	public class TreeNode {
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
		int[] inorder = { 9, 3, 15, 20, 7 }, postorder = { 9, 15, 7, 20, 3 };
		TreeNode root = buildTree(inorder, postorder);
		preorderPrint(root);
	}

	public static void preorderPrint(TreeNode root) {
		if (root == null) {
			System.out.print(" null ");
			return;
		}

		System.out.print(" " + root.val + " ");
		preorderPrint(root.left);
		preorderPrint(root.right);
	}

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			inorderMap.put(inorder[i], i);
		}

		return BinaryTreeFromInorderAndPostorder(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1,
				inorderMap);
	}

	private static TreeNode BinaryTreeFromInorderAndPostorder(int[] inorder, int inorderStart, int inorderEnd,
			int[] postorder, int postorderStart, int postorderEnd, Map<Integer, Integer> inorderMap) {
		if (inorderStart > inorderEnd || postorderStart > postorderEnd)
			return null;

		TreeNode root = new Program08().new TreeNode(postorder[postorderEnd]);
		int NodeIndex = inorderMap.get(postorder[postorderEnd]);

		TreeNode leftNode = BinaryTreeFromInorderAndPostorder(inorder, inorderStart, NodeIndex - 1, postorder,
				postorderStart, postorderStart + NodeIndex - inorderStart - 1, inorderMap);
		TreeNode rightNode = BinaryTreeFromInorderAndPostorder(inorder, NodeIndex + 1, inorderEnd, postorder,
				postorderStart + NodeIndex - inorderStart, postorderEnd - 1, inorderMap);

		root.left = leftNode;
		root.right = rightNode;
		return root;
	}
}