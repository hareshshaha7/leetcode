/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.Arrays;

/*
	ZigZag Conversion
	https://leetcode.com/problems/zigzag-conversion/

	The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
		P   A   H   N
		A P L S I I G
		Y   I   R
	And then read line by line: "PAHNAPLSIIGYIR"
	
	Write the code that will take a string and make this conversion given a number of rows:
	string convert(string s, int numRows);
	
	Example 1:
	Input: s = "PAYPALISHIRING", numRows = 3
	Output: "PAHNAPLSIIGYIR"
	
	Example 2:
	Input: s = "PAYPALISHIRING", numRows = 4
	Output: "PINALSIGYAHRPI"
	Explanation:
		P     I     N
		A   L S   I G
		Y A   H R
		P     I
	
	Example 3:
	Input: s = "A", numRows = 1
	Output: "A"

	Constraints:	
		1 <= s.length <= 1000
		s consists of English letters (lower-case and upper-case), ',' and '.'.
		1 <= numRows <= 1000 
 */

/**
 * @author Haresh Shaha
 * @since 25-May-2021
 *
 */
public class Program24 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 2;

		/*
		 * LOGIC: P 1 A 2 Y 3 P 4 A 3 L 2 I 1 S 2 H 3 I 4 R 3 I 2 N 1 G 2
		 */

		String converted = convert(s, numRows);
		System.out.println(converted);
	}

	public static String convert(String s, int numRows) {
		String converted = "";
		String[] rowWiseAllocation = new String[numRows];
		Arrays.fill(rowWiseAllocation, "");

		int counter = 0;
		while (counter < s.length()) {

			// Go downwards
			for (int i = 0; i < numRows && counter < s.length(); i++) {
				rowWiseAllocation[i] += s.charAt(counter);
				counter++;
			}

			// Go upwards
			for (int i = numRows - 2; i > 0 && counter < s.length(); i--) {
				rowWiseAllocation[i] += s.charAt(counter);
				counter++;
			}
		}

		for (int i = 0; i < rowWiseAllocation.length; i++) {
			converted += rowWiseAllocation[i];
		}

		return converted;
	}

}
