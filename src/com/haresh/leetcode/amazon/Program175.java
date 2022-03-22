package com.haresh.leetcode.amazon;

/*
    1663. [Medium] Smallest String With A Given Numeric Value
    https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/

    The numeric value of a lowercase character is defined as its position (1-indexed) in the alphabet,
    so the numeric value of a is 1, the numeric value of b is 2, the numeric value of c is 3, and so on.

    The numeric value of a string consisting of lowercase characters is defined as the sum of its characters' numeric values.
    For example, the numeric value of the string "abe" is equal to 1 + 2 + 5 = 8.

    You are given two integers n and k. Return the lexicographically smallest string with length equal to n and numeric value equal to k.

    Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order,
    that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.

    Example 1:
    Input: n = 3, k = 27
    Output: "aay"
    Explanation: The numeric value of the string is 1 + 1 + 25 = 27, and it is the smallest string with such a value and length equal to 3.

    Example 2:
    Input: n = 5, k = 73
    Output: "aaszz"

    Constraints:
        1 <= n <= 105
        n <= k <= 26 * n
 */

/**
 * @author Haresh Shaha
 * @since 21-Mar-2022
 */
public class Program175 {
    public static void main(String[] args) {
        int n = 5, k = 73;

        // Runtime: 58 ms	Memory: 72.2 MB
        System.out.println(getSmallestStringSlowest(n, k));

        // Runtime: 37 ms	Memory: 63.4 MB
        System.out.println(getSmallestStringSlow(n, k));

        // Runtime: 9 ms	Memory: 42.5 MB
        System.out.println(getSmallestString(n, k));
    }

    public static String getSmallestStringSlowest(int n, int k) {
        int[] values = new int[n];
        k = k - n;
        for (int i = n - 1; i >= 0; i--) {
            if (k <= 0)
                break;

            if (k >= 25) {
                values[i] += 25;
                k = k - 25;
            } else {
                values[i] += k;
                k = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append((char) (values[i] + 'a'));
        }

        return sb.toString();
    }

    public static String getSmallestStringSlow(int n, int k) {
        StringBuilder sb = new StringBuilder("a".repeat(n));
        k = k - n;
        for (int i = n - 1; i >= 0; i--) {
            if (k <= 0)
                break;

            if (k >= 25) {
                sb.setCharAt(i, 'z');
                k = k - 25;
            } else {
                sb.setCharAt(i, (char) (k + 'a'));
                k = 0;
            }
        }

        return sb.toString();
    }

    public static String getSmallestString(int n, int k) {
        char[] result = new char[n];
        k = k - n;
        for (int i = n - 1; i >= 0; i--) {
            if (k == 0) {
                result[i] = 'a';
            }

            if (k >= 25) {
                result[i] = 'z';
                k = k - 25;
            } else {
                result[i] = (char) (k + 'a');
                k = 0;
            }
        }

        return new String(result);
    }
}
