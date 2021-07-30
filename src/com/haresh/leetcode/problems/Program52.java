/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	53. Maximum Subarray
	https://leetcode.com/problems/maximum-subarray/
	
	Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
	
	A subarray is a contiguous part of an array.
	
	Example 1:
	Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
	Output: 6
	Explanation: [4,-1,2,1] has the largest sum = 6.
	
	Example 2:
	Input: nums = [1]
	Output: 1
	
	Example 3:
	Input: nums = [5,4,-1,7,8]
	Output: 23
	 
	Constraints:
		1 <= nums.length <= 3 * 104
		-105 <= nums[i] <= 105
	 
	Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

/**
 * @author Haresh Shaha
 * @since 30-Jul-2021
 *
 */
public class Program52 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int max = maxSubArray(nums);
		System.out.println(max);
	}

	public static int maxSubArray(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;

		for (int n : nums) {
			sum += n;
			if (maxSum < sum) {
				maxSum = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
		}
		return maxSum;
	}
}
