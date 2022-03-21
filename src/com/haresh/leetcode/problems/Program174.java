package com.haresh.leetcode.problems;

/*
    763. [Medium] Partition Labels
    https://leetcode.com/problems/partition-labels/


    You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

    Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

    Return a list of integers representing the size of these parts.

    Example 1:
    Input: s = "ababcbacadefegdehijhklij"
    Output: [9,7,8]
    Explanation:
        The partition is "ababcbaca", "defegde", "hijhklij".
        This is a partition so that each letter appears in at most one part.
        A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

    Example 2:
    Input: s = "eccbbbbdec"
    Output: [10]

    Constraints:
        1 <= s.length <= 500
        s consists of lowercase English letters.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author Haresh Shaha
 * @since 21-Mar-2022
 */
public class Program174 {
    public static void main(String[] args) {
        String input = "ababcbacadefegdehijhklij";
        List<Integer> partitionLabelsCount = partitionLabels(input);
        System.out.println(partitionLabelsCount);
    }

    public static List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); ++i)
            last[s.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            j = Math.max(j, last[s.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
}
