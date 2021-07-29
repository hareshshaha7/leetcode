/**
 * 
 */
package com.haresh.leetcode.problems;

import java.util.Arrays;

/*
	75. Sort Colors
	https://leetcode.com/problems/sort-colors/
	
	Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
	
	We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
	
	You must solve this problem without using the library's sort function.
	
	Example 1:
	Input: nums = [2,0,2,1,1,0]
	Output: [0,0,1,1,2,2]
	
	Example 2:
	Input: nums = [2,0,1]
	Output: [0,1,2]
	
	Example 3:
	Input: nums = [0]
	Output: [0]
	
	Example 4:
	Input: nums = [1]
	Output: [1]
	 
	Constraints:
		n == nums.length
		1 <= n <= 300
		nums[i] is 0, 1, or 2.
	 
	Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */

/**
 * @author Haresh Shaha
 * @since 29-Jul-2021
 *
 */
public class Program50 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {2,0,2,1,1,0};
		System.out.print("Original Array: ");
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		sortColors(nums);
		System.out.print("Output Array: ");
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		sortColorsImprovised(nums);
		System.out.print("Output Array: ");
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}
	
	public static void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int n: nums) {
            count[n] += 1;
        }
        
        int counter = 0;
        for(int i = 0; i < count.length; i++ ) {
            Arrays.fill(nums, counter, counter + count[i], i);
            counter += count[i];
        }
    }
	
	public static void sortColorsImprovised(int[] nums) {
        int l = 0;
        int m = 0;
        int h = nums.length -1 ;
        
        while(m<=h) {
            switch(nums[m]) {
                case 0:
                    if (nums[l] != 0) {
                        int temp = nums[m];
                        nums[m] = nums[l];
                        nums[l] = temp;
                    }
                    l++;
                    m++;
                    break;
                case 1:
                    m++;
                    break;
                case 2:
                    if (nums[h] != 2) {
                        int temp = nums[m];
                        nums[m] = nums[h];
                        nums[h] = temp;
                    }
                    h--;
                    break;
            }
        }
    }

}
