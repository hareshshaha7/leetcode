package com.haresh.leetcode.problems;

/*
    735. Asteroid Collision
    https://leetcode.com/problems/asteroid-collision/

    We are given an array asteroids of integers representing asteroids in a row.

    For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left).
    Each asteroid moves at the same speed.

    Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
    If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

    Example 1:
    Input: asteroids = [5,10,-5]
    Output: [5,10]
    Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

    Example 2:
    Input: asteroids = [8,-8]
    Output: []
    Explanation: The 8 and -8 collide exploding each other.

    Example 3:
    Input: asteroids = [10,2,-5]
    Output: [10]
    Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

    Constraints:
        2 <= asteroids.length <= 104
        -1000 <= asteroids[i] <= 1000
        asteroids[i] != 0
 */

import java.util.Stack;

/**
 * @author Haresh Shaha
 * @since 20-Jan-2022
 */
public class Program128 {
    public static void main(String[] args) {
        int[] asteroids = {10, 2, -5};
        int[] remainingAsteroid = asteroidCollision(asteroids);
        for (int asteroid : remainingAsteroid)
            System.out.print(asteroid + " ");
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int ast : asteroids) {
            collision:
            {
                while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
                    if (stack.peek() < -ast) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -ast) {
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(ast);
            }
        }

        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }
}
