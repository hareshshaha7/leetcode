package com.haresh.leetcode.problems;

/*
    316. [Medium] Remove Duplicate Letters
    https://leetcode.com/problems/remove-duplicate-letters/

    Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

    Example 1:
    Input: s = "bcabc"
    Output: "abc"

    Example 2:
    Input: s = "cbacdcbc"
    Output: "acdb"

    Constraints:
        1 <= s.length <= 104
        s consists of lowercase English letters.

    Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Haresh Shaha
 * @since 17-Mar-2022
 */
public class Program171 {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        String result = removeDuplicateLetters(s);
        System.out.println(result);
    }

    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            lastIndex.put(ch, i);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.contains(ch)) {
                while (!stack.isEmpty() && stack.peek() > ch && lastIndex.get(stack.peek()) >= i) {
                    stack.pop();
                }
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append((char) (stack.pop()));
        return sb.reverse().toString();
        // return stack.stream().map(c->c.toString()).collect(Collectors.joining("")); // Slower in evaluation
    }
}
