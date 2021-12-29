package com.haresh.leetcode.problems;
/*
    217. Contains Duplicate
    https://leetcode.com/problems/contains-duplicate/

    Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

    Example 1:
    Input: nums = [1,2,3,1]
    Output: true

    Example 2:
    Input: nums = [1,2,3,4]
    Output: false

    Example 3:
    Input: nums = [1,1,1,3,3,4,3,2,4,2]
    Output: true

    Constraints:
        1 <= nums.length <= 105
        -109 <= nums[i] <= 109
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author Haresh Shaha
 * @since 29-Dec-2021
 */
public class Program90 {

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        boolean isDuplicate = containsDuplicate(nums);
        System.out.print(isDuplicate);
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            if (!uniqueNums.add(num)) {
                return true;
            }
        }
        return false;

        // Slower approach
        /*Arrays.sort(nums);
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] == nums[i+1])
                return true;
        }
        return false;*/
    }
}
