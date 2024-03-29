/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	74. Search a 2D Matrix
	https://leetcode.com/problems/search-a-2d-matrix/
	
	Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
	
	Integers in each row are sorted from left to right.
	The first integer of each row is greater than the last integer of the previous row.
	
	Example 1:
	Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
	Output: true
	
	Example 2:
	Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
	Output: false
	
	Constraints:
		m == matrix.length
		n == matrix[i].length
		1 <= m, n <= 100
		-104 <= matrix[i][j], target <= 104
 */

/**
 * @author Haresh Shaha
 * @since 05-Aug-2021
 *
 */
public class Program61 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		int target = 3;
		boolean search = searchMatrix(matrix, target);
		System.out.println(search);
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;

		int low = 0;
		int high = m * n - 1;

		while (low <= high) {
			int mid = (high + low) / 2;

			if (matrix[low / n][low % n] == target) {
				return true;
			}

			if (matrix[high / n][high % n] == target) {
				return true;
			}

			if (matrix[mid / n][mid % n] == target) {
				return true;
			}
			if (matrix[mid / n][mid % n] < target) {
				low = mid + 1;
			}
			if (matrix[mid / n][mid % n] > target) {
				high = mid - 1;
			}
		}

		return false;
	}
}
