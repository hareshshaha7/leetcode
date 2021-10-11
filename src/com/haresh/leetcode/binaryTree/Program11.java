package com.haresh.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Print the outer view of the Binary Tree.

For e.g.
Example 1:
Input:
		1
	  /   \
	 2	   3
Output: 2 1 3

Example 2:
Input:
		1
	  /   \
	 2	   3
	  \
	   4
Output: 4 2 1 3 4

Example 2:
Input:
		1
	  /   \
	 2	   3
	/ \	  / \
   4   5 6   7
  /   /	  \   \
 8	 9    10   11	
Output: 8 4 2 1 3 7 11

 */

/**
 * @author Haresh Shaha
 * @since 09-Oct-2021
 *
 */
public class Program11 {

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "[data=" + data + ", left=" + left.data + ", right=" + right.data + "]";
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Program11().new Node(1);
		root.left = new Program11().new Node(2);
		root.right = new Program11().new Node(3);
		root.left.left = new Program11().new Node(4);
		root.left.right = new Program11().new Node(5);
		root.right.left = new Program11().new Node(6);
		root.right.right = new Program11().new Node(7);
		root.left.left.left = new Program11().new Node(8);
		root.left.right.left = new Program11().new Node(9);
		root.right.left.right = new Program11().new Node(10);
		root.right.right.right = new Program11().new Node(11);

		List<Integer> result = new ArrayList<>();

		maxLevel = 0;
		leftView(root, 1, result);
		Collections.reverse(result);

		maxLevel = 0;
		rightView(root.right, 1, result);

		for (int num : result) {
			System.out.print(num + " ");
		}
	}

	private static int maxLevel = 0;

	public static void leftView(Node node, int level, List<Integer> result) {
		if (node == null) {
			return;
		}

		if (maxLevel < level) {
			result.add(node.data);
			maxLevel++;
		}

		leftView(node.left, level + 1, result);
		leftView(node.right, level + 1, result);
	}

	public static void rightView(Node node, int level, List<Integer> result) {
		if (node == null) {
			return;
		}

		if (maxLevel < level) {
			result.add(node.data);
			maxLevel++;
		}

		rightView(node.right, level + 1, result);
		rightView(node.left, level + 1, result);
	}

}
