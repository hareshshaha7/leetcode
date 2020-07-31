package com.haresh.leetcode.array;

import java.util.Arrays;

/*
	Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.
 */

class Solution15 {
	public int[] sortedSquares(int[] A) {
		for (int i = 0; i < A.length; i++) {
			A[i] = A[i] * A[i];
		}
		Arrays.sort(A);
		return A;
    }
}

public class Program15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {-4,-1,0,3,10};
		Solution15 solution15 = new Solution15();
		int[]  result = solution15.sortedSquares(input);
		for (int i = 0; i < result.length; i++) {
			System.out.println(input[i]);
		}
	}

}
