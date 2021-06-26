/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Queue;

/*
	576. Out of Boundary Paths
	https://leetcode.com/problems/out-of-boundary-paths/
	
	There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent four cells in the grid 
	(possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.
	
	Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.
	
	Example 1:
	Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
	Output: 6
	
	Example 2:
	Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
	Output: 12
	 
	Constraints:
		1 <= m, n <= 50
		0 <= maxMove <= 50
		0 <= startRow <= m
		0 <= startColumn <= n
 */

/**
 * @author Haresh Shaha
 * @since 26-Jun-2021
 *
 */
public class Program48 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int m = 7, n = 6, maxMove = 13, startRow = 0, startColumn = 2;
		int paths = findPaths(m, n, maxMove, startRow, startColumn);
		System.out.println(paths);
	}

	public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		int paths = 0;
		int M = 1000000007;
		Queue<Integer[]> yetToScan = new ArrayDeque<>();
		int[][] possibleDirections = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

		yetToScan.add(new Integer[] { startRow, startColumn });
		while (!yetToScan.isEmpty() && maxMove != 0) {
			int count = yetToScan.size();
			maxMove--;

			for (int i = 0; i < count; i++) {
				Integer[] currentPosition = yetToScan.poll();

				for (int j = 0; j < possibleDirections.length; j++) {
					startRow = currentPosition[0] + possibleDirections[j][0];
					startColumn = currentPosition[1] + possibleDirections[j][1];

					if (startRow < 0 || startRow == m || startColumn < 0 || startColumn == n) {
						paths++;
					} else {
						yetToScan.add(new Integer[] { startRow, startColumn });
					}
				}
			}
		}

		return paths % M;
	}
}
