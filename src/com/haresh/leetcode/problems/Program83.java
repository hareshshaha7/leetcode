/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/*
	78. Subsets
	
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
 * @since 01-Sep-2021
 *
 */
public class Program83 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> subsets = subsets(nums);
		for (List<Integer> list : subsets) {
			System.out.println(list);
		}
	}

	public static List<List<Integer>> subsets(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int i = 0; i < num.length; i++) {
			List<List<Integer>> temp = new ArrayList<>();
			temp.addAll(result);

			List<Integer> l1 = new ArrayList<Integer>();
			l1.add(num[i]);
			result.add(l1);

			for (int j = 0; j < temp.size(); j++) {
				List<Integer> l = new ArrayList<Integer>();
				l.addAll(temp.get(j));
				l.add(num[i]);
				result.add(l);
			}
		}

		result.add(new ArrayList<>());
		return result;
	}

}
