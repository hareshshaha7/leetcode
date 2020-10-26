package com.haresh.leetcode.array;

/*
	Given an array nums of integers, return how many of them contain an even number of digits.
	 
	
	Example 1:
	
	Input: nums = [12,345,2,6,7896]
	Output: 2
	Explanation: 
	12 contains 2 digits (even number of digits). 
	345 contains 3 digits (odd number of digits). 
	2 contains 1 digit (odd number of digits). 
	6 contains 1 digit (odd number of digits). 
	7896 contains 4 digits (even number of digits). 
	Therefore only 12 and 7896 contain an even number of digits.
	
	Example 2:
	
	Input: nums = [555,901,482,1771]
	Output: 1 
	Explanation: 
	Only 1771 contains an even number of digits.
	 
	
	Constraints:
	1 <= nums.length <= 500
	1 <= nums[i] <= 10^5
 
 */

class Solution3 {
    public int findNumbers(int[] nums) {
    	int evenNumbers = 0;
    	
    	for (int i = 0; i < nums.length; i++) {
    		/*
	    		int numberOfDigits = (""+nums[i]).length();
	    		if (numberOfDigits % 2 == 0) {
	    			evenNumbers++;
	    		}
    		*/
    		
    		if ((nums[i] > 9 && nums[i] < 100) || (nums[i] > 999 && nums[i] < 10000) || (nums[i] > 99999 && nums[i] < 1000000)) 
    			evenNumbers++;
		}
    	
        return evenNumbers;
    }
}

public class Program03 {
	
	public static void main(String[] args) {
		
		int[] input = {12,345,2,6,7896};
		Solution3 solution3 = new Solution3();
		int result = solution3.findNumbers(input);
		System.out.println(result);
	}

}
