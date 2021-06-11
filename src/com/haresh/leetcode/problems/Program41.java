/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
	Merge k Sorted Lists
	https://leetcode.com/problems/merge-k-sorted-lists/
	
	You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
	Merge all the linked-lists into one sorted linked-list and return it.
	
	Example 1:
	Input: lists = [[1,4,5],[1,3,4],[2,6]]
	Output: [1,1,2,3,4,4,5,6]
	Explanation: The linked-lists are:
	[
	  1->4->5,
	  1->3->4,
	  2->6
	]
	merging them into one sorted list:
	1->1->2->3->4->4->5->6
	
	Example 2:
	Input: lists = []
	Output: []
	
	Example 3:
	Input: lists = [[]]
	Output: []
	
	Constraints:
		k == lists.length
		0 <= k <= 10^4
		0 <= lists[i].length <= 500
		-10^4 <= lists[i][j] <= 10^4
		lists[i] is sorted in ascending order.
		The sum of lists[i].length won't exceed 10^4.
 */

/**
 * @author Haresh Shaha
 * @since 11-Jun-2021
 *
 */
public class Program41 {

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
		// lists = [[1,4,5],[1,3,4],[2,6]]
		ListNode l1 = new Program41().new ListNode(1);
		l1.next = new Program41().new ListNode(4);
		l1.next.next = new Program41().new ListNode(5);

		ListNode l2 = new Program41().new ListNode(1);
		l2.next = new Program41().new ListNode(3);
		l2.next.next = new Program41().new ListNode(4);

		ListNode l3 = new Program41().new ListNode(2);
		l3.next = new Program41().new ListNode(6);

		ListNode[] lists = new ListNode[3];
		lists[0] = l1;
		lists[1] = l2;
		lists[2] = l3;

		ListNode mergeKLists = mergeKLists(lists);
		while (mergeKLists != null) {
			System.out.println(mergeKLists.val);
			mergeKLists = mergeKLists.next;
		}
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		ListNode head = new Program41().new ListNode();

		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < lists.length; i++) {
			while (lists[i] != null) {
				l.add(lists[i].val);
				lists[i] = lists[i].next;
			}
		}

		Collections.sort(l);
		ListNode node = head;
		for (int i = 0; i < l.size(); i++) {
			ListNode temp = new Program41().new ListNode(l.get(i));
			node.next = temp;
			node = node.next;
		}

		return head.next;
	}
}
