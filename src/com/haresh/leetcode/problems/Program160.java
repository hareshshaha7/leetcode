package com.haresh.leetcode.problems;

/*
    148. Sort List
    https://leetcode.com/problems/sort-list/

    Given the head of a linked list, return the list after sorting it in ascending order.

    Example 1:
        4->2->1->3
        1->2->3->4
    Input: head = [4,2,1,3]
    Output: [1,2,3,4]

    Example 2:
        -1->5->3->4->0
        -1->0->3->4->5
    Input: head = [-1,5,3,4,0]
    Output: [-1,0,3,4,5]

    Example 3:
    Input: head = []
    Output: []

    Constraints:
        The number of nodes in the list is in the range [0, 5 * 104].
        -105 <= Node.val <= 105
 */

/**
 * @author Haresh Shaha
 * @since 24-Feb-2022
 */
public class Program160 {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);

        System.out.println("List before sort: ");
        printList(head);

        ListNode newHead = sortList(head);
        System.out.println("List after sort: ");
        printList(newHead);
    }

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode midNode = getMidNode(head);
        ListNode midNodeNext = midNode.next;
        midNode.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(midNodeNext);

        return mergeNodes(left, right);
    }

    public static ListNode getMidNode(ListNode head) {
        ListNode midNode = null;
        while (head != null && head.next != null) {
            midNode = midNode == null ? head : midNode.next;
            head = head.next.next;
        }

        return midNode; // This is actually previous node to the actual midNode
    }

    public static ListNode mergeNodes(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }

            tail = tail.next;
        }

        tail.next = (left != null) ? left : right;
        return dummyHead.next;
    }
}
