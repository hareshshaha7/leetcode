/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/*
	Subsets
	https://leetcode.com/problems/subsets/
	
	Given an integer array nums of unique elements, return all possible subsets (the power set).
	The solution set must not contain duplicate subsets. Return the solution in any order.
	
	Example 1:
	Input: nums = [1,2,3]
	Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
	
	Example 2:
	Input: nums = [0]
	Output: [[],[0]]
	
	Constraints:
		1 <= nums.length <= 10
		-10 <= nums[i] <= 10
		All the numbers of nums are unique.
 */

/**
 * @author Haresh Shaha
 * @since 26-May-2021
 *
 */
public class Program26 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2 };
		List<List<Integer>> subsets = subsets(arr);
		System.out.println(subsets);

	}

	private static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int i = 0; i < nums.length; i++) {
			List<List<Integer>> temp = new ArrayList<>();
			temp.addAll(result);

			List<Integer> l1 = new ArrayList<Integer>();
			l1.add(nums[i]);
			result.add(l1);

			for (int j = 0; j < temp.size(); j++) {
				List<Integer> l = new ArrayList<Integer>();
				l.addAll(temp.get(j));
				l.add(nums[i]);
				result.add(l);
			}
		}
		
		result.add(new ArrayList<>());
		return result;
	}

}
