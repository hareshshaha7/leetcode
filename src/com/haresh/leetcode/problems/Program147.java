package com.haresh.leetcode.problems;

/*
    258. Add Digits
    https://leetcode.com/problems/add-digits/

    Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

    Example 1:
    Input: num = 38
    Output: 2
    Explanation: The process is
        38 --> 3 + 8 --> 11
        11 --> 1 + 1 --> 2
        Since 2 has only one digit, return it.

    Example 2:
    Input: num = 0
    Output: 0

    Constraints:
        0 <= num <= 231 - 1

    Follow up: Could you do it without any loop/recursion in O(1) runtime?
 */

/**
 * @author Haresh Shaha
 * @since 08-Feb-2022
 */
public class Program147 {
    public static void main(String[] args) {
        int num = 38;
        System.out.println(addDigits1(num));
        System.out.println(addDigits2(num));
    }

    public static int addDigits1(int num) {
        // Recursive way
        int sum = 0;
        while (num > 9) {
            sum += num % 10;
            num = num / 10;
        }

        num = sum + num;
        if (num < 10)
            return num;
        else
            return addDigits1(num);

    }

    public static int addDigits2(int num) {
        // Mathematical: Digital Root
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;

    }
}
