/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
	Number of Good Pairs
	https://leetcode.com/problems/number-of-good-pairs/
	
	Given an array of integers nums.
	A pair (i,j) is called good if nums[i] == nums[j] and i < j.
	Return the number of good pairs.
	
	Example 1:
	Input: nums = [1,2,3,1,1,3]
	Output: 4
	Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
	
	Example 2:
	Input: nums = [1,1,1,1]
	Output: 6
	Explanation: Each pair in the array are good.
	
	Example 3:
	Input: nums = [1,2,3]
	Output: 0
	
	Constraints:
	1 <= nums.length <= 100
	1 <= nums[i] <= 100 
 */

/**
 * @author Haresh Shaha
 * @since 13-May-2021
 *
 */
public class Program05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1, 1, 3 };
		int identicalPairs = numIdenticalPairs(nums);
		System.out.println(identicalPairs);
	}

	public static int numIdenticalPairs(int[] nums) {
//		int identicalPairs = 0;
//
//		for (int i = 0; i < nums.length; i++) {
//			for (int j = i + 1; j < nums.length; j++) {
//				if (nums[i] == nums[j])
//					identicalPairs++;
//			}
//		}
//
//		return identicalPairs;
		
		int count = 0;
        Map<Integer, Set<Integer>> numIndices = new HashMap<>();
        for(int i=0;i<nums.length;++i) {
            int num = nums[i];
            
            if(numIndices.containsKey(num)) {
                Set<Integer> set = numIndices.get(num);
                count += set.size();
                set.add(i);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                numIndices.put(num, set);
            }
        }
        
        return count;
	}

}
