/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	Swap Nodes in Pairs
	https://leetcode.com/problems/swap-nodes-in-pairs/
	
	Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes 
	(i.e., only nodes themselves may be changed.)
	
	Example 1:
	Input: head = [1,2,3,4]
	Output: [2,1,4,3]
	
	Example 2:
	Input: head = []
	Output: []
	
	Example 3:
	Input: head = [1]
	Output: [1]
	
	Constraints:
		The number of nodes in the list is in the range [0, 100].
		0 <= Node.val <= 100 
 */

/**
 * @author Haresh Shaha
 * @since 12-Jun-2021
 *
 */
public class Program42 {

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
		// head = [1,2,3,4]
		ListNode head = new Program42().new ListNode(1);
		head.next = new Program42().new ListNode(2);
		head.next.next = new Program42().new ListNode(3);
		head.next.next.next = new Program42().new ListNode(4);

		ListNode list = swapPairs(head);
		while (list != null) {
			System.out.println(list.val);
			list = list.next;
		}
	}

	public static ListNode swapPairs(ListNode head) {
		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return head;
		}

		ListNode previous = new Program42().new ListNode(-1);
		previous.next = head;
		ListNode first = previous.next;
		ListNode second = first.next;

		head = previous;

		while (second != null) {
			previous.next = second;
			first.next = second.next;
			second.next = first;

			previous = first;
			first = previous.next;

			if (first != null)
				second = first.next;
			else
				second = null;

		}

		return head.next;
	}
}
