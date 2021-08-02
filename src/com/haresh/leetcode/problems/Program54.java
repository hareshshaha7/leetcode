/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/*
	73. Set Matrix Zeroes
	https://leetcode.com/problems/set-matrix-zeroes/
	
	Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.
	
	You must do it in place.
	
	Example 1:
	Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
	Output: [[1,0,1],[0,0,0],[1,0,1]]
	
	Example 2:
	Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
	Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
	
	Constraints:
		m == matrix.length
		n == matrix[0].length
		1 <= m, n <= 200
		-231 <= matrix[i][j] <= 231 - 1
	 
	
	Follow up:
		A straightforward solution using O(mn) space is probably a bad idea.
		A simple improvement uses O(m + n) space, but still not the best solution.
		Could you devise a constant space solution?
 */

/**
 * @author Haresh Shaha
 * @since 02-Aug-2021
 *
 */
public class Program54 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		setZeroes(matrix);
		
		for (int[] m : matrix) {
			System.out.println();
			for (int n : m) {
				System.out.print(n + " ");
			}
		}
	}

	public static void setZeroes(int[][] matrix) {

		List<int[]> row_zero = new ArrayList<>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row_zero.add(new int[] { i, j });
				}
			}
		}

		for (int[] num : row_zero) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[num[0]][i] = 0;
			}

			for (int i = 0; i < matrix.length; i++) {
				matrix[i][num[1]] = 0;
			}
		}
	}

}
