package com.haresh.leetcode.problems;
/*
    349. Intersection of Two Arrays
    https://leetcode.com/problems/intersection-of-two-arrays/

    Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

    Example 1:
    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2]

    Example 2:
    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [9,4]
    Explanation: [4,9] is also accepted.

    Constraints:
        1 <= nums1.length, nums2.length <= 1000
        0 <= nums1[i], nums2[i] <= 1000
 */

import java.util.*;

/**
 * @author Haresh Shaha
 * @since 06-Jan-2022
 */
public class Program93 {

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        int[] result = intersection(nums1, nums2);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        Set<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }

        int[] commonElements = new int[result.size()];
        int i = 0;
        for (int num : result) {
            commonElements[i++] = num;
        }
        return commonElements;
    }
}
