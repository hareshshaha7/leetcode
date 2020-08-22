package com.haresh.leetcode.amazon;

/*
	Merge Two Sorted Lists
	
	Merge two sorted linked lists and return it as a new sorted list. 
	The new list should be made by splicing together the nodes of the first two lists.
	
	Example:
	
	Input: 1->2->4, 1->3->4
	Output: 1->1->2->3->4->4
 */

public class Program18 {
	public static void main(String[] args) {
		ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
		ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		
		ListNode result = mergeTwoLists(list1, list2);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	public static class ListNode {
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

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-10);
		ListNode head = dummy;

		while (l1 != null && l2 != null) {

			if (l1.val < l2.val) {
				head.next = l1;
				l1 = l1.next;
			} else {
				head.next = l2;
				l2 = l2.next;
			}

			head = head.next;

		}

		// this cases are present when the two lists are not equal there will be
		// leftOver elements.
		if (l1 != null) {
			head.next = l1;
		}

		if (l2 != null) {
			head.next = l2;
		}

		return dummy.next;

	}

}
