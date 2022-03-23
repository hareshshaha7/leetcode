package com.haresh.leetcode.problems;

/*
    991. [Medium] Broken Calculator
    https://leetcode.com/problems/broken-calculator/

    There is a broken calculator that has the integer startValue on its display initially. In one operation, you can:

    multiply the number on display by 2, or
    subtract 1 from the number on display.
    Given two integers startValue and target, return the minimum number of operations needed to display target on the calculator.

    Example 1:
    Input: startValue = 2, target = 3
    Output: 2
    Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.

    Example 2:
    Input: startValue = 5, target = 8
    Output: 2
    Explanation: Use decrement and then double {5 -> 4 -> 8}.

    Example 3:
    Input: startValue = 3, target = 10
    Output: 3
    Explanation: Use double, decrement and double {3 -> 6 -> 5 -> 10}.

    Constraints: 1 <= x, y <= 109
 */

/**
 * @author Haresh Shaha
 * @since 23-Mar-2022
 */
public class Program176 {
    public static void main(String[] args) {
        int startValue = 3, target = 10;
        int operations = brokenCalc(startValue, target);
        System.out.println(operations);
    }

    public static int brokenCalc(int startValue, int target) {
        int ans = 0;
        while (target > startValue) {
            ans++;
            if (target % 2 == 1)
                target++;
            else
                target /= 2;
        }

        return ans + startValue - target;
    }
}
