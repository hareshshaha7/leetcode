/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
	4Sum
	https://leetcode.com/problems/4sum/

	Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
	0 <= a, b, c, d < n
	a, b, c, and d are distinct.
	nums[a] + nums[b] + nums[c] + nums[d] == target
	You may return the answer in any order.
	
	Example 1:
	Input: nums = [1,0,-1,0,-2,2], target = 0
	Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
	
	Example 2:
	Input: nums = [2,2,2,2,2], target = 8
	Output: [[2,2,2,2]]
	
	Constraints:
		1 <= nums.length <= 200
		-109 <= nums[i] <= 109
		-109 <= target <= 109
 */

/**
 * @author Haresh Shaha
 * @since 06-Jun-2021
 *
 */
public class Program36 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 3, 3 };
		int target = 9;

		List<List<Integer>> list = fourSum(nums, target);
		System.out.println(list);
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		return kSum(nums, target, 0, 4);
	}

	public static List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
		List<List<Integer>> res = new ArrayList<>();

		if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k)
			return res;

		if (k == 2)
			return twoSum(nums, target, start);

		for (int i = start; i < nums.length; ++i)

			if (i == start || nums[i - 1] != nums[i])

				for (List<Integer> set : kSum(nums, target - nums[i], i + 1, k - 1)) {
					res.add(new ArrayList<>(Arrays.asList(nums[i])));
					res.get(res.size() - 1).addAll(set);
				}

		return res;
	}

	public static List<List<Integer>> twoSum(int[] nums, int target, int start) {
		List<List<Integer>> res = new ArrayList<>();
		int lo = start, hi = nums.length - 1;

		while (lo < hi) {
			int sum = nums[lo] + nums[hi];

			if (sum < target || (lo > start && nums[lo] == nums[lo - 1]))
				++lo;
			else if (sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1]))
				--hi;
			else
				res.add(Arrays.asList(nums[lo++], nums[hi--]));
		}

		return res;
	}

}
