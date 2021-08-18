/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	61. Rotate List
	https://leetcode.com/problems/rotate-list/
	
	Given the head of a linked list, rotate the list to the right by k places.
	
	Example 1:
					1 -> 2 -> 3 -> 4 -> 5
		Rotate 1	5 -> 1 -> 2 -> 3 -> 4
		Rotate 2	4 -> 5 -> 1 -> 2 -> 3	
	Input: head = [1,2,3,4,5], k = 2
	Output: [4,5,1,2,3]
	
	Example 2:
					0 -> 1 -> 2
		Rotate 1	2 -> 0 -> 1
		Rotate 2	1 -> 2 -> 0
		Rotate 3	0 -> 1 -> 2
		Rotate 4	2 -> 0 -> 1
	Input: head = [0,1,2], k = 4
	Output: [2,0,1]
	
	Constraints:
		The number of nodes in the list is in the range [0, 500].
		-100 <= Node.val <= 100
		0 <= k <= 2 * 109
 */

/**
 * @author Haresh Shaha
 * @since 18-Aug-2021
 *
 */
public class Program76 {

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

	public static void main(String[] args) {
		// head = [1,2,3,4,5], k = 2
		ListNode head = new Program76().new ListNode(1);
		head.next = new Program76().new ListNode(2);
		head.next.next = new Program76().new ListNode(3);
		head.next.next.next = new Program76().new ListNode(4);
		int k = 2;

		System.out.println("List before flattning: ");
		printList(head);

		ListNode node = rotateRight(head, k);

		System.out.println("List after flattning: ");
		printList(node);
	}

	public static int getLength(ListNode head) {
		int length = 0;
		while (head != null) {
			head = head.next;
			length++;
		}
		return length;
	}

	public static ListNode rotateRight(ListNode head, int k) {

		if (head == null || head.next == null)
			return head;

		k = k % getLength(head);

		ListNode newHead = new Program76().new ListNode(-1);
		newHead.next = head;
		ListNode node = head;

		while (k > 0 && node != null) {
			node = node.next;
			k--;
		}

		while (node.next != null) {
			head = head.next;
			node = node.next;
		}

		node.next = newHead.next;
		newHead.next = head.next;
		head.next = null;

		return newHead.next;
	}
}
