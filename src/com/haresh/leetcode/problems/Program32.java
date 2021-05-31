/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.Arrays;

/*
	Longest Common Prefix
	https://leetcode.com/problems/longest-common-prefix/

	Write a function to find the longest common prefix string amongst an array of strings.
	If there is no common prefix, return an empty string "".
	
	Example 1:
	Input: strs = ["flower","flow","flight"]
	Output: "fl"

	Example 2:
	Input: strs = ["dog","racecar","car"]
	Output: ""
	Explanation: There is no common prefix among the input strings.
	
	Constraints:
		1 <= strs.length <= 200
		0 <= strs[i].length <= 200
		strs[i] consists of only lower-case English letters.
 */

/**
 * @author Haresh Shaha
 * @since 31-May-2021
 *
 */
public class Program32 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] strs = { "" };
		String longestCommonPrefix = longestCommonPrefix(strs);
		System.out.println(longestCommonPrefix);
	}

	public static String longestCommonPrefix(String[] strs) {
		int minCommonIndex = Integer.MAX_VALUE;

		for (int i = 0; i < strs.length - 1; i++) {

			int index = Arrays.mismatch(strs[i].toCharArray(), strs[i + 1].toCharArray());
			if (index == -1) {
				index = strs[i].length();
			}

			if (index < minCommonIndex) {
				minCommonIndex = index;
			}
		}

		return minCommonIndex != Integer.MAX_VALUE ? strs[0].substring(0, minCommonIndex) : strs[0];
	}
}
