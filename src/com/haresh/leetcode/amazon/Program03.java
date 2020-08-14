package com.haresh.leetcode.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	Top K Frequently Mentioned Keywords
	
	Given a list of reviews, a list of keywords and an integer k. Find the most popular k keywords in order of most to least frequently mentioned.
	
	The comparison of strings is case-insensitive.
	Multiple occurances of a keyword in a review should be considred as a single mention.
	If keywords are mentioned an equal number of times in reviews, sort alphabetically.
	
	Example 1:
	
	Input:
	k = 2
	keywords = ["anacell", "cetracular", "betacellular"]
	reviews = [
	  "Anacell provides the best services in the city",
	  "betacellular has awesome services",
	  "Best services provided by anacell, everyone should use anacell",
	]
	
	Output:
	["anacell", "betacellular"]
	
	Explanation:
	"anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.
	Example 2:
	
	Input:
	k = 2
	keywords = ["anacell", "betacellular", "cetracular", "deltacellular", "eurocell"]
	reviews = [
	  "I love anacell Best services; Best services provided by anacell",
	  "betacellular has great services",
	  "deltacellular provides much better services than betacellular",
	  "cetracular is worse than anacell",
	  "Betacellular is better than deltacellular.",
	]
	
	Output:
	["betacellular", "anacell"]
	
	Explanation:
	"betacellular" is occuring in 3 different reviews. "anacell" and "deltacellular" are occuring in 2 reviews, but "anacell" is lexicographically smaller.
 */

public class Program03 {
	public static List<String> topKFrequent(int k, String[] keywords, String[] reviews) {
		Map<String, Integer> keywordCount = new HashMap<String, Integer>();
		for (String review : reviews) {
			for (String keyword : keywords) {
				if (review.toLowerCase().contains(keyword)) {
					keywordCount.put(keyword, keywordCount.getOrDefault(keyword, 0) + 1);
				}
			}			
		}
		
		List<String> topWords = new ArrayList<String>(keywordCount.keySet());
		Collections.sort(topWords, (s1, s2) -> keywordCount.get(s1).equals(keywordCount.get(s2)) ? s1.compareTo(s2) : keywordCount.get(s2) - keywordCount.get(s1));
		return topWords.subList(0, k);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 2;
		String[] keywords = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
		String[] reviews = { 
				  "I love anacell Best services; Best services provided by anacell",
				  "betacellular has great services",
				  "deltacellular provides much better services than betacellular",
				  "cetracular is worse than anacell",
				  "Betacellular is better than deltacellular." };
		List<String> result = topKFrequent(k, keywords, reviews);
		for (String word : result) {
			System.out.println(word);
		}
	}

}
