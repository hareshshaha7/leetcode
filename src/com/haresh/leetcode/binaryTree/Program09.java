package com.haresh.leetcode.binaryTree;

/*
Print the left view of the Binary Tree.

For e.g.
Example 1:
Input:
		1
	  /   \
	2		3
Output: 1 2

Example 2:
Input:
		1
	  /   \
	2		3
	  \
	   4
Output: 1 2 4

Example 2:
Input:
		1
	  /   \
	2		3
	  \	   /
	   4  5
	   	   \
	   	   	6
Output: 1 2 4 6

 */

/**
 * @author Haresh Shaha
 * @since 09-Oct-2021
 *
 */
public class Program09 {

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
		Node root = new Program09().new Node(1);
		root.left = new Program09().new Node(2);
		root.right = new Program09().new Node(3);
		root.left.right = new Program09().new Node(4);
		root.right.left = new Program09().new Node(5);
		root.right.left.right = new Program09().new Node(6);

		leftView(root, 1);
	}

	private static int maxLevel = 0;

	public static void leftView(Node node, int level) {
		if (node == null) {
			return;
		}

		if (maxLevel < level) {
			System.out.print(node.data + " ");
			maxLevel++;
		}
		
		leftView(node.left, level+1);
		leftView(node.right, level+1);
	}

}
