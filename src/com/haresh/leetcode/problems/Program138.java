package com.haresh.leetcode.problems;

/*
    567. Permutation in String
    https://leetcode.com/problems/permutation-in-string/

    Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
    In other words, return true if one of s1's permutations is the substring of s2.

    Example 1:
    Input: s1 = "ab", s2 = "eidbaooo"
    Output: true
    Explanation: s2 contains one permutation of s1 ("ba").

    Example 2:
    Input: s1 = "ab", s2 = "eidboaoo"
    Output: false

    Constraints:
        1 <= s1.length, s2.length <= 104
        s1 and s2 consist of lowercase English letters.
 */

/**
 * @author Haresh Shaha
 * @since 05-Feb-2022
 */
public class Program138 {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        boolean isInclusion = checkInclusion1(s1, s2);
        System.out.println(isInclusion);

        isInclusion = checkInclusion2(s1, s2);
        System.out.println(isInclusion);
    }

    /*
    # Using Array
    Complexity Analysis
        Time complexity: O(l1 + 26 * l1 * (l2-l1)), where l1 is the length of string l1 and l2 is the length of string l2
        Space complexity: O(1). s1map and s2map of size 26 is used.
     */
    public static boolean checkInclusion1(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        for (int i = 0; i < s1.length(); i++)
            s1map[s1.charAt(i) - 'a']++;
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2map = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2map[s2.charAt(i + j) - 'a']++;
            }
            if (matches(s1map, s2map))
                return true;
        }
        return false;
    }

    /*
    # Sliding Window
    Complexity Analysis
        Time complexity: O(l1 + 26 * (l2-l1)), where l1 is the length of string l1 and l2 is the length of string l2
        Space complexity: O(1).
     */
    public static boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1map, s2map))
                return true;
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return matches(s1map, s2map);
    }

    public static boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }

}
