/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	160. Intersection of Two Linked Lists
	https://leetcode.com/problems/intersection-of-two-linked-lists/
	
	Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
	
	For example, the following two linked lists begin to intersect at node c1:
	
	The test cases are generated such that there are no cycles anywhere in the entire linked structure.
	
	Note that the linked lists must retain their original structure after the function returns.
	
	Custom Judge:
		The inputs to the judge are given as follows (your program is not given these inputs):
		intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
		listA - The first linked list.
		listB - The second linked list.
		skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
		skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
		The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. 
		If you correctly return the intersected node, then your solution will be accepted.
	
	Example 1:
	Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
	Output: Intersected at '8'
	Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
	From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
	
	Example 2:
	Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
	Output: Intersected at '2'
	Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
	From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
	
	Example 3:
	Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
	Output: No intersection
	Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
	Explanation: The two lists do not intersect, so return null.
	
	Constraints:
		The number of nodes of listA is in the m.
		The number of nodes of listB is in the n.
		0 <= m, n <= 3 * 104
		1 <= Node.val <= 105
		0 <= skipA <= m
		0 <= skipB <= n
		intersectVal is 0 if listA and listB do not intersect.
		intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
	
	Follow up: Could you write a solution that runs in O(n) time and use only O(1) memory?
 */

/**
 * @author Haresh Shaha
 * @since 16-Aug-2021
 *
 */
public class Program70 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
		ListNode headA = new Program70().new ListNode(4);
		headA.next = new Program70().new ListNode(1);

		ListNode intersection = new Program70().new ListNode(8);
		intersection.next = new Program70().new ListNode(4);
		intersection.next.next = new Program70().new ListNode(5);

		headA.next.next = intersection;

		ListNode headB = new Program70().new ListNode(5);
		headB.next = new Program70().new ListNode(6);
		headB.next.next = new Program70().new ListNode(1);

		headB.next.next.next = intersection;

		System.out.println("Original ListA:");
		printList(headA);
		System.out.println("Original ListB:");
		printList(headB);

		ListNode node = getIntersectionNode(headA, headB);
		System.out.println("List after:");
		printList(node);
	}

	public static void printList(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;

		ListNode curr = headA;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = headA;

		ListNode first = headB;
		ListNode second = headB;

		while (second != null) {
			first = first.next;
			if (second.next != null)
				second = second.next.next;
			else {
				curr.next = null;
				return null;
			}

			if (first == second) {
				first = headB;
				while (first != second) {
					first = first.next;
					second = second.next;
				}
				curr.next = null;
				return first;
			}
		}
		curr.next = null;
		return null;
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
