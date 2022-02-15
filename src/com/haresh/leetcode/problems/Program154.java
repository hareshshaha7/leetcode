package com.haresh.leetcode.problems;

/*
2006. [Easy] Count Number of Pairs With Absolute Difference K
https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/

Given an integer array nums and an integer k, return the number of pairs (i, j) where i < j such that |nums[i] - nums[j]| == k.

The value of |x| is defined as:
    x if x >= 0.
    -x if x < 0.

Example 1:
Input: nums = [1,2,2,1], k = 1
Output: 4
Explanation: The pairs with an absolute difference of 1 are:
    - [1,2,2,1]
       | |
    - [1,2,2,1]
       |   |
    - [1,2,2,1]
         |   |
    - [1,2,2,1]
           | |

Example 2:
Input: nums = [1,3], k = 3
Output: 0
Explanation: There are no pairs with an absolute difference of 3.

Example 3:
Input: nums = [3,2,1,5,4], k = 2
Output: 3
Explanation: The pairs with an absolute difference of 2 are:
    - [3,2,1,5,4]
       |   |
    - [3,2,1,5,4]
       |     |
    - [3,2,1,5,4]
         |     |

Constraints:
    1 <= nums.length <= 200
    1 <= nums[i] <= 100
    1 <= k <= 99
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author Haresh Shaha
 * @since 15-Feb-2022
 */
public class Program154 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 4};
        int k = 2;
        int result = countKDifference(nums, k);
        System.out.println(result);
    }

    public static int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int num : nums) {
            if (map.containsKey(num - k)) {
                result += map.get(num - k);
            }
            if (map.containsKey(num + k)) {
                result += map.get(num + k);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return result;
    }
}
