package com.haresh.leetcode.problems;

/*
    200. Number of Islands
    https://leetcode.com/problems/number-of-islands/

    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

    Example 1:
    Input: grid = [
                      ["1","1","1","1","0"],
                      ["1","1","0","1","0"],
                      ["1","1","0","0","0"],
                      ["0","0","0","0","0"]
                    ]
    Output: 1

    Example 2:
    Input: grid = [
                      ["1","1","0","0","0"],
                      ["1","1","0","0","0"],
                      ["0","0","1","0","0"],
                      ["0","0","0","1","1"]
                    ]
    Output: 3

    Constraints:
        m == grid.length
        n == grid[i].length
        1 <= m, n <= 300
        grid[i][j] is '0' or '1'.
 */

/**
 * @author Haresh Shaha
 * @since 05-Feb-2022
 */
public class Program141 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        final int numOfLands = numIslands(grid);
        System.out.println(numOfLands);
    }

    public static int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    DFSMarking(i, j, grid);
                }
            }
        }

        return result;
    }

    public static void DFSMarking(int i, int j, char[][] grid) {
        if (!isValidLocation(i, j, grid.length, grid[0].length) || grid[i][j] != '1')
            return;

        grid[i][j] = '2'; // You can even mark this as '0' i.e. water

        DFSMarking(i + 1, j, grid);
        DFSMarking(i, j + 1, grid);
        DFSMarking(i - 1, j, grid);
        DFSMarking(i, j - 1, grid);
    }

    public static boolean isValidLocation(int i, int j, int iMax, int jMax) {
        return i >= 0 && j >= 0 && i < iMax && j < jMax;
    }
}
