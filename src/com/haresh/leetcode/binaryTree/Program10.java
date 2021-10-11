package com.haresh.leetcode.binaryTree;

/*
	Print the right view of the Binary Tree.
	
	For e.g.
	Example 1:
	Input:
			1
		  /   \
		 2	   3
	Output: 1 3
	
	Example 2:
	Input:
			1
		  /   \
		 2	   3
		  \
		   4
	Output: 1 3 4
	
	Example 2:
	Input:
			1
		  /   \
		 2	   3
		  \	  /
		   4 5
	 	  /	   
	 	 6  	   	
	Output: 1 3 5 6

 */

/**
 * @author Haresh Shaha
 * @since 09-Oct-2021
 *
 */
public class Program10 {

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
		Node root = new Program10().new Node(1);
		root.left = new Program10().new Node(2);
		root.right = new Program10().new Node(3);
		root.left.right = new Program10().new Node(4);
		root.right.left = new Program10().new Node(5);
		root.left.right.left = new Program10().new Node(6);

		rightView(root, 1);
	}

	private static int maxLevel = 0;

	public static void rightView(Node node, int level) {
		if (node == null) {
			return;
		}

		if (maxLevel < level) {
			System.out.print(node.data + " ");
			maxLevel++;
		}

		rightView(node.right, level + 1);

		rightView(node.left, level + 1);
	}

}
