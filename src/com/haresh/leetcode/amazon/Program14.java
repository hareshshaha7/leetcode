package com.haresh.leetcode.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
	Min Cost to Connect Ropes

	Given n ropes of different lengths, we need to connect these ropes into one rope. We can connect only 2 ropes at a time. The cost required to connect 2 ropes is equal to sum of their lengths. The length of this connected rope is also equal to the sum of their lengths. This process is repeated until n ropes are connected into a single rope. Find the min possible cost required to connect all ropes.
	
	Example 1:	
	Input: ropes = [8, 4, 6, 12]
	Output: 58
	Explanation: The optimal way to connect ropes is as follows
	1. Connect the ropes of length 4 and 6 (cost is 10). Ropes after connecting: [8, 10, 12]
	2. Connect the ropes of length 8 and 10 (cost is 18). Ropes after connecting: [18, 12]
	3. Connect the ropes of length 18 and 12 (cost is 30).
	Total cost to connect the ropes is 10 + 18 + 30 = 58
	
	Example 2:
	Input: ropes = [20, 4, 8, 2]
	Output: 54
	
	Example 3:
	Input: ropes = [1, 2, 5, 10, 35, 89]
	Output: 224
	
	Example 4:
	Input: ropes = [2, 2, 3, 3]
	Output: 20
 */

public class Program14 {

	public static void main(String[] args) {
		int[] ropes = {1, 2, 5, 10, 35, 89};
		int length = lengthOfConnectedRopes(ropes);
		System.out.println(length);
	}

	private static int lengthOfConnectedRopes(int[] ropes) {
		if (ropes.length == 0)
			return 0;
		
		int length = 0;
		ArrayList<Integer> list = IntStream.of(ropes)
	              .boxed().collect(Collectors.toCollection(ArrayList::new));
		
		while(list.size() > 1) {
			Collections.sort(list);
			int sum = list.remove(0) + list.remove(0);
			list.add(sum);
			length += sum;
		}
		return length;
	}

}
