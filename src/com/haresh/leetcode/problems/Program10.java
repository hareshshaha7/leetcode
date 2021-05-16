/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	Minimum Number of Operations to Move All Balls to Each Box
	https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
	
	You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.
	In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.
	
	Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.
	Each answer[i] is calculated considering the initial state of the boxes.
	
	Example 1:
	Input: boxes = "110"
	Output: [1,1,3]
	Explanation: The answer for each box is as follows:
		1) First box: you will have to move one ball from the second box to the first box in one operation.
		2) Second box: you will have to move one ball from the first box to the second box in one operation.
		3) Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball from the second box to the third box in one operation.
	
	Example 2:
	Input: boxes = "001011"
	Output: [11,8,5,4,3,4]
	
	Constraints:
		n == boxes.length
		1 <= n <= 2000
		boxes[i] is either '0' or '1'.
 */

/**
 * @author Haresh Shaha
 * @since 16-May-2021
 *
 */
public class Program10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String boxes = "001011";
		int[] answer = minOperations(boxes);

		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	public static int[] minOperations(String boxes) {
//		int[] answer = new int[boxes.length()];
//
//		for (int i = 0; i < boxes.length(); i++) {
//			int box = Integer.parseInt(String.valueOf(boxes.charAt(i)));
//
//			if (box == 1) {
//				for (int j = 0; j < answer.length; j++) {
//					int value = Math.abs(i - j);
//					answer[j] = answer[j] + value;
//				}
//			}
//		}
//
//		return answer;

		// Faster Solution
		int[] result = new int[boxes.length()];
		char[] array = boxes.toCharArray();// to make excess to chars a little bit faster
		int Count = 0;
		int accumulativeCount = 0;
		for (int i = 0; i < boxes.length(); i++) {
			accumulativeCount += Count;
			if (array[i] == '1')
				Count++;
			result[i] = accumulativeCount;
		}
		accumulativeCount = 0;
		Count = 0;
		for (int j = boxes.length() - 1; j > -1; j--) {
			accumulativeCount += Count;
			if (array[j] == '1')
				Count++;
			result[j] += accumulativeCount;

		}
		return result;
	}

}
