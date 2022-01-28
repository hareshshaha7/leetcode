package com.haresh.leetcode.problems;

/*
    1305. All Elements in Two Binary Search Trees
    https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

    Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.

    Example 1:
    Input: root1 = [2,1,4], root2 = [1,0,3]
    Output: [0,1,1,2,3,4]

    Example 2:
    Input: root1 = [1,null,8], root2 = [8,1]
    Output: [1,1,8,8]

    Constraints:
        The number of nodes in each tree is in the range [0, 5000].
        -105 <= Node.val <= 105
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author Haresh Shaha
 * @since 28-Jan-2022
 */
public class Program137 {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
//        root1 = [2,1,4], root2 = [1,0,3]
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);

        List<Integer> list = getAllElements(root1, root2);
        for (int num : list) {
            System.out.print(num + " ");
        }
    }

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> list1 = new ArrayList<>();
        if (root1 != null) {
            createList(root1, list1);
        }

        List<Integer> list2 = new ArrayList<>();
        if (root2 != null) {
            createList(root2, list2);
        }

        if (list1.size() == 0)
            return list2;
        if (list2.size() == 0)
            return list1;

        return sortList(list1, list2);
    }

    public static void createList(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        createList(root.left, list);
        list.add(root.val);
        createList(root.right, list);
    }

    public static List<Integer> sortList(List<Integer> list1, List<Integer> list2) {
        List<Integer> list = new ArrayList<>();

        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            int num1 = list1.get(i);
            int num2 = list2.get(j);
            if (num1 <= num2) {
                list.add(num1);
                i++;
            } else {
                list.add(num2);
                j++;
            }
        }

        while (i < list1.size()) {
            list.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            list.add(list2.get(j));
            j++;
        }

        return list;
    }
}
