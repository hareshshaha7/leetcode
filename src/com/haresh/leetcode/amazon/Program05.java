package com.haresh.leetcode.amazon;

import java.util.LinkedList;
import java.util.Queue;

/*
 	Zombie in Matrix
 	 
  	Given a 2D grid, each cell is either a zombie 1 or a human 0. 
  	Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour. 
  	Find out how many hours does it take to infect all humans?
	
	Example:
	
	Input:
	[[0, 1, 1, 0, 1],
	 [0, 1, 0, 1, 0],
	 [0, 0, 0, 0, 1],
	 [0, 1, 0, 0, 0]]
	Output: 2
	
	Explanation:
	At the end of the 1st hour, the status of the grid:
	[[1, 1, 1, 1, 1],
	 [1, 1, 1, 1, 1],
	 [0, 1, 0, 1, 1],
	 [1, 1, 1, 0, 1]]
	
	At the end of the 2nd hour, the status of the grid:
	[[1, 1, 1, 1, 1],
	 [1, 1, 1, 1, 1],
	 [1, 1, 1, 1, 1],
	 [1, 1, 1, 1, 1]]
*/

public class Program05 {
	public static int minHours(int rows, int columns, int[][] grid) {

		if (rows == 0 || columns == 0)
			return 0;

		Queue<int[]> zombies = new LinkedList<int[]>();
		int humans = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (grid[i][j] == 1)
					zombies.offer(new int[] { i, j });
				else
					humans++;
			}
		}

		int[][] adjacentSides = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int hours = 0;
		if (humans == 0)
			return 0;

		while (!zombies.isEmpty() && humans != 0) {
			hours++;
			int size = zombies.size();

			for (int i = 0; i < size; i++) {
				int[] zombie = zombies.poll();
				for (int[] adjacentSide : adjacentSides) {
					int x = zombie[0] + adjacentSide[0];
					int y = zombie[1] + adjacentSide[1];

					if (x < 0 || y < 0 || x >= rows || y >= columns || grid[x][y] == 1)
						continue;

					grid[x][y] = 1;
					zombies.offer(new int[] { x, y });
					humans--;
				}
			}
		}

		return humans == 0 ? hours : -1;
	}

	public static void main(String[] args) {

		int[][] input = new int[][] { { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };

		int rows = input.length;
		int columns = input[0].length;
		int result = minHours(rows, columns, input);
		System.out.println(result);
	}
}
