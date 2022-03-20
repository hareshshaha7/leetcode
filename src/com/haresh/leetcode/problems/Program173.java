package com.haresh.leetcode.problems;

/*
    1007. [Medium] Minimum Domino Rotations For Equal Row

    In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino.
    (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
    We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.

    Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.
    If it cannot be done, return -1.

    Example 1:
    Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
    Output: 2
    Explanation:
    The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
    If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.

    Example 2:
    Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
    Output: -1
    Explanation:
    In this case, it is not possible to rotate the dominoes to make one row of values equal.

    Constraints:
        2 <= tops.length <= 2 * 104
        bottoms.length == tops.length
        1 <= tops[i], bottoms[i] <= 6
 */

/**
 * @author Haresh Shaha
 * @since 20-Mar-2022
 */
public class Program173 {
    public static void main(String[] args) {
        int[] tops = {2, 1, 2, 4, 2, 2}, bottoms = {5, 2, 6, 2, 3, 2};
        int numberOfSwaps = minDominoRotations(tops, bottoms);
        System.out.println(numberOfSwaps);
    }

    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int length = tops.length;
        int[] topCount = new int[6];
        int[] bottomCount = new int[6];

        int common = 0;
        for (int i = 0; i < length; i++) {
            topCount[tops[i] - 1]++;
            if (bottoms[i] != tops[i])
                bottomCount[bottoms[i] - 1]++;
            else
                common++;
        }

        boolean canBeDone = false;
        int doneWith = 0;
        for (int i = 0; i < 6; i++) {
            if (topCount[i] + bottomCount[i] >= length) {
                canBeDone = true;
                doneWith = i;
                break;
            }
        }

        if (!canBeDone)
            return -1;

        return Math.min(length - topCount[doneWith], length - common - bottomCount[doneWith]);
    }
}
