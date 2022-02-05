package com.haresh.leetcode.problems;

/*
    242. Valid Anagram
    https://leetcode.com/problems/valid-anagram/

    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

    Example 1:
    Input: s = "anagram", t = "nagaram"
    Output: true

    Example 2:
    Input: s = "rat", t = "car"
    Output: false

    Constraints:
        1 <= s.length, t.length <= 5 * 104
        s and t consist of lowercase English letters.
 */

import java.util.Arrays;

/**
 * @author Haresh Shaha
 * @since 05-Feb-2022
 */
public class Program140 {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram1(s, t));
        System.out.println(isAnagram2(s, t));
    }

    /*
    # Sort and compare
    Complexity Analysis
        Time complexity: O(logN + logN)=O(logN), where N is the length of string l1 and l2
        Space complexity: O(1). Constant space for 2 char array of N length.
     */
    public static boolean isAnagram1(String s1, String s2) {
        final char[] chars1 = s1.toCharArray();
        final char[] chars2 = s2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        s1 = new String(chars1);
        s2 = new String(chars2);

        return s1.equals(s2);
    }

    /*
    # Sliding Window
    Complexity Analysis
        Time complexity: O(l1 + 26), where l1 is the length of string l1 and l2 is the length of string l2
        Space complexity: O(1).
     */
    public static boolean isAnagram2(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }

        return matches(s1Map, s2Map);
    }

    public static boolean matches(int[] s1Map, int[] s2Map) {
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] != s2Map[i])
                return false;
        }
        return true;
    }
}
