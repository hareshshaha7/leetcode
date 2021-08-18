/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	42. Trapping Rain Water
	https://leetcode.com/problems/trapping-rain-water/
	
	Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
	
	Example 1:
	Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
	Output: 6
	Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
	
	Example 2:
	Input: height = [4,2,0,3,2,5]
	Output: 9
	
	Constraints:
		n == height.length
		1 <= n <= 2 * 104
		0 <= height[i] <= 105
 */

/**
 * @author Haresh Shaha
 * @since 18-Aug-2021
 *
 */
public class Program78 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int trappedWater = trap(height);
		System.out.println(trappedWater);
	}

	public static int trap(int[] height) {
		int leftMax = 0;
		int rightMax = 0;
		int left = 0;
		int right = height.length - 1;
		int trappedWater = 0;

		while (left < right) {
			if (height[left] < height[right]) {
				if (height[left] >= leftMax)
					leftMax = height[left];
				else
					trappedWater += leftMax - height[left];
				left++;
			} else {
				if (height[right] >= rightMax)
					rightMax = height[right];
				else
					trappedWater += rightMax - height[right];
				right--;
			}
		}

		return trappedWater;
	}

}
