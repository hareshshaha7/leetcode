package com.haresh.leetcode.array;

import java.util.Arrays;

/*
	Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

	Example 1:
	Input: [3, 2, 1]
	Output: 1
	Explanation: The third maximum is 1.
	
	Example 2:
	Input: [1, 2]
	Output: 2
	Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
	
	Example 3:
	Input: [2, 2, 3, 1]
	Output: 1
	Explanation: Note that the third maximum here means the third maximum distinct number.
	Both numbers with value 2 are both considered as second maximum.
*/

class Solution17 {
	// !!! Incorrect !!!
	public int thirdMax(int[] nums) {
    	
    	if (nums.length < 3)
    		return nums[nums.length - 1];
    	
    	int i = 0;
    	int j = 0;
    	for (i = 0; i < nums.length - 1; i++) {
    		if (nums[i] != nums[i+1]) {
    			j++;
    		}
        	System.out.println("-"+i+"-"+j);
    		if (j == 3)
    			break;
    	}
    	System.out.println("="+i);
        return nums[i];
    }
}

public class Program17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] heights = {2, 2, 3, 1};
		 Solution17 solution17 = new Solution17();
		 int result = solution17.thirdMax(heights);
		 System.out.println(result);
	}

}
