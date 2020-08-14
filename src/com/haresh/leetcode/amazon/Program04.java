package com.haresh.leetcode.amazon;

import java.util.LinkedList;
import java.util.Queue;

/*
	Rotten Oranges
	
	In a given grid, each cell can have one of three values:
	the value 0 representing an empty cell;
	the value 1 representing a fresh orange;
	the value 2 representing a rotten orange.
	Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
	Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
		
	Example 1:	
	Input: [[2,1,1],[1,1,0],[0,1,1]]
	Output: 4
	
	Example 2:
	Input: [[2,1,1],[0,1,1],[1,0,1]]
	Output: -1
	Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
	
	Example 3:	
	Input: [[0,2]]
	Output: 0
	Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
		
	Note:
	1 <= grid.length <= 10
	1 <= grid[0].length <= 10
	grid[i][j] is only 0, 1, or 2.
 */

public class Program04 {
	public static int orangesRotting(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		int rows = grid.length;
		int columns = grid[0].length;
		int freshOranges = 0;
		Queue<int[]> rottenOranges = new LinkedList<int[]>();

		// Put the position of all rotten oranges in queue
		// count the number of fresh oranges
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (grid[i][j] == 1) {
					freshOranges++;
				} else if (grid[i][j] == 2) {
					rottenOranges.offer(new int[] { i, j });
				}
			}
		}

		// if count of fresh oranges is zero --> return 0
		if (freshOranges == 0)
			return 0;

		int minutes = 0;
		int[][] adjacentSides = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		// bfs starting from initially rotten oranges
		while (!rottenOranges.isEmpty()) {
			minutes++;

			for (int i = 0; i < rottenOranges.size(); i++) {
				int[] rottenOrange = rottenOranges.poll();

				for (int[] adjacentSide : adjacentSides) {
					int x = rottenOrange[0] + adjacentSide[0];
					int y = rottenOrange[1] + adjacentSide[1];

					// if x or y is out of bound
					// or the orange at (x , y) is already rotten
					// or the cell at (x , y) is empty
					// we do nothing
					if (x < 0 || y < 0 || x >= rows || y >= columns || grid[x][y] == 2 || grid[x][y] == 0) {
						continue;
					}

					// mark the orange at (x , y) as rotten
					grid[x][y] = 2;

					// put the new rotten orange at (x , y) in queue
					rottenOranges.offer(new int[] { x, y });

					// decrease the count of fresh oranges by 1
					freshOranges--;
				}
			}
		}

		return freshOranges == 0 ? minutes - 1 : -1;
	}

	public static void main(String[] args) {
		int[][] input = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int result = orangesRotting(input);
		System.out.println(result);
	}

}
