/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	Median of Two Sorted Arrays
	https://leetcode.com/problems/median-of-two-sorted-arrays/
	
	Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
	The overall run time complexity should be O(log (m+n)).
	
	Example 1:
	Input: nums1 = [1,3], nums2 = [2]
	Output: 2.00000
	Explanation: merged array = [1,2,3] and median is 2.
	
	Example 2:
	Input: nums1 = [1,2], nums2 = [3,4]
	Output: 2.50000
	Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
	
	Example 3:
	Input: nums1 = [0,0], nums2 = [0,0]
	Output: 0.00000
	
	Example 4:
	Input: nums1 = [], nums2 = [1]
	Output: 1.00000
	
	Example 5:
	Input: nums1 = [2], nums2 = []
	Output: 2.00000
	
	Constraints:
		nums1.length == m
		nums2.length == n
		0 <= m <= 1000
		0 <= n <= 1000
		1 <= m + n <= 2000
		-106 <= nums1[i], nums2[i] <= 106
 */

/**
 * @author Haresh Shaha
 * @since 23-May-2021
 *
 */
public class Program22 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2, 4 };

		double median = findMedianSortedArrays(nums1, nums2);
		System.out.println(median);

	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double median = 0;
		int[] mergedArrays = mergeArrays(nums1, nums2);

		if (mergedArrays.length % 2 == 0) {
			median = (mergedArrays[mergedArrays.length / 2] + mergedArrays[(mergedArrays.length - 1) / 2]) / 2.0;
		} else {
			median = mergedArrays[(mergedArrays.length - 1) / 2];
		}

		return median;
	}

	private static int[] mergeArrays(int[] nums1, int[] nums2) {
		int i = 0, j = 0;
		int[] mergedArrays = new int[nums1.length + nums2.length];
		int counter = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				mergedArrays[counter++] = nums1[i++];
			} else {
				mergedArrays[counter++] = nums2[j++];
			}
		}

		while (i < nums1.length) {
			mergedArrays[counter++] = nums1[i++];
		}

		while (j < nums2.length) {
			mergedArrays[counter++] = nums2[j++];
		}
		return mergedArrays;
	}
}
