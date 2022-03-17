package com.haresh.leetcode.problems;

/*
    856. [Medium] Score of Parentheses
    https://leetcode.com/problems/score-of-parentheses/

    Given a balanced parentheses string s, return the score of the string.

    The score of a balanced parentheses string is based on the following rule:
        "()" has score 1.
        AB has score A + B, where A and B are balanced parentheses strings.
        (A) has score 2 * A, where A is a balanced parentheses string.

    Example 1:
    Input: s = "()"
    Output: 1

    Example 2:
    Input: s = "(())"
    Output: 2

    Example 3:
    Input: s = "()()"
    Output: 2

    Constraints:
        2 <= s.length <= 50
        s consists of only '(' and ')'.
        s is a balanced parentheses string.
 */

/**
 * @author Haresh Shaha
 * @since 17-Mar-2022
 */
public class Program170 {
    public static void main(String[] args) {
        String s = "((())())";
        int ans = scoreOfParentheses(s);
        System.out.println(ans);
    }

    public static int scoreOfParentheses(String s) {
        int ans = 0, bal = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (s.charAt(i - 1) == '(')
                    ans += 1 << bal;
            }
        }

        return ans;
    }
}
