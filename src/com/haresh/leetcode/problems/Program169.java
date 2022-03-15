package com.haresh.leetcode.problems;

/*
    1249. [Medium] Minimum Remove to Make Valid Parentheses

    Given a string s of '(' , ')' and lowercase English characters.

    Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

    Formally, a parentheses string is valid if and only if:
        It is the empty string, contains only lowercase characters, or
        It can be written as AB (A concatenated with B), where A and B are valid strings, or
        It can be written as (A), where A is a valid string.

    Example 1:
    Input: s = "lee(t(c)o)de)"
    Output: "lee(t(c)o)de"
    Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

    Example 2:
    Input: s = "a)b(c)d"
    Output: "ab(c)d"

    Example 3:
    Input: s = "))(("
    Output: ""
    Explanation: An empty string is also valid.

    Constraints:
        1 <= s.length <= 105
        s[i] is either'(' , ')', or lowercase English letter.
 */

import java.util.Collections;
import java.util.Stack;

/**
 * @author Haresh Shaha
 * @since 15-Mar-2022
 */
public class Program169 {
    public static void main(String[] args) {
        String s = "a)b(c)d";
        System.out.println(minRemoveToMakeValid(s));
    }

    public static String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder(s);
        Stack<Integer> parentheses = new Stack<>();
        Stack<Integer> removeCharAtIndex = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                parentheses.push(i);
            } else if (ch == ')') {
                if (parentheses.isEmpty()) {
                    removeCharAtIndex.push(i);
                } else {
                    parentheses.pop();
                }
            }
        }

        removeCharAtIndex.addAll(parentheses);
        Collections.sort(removeCharAtIndex);
        while (!removeCharAtIndex.isEmpty()) {
            result.deleteCharAt(removeCharAtIndex.pop());
        }

        return result.toString();
    }
}
