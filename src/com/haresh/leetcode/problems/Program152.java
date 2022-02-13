package com.haresh.leetcode.problems;

/*
    784. [Medium] Letter Case Permutation
    https://leetcode.com/problems/letter-case-permutation/

    Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

    Return a list of all possible strings we could create. Return the output in any order.

    Example 1:
    Input: s = "a1b2"
    Output: ["a1b2","a1B2","A1b2","A1B2"]

    Example 2:
    Input: s = "3z4"
    Output: ["3z4","3Z4"]

    Constraints:
        1 <= s.length <= 12
        s consists of lowercase English letters, uppercase English letters, and digits.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Haresh Shaha
 * @since 13-Feb-2022
 */
public class Program152 {
    public static void main(String[] args) {
        String s = "a1b2";
        List<String> ans = letterCasePermutation(s);
        System.out.println(ans);

        ans = letterCasePermutation1(s);
        System.out.println(ans);
    }

    // Faster and simple approach
    public static List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        compute(ans, S.toCharArray(), 0);
        return ans;
    }

    public static void compute(List<String> ans, char[] chars, int index) {
        if (index == chars.length)
            ans.add(new String(chars));
        else {
            if (Character.isLetter(chars[index])) {
                chars[index] = Character.toLowerCase(chars[index]);
                compute(ans, chars, index + 1);
                chars[index] = Character.toUpperCase(chars[index]);
            }
            compute(ans, chars, index + 1);
        }
    }

    // Slower approach
    public static List<String> letterCasePermutation1(String s) {
        s = s.toLowerCase();
        Set<String> combinations = new HashSet<>();
        combinations.add(s);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {

                List<String> l = new ArrayList<>(combinations);
                for (String str : l) {
                    char[] chs = str.toCharArray();
                    chs[i] = Character.toUpperCase(chs[i]);
                    combinations.add(String.valueOf(chs));

                    // StringBuilder sb = new StringBuilder(str);
                    // sb.setCharAt(i, Character.toUpperCase(ch));
                    // combinations.add(sb.toString());
                }
            }
        }
        return new ArrayList<>(combinations);
    }
}
