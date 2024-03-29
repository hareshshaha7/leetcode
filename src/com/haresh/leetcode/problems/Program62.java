/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	50. Pow(x, n)
	https://leetcode.com/problems/powx-n/
	
	Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
	
	Example 1:
	Input: x = 2.00000, n = 10
	Output: 1024.00000
	
	Example 2:
	Input: x = 2.10000, n = 3
	Output: 9.26100
	
	Example 3:
	Input: x = 2.00000, n = -2
	Output: 0.25000
	Explanation: 2-2 = 1/22 = 1/4 = 0.25
	
	Constraints:
		-100.0 < x < 100.0
		-231 <= n <= 231-1
		-104 <= xn <= 104
 */

/**
 * @author Haresh Shaha
 * @since 05-Aug-2021
 *
 */
public class Program62 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double x = 2.00000;
		int n = 10;
		double pow = myPow(x, n);
		System.out.println(pow);
	}

	public static double myPow(double x, int n) {
		double result = 1;
		if (x == 1)
			return 1;

		if (n > 0) {
			while (n > 0) {
				result *= x;
				n--;
			}
		} else if (n < 0) {
			while (n < 0) {
				result /= x;
				n++;
			}
		}

		return result;
		// return Math.pow(x, n);
	}
}
