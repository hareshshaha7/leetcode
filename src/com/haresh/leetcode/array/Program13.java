package com.haresh.leetcode.array;

/*
	Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
	
	Example:
	Input: [0,1,0,3,12]
	Output: [1,3,12,0,0]

	Note:
	You must do this in-place without making a copy of the array.
	Minimize the total number of operations. 
 */

class Solution13 {
    public void moveZeroes(int[] nums) {
    	int j = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] != 0) {
				nums[j++] = nums[i];
        	}
		}
        for (; j < nums.length; j++) {
        	nums[j] = 0;
        }
    }
}

public class Program13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, -5};
		Solution13 solution13 = new Solution13();
		solution13.moveZeroes(input);
		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
	}

}
