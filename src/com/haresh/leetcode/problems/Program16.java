/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
	Decompress Run-Length Encoded List
	https://leetcode.com/problems/decompress-run-length-encoded-list/
	
	We are given a list nums of integers representing a list compressed with run-length encoding.
	Consider each adjacent pair of elements [freq, val] = [nums[2*i], nums[2*i+1]] (with i >= 0).  
	For each such pair, there are freq elements with value val concatenated in a sublist. Concatenate all the sublists from left to right to generate the decompressed list.
	Return the decompressed list.
	
	Example 1:
	Input: nums = [1,2,3,4]
	Output: [2,4,4,4]
	Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
		The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
		At the end the concatenation [2] + [4,4,4] is [2,4,4,4].
	
	Example 2:
	Input: nums = [1,1,2,3]
	Output: [1,3,3]
	
	Constraints:
		2 <= nums.length <= 100
		nums.length % 2 == 0
		1 <= nums[i] <= 100

 */

/**
 * @author Haresh Shaha
 * @since 19-May-2021
 *
 */
public class Program16 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 1,2,3,4 };
		int[] result = decompressRLElist(nums);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	public static int[] decompressRLElist(int[] nums) {
		int sum = 0; // sum of Frequencies
        int max = 0;
        
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            i++ ;    
        }
        
        int[] res = new int[sum];
        int pos = 0;
        
        for(int j = 1 ; j < nums.length ; j++){
            max += nums[j - 1]; // position before which to be filled
            Arrays.fill(res, pos , max, nums[j]);
            pos += nums[j - 1];
            j++ ;
        }
        
        return res;
	}
}
