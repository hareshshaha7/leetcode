package com.haresh.leetcode.problems;

/*
    70. [Easy] Climbing Stairs
    https://leetcode.com/problems/climbing-stairs/

    You are climbing a staircase. It takes n steps to reach the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    Example 1:
    Input: n = 2
    Output: 2
    Explanation: There are two ways to climb to the top.
        1. 1 step + 1 step
        2. 2 steps

    Example 2:
    Input: n = 3
    Output: 3
    Explanation: There are three ways to climb to the top.
        1. 1 step + 1 step + 1 step
        2. 1 step + 2 steps
        3. 2 steps + 1 step

    Constraints: 1 <= n <= 45
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author Haresh Shaha
 * @since 15-Feb-2022
 */
public class Program157 {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(climbStairs1(n));
        System.out.println(climbStairs2(n));
        System.out.println(climbStairs3(n));
        System.out.println(climbStairs4(n));

        n = 45;
        System.out.println(climbStairs1(n));
        System.out.println(climbStairs2(n));
        System.out.println(climbStairs3(n));
        System.out.println(climbStairs4(n));
    }

    /**
     * Recursion (Top Down Approach)
     * <p>
     * Question   : Climbing Stairs
     * Complexity : Time: O(2^n) ; Space: O(n)
     */
    public static int climbStairs1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    /**
     * Recursion + Memorization (Top Down Approach)
     * <p>
     * Question   : Climbing Stairs
     * Complexity : Time: O(n) ; Space: O(n)
     */
    public static int climbStairs2(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1, 1);
        memo.put(2, 2);
        return climbStairs2(n, memo);
    }

    private static int climbStairs2(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, climbStairs2(n - 1, memo) + climbStairs2(n - 2, memo));
        return memo.get(n);
    }

    /**
     * DP (Bottom Up Approach)
     * <p>
     * Question   : Climbing Stairs
     * Complexity : Time: O(n) ; Space: O(n)
     */
    public static int climbStairs3(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }


    /**
     * DP + Optimization (Bottom Up Approach)
     * To calculate the new value we only leverage the previous two values.
     * So we don't need to use an array to store all the previous values.
     * <p>
     * Question   : Climbing Stairs
     * Complexity : Time: O(n) ; Space: O(1)
     */
    public static int climbStairs4(int n) {
        if (n <= 1) {
            return 1;
        }

        int prev1 = 1;
        int prev2 = 2;

        for (int i = 3; i <= n; i++) {
            int newValue = prev1 + prev2;
            prev1 = prev2;
            prev2 = newValue;
        }

        return prev2;
    }
}
