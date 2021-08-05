/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
	229. Majority Element II
	https://leetcode.com/problems/majority-element-ii/
	
	Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
	
	Follow-up: Could you solve the problem in linear time and in O(1) space?
	
	Example 1:
	Input: nums = [3,2,3]
	Output: [3]
	
	Example 2:
	Input: nums = [1]
	Output: [1]
	
	Example 3:
	Input: nums = [1,2]
	Output: [1,2]
	
	Constraints:
		1 <= nums.length <= 5 * 104
		-109 <= nums[i] <= 109
 */

/**
 * @author Haresh Shaha
 * @since 05-Aug-2021
 *
 */
public class Program64 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		List<Integer> majorityElements = majorityElementObvious(nums);
		System.out.println(majorityElements);

		majorityElements = majorityElementEfficient(nums);
		System.out.println(majorityElements);
	}

	public static List<Integer> majorityElementObvious(int[] nums) {
		Map<Integer, Integer> counts = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		for (int num : nums) {
			counts.put(num, counts.getOrDefault(num, 0) + 1);
		}

		list = counts.keySet().stream().filter(p -> counts.get(p) > nums.length / 3).collect(Collectors.toList());
		return list;
	}

	public static List<Integer> majorityElementEfficient(int[] nums) {
		int n = nums.length / 3;
		List<Integer> list = new ArrayList<>();
		int count = 1;
		Arrays.sort(nums);

		if (n == 0)
			list.add(nums[0]);

		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] == nums[i]) {
				count++;
			} else {
				count = 1;
			}

			if (count > n && !list.contains(nums[i])) {
				list.add(nums[i]);
			}
		}

		return list;
	}

}
