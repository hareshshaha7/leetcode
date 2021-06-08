/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/*
	Generate Parentheses
	https://leetcode.com/problems/generate-parentheses/
	
	Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
	
	Example 1:
	Input: n = 3
	Output: ["((()))","(()())","(())()","()(())","()()()"]
	
	Example 2:
	Input: n = 1
	Output: ["()"]
	
	Constraints:
		1 <= n <= 8
		
	Solution Explanation: https://youtu.be/s9fokUqJ76A
 */

/**
 * @author Haresh Shaha
 * @since 08-Jun-2021
 *
 */
public class Program40 {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 3;
		List<String> parenthesisList = generateParenthesis(n);
		System.out.println(parenthesisList);
	}

	public static List<String> generateParenthesis(int n) {
		List<String> parenthesisList = new ArrayList<String>();
		backtrack(0, 0, n, new StringBuilder(), parenthesisList);
		return parenthesisList;
	}

	private static void backtrack(int openCount, int closeCount, int n, StringBuilder parenthesis,
			List<String> parenthesisList) {
		if (openCount == n && closeCount == n) {
			parenthesisList.add(parenthesis.toString());
		}

		if (openCount > closeCount) {
			parenthesis.append(")");
			backtrack(openCount, closeCount + 1, n, parenthesis, parenthesisList);
			parenthesis.deleteCharAt(parenthesis.length() - 1);
		}

		if (openCount < n) {
			parenthesis.append("(");
			backtrack(openCount + 1, closeCount, n, parenthesis, parenthesisList);
			parenthesis.deleteCharAt(parenthesis.length() - 1);
		}
	}
}
