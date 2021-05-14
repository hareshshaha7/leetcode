/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	Partitioning Into Minimum Number Of Deci-Binary Numbers 
	https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
	
	A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros. 
	For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
	Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary numbers needed so that they sum up to n.
	
	Example 1:
	Input: n = "32"
	Output: 3
	Explanation: 10 + 11 + 11 = 32
	
	Example 2:
	Input: n = "82734"
	Output: 8
	
	Example 3:
	Input: n = "27346209830709182346"
	Output: 9
	 
	
	Constraints:
	1 <= n.length <= 105
	n consists of only digits.
	n does not contain any leading zeros and represents a positive integer.
	
	Logic:
	All you have to do is find the max value in the string 'n' passed as parameter. Let's take the string "32" as example.
	We know that we can have only 0's and 1's. So to make the first digit, i.e., 3, we need to sum up three 1's and to make the second digit, i.e. 2, we need two 1's (and one 0). So the answer is the max number of 1's, which is 3 in this case.
		3 2
		= =
		1 1
		1 1
		1 0

	So we will just check the maximum digit in the number as that will be the total deci-binary numbers.
		82734	11111
        71623	11111
        60512	10111
        50401	10101
        40300	10100
        30200	10100
        20100	10100
        10000	10000
 */

/**
 * @author Haresh Shaha
 * @since 14-May-2021
 *
 */
public class Program08 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String n = "82734";
		int minPartitions = minPartitions(n);
		System.out.println(minPartitions);
	}

	public static int minPartitions(String n) {
		// Regular
//		int maxDigit = 0;
//		for (int i = 0; i < n.length(); i++) {
//			int digit = Integer.parseInt(String.valueOf(n.charAt(i)));
//			if (maxDigit < digit) {
//				maxDigit = digit;
//			}
//		}
//		return maxDigit;
		
		// Shorter
		return n.chars().max().getAsInt() -'0';
	}
}
