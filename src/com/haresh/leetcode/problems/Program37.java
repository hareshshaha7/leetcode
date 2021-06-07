/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	Remove Nth Node From End of List
	https://leetcode.com/problems/remove-nth-node-from-end-of-list/
	
	Given the head of a linked list, remove the nth node from the end of the list and return its head.
	
	Example 1:
	Input: head = [1,2,3,4,5], n = 2
	Output: [1,2,3,5]
	
	Example 2:
	Input: head = [1], n = 1
	Output: []
	
	Example 3:
	Input: head = [1,2], n = 1
	Output: [1]
 */

/**
 * @author Haresh Shaha
 * @since 07-Jun-2021
 *
 */
public class Program37 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// head = [1,2,3,4,5];
		ListNode head = new Program37().new ListNode(1);
		head.next = new Program37().new ListNode(2);
		head.next.next = new Program37().new ListNode(3);
		head.next.next.next = new Program37().new ListNode(4);
		head.next.next.next.next = new Program37().new ListNode(5);
		int n = 2;

		ListNode node = removeNthFromEnd(head, n);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}

	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode front = head;
		while (n > 0) {
			front = front.next;
			n--;
		}

		if (front == null) {
			return head.next;
		}

		ListNode rear = head;
		while (front.next != null) {
			front = front.next;
			rear = rear.next;
		}

		if (rear == front) {
			head = null;
			return head;
		}

		rear.next = rear.next.next;
		return head;
	}

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

}
