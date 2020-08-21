package com.haresh.leetcode.amazon;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/*
	Treasure Island
	
	You have a map that marks the location of a treasure island. 
	Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in. 
	There are other explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.
	
	Assume the map area is a two dimensional grid, represented by a matrix of characters. 
	You must start from the top-left corner of the map and can move one block up, down, left or right at a time. 
	The treasure island is marked as X in a block of the matrix. X will not be at the top-left corner.
	Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks. 
	You cannot leave the map area. Other areas O are safe to sail in. The top-left corner is always safe. 
	Output the minimum number of steps to get to the treasure.
	
	Example:
	
	Input:
	[['O', 'O', 'O', 'O'],
	 ['D', 'O', 'D', 'O'],
	 ['O', 'O', 'O', 'O'],
	 ['X', 'D', 'D', 'O']]
	Output: 5
	Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
 */
class Program15 {

	public static void main(String[] args) {
		char[][] grid = { { 'O', 'O', 'O', 'O' }, { 'D', 'O', 'D', 'O' }, { 'O', 'O', 'O', 'O' },
				{ 'X', 'D', 'D', 'O' } };
		int steps = minSteps(grid);
		System.out.println(steps);
	}

	private static final int[][] DIRS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static int minSteps(char[][] grid) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { 0, 0 });
		grid[0][0] = 'D';
		int steps = 0;
		while (!q.isEmpty()) {
			steps++;
			int length = q.size();

			for (int i = 0; i < length; i++) {
				int[] point = q.poll();

				for (int j = 0; j < DIRS.length; j++) {
					int x = point[0] + DIRS[j][0];
					int y = point[1] + DIRS[j][1];

					if (validPoint(x, y, grid)) {
						if (grid[x][y] == 'X')
							return steps;
						grid[x][y] = 'D';
						q.offer(new int[] { x, y });
					}
				}
			}
		}

		return -1;
	}

	private static boolean validPoint(int x, int y, char[][] grid) {
		return (x >= 0) && (y >= 0) && (x < grid.length) && (y < grid[0].length) && (grid[x][y] != 'D');
	}

}
