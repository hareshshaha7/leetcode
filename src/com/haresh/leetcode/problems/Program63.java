/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.Arrays;

/*
	169. Majority Element
	https://leetcode.com/problems/majority-element/
	
	Given an array nums of size n, return the majority element.
	
	The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
	
	Example 1:
	Input: nums = [3,2,3]
	Output: 3
	
	Example 2:
	Input: nums = [2,2,1,1,1,2,2]
	Output: 2
	
	Constraints:
		n == nums.length
		1 <= n <= 5 * 104
		-231 <= nums[i] <= 231 - 1
	
	Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

/**
 * @author Haresh Shaha
 * @since 05-Aug-2021
 *
 */
public class Program63 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		int element = majorityElement(nums);
		System.out.println(element);
	}

	public static int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}
}
