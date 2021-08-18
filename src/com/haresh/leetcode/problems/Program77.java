/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/*
	138. Copy List with Random Pointer
	https://leetcode.com/problems/copy-list-with-random-pointer/
	
	A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
	
	Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. 
	Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. 
	None of the pointers in the new list should point to nodes in the original list.
	
	For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
	
	Return the head of the copied linked list.
	
	The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
	
	val: an integer representing Node.val
	random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
	Your code will only be given the head of the original linked list.
	
	Example 1:
	Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
	Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
	
	Example 2:
	Input: head = [[1,1],[2,1]]
	Output: [[1,1],[2,1]]
	
	Example 3:
	Input: head = [[3,null],[3,0],[3,null]]
	Output: [[3,null],[3,0],[3,null]]
	
	Example 4:
	Input: head = []
	Output: []
	Explanation: The given linked list is empty (null pointer), so return null.
	
	Constraints:
		0 <= n <= 1000
		-10000 <= Node.val <= 10000
		Node.random is null or is pointing to some node in the linked list.
 */

/**
 * @author Haresh Shaha
 * @since 18-Aug-2021
 *
 */
public class Program77 {

	class Node {
		public int val;
		public Node next;
		public Node random;

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
		// head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
		Node node0 = new Program77().new Node(7);
		Node node1 = new Program77().new Node(13);
		Node node2 = new Program77().new Node(11);
		Node node3 = new Program77().new Node(10);
		Node node4 = new Program77().new Node(1);

		node1.random = node0;
		node2.random = node4;
		node3.random = node2;
		node4.random = node0;

		System.out.println("List before flattning: ");
		printList(node0);

		Node node = copyRandomList(node0);

		System.out.println("List after flattning: ");
		printList(node);
	}

	public static Node copyRandomList(Node head) {

		if (head == null)
			return head;

		Node newHead = new Program77().new Node(-1);
		newHead.next = head;
		Map<Node, Node> map = new HashMap<>();

		while (head != null) {
			map.put(head, new Program77().new Node(head.val));
			head = head.next;
		}

		head = newHead.next;
		while (head != null) {
			Node newNode = map.get(head);

			if (head.next != null) {
				Node nextNode = map.get(head.next);
				newNode.next = nextNode;
			}

			if (head.random != null) {
				Node randomNode = map.get(head.random);
				newNode.random = randomNode;
			}
			head = head.next;
		}

		return map.get(newHead.next);
	}

}
