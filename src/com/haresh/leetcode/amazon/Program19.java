package com.haresh.leetcode.amazon;

/*
Subtree of Another Tree

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. 
A subtree of s is a tree consists of a node in s and all of this node's descendants. 
The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:
     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
 

Example 2:
Given tree s:
     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.

 */

public class Program19 {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		t1.left = new TreeNode(4);
		t1.right = new TreeNode(5);
		t1.left.left = new TreeNode(1);
		t1.left.right = new TreeNode(2);

		TreeNode t2 = new TreeNode(4);
		t2.left = new TreeNode(1);
		t2.right = new TreeNode(2);

		System.out.println(isSubtree(t1, t2));

	}

	public static class TreeNode {
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

	public static boolean isSubtree(TreeNode s, TreeNode t) {
		String tree1 = preorder(s, true);
		String tree2 = preorder(t, true);
		return tree1.indexOf(tree2) >= 0;
	}

	public static String preorder(TreeNode t, boolean left) {
		if (t == null) {
			if (left)
				return "lnull";
			else
				return "rnull";
		}
		return "#" + t.val + " " + preorder(t.left, true) + " " + preorder(t.right, false);
	}
	
	/*
	// Best Solution
	public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }
    public boolean equals(TreeNode x,TreeNode y)
    {
        if(x==null && y==null)
            return true;
        if(x==null || y==null)
            return false;
        return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
    }
    public boolean traverse(TreeNode s,TreeNode t)
    {
        return  s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }
	 */

}
