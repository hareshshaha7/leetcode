package com.haresh.leetcode.problems;

/*
    1016. Binary String With Substrings Representing 1 To N
    https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/

    Given a binary string s and a positive integer n, return true if the binary representation of all the integers in the range [1, n] are substrings of s, or false otherwise.

    A substring is a contiguous sequence of characters within a string.

    Example 1:
    Input: s = "0110", n = 3
    Output: true

    Example 2:
    Input: s = "0110", n = 4
    Output: false

    Constraints:
        1 <= s.length <= 1000
        s[i] is either '0' or '1'.
        1 <= n <= 109
 */

/**
 * @author Haresh Shaha
 * @since 15-Jan-2022
 */
public class Program97 {

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        String s = "0110";
        int n = 3;
        boolean result = queryString(s, n);
        System.out.println(result);
    }

    public static boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            String binary = getBinaryString(i);
            if (!s.contains(binary)) {
                return false;
            }
        }
        return true;
    }

    public static String getBinaryString(int num) {
        StringBuilder binary = new StringBuilder();
        while (num != 1) {
            binary.append(num % 2);
            num /= 2;
        }
        binary.append("1");

        return binary.reverse().toString();
    }
}
