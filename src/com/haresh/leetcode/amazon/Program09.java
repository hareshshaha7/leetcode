package com.haresh.leetcode.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
	Given an array of strings products and a string searchWord. 
	We want to design a system that suggests at most three product names from products after each character of searchWord is typed. 
	Suggested products should have common prefix with the searchWord. 
	If there are more than three products with a common prefix return the three lexicographically minimums products.
	
	Return list of lists of the suggested products after each character of searchWord is typed. 
		
	Example 1:
	Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
	Output: [
	["mobile","moneypot","monitor"],
	["mobile","moneypot","monitor"],
	["mouse","mousepad"],
	["mouse","mousepad"],
	["mouse","mousepad"]
	]
	Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
	After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
	After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
	
	Example 2:
	Input: products = ["havana"], searchWord = "havana"
	Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
	
	Example 3:
	Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
	Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
	
	Example 4:
	Input: products = ["havana"], searchWord = "tatiana"
	Output: [[],[],[],[],[],[],[]]
	 
	Constraints:
		1 <= products.length <= 1000
		There are no repeated elements in products.
		1 <= Σ products[i].length <= 2 * 10^4
		All characters of products[i] are lower-case English letters.
		1 <= searchWord.length <= 1000
		All characters of searchWord are lower-case English letters.
 */

import java.util.List;

public class Program09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] productsArr = new String[] { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
		String searchWord = "mouse";
		List<List<String>> suggestedProducts = suggestedProducts(productsArr, searchWord);
		System.out.println(suggestedProducts);
	}

	public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
		List<List<String>> suggestedProducts = new ArrayList<List<String>>();

		Arrays.sort(products);
		for (int i = 0; i < searchWord.length(); i++) {
			String str = searchWord.substring(0, i + 1);
			List<String> subProducts = new ArrayList<String>();

			for (int j = 0; j < products.length; j++) {
				if (products[j].startsWith(str))
					subProducts.add(products[j]);
			}
			
			if (subProducts.size() > 3)
				suggestedProducts.add(subProducts.subList(0, 3));
			else
				suggestedProducts.add(subProducts);
		}
		return suggestedProducts;
	}

}
