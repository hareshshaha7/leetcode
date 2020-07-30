package com.haresh.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/*
	Given an array A of integers, return true if and only if it is a valid mountain array.
	Recall that A is a mountain array if and only if:
	
	A.length >= 3
	There exists some i with 0 < i < A.length - 1 such that:
	A[0] < A[1] < ... A[i-1] < A[i]
	A[i] > A[i+1] > ... > A[A.length - 1]
	
	
	Example 1:

	Input: [2,1]
	Output: false
	Example 2:
	
	Input: [3,5,5]
	Output: false
	Example 3:
	
	Input: [0,3,2,1]
	Output: true
	 
	
	Note:
	0 <= A.length <= 10000
	0 <= A[i] <= 10000 
 */

class Solution10 {
	public boolean validMountainArray(int[] A) {
		if (A.length < 3)
			return false;
		boolean strictlyIncreasing = true;
		for (int i = 0; i < A.length - 1; i++) {
			if (strictlyIncreasing && A[i] > A[i + 1]) {
				if (i == 0)
					return false;
				strictlyIncreasing = false;
			} 
			else if (!strictlyIncreasing && A[i] < A[i + 1])
				return false;
			else if (A[i] == A[i + 1])
				return false;
		}
		if (!strictlyIncreasing)
			return true;
		return false;

		/*
		// Best Solution
		int max = -1;
		int i = 0;
		for (int j = 0; j < A.length; j++) {
			if (max < A[j]) {
				max = A[j];
				i = j;
			}
			else
				break;
		}
		if (i==0 || i==A.length - 1)
			return false;
		for (; i < A.length - 1; i++) {
			if (A[i] <= A[i+1]) 
				return false;
		}
		return true;
	}
	*/	
		
}

public class Program10 {

	public static void main(String[] args) {

		int[] input = { 3,5, 5};
		Solution10 solution10 = new Solution10();
		Boolean result = solution10.validMountainArray(input);
		System.out.println(result);
	}

}
