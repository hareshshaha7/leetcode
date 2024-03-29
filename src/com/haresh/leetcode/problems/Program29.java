/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	Container With Most Water
	https://leetcode.com/problems/container-with-most-water/

	Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
	n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). 
	Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
	
	Notice that you may not slant the container.
	
	Example 1:
		|___________________|_______
		|					|		|
		|	|				|		|
		|	|		|		|		|
		|	|		|	|	|		|
		|	|		|	|	|	|	|
		|	|	|	|	|	|	|	|
	|	|	|	|	|	|	|	|	|
	---------------------------------
	Input: height = [1,8,6,2,5,4,8,3,7]
	Output: 49
	Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
	
	Example 2:
	Input: height = [1,1]
	Output: 1
	
	Example 3:
	Input: height = [4,3,2,1,4]
	Output: 16
	
	Example 4:
	Input: height = [1,2,1]
	Output: 2
	
	Constraints:
		n == height.length
		2 <= n <= 105
		0 <= height[i] <= 104
 */

/**
 * @author Haresh Shaha
 * @since 29-May-2021
 *
 */
public class Program29 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int maxArea = maxArea(height);
		System.out.println(maxArea);
	}

	public static int maxArea(int[] height) {
		int maxArea = 0;
		for (int i = 0, j = height.length - 1; i <= j;) {
			int area = 0;

			if (height[i] < height[j]) {
				area = height[i] * (j - i);
				i++;

			} else {
				area = height[j] * (j - i);
				j--;
			}

			if (maxArea < area) {
				maxArea = area;
			}
		}

		return maxArea;
	}
}
