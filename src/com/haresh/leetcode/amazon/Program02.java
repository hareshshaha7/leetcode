package com.haresh.leetcode.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	Top K Frequent Elements
	
	Given a non-empty array of integers, return the k most frequent elements.
	
	Example 1:
	Input: nums = [1,1,1,2,2,3], k = 2
	Output: [1,2]
	
	Example 2:
	Input: nums = [1], k = 1
	Output: [1]
	
	Note:
		You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
		Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
		It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
		You can return the answer in any order.
 */

public class Program02 {
	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> numberFrequency = new HashMap<Integer, Integer>();
		for (int num : nums) {
			numberFrequency.put(num, numberFrequency.getOrDefault(num, 0) + 1);
		}

		List<Integer> numList = new ArrayList<Integer>(numberFrequency.keySet());
		Collections.sort(numList, (i, j) -> numberFrequency.get(j) - numberFrequency.get(i));

		return numList.subList(0, k).stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		int[] input = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		int[] result = topKFrequent(input, k);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}
}
