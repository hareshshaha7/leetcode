package com.haresh.leetcode.amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
	Partition Labels
	
	A string S of lowercase English letters is given. 
	We want to partition this string into as many parts as possible 
	so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
	
	Example 1:
	Input: S = "ababcbacadefegdehijhklij"
	Output: [9,7,8]
	Explanation:
	The partition is "ababcbaca", "defegde", "hijhklij".
	This is a partition so that each letter appears in at most one part.
	A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
	 
	Note:
	S will have length in range [1, 500].
	S will consist of lowercase English letters ('a' to 'z') only.
 */

public class Program11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "ababcbacadefegdehijhklij";
		List<Integer> partitionLabelsCount = partitionLabels(input);
		System.out.println(partitionLabelsCount);
	}

	public static List<Integer> partitionLabels(String S) {
		List<Integer> partitionLabelsCount = new ArrayList<Integer>();
		int i = 0;
		
		while (i < S.length()) {
			char ch = S.charAt(i);
			int length = S.lastIndexOf(ch);
			Set<Character> charSet = new HashSet<Character>();
		
			for (int j = i; j < length; j++) {
				if (charSet.add(S.charAt(j)) && S.lastIndexOf(S.charAt(j)) > length)
					length = S.lastIndexOf(S.charAt(j));
			}
			
			System.out.println(S.substring(i, length + 1));
			partitionLabelsCount.add(length - i + 1);
			i = length + 1;
		}
		return partitionLabelsCount;
	}

}
