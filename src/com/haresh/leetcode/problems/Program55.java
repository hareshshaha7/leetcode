/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/*
	287. Find the Duplicate Number
	https://leetcode.com/problems/find-the-duplicate-number/
	
	Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
	
	There is only one repeated number in nums, return this repeated number.
	
	You must solve the problem without modifying the array nums and uses only constant extra space.
	
	Example 1:
	Input: nums = [1,3,4,2,2]
	Output: 2
	
	Example 2:
	Input: nums = [3,1,3,4,2]
	Output: 3
	
	Example 3:
	Input: nums = [1,1]
	Output: 1
	
	Example 4:
	Input: nums = [1,1,2]
	Output: 1
	 
	Constraints:
		1 <= n <= 105
		nums.length == n + 1
		1 <= nums[i] <= n
		All the integers in nums appear only once except for precisely one integer which appears two or more times.
	 
	Follow up:
		How can we prove that at least one duplicate number must exist in nums?
		Can you solve the problem in linear runtime complexity?
 */

/**
 * @author Haresh Shaha
 * @since 02-Aug-2021
 *
 */
public class Program55 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 3, 1, 3, 4, 2 };
		int duplicateNumber = findDuplicate(nums);
		System.out.println(duplicateNumber);

	}

	public static int findDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int num : nums) {
			if (set.contains(num)) {
				return num;
			}
			set.add(num);
		}
		return -1;
	}

}
