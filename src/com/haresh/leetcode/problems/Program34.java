/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.Arrays;

/*
	3Sum Closest
	https://leetcode.com/problems/3sum-closest/
	
	Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. 
	You may assume that each input would have exactly one solution.
	
	Example 1:
	Input: nums = [-1,2,1,-4], target = 1
	Output: 2
	Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	
	Constraints:
		3 <= nums.length <= 10^3
		-10^3 <= nums[i] <= 10^3
		-10^4 <= target <= 10^4
 */

/**
 * @author Haresh Shaha
 * @since 03-Jun-2021
 *
 */
public class Program34 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { -1, 2, 1, -4 };
		int target = 1;
		int threeSumClosest = threeSumClosest(nums, target);
		System.out.println(threeSumClosest);
	}

	public static int threeSumClosest(int[] nums, int target) {
		int difference = Integer.MAX_VALUE;
		int size = nums.length;
		Arrays.sort(nums);
		
		for (int i = 0; i < size && difference != 0; ++i) {
			int lo = i + 1, hi = size - 1;
		
			while (lo < hi) {
				int sum = nums[i] + nums[lo] + nums[hi];
			
				if (Math.abs(target - sum) < Math.abs(difference))
					difference = target - sum;
				if (sum < target)
					++lo;
				else
					--hi;
			}
		}
		return target - difference;
	}
}
