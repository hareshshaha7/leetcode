package com.haresh.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
	40. Combination Sum II
	https://leetcode.com/problems/combination-sum-ii/
	
	Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
	
	Each number in candidates may only be used once in the combination.
	
	Note: The solution set must not contain duplicate combinations.
	
	Example 1:
	Input: candidates = [10,1,2,7,6,1,5], target = 8
	Output: 
		[
			[1,1,6],
			[1,2,5],
			[1,7],
			[2,6]
		]
	
	Example 2:
	Input: candidates = [2,5,2,1,2], target = 5
	Output: 
		[
			[1,2,2],
			[5]
		]
	
	Constraints:
		1 <= candidates.length <= 100
		1 <= candidates[i] <= 50
		1 <= target <= 30
 */

/**
 * @author Haresh Shaha
 * @since 07-Sep-2021
 *
 */
public class Program86 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		List<List<Integer>> combinationSum2 = combinationSum2(candidates, target);
		System.out.println(combinationSum2);
	}

	public static List<List<Integer>> combinationSum2(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, target, 0);
		return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
		if (remain < 0)
			return;
		else if (remain == 0)
			list.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i < nums.length; i++) {
				if (i > start && nums[i] == nums[i - 1])
					continue; // skip duplicates
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, remain - nums[i], i + 1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
