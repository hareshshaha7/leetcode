/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	Letter Combinations of a Phone Number
	https://leetcode.com/problems/letter-combinations-of-a-phone-number/
	
	Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
	A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
	 
	Example 1:
	Input: digits = "23"
	Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
	
	Example 2:
	Input: digits = ""
	Output: []
	
	Example 3:
	Input: digits = "2"
	Output: ["a","b","c"]
	
	Constraints:
		0 <= digits.length <= 4
		digits[i] is a digit in the range ['2', '9'].

 */

/**
 * @author Haresh Shaha
 * @since 04-Jun-2021
 *
 */
public class Program35 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String digits = "23";
		List<String> combinations = letterCombinations(digits);
		System.out.println(combinations);
	}

	static List<String> combinations = new ArrayList<String>();

	public static List<String> letterCombinations(String digits) {
		int length = digits.length();

		if (length == 0)
			return new ArrayList<>();

		Map<Character, List<String>> dialPad = new HashMap<>();
		dialPad.put('2', Arrays.asList("a", "b", "c"));
		dialPad.put('3', Arrays.asList("d", "e", "f"));
		dialPad.put('4', Arrays.asList("g", "h", "i"));
		dialPad.put('5', Arrays.asList("j", "k", "l"));
		dialPad.put('6', Arrays.asList("m", "n", "o"));
		dialPad.put('7', Arrays.asList("p", "q", "r", "s"));
		dialPad.put('8', Arrays.asList("t", "u", "v"));
		dialPad.put('9', Arrays.asList("w", "x", "y", "z"));

		if (length == 1)
			return dialPad.get(digits.charAt(0));

		combination(dialPad, 0, digits, new StringBuilder());
		return combinations;
	}

	public static void combination(Map<Character, List<String>> dialPad, int length, String digits, StringBuilder sb) {
		if (length == digits.length()) {
			combinations.add(sb.toString());
			return;
		}

		List<String> letters = dialPad.get(digits.charAt(length));
		for (String c : letters) {
			sb.append(c);
			combination(dialPad, length + 1, digits, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
