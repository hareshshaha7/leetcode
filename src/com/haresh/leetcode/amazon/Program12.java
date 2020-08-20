package com.haresh.leetcode.amazon;

/*
	Distance Between TreeNodes in BST
	
	Given a list of unique integers nums, construct a BST from it 
	(you need to insert TreeNodes one-by-one with the given order to get the BST) 
	and find the distance between two TreeNodes TreeNode1 and TreeNode2. Distance is the number of edges between two TreeNodes. 
	If any of the given TreeNodes does not appear in the BST, return -1.
	
	Example 1:
	Input: nums = [2, 1, 3], TreeNode1 = 1, TreeNode2 = 3
	Output: 2
	Explanation:
	     2
	   /   \
	  1     3
 */

public class Program12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree tree = new Program12().new BinarySearchTree();

		tree.root = tree.insertNewTreeNode(tree.root, 10);
		tree.root = tree.insertNewTreeNode(tree.root, 5);
		tree.root = tree.insertNewTreeNode(tree.root, 15);
		tree.root = tree.insertNewTreeNode(tree.root, 30);
		tree.root = tree.insertNewTreeNode(tree.root, 25);
		tree.root = tree.insertNewTreeNode(tree.root, 35);

		tree.display(tree.root);

		int distance = tree.findShortestDistanceInTreeNodes(tree.root, 5, 35);
		System.out.println(distance);
	}

	class BinarySearchTree {
		class TreeNode {
			int val;
			TreeNode left;
			TreeNode right;

			TreeNode(int val) {
				this.val = val;
			}
		}

		TreeNode root;

		// Standard BST insert function  
		public TreeNode insertNewTreeNode(TreeNode root, int val) {
			if (root == null)
				return new TreeNode(val);

			if (root.val > val)
				root.left = insertNewTreeNode(root.left, val);
			else
				root.right = insertNewTreeNode(root.right, val);

			return root;
		}

		// Standard In-Order Traversal
		public void display(TreeNode root) {
			if (root == null)
				return;

			display(root.left);
			System.out.println(root.val);
			display(root.right);
		}

		// This function make sure that a is smaller than b before making a call
		public int findShortestDistanceInTreeNodes(TreeNode root, int a, int b) {
			if (a > b) {
				int temp = a;
				a = b;
				b = temp;
			}
			TreeNode lca = getLowestCommonAncestor(root, a, b);
			int x = getDistanceFromRoot(lca, a);
			int y = getDistanceFromRoot(lca, b);
			return x + y;
		}

		// Returns minimum distance beween a and b.  
		// This function assumes that a and b exist in BST.  
		private TreeNode getLowestCommonAncestor(TreeNode root, int a, int b) {
			
			// Both keys lie in left  
			if (root.val > a && root.val > b)
				return getLowestCommonAncestor(root.left, a, b);
			
			// Both keys lie in right  
			else if (root.val < a && root.val < b)
				return getLowestCommonAncestor(root.right, a, b);

			// Lie in opposite directions (Root is  
		    // LCA of two nodes)  
			else
				return root;
		}

		// This function returns distance of x from root. 
		// This function assumes that x exists in BST and BST is not NULL. 
		private int getDistanceFromRoot(TreeNode root, int val) {
			if (root == null)
				return -1;
			else if (root.val > val)
				return 1 + getDistanceFromRoot(root.left, val);
			else
				return 1 + getDistanceFromRoot(root.right, val);
		}
	}

}
