/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	430. Flatten a Multilevel Doubly Linked List
	https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
	
	You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. 
	These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
	
	Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
	
	Example 1:
	Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
	Output: [1,2,3,7,8,11,12,9,10,4,5,6]
	
	Example 2:
	Input: head = [1,2,null,3]
	Output: [1,3,2]
	Explanation:
		The input multilevel linked list is as follows:
		
		  1---2---NULL
		  |
		  3---NULL
	
	Example 3:
	Input: head = []
	Output: []
	
	How multilevel linked list is represented in test case:
	We use the multilevel linked list from Example 1 above:
	
	 1---2---3---4---5---6--NULL
	         |
	         7---8---9---10--NULL
	             |
	             11--12--NULL
	
	The serialization of each level is as follows:
		[1,2,3,4,5,6,null]
		[7,8,9,10,null]
		[11,12,null]
	
	To serialize all levels together we will add nulls in each level to signify no node connects to the upper node of the previous level. The serialization becomes:
		[1,2,3,4,5,6,null]
		[null,null,7,8,9,10,null]
		[null,11,12,null]
	
	Merging the serialization of each level and removing trailing nulls we obtain:
		[1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
	
	Constraints:
		The number of Nodes will not exceed 1000.
		1 <= Node.val <= 105
 */

/**
 * @author Haresh Shaha
 * @since 17-Aug-2021
 *
 */
public class Program75 {

	class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;

		Node(int val) {
			this.val = val;
		}
	}

	public static void printList(Node head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	public static void main(String[] args) {
		// head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
		Node node1 = new Program75().new Node(1);
		Node node2 = new Program75().new Node(2);
		Node node3 = new Program75().new Node(3);
		Node node4 = new Program75().new Node(4);
		Node node5 = new Program75().new Node(5);
		Node node6 = new Program75().new Node(6);
		Node node7 = new Program75().new Node(7);
		Node node8 = new Program75().new Node(8);
		Node node9 = new Program75().new Node(9);
		Node node10 = new Program75().new Node(10);
		Node node11 = new Program75().new Node(11);
		Node node12 = new Program75().new Node(12);

		node1.next = node2;

		node2.next = node3;
		node2.prev = node1;

		node3.next = node4;
		node3.prev = node2;
		node3.child = node7;

		node4.next = node5;
		node4.prev = node3;

		node5.next = node6;
		node5.prev = node4;

		node6.prev = node5;

		node7.next = node8;

		node8.next = node9;
		node8.prev = node7;
		node8.child = node11;

		node9.next = node10;
		node9.prev = node8;

		node10.prev = node9;

		node11.next = node12;

		node12.prev = node11;

		System.out.println("List before flattning: ");
		printList(node1);
		Node node = flatten(node1);

		System.out.println("List after flattning: ");
		printList(node);
	}

	public static Node flatten(Node head) {
		if (head == null)
			return head;

		// Pointer
		Node p = head;
		while (p != null) {

			/* CASE 1: if no child, proceed */
			if (p.child == null) {
				p = p.next;
				continue;
			}

			/* CASE 2: got child, find the tail of the child and link it to p.next */
			Node temp = p.child;

			// Find the tail of the child
			while (temp.next != null)
				temp = temp.next;

			// Connect tail with p.next, if it is not null
			temp.next = p.next;
			if (p.next != null)
				p.next.prev = temp;

			// Connect p with p.child, and remove p.child
			p.next = p.child;
			p.child.prev = p;
			p.child = null;
		}

		return head;
	}

}
