/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.HashMap;

/*
	560. Subarray Sum Equals K
	https://leetcode.com/problems/subarray-sum-equals-k/
	
	Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
	
	Example 1:
	Input: nums = [1,1,1], k = 2
	Output: 2
	
	Example 2:
	Input: nums = [1,2,3], k = 3
	Output: 2
	 
	Constraints:
		1 <= nums.length <= 2 * 104
		-1000 <= nums[i] <= 1000
		-107 <= k <= 107
 */

/**
 * @author Haresh Shaha
 * @since 10-Aug-2021
 *
 */
public class Program67 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		int k = 3;
		int count = subarraySum(nums, k);
		System.out.println(count);
	}

	public static int subarraySum(int[] nums, int k) {
		int count = 0, sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			if (map.containsKey(sum - k))
				count += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return count;
	}

}
