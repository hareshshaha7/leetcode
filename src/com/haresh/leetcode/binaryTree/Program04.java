/**
 * 
 */
package com.haresh.leetcode.binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
	Binary Tree Level Order Traversal
	
	Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
	
	Example 1:
	Input: root = [3,9,20,null,null,15,7]
	Output: [[3],[9,20],[15,7]]
	
	Example 2:
	Input: root = [1]
	Output: [[1]]
	
	Example 3:
	Input: root = []
	Output: []
	
	Constraints:
		The number of nodes in the tree is in the range [0, 2000].
		-1000 <= Node.val <= 1000
 */

/**
 * @author Haresh Shaha
 * @since 06-Jul-2021
 *
 */
public class Program04 {

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
		TreeNode root = new Program04().new TreeNode(3);
		root.left = new Program04().new TreeNode(9);
		root.right = new Program04().new TreeNode(20);
		root.left.left = new Program04().new TreeNode(10);
		root.right.left = new Program04().new TreeNode(15);
		root.right.right = new Program04().new TreeNode(7);

		List<List<Integer>> result = levelOrder(root);
		System.out.println(result);
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return new ArrayList<>();

		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			List<Integer> nodesAtLevel = new ArrayList<>();
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				nodesAtLevel.add(node.val);

				if (node.left != null)
					queue.add(node.left);

				if (node.right != null)
					queue.add(node.right);
			}
			
			result.add(nodesAtLevel);
		}

		return result;
	}

}
