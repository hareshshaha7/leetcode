package com.haresh.leetcode.array;

/*
	Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
	You may return any answer array that satisfies this condition.
	
	Example 1:	
	Input: [3,1,2,4]
	Output: [2,4,3,1]
	The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
	 	
	Note:	
	1 <= A.length <= 5000
	0 <= A[i] <= 5000
 */

class Solution14 {
	public int[] sortArrayByParity(int[] A) {
		int j = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0) {
				int temp = A[j];
				A[j] = A[i];
				A[i] = temp;
				j++;
			}
		}
		return A;
    }
}

public class Program14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {4,2,1,3};
		Solution14 solution14 = new Solution14();
		int[]  result = solution14.sortArrayByParity(input);
		for (int i = 0; i < result.length; i++) {
			System.out.println(input[i]);
		}
	}

}
