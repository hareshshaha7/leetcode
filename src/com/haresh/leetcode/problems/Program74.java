/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	142. Linked List Cycle II
	https://leetcode.com/problems/linked-list-cycle-ii/
	
	Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
	There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
	Notice that you should not modify the linked list.
	
	Example 1:
	Input: head = [3,2,0,-4], pos = 1
	Output: tail connects to node index 1
	Explanation: There is a cycle in the linked list, where tail connects to the second node.
	
	Example 2:
	Input: head = [1,2], pos = 0
	Output: tail connects to node index 0
	Explanation: There is a cycle in the linked list, where tail connects to the first node.
	
	Example 3:
	Input: head = [1], pos = -1
	Output: no cycle
	Explanation: There is no cycle in the linked list.
	
	Constraints:
	The number of the nodes in the list is in the range [0, 104].
		-105 <= Node.val <= 105
		pos is -1 or a valid index in the linked-list.
	
	Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
/**
 * @author Haresh Shaha
 * @since 17-Aug-2021
 *
 */
public class Program74 {

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
		// head = [3,2,0,-4], pos = 1
		ListNode head = new Program74().new ListNode(3);
		head.next = new Program74().new ListNode(2);
		head.next.next = new Program74().new ListNode(0);
		head.next.next.next = new Program74().new ListNode(-4);
		head.next.next.next.next = head.next;

		ListNode node = detectCycle(head);
		System.out.println("Starting Node of the cycle: " + node.val);
	}

	public static ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) {

				ListNode slow2 = head;
				while (slow2 != slow) {
					slow = slow.next;
					slow2 = slow2.next;
				}

				return slow;
			}
		}

		return null;
	}

}
