/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
	90. Subsets II
	
	Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
	
	The solution set must not contain duplicate subsets. Return the solution in any order.
	
	Example 1:
	Input: nums = [1,2,2]
	Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
	
	Example 2:
	Input: nums = [0]
	Output: [[],[0]]
	
	Constraints:
		1 <= nums.length <= 10
		-10 <= nums[i] <= 10
 */

/**
 * @author Haresh Shaha
 * @since 04-Sep-2021
 *
 */
public class Program84 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 1, 2, 2 };
		List<List<Integer>> list = subsetsWithDup(nums);
		System.out.println(list);

	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Set<List<Integer>> result = new HashSet<>();

		for (int num : nums) {
			List<List<Integer>> temp = new ArrayList<>();
			temp.addAll(result);

			result.add(new ArrayList<>(List.of(num)));
			for (List<Integer> l : temp) {
				List<Integer> tempList = new ArrayList<>(l);
				tempList.add(num);
				Collections.sort(tempList);
				result.add(tempList);
			}

		}

		result.add(new ArrayList<>());
		return new ArrayList<>(result);
	}
}
