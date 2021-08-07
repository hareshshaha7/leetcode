/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	62. Unique Paths
	https://leetcode.com/problems/unique-paths/
	
	A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
	
	The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
	
	How many possible unique paths are there?
	
	Example 1:
	Input: m = 3, n = 7
	Output: 28
	
	Example 2:
	Input: m = 3, n = 2
	Output: 3
	Explanation:
		From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
		1. Right -> Down -> Down
		2. Down -> Down -> Right
		3. Down -> Right -> Down
	
	Example 3:
	Input: m = 7, n = 3
	Output: 28
	
	Example 4:
	Input: m = 3, n = 3
	Output: 6
	 
	Constraints:
		1 <= m, n <= 100
		It's guaranteed that the answer will be less than or equal to 2 * 109.
 */

/**
 * @author Haresh Shaha
 * @since 07-Aug-2021
 *
 */
public class Program65 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int m = 7, n = 3;

//		 Explanation
//		for, m = 3, n = 2
//
//		Start	0
//		0		0
//		0		End
//		
//		1	0		1	1		1	1		1	1
//		0	0	->	1	0	->	1	2	->	1	2
//		0	0		0	0		1	0		1	3

		int paths = uniquePaths(m, n);
		System.out.println(paths);
	}

	public static int uniquePaths(int m, int n) {
		int[][] grid = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0)
					grid[i][j] = 1;
				else
					grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
			}
		}

		return grid[m - 1][n - 1];
	}

}
