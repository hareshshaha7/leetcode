package com.haresh.leetcode.amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
	Given a string s and an int k, return all unique substrings of s of size k with k distinct characters.
	
	Example 1:	
	Input: s = "abcabc", k = 3
	Output: ["abc", "bca", "cab"]
	
	Example 2:
	Input: s = "abacab", k = 3
	Output: ["bac", "cab"]
	
	Example 3:
	Input: s = "awaglknagawunagwkwagl", k = 4
	Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
	Explanation: 
	Substrings in order are: "wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag", "wagl" 
	"wagl" is repeated twice, but is included in the output once.
	Constraints:
	
	The input string consists of only lowercase English letters [a-z]
	0 ≤ k ≤ 26 
 */

public class Program08 {

	public static void main(String[] args) {
		String s = "awaglknagawunagwkwagl";
		int k = 4;
		List<String> listUniqueSubstrings = getUniquenSubStrings(s, k);
		for (String subString : listUniqueSubstrings) {
			System.out.println(subString);
		}
	}

	private static List<String> getUniquenSubStrings(String s, int k) {
		List<String> subString = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {	
			Set<Character> uniqueChars = new HashSet<Character>();
			String uniqueString = "";  
			
			for (int j = i; j < i + k && j < s.length(); j++) {
				char ch = s.charAt(j);
				if (uniqueChars.contains(ch)) {
					uniqueString = null;
					break; 
				}
				uniqueChars.add(ch);
				uniqueString += ch;
			}
			
			if (uniqueString != null && !subString.contains(uniqueString) && uniqueString.length() == k) {
				subString.add(uniqueString); 
			}			
		}
		return subString;
	}

}
