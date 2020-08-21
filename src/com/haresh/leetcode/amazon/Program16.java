package com.haresh.leetcode.amazon;

import java.util.ArrayDeque;
import java.util.Queue;

/*
	Treasure Island II
	
	You have a map that marks the locations of treasure islands. Some of the map area has jagged rocks and dangerous reefs. 
	Other areas are safe to sail in. There are other explorers trying to find the treasure. 
	So you must figure out a shortest route to one of the treasure islands.
	
	Assume the map area is a two dimensional grid, represented by a matrix of characters. 
	You must start from one of the starting point (marked as S) of the map and can move one block up, down, left or right at a time. 
	The treasure island is marked as X. Any block with dangerous rocks or reefs will be marked as D. 
	You must not enter dangerous blocks. You cannot leave the map area. Other areas O are safe to sail in. 
	Output the minimum number of steps to get to any of the treasure islands.
	
	Example:
	
	Input:
	[['S', 'O', 'O', 'S', 'S'],
	 ['D', 'O', 'D', 'O', 'D'],
	 ['O', 'O', 'O', 'O', 'X'],
	 ['X', 'D', 'D', 'O', 'O'],
	 ['X', 'D', 'D', 'D', 'O']]
	Output: 3
	Explanation:
	You can start from (0,0), (0, 3) or (0, 4). The treasure locations are (2, 4) (3, 0) and (4, 0). 
	Here the shortest route is (0, 3), (1, 3), (2, 3), (2, 4).
 */

public class Program16 {

	public static void main(String[] args) {
		char[][] grid = { { 'S', 'O', 'O', 'S', 'S' }, { 'D', 'O', 'D', 'O', 'D' }, { 'O', 'O', 'O', 'O', 'X' },
				{ 'X', 'D', 'D', 'O', 'O' }, { 'X', 'D', 'D', 'D', 'O' } };

		int steps = minSteps(grid);
		System.out.println(steps);
	}

	private static final int[][] DIRS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static int minSteps(char[][] grid) {
		int totalTreasures = 0;
		Queue<int[]> startPoints = new ArrayDeque<int[]>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 'S')
					startPoints.offer(new int[] { i, j });
				else if (grid[i][j] == 'X')
					totalTreasures++;
			}
		}
		
		if (totalTreasures == 0)
			return 0;
		
		int steps = 0;
		while(!startPoints.isEmpty()) {
			int length = startPoints.size();
			steps++;
			
			for (int i = 0; i < length; i++) {
				int[] point = startPoints.poll();
				grid[point[0]][point[1]] = 'D';
				
				for (int j = 0; j < DIRS.length; j++) {
					int x = DIRS[j][0] + point[0];
					int y = DIRS[j][1] + point[1];
					
					if (isValidPint(x, y, grid)) {
						if (grid[x][y] == 'X')
							return steps;
						startPoints.offer(new int[] { x, y });
					}
				}
			}
		}

		return -1;
	}

	private static boolean isValidPint(int x, int y, char[][] grid) {
		return (x>=0) && (y>=0) && (x< grid.length) && (y< grid.length) && (grid[x][y] != 'D');
	}
}
