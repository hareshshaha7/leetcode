/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/*
118. Pascal's Triangle
https://leetcode.com/problems/pascals-triangle/

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1

Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:
Input: numRows = 1
Output: [[1]]

Constraints:
	1 <= numRows <= 30
 */

/**
 * @author Haresh Shaha
 * @since 02-Aug-2021
 *
 */
public class Program56 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 5;
		List<List<Integer>> result = generate(num);
		for (List<Integer> list : result) {
			System.out.println(list);
		}

	}

	public static List<List<Integer>> generate(int numRows) {

		List<List<Integer>> result = new ArrayList<>();
		result.add(List.of(1));

		for (int i = 1; i < numRows; i++) {
			List<Integer> l = new ArrayList<>(List.of(1));
			List<Integer> a = result.get(i - 1);

			for (int j = 1; j <= i; j++) {
				int val = a.size() > j ? a.get(j) : 0;
				l.add(j, val + a.get(j - 1));
			}
			result.add(l);
		}

		return result;
	}

}
