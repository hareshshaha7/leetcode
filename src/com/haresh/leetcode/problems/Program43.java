/**
 * 
 */
package com.haresh.leetcode.problems;

//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;

/*
	Reverse Nodes in k-Group
	https://leetcode.com/problems/reverse-nodes-in-k-group/
	
	Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
	
	k is a positive integer and is less than or equal to the length of the linked list. 
	If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
	
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
 * @since 13-Jun-2021
 *
 */
public class Program43 {

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
		// head = [1,2,3,4,5], k = 2
		ListNode head = new Program43().new ListNode(1);
		head.next = new Program43().new ListNode(2);
		head.next.next = new Program43().new ListNode(3);
		head.next.next.next = new Program43().new ListNode(4);
		head.next.next.next.next = new Program43().new ListNode(5);
		int k = 2;

		ListNode list = reverseKGroup(head, k);
		while (list != null) {
			System.out.println(list.val);
			list = list.next;
		}

	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		if (k == 1) {
			return head;
		}

		ListNode sHead = new Program43().new ListNode(-1);
		ListNode sTail = sHead;
		int count = 0;

		ListNode n1 = head, n2 = head;

		while (n2 != null) {
			ListNode next = n2.next;
			count++;

			if (count == k) {
				n2.next = null;

				ListNode[] reverse = reverseList(n1);
				sTail.next = reverse[0]; // Head of the reversed list
				sTail = reverse[1]; // Tail of the reversed list

				n1 = next;
				count = 0;

			} else if (next == null) {
				sTail.next = n1;
			}

			n2 = next;
		}

		return sHead.next;

//		Slower Solution
//		
//		List<Integer> resultingList = new ArrayList<>();
//		while (head != null) {
//			List<Integer> l = new ArrayList<Integer>();
//			for (int i = 1; i <= k; i++) {
//				if (head == null)
//					break;
//				l.add(head.val);
//				head = head.next;
//			}
//
//			if (l.size() == k)
//				Collections.reverse(l);
//			resultingList.addAll(l);
//		}
//
//		ListNode result = new Program43().new ListNode(-1);
//		ListNode node = result;
//		for (int i = 0; i < resultingList.size(); i++) {
//			node.next = new Program43().new ListNode(resultingList.get(i));
//			node = node.next;
//		}
//
//		return result.next;
	}

	private static ListNode[] reverseList(ListNode n1) {
		ListNode rHead = null, rTail = null;

		while (n1 != null) {
			ListNode next = n1.next;
			n1.next = rHead;
			rHead = n1;
			n1 = next;

			if (rTail == null) {
				rTail = rHead;
			}
		}

		return new ListNode[] { rHead, rTail };
	}
}