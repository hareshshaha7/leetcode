package com.haresh.google.kickstart;

/*
	Allocation (5pts, 7pts)

	Problem
	There are N houses for sale. The i-th house costs Ai dollars to buy. You have a budget of B dollars to spend.
	
	What is the maximum number of houses you can buy?
	
	Input
		The first line of the input gives the number of test cases, T. T test cases follow. Each test case begins with a single line containing the two integers N and B. 
		The second line contains N integers. The i-th integer is Ai, the cost of the i-th house.
	
	Output
		For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the maximum number of houses you can buy.
	
	Limits
		Time limit: 15 seconds.
		Memory limit: 1 GB.
		1 ≤ T ≤ 100.
		1 ≤ B ≤ 105.
		1 ≤ Ai ≤ 1000, for all i.
	
	Test Set 1
		1 ≤ N ≤ 100.
	
	Test Set 2
		1 ≤ N ≤ 105.
	
	Sample Input
		3
		4 100
		20 90 40 90
		4 50
		30 30 10 10
		3 300
		999 999 999
	
	Sample Output
		Case #1: 2
		Case #2: 3
		Case #3: 0
	
	In Sample Case #1, you have a budget of 100 dollars. You can buy the 1st and 3rd houses for 20 + 40 = 60 dollars.
	In Sample Case #2, you have a budget of 50 dollars. You can buy the 1st, 3rd and 4th houses for 30 + 10 + 10 = 50 dollars.
	In Sample Case #3, you have a budget of 300 dollars. You cannot buy any houses (so the answer is 0).
	
	Note: Unlike previous editions, in Kick Start 2020, all test sets are visible verdict test sets, meaning you receive instant feedback upon submission.
 */

/**
 * @author Haresh Shaha
 * @since 07-Sep-2021
 *
 */
import java.util.*;

public class Program01 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();

		for (int testCase = 1; testCase <= testCases; testCase++) {
			int numberOfHouses = in.nextInt();
			int budget = in.nextInt();
			int[] costOfHouses = new int[numberOfHouses];

			for (int index = 0; index < numberOfHouses; index++) {
				costOfHouses[index] = in.nextInt();
			}

			int ans = buyMaximumHouses(costOfHouses, budget);
			System.out.println("Case #" + testCase + ": " + ans);
		}

		in.close();
	}

	static int buyMaximumHouses(int[] costOfHouses, int budget) {
		Arrays.sort(costOfHouses);
		int maxHouses = 0;

		for (int i = 0; i < costOfHouses.length && budget >= 0; ++i) {
			budget -= costOfHouses[i];
			if (budget >= 0)
				maxHouses++;
		}

		return maxHouses;
	}
}