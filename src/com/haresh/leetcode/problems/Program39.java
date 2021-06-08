/**
 * 
 */
package com.haresh.leetcode.problems;

import com.haresh.leetcode.problems.Program37.ListNode;

/*
	Merge Two Sorted Lists
	https://leetcode.com/problems/merge-two-sorted-lists/
	
	Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
	
	Example 1:
	Input: l1 = [1,2,4], l2 = [1,3,4]
	Output: [1,1,2,3,4,4]
	
	Example 2:
	Input: l1 = [], l2 = []
	Output: []
	
	Example 3:
	Input: l1 = [], l2 = [0]
	Output: [0]
 */

/**
 * @author Haresh Shaha
 * @since 08-Jun-2021
 *
 */
public class Program39 {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		l1 = [1,2,4], l2 = [1,3,4]
		ListNode l1 = new Program39().new ListNode(1);
		l1.next = new Program39().new ListNode(2);
		l1.next.next = new Program39().new ListNode(4);

		ListNode l2 = new Program39().new ListNode(1);
		l2.next = new Program39().new ListNode(3);
		l2.next.next = new Program39().new ListNode(4);

		ListNode head = mergeTwoLists(l1, l2);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;

		if (l2 == null)
			return l1;

		ListNode root = new Program39().new ListNode();
		// keep a copy pointer to root node to return.
		ListNode head = root;

		while (l1 != null && l2 != null) {
			
			if (l1.val <= l2.val) {
				root.next = l1;
				l1 = l1.next;
			} else {
				root.next = l2;
				l2 = l2.next;
			}
			
			root = root.next;
		}

		// add rest of of node when list of different size
		if (l1 != null)
			root.next = l1;

		if (l2 != null)
			root.next = l2;

		return head.next;
	}
}
