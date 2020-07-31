package com.haresh.leetcode.array;

/*
 	Given a binary array, find the maximum number of consecutive 1s in this array.

	Example 1:
	Input: [1,1,0,1,1,1]
	Output: 3
	Explanation: The first two digits or the last three digits are consecutive 1s.
	    The maximum number of consecutive 1s is 3.
	
	Note:
	The input array will only contain 0 and 1.
	The length of input array is a positive integer and will not exceed 10,000
 
 */

class Solution2 {
    public int findMaxConsecutiveOnes(int[] nums) {
    	int maxConsecutiveOnes = 0;
    	int consecutiveOnes = 0;
    	
    	for (int i = 0; i < nums.length; i++) {
		
    		if (nums[i] == 1) {
				consecutiveOnes++;
			}
			else {
				consecutiveOnes = 0;
			}
			
    		if (maxConsecutiveOnes < consecutiveOnes) {
				maxConsecutiveOnes = consecutiveOnes;
			}
		}
    	
        return maxConsecutiveOnes;
    }
}

public class Program2 {
	
	public static void main(String[] args) {
		
		int[] input = {1,1,0,1,1,1, 1, 1};
		Solution2 solution2 = new Solution2();
		int result = solution2.findMaxConsecutiveOnes(input);
		System.out.println(result);
	}

}
