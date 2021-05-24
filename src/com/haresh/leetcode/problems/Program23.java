/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	Longest Palindromic Substring
	https://leetcode.com/problems/longest-palindromic-substring/
	
	Given a string s, return the longest palindromic substring in s.
	
	Example 1:
	Input: s = "babad"
	Output: "bab"
	Note: "aba" is also a valid answer.
	
	Example 2:
	Input: s = "cbbd"
	Output: "bb"
	
	Example 3:
	Input: s = "a"
	Output: "a"
	
	Example 4:
	Input: s = "ac"
	Output: "a"
	
	Constraints:
		1 <= s.length <= 1000
		s consist of only digits and English letters (lower-case and/or upper-case), 
 */

/**
 * @author Haresh Shaha
 * @since 24-May-2021
 *
 */
public class Program23 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "baabad";
		String longestPalindrome = longestPalindrome(s);
		System.out.println(longestPalindrome);
	}

	public static String longestPalindrome(String s) {
		String longestPalindrome = "";

		if (s == null || s.length() == 0) {
			return "";
		}

		for (int i = 0; i < s.length(); i++) {
			// For odd string
			longestPalindrome = getPalindromAroundIndex(s, longestPalindrome, i, i);

			// for even string
			longestPalindrome = getPalindromAroundIndex(s, longestPalindrome, i, i + 1);
		}

		return longestPalindrome;
	}

	private static String getPalindromAroundIndex(String s, String longestPalindrome, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

			if (right - left + 1 > longestPalindrome.length()) {
				longestPalindrome = s.substring(left, right + 1);
			}

			left--;
			right++;
		}

		return longestPalindrome;
	}

}
