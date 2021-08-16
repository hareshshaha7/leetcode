/**
 * 
 */
package com.haresh.leetcode.problems;
/*
	206. Reverse Linked List
	https://leetcode.com/problems/reverse-linked-list/
	
	Given the head of a singly linked list, reverse the list, and return the reversed list.
	
	Example 1:
	Input: head = [1,2,3,4,5]
	Output: [5,4,3,2,1]
	
	Example 2:
	Input: head = [1,2]
	Output: [2,1]
	
	Example 3:
	Input: head = []
	Output: []
	
	Constraints:
		The number of nodes in the list is the range [0, 5000].
		-5000 <= Node.val <= 5000
	 
	
	Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

/**
 * @author Haresh Shaha
 * @since 16-Aug-2021
 *
 */
public class Program69 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// [1,2,3,4,5]
		ListNode head = new Program69().new ListNode(1);
		head.next = new Program69().new ListNode(2);
		head.next.next = new Program69().new ListNode(3);
		head.next.next.next = new Program69().new ListNode(4);
		head.next.next.next.next = new Program69().new ListNode(5);

		System.out.println("Original List");
		printList(head);

		ListNode node = reverseList(head);
		System.out.println("Reversed List");
		printList(node);
	}

	public static void printList(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	public static ListNode reverseList(ListNode head) {
		ListNode prevNode = null;

		while (head != null) {
			ListNode nextNode = head.next;
			head.next = prevNode;
			prevNode = head;
			head = nextNode;
		}
		return prevNode;
	}

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
}
