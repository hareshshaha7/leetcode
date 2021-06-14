/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
	3Sum
	https://leetcode.com/problems/3sum/
	
	Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
	Notice that the solution set must not contain duplicate triplets.
	
	Example 1:
	Input: nums = [-1,0,1,2,-1,-4]
	Output: [[-1,-1,2],[-1,0,1]]
	
	Example 2:
	Input: nums = []
	Output: []
	
	Example 3:
	Input: nums = [0]
	Output: []
	
	Constraints:
		0 <= nums.length <= 3000
		-105 <= nums[i] <= 105
 */

/**
 * @author Haresh Shaha
 * @since 02-Jun-2021
 *
 */
public class Program33 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> result = threeSum(nums);
		System.out.println(result);
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> result = new HashSet<List<Integer>>();
//		Set<Integer> hs = new HashSet<>();

		if (nums.length < 3)
			return new ArrayList<List<Integer>>();

		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
//			// avoid duplicates add() returns false if an element already present.
//			if (hs.add(nums[i])) {
//				result.addAll(twoSum(i, nums));
//			}
			
			if (nums[i] > 0)
				break;
		
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];

				if (sum == 0) {
					List<Integer> l = new ArrayList<>();
					l.add(nums[i]);
					l.add(nums[left]);
					l.add(nums[right]);
					result.add(l);

					left++;
					right--;

				} else if (sum > 0)
					right--;
				else
					left++;
			}
		}

		return new ArrayList<>(result);
	}

	private static Set<List<Integer>> twoSum(int index, int[] nums) {
		Set<List<Integer>> result = new HashSet<List<Integer>>();
		Map<Integer, Integer> hm = new HashMap<>();

		// negating the target is important.
		int target = -nums[index];

		for (int i = 0; i < nums.length; i++) {
			if (i == index)
				continue;

			int compliment = target - nums[i];
			if (hm.containsKey(nums[i])) {
				ArrayList<Integer> ll = new ArrayList<>();
				ll.add(nums[index]);
				ll.add(nums[i]);
				ll.add(nums[hm.get(nums[i])]);

				// sorting is done inorder to insist hashset to compare the triplet duplicates.
				Collections.sort(ll);
				result.add(ll);
			} else {
				hm.put(compliment, i);
			}
		}

		return result;
	}
}
