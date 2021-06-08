/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
	Valid Parentheses
	https://leetcode.com/problems/valid-parentheses/
	
	Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
	
	An input string is valid if:
		Open brackets must be closed by the same type of brackets.
		Open brackets must be closed in the correct order.
	 
	Example 1:
	Input: s = "()"
	Output: true
	
	Example 2:
	Input: s = "()[]{}"
	Output: true
	
	Example 3:
	Input: s = "(]"
	Output: false
	
	Example 4:
	Input: s = "([)]"
	Output: false
	
	Example 5:
	Input: s = "{[]}"
	Output: true
	
	Constraints:
		1 <= s.length <= 104
		s consists of parentheses only '()[]{}'.
 */

/**
 * @author Haresh Shaha
 * @since 08-Jun-2021
 *
 */
public class Program38 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "[]";
		System.out.println(isValid(s));
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		Map<Character, Character> brackets = new HashMap<Character, Character>();
		brackets.put('{', '}');
		brackets.put('[', ']');
		brackets.put('(', ')');

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (brackets.containsKey(ch)) {
				stack.push(ch);
			} else {
				if (!stack.isEmpty()) {
					Character pop = stack.pop();
					if (brackets.get(pop) != ch)
						return false;
				}
				else {
					return false;
				}
			}
		}

		if (!stack.isEmpty())
			return false;
		return true;

	}
}
