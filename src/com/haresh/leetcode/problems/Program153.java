package com.haresh.leetcode.problems;

/*
    532. [Medium] K-diff Pairs in an Array
    https://leetcode.com/problems/k-diff-pairs-in-an-array/

    Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

    A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
        0 <= i, j < nums.length
        i != j
        nums[i] - nums[j] == k
    Notice that |val| denotes the absolute value of val.

    Example 1:
    Input: nums = [3,1,4,1,5], k = 2
    Output: 2
    Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
    Although we have two 1s in the input, we should only return the number of unique pairs.

    Example 2:
    Input: nums = [1,2,3,4,5], k = 1
    Output: 4
    Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).

    Example 3:
    Input: nums = [1,3,1,5,4], k = 0
    Output: 1
    Explanation: There is one 0-diff pair in the array, (1, 1).

    Constraints:
        1 <= nums.length <= 104
        -107 <= nums[i] <= 107
        0 <= k <= 107
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Haresh Shaha
 * @since 15-Feb-2022
 */
public class Program153 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 1;
        System.out.println(findPairs1(nums, k));
        System.out.println(findPairs2(nums, k));
    }

    public static int findPairs1(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (counts.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }

        return count;
    }

    // Faster solution
    public static int findPairs2(int[] nums, int k) {
        Set<Integer> number = new HashSet<>();
        Set<Integer> found = new HashSet<>();

        for (int num : nums) {
            if (number.contains(num - k))
                found.add(num - k);
            if (number.contains(num + k))
                found.add(num);
            number.add(num);
        }
        return found.size();
    }
}
