package com.haresh.leetcode.problems;

/*
	234. Palindrome Linked List
	https://leetcode.com/problems/palindrome-linked-list/
	
	Given the head of a singly linked list, return true if it is a palindrome.
	
	Example 1:
	Input: head = [1,2,2,1]
	Output: true
	
	Example 2:
	Input: head = [1,2]
	Output: false
	
	Constraints:
		The number of nodes in the list is in the range [1, 105].
		0 <= Node.val <= 9
	
	Follow up: Could you do it in O(n) time and O(1) space?
 */

/**
 * @author Haresh Shaha
 * @since 17-Aug-2021
 *
 */
public class Program73 {

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
		// head = [1,2,2,1]
		ListNode head = new Program73().new ListNode(1);
		head.next = new Program73().new ListNode(2);
		head.next.next = new Program73().new ListNode(2);
		head.next.next.next = new Program73().new ListNode(1);

		System.out.println("Original List");
		printList(head);

		boolean isboolean = isPalindrome(head);
		System.out.println(isboolean);
	}

	public static boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode head2 = reverse(slow.next);

		while (head2 != null) {
			if (head.val != head2.val) {
				return false;
			}
			head = head.next;
			head2 = head2.next;
		}
		return true;
	}

	public static ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

}
