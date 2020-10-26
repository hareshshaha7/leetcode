package com.haresh.leetcode.array;

/*
	Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

	Note that elements beyond the length of the original array are not written.
	
	Do the above modifications to the input array in place, do not return anything from your function.
	
	 
	
	Example 1:
	
	Input: [1,0,2,3,0,4,5,0]
	Output: null
	Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
	Example 2:
	
	Input: [1,2,3]
	Output: null
	Explanation: After calling your function, the input array is modified to: [1,2,3]
	 
	
	Note:	
	1. 1 <= arr.length <= 10000
	2. 0 <= arr[i] <= 9
 */

class Solution5 {

	public void duplicateZeros(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == 0) {
				for (int j = arr.length - 1; j > i; j--) {
					arr[j] = arr[j - 1];
				}
				i++;
			}
		}
	}

}

public class Program05 {

	public static void main(String[] args) {

		int[] input = { 1, 0, 2, 3, 0, 4, 5, 0 };
		Solution5 solution5 = new Solution5();
		solution5.duplicateZeros(input);
		for (int number : input) {
			System.out.println(number);
		}

	}

}
