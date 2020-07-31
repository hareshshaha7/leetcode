package com.haresh.leetcode.array;

/*
 	Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
	After doing so, return the array.
		
	Example 1:
	Input: arr = [17,18,5,4,6,1]
	Output: [18,6,6,6,1,-1]
	 
	Constraints:
	1 <= arr.length <= 10^4
	1 <= arr[i] <= 10^5
 */

class Solution11 {
	public int[] replaceElements(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int maxValue = 0;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > maxValue)
					maxValue = arr[j];
			}
			arr[i] = maxValue;
		}
		arr[arr.length - 1] = -1;
		return arr;

		/*
		// Best Solution
		int maxValue = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			int temp = arr[i];
			arr[i] = maxValue;
			if (maxValue < temp) {
				maxValue = temp;
			}
		}
		arr[arr.length - 1] = -1;
		return arr;
		*/
	}
}

public class Program11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 17, 18, 5, 4, 6, 1 };

		Solution11 solution11 = new Solution11();
		int[] result = solution11.replaceElements(input);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
