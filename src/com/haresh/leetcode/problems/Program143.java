package com.haresh.leetcode.problems;

/*
    695. Max Area of Island
    https://leetcode.com/problems/max-area-of-island/

    You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
    (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

    The area of an island is the number of cells with a value 1 in the island.

    Return the maximum area of an island in grid. If there is no island, return 0.

    Example 1:
            0 0 1 0 0 0 0 1 0 0 0 0 0
            0 0 0 0 0 0 0 1 1 1 0 0 0
            0 1 1 0 1 0 0 0 0 0 0 0 0
            0 1 0 0 1 1 0 0 1 0 1 0 0
            0 1 0 0 1 1 0 0 1 1 1 0 0
            0 0 0 0 0 0 0 0 0 0 1 0 0
            0 0 0 0 0 0 0 1 1 1 0 0 0
            0 0 0 0 0 0 0 1 1 0 0 0 0
    Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
    Output: 6
    Explanation: The answer is not 11, because the island must be connected 4-directionally.

    Example 2:
    Input: grid = [[0,0,0,0,0,0,0,0]]
    Output: 0

    Constraints:
        m == grid.length
        n == grid[i].length
        1 <= m, n <= 50
        grid[i][j] is either 0 or 1.
 */

/**
 * @author Haresh Shaha
 * @since 05-Feb-2022
 */
public class Program143 {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        final int maxArea = maxAreaOfIsland(grid);
        System.out.println(maxArea);
    }

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0)
            return 0;

        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int area = getArea(i, j, grid, 0);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    public static int getArea(int i, int j, int[][] grid, int area) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        if (grid[i][j] == 1) {
            area++;
            grid[i][j] = 2;
        }

        return getArea(i + 1, j, grid, area) +
                getArea(i, j + 1, grid, area) +
                getArea(i - 1, j, grid, area) +
                getArea(i, j - 1, grid, area) + 1;
    }
}
