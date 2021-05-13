/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/*
	Jewels and Stones
	https://leetcode.com/problems/jewels-and-stones/
	
	You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
	Letters are case sensitive, so "a" is considered a different type of stone from "A".
	
	Example 1:
	Input: jewels = "aA", stones = "aAAbbbb"
	Output: 3
	
	Example 2:
	Input: jewels = "z", stones = "ZZ"
	Output: 0
	
	Constraints:
	1 <= jewels.length, stones.length <= 50
	jewels and stones consist of only English letters.
	All the characters of jewels are unique.
 */

/**
 * @author Haresh Shaha
 * @since 13-May-2021
 *
 */
public class Program07 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String jewels = "a", stones = "AA";
		int numberOfJewels = numJewelsInStones(jewels, stones);
		System.out.println(numberOfJewels);
	}

	public static int numJewelsInStones(String jewels, String stones) {
		int numberOfJewels = 0;
		Map<Character, Integer> jewelsCount = new HashMap<Character, Integer>();

		for (int i = 0; i < stones.length(); i++) {
			int count = jewelsCount.getOrDefault(stones.charAt(i), 0);
			jewelsCount.put(stones.charAt(i), ++count);
		}

		for (int i = 0; i < jewels.length(); i++) {
			numberOfJewels += jewelsCount.getOrDefault(jewels.charAt(i), 0);
		}
		return numberOfJewels;
	}
}
