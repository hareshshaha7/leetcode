package com.haresh.leetcode.problems;
/*
    219. Contains Duplicate II
    https://leetcode.com/problems/contains-duplicate-ii/

    Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

    Example 1:
    Input: nums = [1,2,3,1], k = 3
    Output: true

    Example 2:
    Input: nums = [1,0,1,1], k = 1
    Output: true

    Example 3:
    Input: nums = [1,2,3,1,2,3], k = 2
    Output: false

    Constraints:
        1 <= nums.length <= 105
        -109 <= nums[i] <= 109
        0 <= k <= 105
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author Haresh Shaha
 * @since 29-Dec-2021
 */
public class Program91 {

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 1};
        int k = 2;
        boolean isDuplicate = containsNearbyDuplicate(nums, k);
        System.out.print(isDuplicate);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0)
            return false;

        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < k && i < nums.length; i++) {
            if (!list.add(nums[i])) {
                return true;
            }
        }

        for (int i = k; i < nums.length; i++) {
            if (!list.add(nums[i])) {
                return true;
            }
            list.remove(nums[i - k]);
        }

        // Short hand for same above solution
        /*
        for (int i = 0; i<nums.length; i++) {
            if (!list.add(nums[i])) {
                return true;
            }
            if (i>=k)
                list.remove(nums[i-k]);
        }
        */

        return false;
    }
}
