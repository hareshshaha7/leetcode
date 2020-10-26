package com.haresh.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/*
	Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
	More formally check if there exists two indices i and j such that :
	i != j
	0 <= i, j < arr.length
	arr[i] == 2 * arr[j]
	 
	
	Example 1:	
	Input: arr = [10,2,5,3]
	Output: true
	Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
	
	Example 2:
	Input: arr = [7,1,14,11]
	Output: true
	Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
	
	Example 3:
	Input: arr = [3,1,7,11]
	Output: false
	Explanation: In this case does not exist N and M, such that N = 2 * M.
	 
	
	Constraints:
	2 <= arr.length <= 500
	-10^3 <= arr[i] <= 10^3
 */

class Solution9 {
    public boolean checkIfExist(int[] arr) {
    	for (int i = 0; i < arr.length - 1; i++) {
    		for (int j = i + 1; j < arr.length; j++) {
    			if (arr[i] * 2 == arr[j] || arr[i] / 2.0 == arr[j]) {
    				return true;
    			}
    		}
		}
        return false;
        
    	/*
        // Best Solution
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i] * 2) || (set.contains(arr[i] / 2) && (arr[i] % 2 ==0))) {
				return true;
			}
			else
				set.add(arr[i]);
		}
        return false;
        */
    }
}

public class Program09 {

	public static void main(String[] args) {

		int[] input = {7,1,14,11 };
		Solution9 solution9 = new Solution9();
		Boolean result = solution9.checkIfExist(input);
		System.out.println(result);
	}

}
