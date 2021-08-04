/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	48. Rotate Image
	https://leetcode.com/problems/rotate-image/
	
	You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
	
	You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
	
	Example 1:
		1 2 3		7 4 1
		4 5 6	->	8 5 2
		7 8 9		9 6 3
	Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
	Output: [[7,4,1],[8,5,2],[9,6,3]]
	
	Example 2:
		5	1	9	11		15	13	2	5
		2	4	8	10	->	14	3	4	1
		13	2	6	7		12	6	8	9
		15	14	12	16		16	7	10	11
	Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
	Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
	
	Example 3:
		1	->	1
	Input: matrix = [[1]]
	Output: [[1]]
	
	Example 4:
		1	2	->	3	1
		3	4		4	2
	Input: matrix = [[1,2],[3,4]]
	Output: [[3,1],[4,2]]
	
	Constraints:
		matrix.length == n
		matrix[i].length == n
		1 <= n <= 20
		-1000 <= matrix[i][j] <= 1000
 */

/**
 * @author Haresh Shaha
 * @since 04-Aug-2021
 *
 */
public class Program60 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		printMatrix(matrix);
		rotate(matrix);
		printMatrix(matrix);

		int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		printMatrix(matrix1);
		rotateSimple(matrix1);
		printMatrix(matrix1);
	}

	private static void printMatrix(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			System.out.println();
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
		}
		System.out.println();
	}

	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < (n + 1) / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
				matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
	}

	public static void rotateSimple(int[][] matrix) {
		transpose(matrix);
		reverse(matrix);
	}

	public static void transpose(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	public static void reverse(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = temp;
			}
		}
	}

}
