/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	Integer to Roman
	https://leetcode.com/problems/integer-to-roman/

	Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
	
	Symbol       Value
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
	For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
	
	Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. 
	Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. 
	
	There are six instances where subtraction is used:
	I can be placed before V (5) and X (10) to make 4 and 9. 
	X can be placed before L (50) and C (100) to make 40 and 90. 
	C can be placed before D (500) and M (1000) to make 400 and 900.
	
	Given an integer, convert it to a roman numeral.
	
	Example 1:
	Input: num = 3
	Output: "III"
	
	Example 2:
	Input: num = 4
	Output: "IV"
	
	Example 3:
	Input: num = 9
	Output: "IX"
	
	Example 4:
	Input: num = 58
	Output: "LVIII"
	Explanation: L = 50, V = 5, III = 3.
	
	Example 5:
	Input: num = 1994
	Output: "MCMXCIV"
	Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
	
	Constraints:
		1 <= num <= 3999
 */

/**
 * @author Haresh Shaha
 * @since 29-May-2021
 *
 */
public class Program30 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 1990;
		String romanNumber = intToRoman(num);
		System.out.println(romanNumber);
		
		System.out.println(intToRomanBetter(num));
	}

	public static String intToRoman(int num) {
		String romanNumber = "";

		while (num / 1000 > 0) {
			romanNumber += "M";
			num = num - 1000;
		}
		while (num / 900 > 0) {
			romanNumber += "CM";
			num = num - 900;
		}
		while (num / 500 > 0) {
			romanNumber += "D";
			num = num - 500;
		}
		while (num / 400 > 0) {
			romanNumber += "CD";
			num = num - 400;
		}
		while (num / 100 > 0) {
			romanNumber += "C";
			num = num - 100;
		}
		while (num / 90 > 0) {
			romanNumber += "XC";
			num = num - 90;
		}
		while (num / 50 > 0) {
			romanNumber += "L";
			num = num - 50;
		}
		while (num / 40 > 0) {
			romanNumber += "XL";
			num = num - 40;
		}
		while (num / 10 > 0) {
			romanNumber += "X";
			num = num - 10;
		}
		while (num / 9 > 0) {
			romanNumber += "IX";
			num = num - 9;
		}
		while (num / 5 > 0) {
			romanNumber += "V";
			num = num - 5;
		}
		while (num / 4 > 0) {
			romanNumber += "IV";
			num = num - 4;
		}
		while (num > 0) {
			romanNumber += "I";
			num--;
		}

		return romanNumber;
	}
	
	class Pair {
		int num;
		String romanStr;
		
		public Pair(int num, String romanStr) {
			this.num = num;
			this.romanStr = romanStr;
		}
		
	}
	
	public static String intToRomanBetter(int num) {
		Pair[] pairs = new Pair[] {
				new Program30().new Pair(1000, "M"),
				new Program30().new Pair(900, "CM"),
				new Program30().new Pair(500, "D"),
				new Program30().new Pair(400, "CD"),
				new Program30().new Pair(100, "C"),
				new Program30().new Pair(90, "XC"),
				new Program30().new Pair(50, "L"),
				new Program30().new Pair(40, "XL"),
				new Program30().new Pair(10, "X"),
				new Program30().new Pair(9, "IX"),
				new Program30().new Pair(5, "V"),
				new Program30().new Pair(4, "IV"),
				new Program30().new Pair(1, "I")
				};
		
		String romanNumber = "";
		while (num > 0) {
			
			for (int i = 0; i < pairs.length; i++) {
				
				while (num >= pairs[i].num ) {
					num -= pairs[i].num;
					romanNumber += pairs[i].romanStr;
				}
			}
		}
		
		return romanNumber;
	}
}