package com.haresh.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
	Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
	
	Note:
	
	The number of elements initialized in nums1 and nums2 are m and n respectively.
	You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
	Example:
	
	Input:
	nums1 = [1,2,3,0,0,0], m = 3
	nums2 = [2,5,6],       n = 3
	
	Output: [1,2,2,3,5,6]
	 
	
	Constraints:
	1. -10^9 <= nums1[i], nums2[i] <= 10^9
	2. nums1.length == m + n
	3. nums2.length == n
 */

class Solution6 {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		List<Integer> list = new ArrayList<Integer>();		
		int i = 0; int j = 0;
		while (n > 0 && i < m) {
			while (j < n && nums1[i] > nums2[j]) {
				list.add(nums2[j]);
				j++;
				m++;
			}
			list.add(nums1[i]);
			nums1[i] = list.get(i);
			i++;
		}
		for (i = j; i < n; i++) {
			nums1[m++] = nums2[j++];
		}

		/*
		// Best Solution
		int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0)){
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
    
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        */
	}
}

public class Program6 {

	public static void main(String[] args) {

		int[] input1 = { 1,2,3,0,0,0};
		int[] input2 = {2,5,6 };
		Solution6 solution6 = new Solution6();
		solution6.merge(input1, 3, input2, 3);
		for (int number : input1) {
			System.out.println(number);
		}

	}

}
