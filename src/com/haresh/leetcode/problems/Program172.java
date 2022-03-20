package com.haresh.leetcode.problems;

/*
    1081. [Medium] Smallest Subsequence of Distinct Characters
    https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

    Given a string s, return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.

    Example 1:
    Input: s = "bcabc"
    Output: "abc"

    Example 2:
    Input: s = "cbacdcbc"
    Output: "acdb"

    Constraints:
        1 <= s.length <= 1000
        s consists of lowercase English letters.

    Note: This question is the same as 316: https://leetcode.com/problems/remove-duplicate-letters/
 */

import java.util.Stack;

/**
 * @author Haresh Shaha
 * @since 17-Mar-2022
 */
public class Program172 {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        String result = removeDuplicateLetters(s);
        System.out.println(result);
    }

    public static String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i; // track the lastIndex of character presence
        }

        boolean[] seen = new boolean[26]; // keep track seen
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (seen[curr]) continue; // if seen continue as we need to pick one char only
            while (!st.isEmpty() && st.peek() > curr && i < lastIndex[st.peek()]) {
                seen[st.pop()] = false; // pop out and mark unseen
            }
            st.push(curr); // add into stack
            seen[curr] = true; // mark seen
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty())
            sb.append((char) (st.pop() + 'a'));
        return sb.reverse().toString();
    }
}
