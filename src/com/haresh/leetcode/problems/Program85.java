package com.haresh.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
	39. Combination Sum
	https://leetcode.com/problems/combination-sum/
	
	Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. 
	You may return the combinations in any order.
	
	The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
	
	It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
	
	Example 1:
	Input: candidates = [2,3,6,7], target = 7
	Output: [[2,2,3],[7]]
	Explanation:
		2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
		7 is a candidate, and 7 = 7.
		These are the only two combinations.
	
	Example 2:
	Input: candidates = [2,3,5], target = 8
	Output: [[2,2,2,2],[2,3,3],[3,5]]
	
	Example 3:
	Input: candidates = [2], target = 1
	Output: []
	
	Example 4:
	Input: candidates = [1], target = 1
	Output: [[1]]
	
	Example 5:
	Input: candidates = [1], target = 2
	Output: [[1,1]]
	
	Constraints:
		1 <= candidates.length <= 30
		1 <= candidates[i] <= 200
		All elements of candidates are distinct.
		1 <= target <= 500
 */

/**
 * @author Haresh Shaha
 * @since 07-Sep-2021
 *
 */
public class Program85 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		List<List<Integer>> combinationSum = combinationSum(candidates, target);
		System.out.println(combinationSum);
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		helper(candidates, target, new ArrayList<>(), result, 0);
		return result;
	}

	public static void helper(int[] candidates, int target, List<Integer> list, List<List<Integer>> result, int start) {
		if (target < 0) {
			return;
		}

		if (target == 0) {
			List<Integer> temp = new ArrayList<>(list);
			Collections.sort(temp);
			if (!result.contains(temp))
				result.add(temp);
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			list.add(candidates[i]);
			helper(candidates, target - candidates[i], list, result, i);
			list.remove(list.size() - 1);
		}
	}

}
