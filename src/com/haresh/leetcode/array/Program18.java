package com.haresh.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
	Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
	
	Find all the elements of [1, n] inclusive that do not appear in this array.
	
	Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
	
	Example:
	
	Input:
	[4,3,2,7,8,2,3,1]
	
	Output:
	[5,6]
*/
class Solution18 {
    public List<Integer> findDisappearedNumbers(int[] nums) {

    	List<Integer> missingNumbers = new ArrayList<Integer>(nums.length);
    	for (int i = 0; i< nums.length; i++) {
    		missingNumbers.add(i+1);
    	}
        for (int i = 0; i< nums.length; i++) {
        	System.out.println("="+missingNumbers);
            if (missingNumbers.contains(nums[i]))
            	missingNumbers.remove(missingNumbers.indexOf(nums[i]));
        }
        return missingNumbers;
    }
}

public class Program18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,3,2,7,8,2,3,1};
		Solution18 solution18 = new Solution18();
		List<Integer> missingNumbers = solution18.findDisappearedNumbers(nums);
		System.out.println(missingNumbers);
		
	}

}
