/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	Add Two Numbers
	https://leetcode.com/problems/add-two-numbers/
	
	You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. 
	Add the two numbers and return the sum as a linked list.
	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	
	Example 1:
	Input: l1 = [2,4,3], l2 = [5,6,4]
	Output: [7,0,8]
	Explanation: 342 + 465 = 807.
	
	Example 2:
	Input: l1 = [0], l2 = [0]
	Output: [0]
	
	Example 3:
	Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
	Output: [8,9,9,9,0,0,0,1]
	
	Constraints:
		The number of nodes in each linked list is in the range [1, 100].
		0 <= Node.val <= 9
		It is guaranteed that the list represents a number that does not have leading zeros.
 */

/**
 * @author Haresh Shaha
 * @since 22-May-2021
 *
 */
public class Program20 {

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

//		9 9 9
//		9 9
//		8 9 0 1

		ListNode l1 = new Program20().new ListNode(9);
		l1.next = new Program20().new ListNode(9);
		l1.next.next = new Program20().new ListNode(9);

		ListNode l2 = new Program20().new ListNode(9);
		l2.next = new Program20().new ListNode(9);

		ListNode result = addTwoNumbers(l1, l2);

		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int carrier = 0;
		ListNode head = new Program20().new ListNode(-1);
		head.next = new Program20().new ListNode(carrier);
		ListNode result = head.next;

		while (l1 != null || l2 != null) {
			int sum = carrier;

			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			carrier = sum / 10;
			sum = sum % 10;

			head.next.val = sum;
			head.next.next = new Program20().new ListNode(carrier);
			head = head.next;

		}

		if (head.next.val == 0) {
			head.next = null;
		}
		return result;
	}

}
