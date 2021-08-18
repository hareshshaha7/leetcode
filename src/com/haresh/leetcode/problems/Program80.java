/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	485. Max Consecutive Ones
	https://leetcode.com/problems/max-consecutive-ones
	
	Given a binary array nums, return the maximum number of consecutive 1's in the array.
	
	Example 1:
	Input: nums = [1,1,0,1,1,1]
	Output: 3
	Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
	
	Example 2:
	Input: nums = [1,0,1,1,0,1]
	Output: 2
	
	Constraints:
		1 <= nums.length <= 105
		nums[i] is either 0 or 1.
 */

/**
 * @author Haresh Shaha
 * @since 18-Aug-2021
 *
 */
public class Program80 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 1, 1, 0, 1, 1, 1 };
		int count = findMaxConsecutiveOnes(nums);
		System.out.println(count);
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		int max = 0, count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				count++;
				if (count > max) {
					max = count;
				}
			} else {
				count = 0;
			}
		}
		return max;
	}

}
