/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	Running Sum of 1d Array
	
	Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
	Return the running sum of nums.

	Example 1:	
	Input: nums = [1,2,3,4]
	Output: [1,3,6,10]
	Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
	
	Example 2:
	Input: nums = [1,1,1,1,1]
	Output: [1,2,3,4,5]
	Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
	
	Example 3:
	Input: nums = [3,1,2,10,1]
	Output: [3,4,6,16,17]
	
	Constraints:
	1 <= nums.length <= 1000
	-10^6 <= nums[i] <= 10^6
 */

/**
 * @author Haresh Shaha
 * @since 12-May-2021
 *
 */
public class Program01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		int[] sums = runningSum(nums);
		for (int i = 0; i < sums.length; i++) {
			System.out.println(sums[i]);
		}

	}

	public static int[] runningSum(int[] nums) {
		int[] sums = new int[nums.length];
		sums[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sums[i] = sums[i - 1] + nums[i];
		}
		return sums;
	}
}
