package com.haresh.leetcode.problems;

/*
    413. Arithmetic Slices
    https://leetcode.com/problems/arithmetic-slices/

    An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

    For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
    Given an integer array nums, return the number of arithmetic subarrays of nums.

    A subarray is a contiguous subsequence of the array.

    Example 1:
    Input: nums = [1,2,3,4]
    Output: 3
    Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.

    Example 2:
    Input: nums = [1]
    Output: 0

    Constraints:
        1 <= nums.length <= 5000
        -1000 <= nums[i] <= 1000
 */

/**
 * @author Haresh Shaha
 * @since 03-Mar-2022
 */
public class Program164 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int slices = numberOfArithmeticSlices(nums);
        System.out.println(slices);
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3)
            return 0;

        int slices = 0;
        int slice = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                slice++;
                slices += slice;
            } else {
                slice = 0;
            }
        }

        return slices;
    }
}
