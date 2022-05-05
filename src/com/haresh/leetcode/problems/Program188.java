package com.haresh.leetcode.problems;

/*
    54. [Medium] Spiral Matrix
    https://leetcode.com/problems/spiral-matrix/

    Given an m x n matrix, return all elements of the matrix in spiral order.

    Example 1:
        1   2   3
        4   5   6
        7   8   9
    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    Output: [1,2,3,6,9,8,7,4,5]

    Example 2:
        1   2   3   4
        5   6   7   8
        9   10  11  12
    Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
    Output: [1,2,3,4,8,12,11,10,9,5,6,7]

    Constraints:
        m == matrix.length
        n == matrix[i].length
        1 <= m, n <= 10
        -100 <= matrix[i][j] <= 100
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author Haresh Shaha
 * @since 06-MAY-2022
 */
public class Program188 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        final List<Integer> spiralList = spiralOrder(matrix);
        System.out.println(spiralList);
    }

    enum State {LEFT, RIGHT, TOP, BOTTOM}
    public static List<Integer> spiralOrder(int[][] matrix) {
        State s = State.TOP;
        int i = 0, j = 0;
        int minRows = 0;
        int minCols = 0;
        int maxRows = matrix.length - 1;
        int maxCols = matrix[0].length - 1;
        int maxElements = (maxRows + 1) * (maxCols + 1);
        List<Integer> spiralList = new ArrayList<>();

        while (spiralList.size() < maxElements) {
            switch (s) {
                case TOP:
                    if (j <= maxCols) {
                        spiralList.add(matrix[i][j]);
                        j++;
                    } else {
                        s = State.RIGHT;
                        minRows++;
                        j--;
                        i++;
                    }
                    break;

                case RIGHT:
                    if (i <= maxRows) {
                        spiralList.add(matrix[i][j]);
                        i++;
                    } else {
                        s = State.BOTTOM;
                        maxCols--;
                        i--;
                        j--;
                    }
                    break;

                case BOTTOM:
                    if (j >= minCols) {
                        spiralList.add(matrix[i][j]);
                        j--;
                    } else {
                        s = State.LEFT;
                        maxRows--;
                        j++;
                        i--;
                    }
                    break;

                case LEFT:
                    if (i >= minRows) {
                        spiralList.add(matrix[i][j]);
                        i--;
                    } else {
                        s = State.TOP;
                        minCols++;
                        i++;
                        j++;
                    }
                    break;

                default:
                    break;
            }

        }
        return spiralList;
    }
}
