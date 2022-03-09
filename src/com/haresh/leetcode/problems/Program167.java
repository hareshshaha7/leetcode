package com.haresh.leetcode.problems;

/*
    82. [Medium] Remove Duplicates from Sorted List II
    https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

    Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers
    from the original list. Return the linked list sorted as well.

    Example 1:
    Input: head = [1,2,3,3,4,4,5]
    Output: [1,2,5]

    Example 2:
    Input: head = [1,1,1,2,3]
    Output: [2,3]

    Constraints:
        The number of nodes in the list is in the range [0, 300].
        -100 <= Node.val <= 100
        The list is guaranteed to be sorted in ascending order.
 */

/**
 * @author Haresh Shaha
 * @since 09-Mar-2022
 */
public class Program167 {
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        System.out.println("List before deletion: ");
        printList(head);
        System.out.println();
        
        ListNode newHead = deleteDuplicates(head);
        System.out.println("List after deletion: ");
        printList(newHead);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode previous = dummy;

        while (head != null) {
            if (head.next != null && head.next.val == head.val) {
                int duplicate = head.val;

                while (head != null && head.val == duplicate) {
                    head = head.next;
                }
                previous.next = head;
            } else {
                previous = head;
                head = head.next;
            }
        }

        return dummy.next;
    }
}
