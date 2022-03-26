package com.haresh.leetcode.problems;

/*
    704. [Easy] Binary Search
    https://leetcode.com/problems/binary-search/

    Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

    You must write an algorithm with O(log n) runtime complexity.

    Example 1:
    Input: nums = [-1,0,3,5,9,12], target = 9
    Output: 4
    Explanation: 9 exists in nums and its index is 4

    Example 2:
    Input: nums = [-1,0,3,5,9,12], target = 2
    Output: -1
    Explanation: 2 does not exist in nums so return -1

    Constraints:
        1 <= nums.length <= 104
        -104 < nums[i], target < 104
        All the integers in nums are unique.
        nums is sorted in ascending order.
 */

/**
 * @author Haresh Shaha
 * @since 26-Mar-2022
 */
public class Program179 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int index = search(nums, target);
        System.out.println(index);

        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        int target1 = 2;
        int index1 = search(nums1, target1);
        System.out.println(index1);
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            if (nums[start] == target) {
                return start;
            }
            if (nums[end] == target) {
                return end;
            }
            int mid = start + ((end - start) / 2);
            // System.out.println(start+" "+end+" "+mid);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
