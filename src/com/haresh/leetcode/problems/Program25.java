/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	Reverse Integer
	https://leetcode.com/problems/reverse-integer/

	Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
	Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
	
	Example 1:
	Input: x = 123
	Output: 321
	
	Example 2:
	Input: x = -123
	Output: -321
	
	Example 3:
	Input: x = 120
	Output: 21
	
	Example 4:
	Input: x = 0
	Output: 0
	
	Constraints:
		-231 <= x <= 231 - 1
 */

/**
 * @author Haresh Shaha
 * @since 25-May-2021
 *
 */
public class Program25 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = -2147483641;
		int reversedNumber = reverse(x);
		System.out.println(reversedNumber);
	}

	public static int reverse(int x) {
//		int reversedNumber = 0;
//		String reversedString = "";
//		
//		boolean isNegative = x < 0 ? true : false;
//		x = isNegative ? x * -1 : x;
//		
//		while (x != 0) {
//			reversedString += String.valueOf(x % 10);
//			x = x / 10;
//		}
//		
//		try {
//			reversedString = isNegative ? "-" + reversedString : reversedString;
//			reversedNumber = Integer.parseInt(reversedString);
//		} catch (NumberFormatException e) {
//			reversedNumber = 0;
//		}
//		
//		return reversedNumber;
		
		// Faster Approach
		int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
	}
}
