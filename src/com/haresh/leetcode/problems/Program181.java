package com.haresh.leetcode.problems;

/*
    410. [Hard] Split Array Largest Sum
    https://leetcode.com/problems/split-array-largest-sum/

    Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.

    Write an algorithm to minimize the largest sum among these m subarrays.

    Example 1:
    Input: nums = [7,2,5,10,8], m = 2
    Output: 18
    Explanation:
        There are four ways to split nums into two subarrays.
        The best way is to split it into [7,2,5] and [10,8],
        where the largest sum among the two subarrays is only 18.

    Example 2:
    Input: nums = [1,2,3,4,5], m = 2
    Output: 9

    Example 3:
    Input: nums = [1,4,4], m = 3
    Output: 4

    Constraints:
        1 <= nums.length <= 1000
        0 <= nums[i] <= 106
        1 <= m <= min(50, nums.length)
 */

/**
 * @author Haresh Shaha
 * @since 31-Mar-2022
 */
public class Program181 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int m = 2;

        int largestSum = splitArray(nums, m);
        System.out.println(largestSum);
    }

    public static int splitArray(int[] nums, int m) {
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(num, max);
        }

        if (m == 1) {
            return sum;
        }

        if (m == nums.length) {
            return max;
        }

        int left = max;
        int right = sum;
        int largestSum = max;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (canSplit(nums, m, mid)) {
                largestSum = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return largestSum;
    }

    public static boolean canSplit(int[] nums, int m, int mid) {
        int subArray = 0;
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            if (currentSum > mid) {
                subArray++;
                currentSum = num;
            }
        }

        return (subArray + 1) <= m;
    }
}
