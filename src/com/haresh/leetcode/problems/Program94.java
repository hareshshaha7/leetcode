package com.haresh.leetcode.problems;
/*
    350. Intersection of Two Arrays II
    https://leetcode.com/problems/intersection-of-two-arrays-ii/

    Given two integer arrays nums1 and nums2, return an array of their intersection.
    Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

    Example 1:
    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2,2]

    Example 2:
    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [4,9]
    Explanation: [9,4] is also accepted.

    Constraints:
        1 <= nums1.length, nums2.length <= 1000
        0 <= nums1[i], nums2[i] <= 1000

    Follow up:
        What if the given array is already sorted? How would you optimize your algorithm?
        What if nums1's size is small compared to nums2's size? Which algorithm is better?
        What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

import java.util.*;

/**
 * @author Haresh Shaha
 * @since 03-Jan-2022
 */
public class Program94 {

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        int[] result = intersect1(nums1, nums2);
        for (int num : result) {
            System.out.print(num);
        }

        System.out.println();

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        result = intersect1(nums1, nums2);
        for (int num : result) {
            System.out.print(num);
        }
    }

    public static int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {

        int index1 = 0, index2 = 0;
        List<Integer> list = new ArrayList<>();
        while (index1 < nums1.length && index2 < nums2.length) {
            int num1 = nums1[index1], num2 = nums2[index2];
            if (num1 == num2) {
                list.add(num1);
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
