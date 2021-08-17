/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	25. Reverse Nodes in k-Group
	https://leetcode.com/problems/reverse-nodes-in-k-group/

	Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
	k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
	You may not alter the values in the list's nodes, only nodes themselves may be changed.
	
	Example 1:
	Input: head = [1,2,3,4,5], k = 2
	Output: [2,1,4,3,5]

	Example 2:
	Input: head = [1,2,3,4,5], k = 3
	Output: [3,2,1,4,5]
	
	Example 3:
	Input: head = [1,2,3,4,5], k = 1
	Output: [1,2,3,4,5]
	
	Example 4:
	Input: head = [1], k = 1
	Output: [1]
	
	Constraints:
		The number of nodes in the list is in the range sz.
		1 <= sz <= 5000
		0 <= Node.val <= 1000
		1 <= k <= sz

	Follow-up: Can you solve the problem in O(1) extra memory space?
 */

/**
 * @author Haresh Shaha
 * @since 17-Aug-2021
 *
 */
public class Program72 {

	class ListNode {
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
	}

	public static void printList(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// head = [1,2,3,4,5], k = 3
		ListNode head = new Program72().new ListNode(1);
		head.next = new Program72().new ListNode(2);
		head.next.next = new Program72().new ListNode(3);
		head.next.next.next = new Program72().new ListNode(4);
		head.next.next.next.next = new Program72().new ListNode(5);
		int k = 3;

		System.out.println("Original List");
		printList(head);

		ListNode node = reverseKGroup(head, k);
		System.out.println("Reversed List");
		printList(node);

	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode begin;
		if (head == null || head.next == null || k == 1)
			return head;
		ListNode dummyhead = new Program72().new ListNode(-1);
		dummyhead.next = head;
		begin = dummyhead;
		int i = 0;
		while (head != null) {
			i++;
			if (i % k == 0) {
				begin = reverse(begin, head.next);
				head = begin.next;
			} else {
				head = head.next;
			}
		}
		return dummyhead.next;

	}

	public static ListNode reverse(ListNode begin, ListNode end) {
		ListNode curr = begin.next;
		ListNode next, first;
		ListNode prev = begin;
		first = curr;
		while (curr != end) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		begin.next = prev;
		first.next = curr;
		return first;
	}

}
