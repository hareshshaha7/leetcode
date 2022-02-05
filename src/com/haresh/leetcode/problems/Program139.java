package com.haresh.leetcode.problems;

/*
    438. Find All Anagrams in a String
    https://leetcode.com/problems/find-all-anagrams-in-a-string/

    Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

    Example 1:
    Input: s = "cbaebabacd", p = "abc"
    Output: [0,6]
    Explanation:
        The substring with start index = 0 is "cba", which is an anagram of "abc".
        The substring with start index = 6 is "bac", which is an anagram of "abc".

    Example 2:
    Input: s = "abab", p = "ab"
    Output: [0,1,2]
    Explanation:
        The substring with start index = 0 is "ab", which is an anagram of "ab".
        The substring with start index = 1 is "ba", which is an anagram of "ab".
        The substring with start index = 2 is "ab", which is an anagram of "ab".

    Constraints:
        1 <= s.length, p.length <= 3 * 104
        s and p consist of lowercase English letters.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author Haresh Shaha
 * @since 05-Feb-2022
 */
public class Program139 {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        List<Integer> result = findAnagrams(s, p);
        System.out.println(result);
    }

    /*
    # Sliding Window
    Complexity Analysis
        Time complexity: O(l1 + 26 * (l2-l1)), where l1 is the length of string l1 and l2 is the length of string l2
        Space complexity: O(1).
     */
    public static List<Integer> findAnagrams(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        for (int i = 0; i < s2.length(); i++) {
            s2Map[s2.charAt(i) - 'a']++;
            s1Map[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s1.length() - s2.length(); i++) {
            if (matches(s1Map, s2Map))
                result.add(i);
            s1Map[s1.charAt(i + s2.length()) - 'a']++;
            s1Map[s1.charAt(i) - 'a']--;
        }

        if (matches(s1Map, s2Map))
            result.add(s1.length() - s2.length());

        return result;
    }

    public static boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
}
