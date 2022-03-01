package com.haresh.leetcode.problems;

/*
    338. Counting Bits
    https://leetcode.com/problems/counting-bits/

    Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

    Example 1:
    Input: n = 2
    Output: [0,1,1]
    Explanation:
        0 --> 0
        1 --> 1
        2 --> 10

    Example 2:
    Input: n = 5
    Output: [0,1,1,2,1,2]
    Explanation:
        0 --> 0
        1 --> 1
        2 --> 10
        3 --> 11
        4 --> 100
        5 --> 101

    Constraints:
        0 <= n <= 105

    Follow up:
        It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
        Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
 */

/**
 * @author Haresh Shaha
 * @since 01-Mar-2022
 */
public class Program162 {
    /**
     * [0,1,1,2,1,2,2,3,1,2,2,3,2,2,3,3,4,1]
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     * 3 --> 11
     * 4 --> 100
     * 5 --> 101
     * 6      101
     * 7       111
     * 8       1000
     * 9       1001
     * 10      1010
     * 11      1011
     * 12      1100
     * 13      1101
     * 14      1110
     * 15      1111
     * 16      10000
     */
    public static void main(String[] args) {
        int n = 5;
        int[] result = countBits(n);
        for (int bits : result) {
            System.out.print(bits + " ");
        }
    }

    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;

        for (int i = 0; i <= n; i++) {
            result[i] = result[i / 2] + (i % 2);
        }

        return result;
    }
}
