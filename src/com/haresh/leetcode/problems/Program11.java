/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
	How Many Numbers Are Smaller Than the Current Number
	https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
	
	Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. 
	That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
	Return the answer in an array.
	
	Example 1:
	Input: nums = [8,1,2,2,3]
	Output: [4,0,1,1,3]
	Explanation: 
		For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
		For nums[1]=1 does not exist any smaller number than it.
		For nums[2]=2 there exist one smaller number than it (1). 
		For nums[3]=2 there exist one smaller number than it (1). 
		For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
	
	Example 2:
	Input: nums = [6,5,4,8]
	Output: [2,1,0,3]
	
	Example 3:
	Input: nums = [7,7,7,7]
	Output: [0,0,0,0]
 */

/**
 * @author Haresh Shaha
 * @since 17-May-2021
 *
 */
public class Program11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 8, 1, 2, 2, 3 };
		int[] result = smallerNumbersThanCurrent(nums);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	public static int[] smallerNumbersThanCurrent(int[] nums) {
		int[] result = new int[nums.length];
		int[] sortedNums = nums.clone();
		Arrays.sort(sortedNums);

		Map<Integer, Integer> smallerCount = new HashMap<>();
		for (int i = 0; i < sortedNums.length; i++) {
			if (!smallerCount.containsKey(sortedNums[i])) {
				smallerCount.put(sortedNums[i], i);
			}
		}

		for (int i = 0; i < nums.length; i++) {
			result[i] = smallerCount.get(nums[i]);
		}

		return result;
	}
}
