package com.haresh.leetcode.amazon;

/*
	Search an element in a sorted and rotated array

	An element in a sorted array can be found in O(log n) time via binary search. 
	But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand. 
	So for instance, 1 2 3 4 5 might become 3 4 5 1 2. 
	Devise a way to find an element in the rotated array in O(log n) time.
	
	Example:
	
	Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
	         key = 3
	Output : Found at index 8
	
	Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
	         key = 30
	Output : Not found
	
	Input : arr[] = {30, 40, 50, 10, 20}
	        key = 10   
	Output : Found at index 3 
	
	
	Improved Solution:
	Approach: 
		1) Find middle point mid = (l + h)/2
		2) If key is present at middle point, return mid.
		3) Else If arr[l..mid] is sorted
		    a) If key to be searched lies in range from arr[l]
		       to arr[mid], recur for arr[l..mid].
		    b) Else recur for arr[mid+1..h]
		4) Else (arr[mid+1..h] must be sorted)
		    a) If key to be searched lies in range from arr[mid+1]
		       to arr[h], recur for arr[mid+1..h].
		    b) Else recur for arr[l..mid] 
		    
		    
    Complexity Analysis:	
		Time Complexity: O(log n).
		Binary Search requires log n comparisons to find the element. So time complexity is O(log n).
		Space Complexity: O(1).
		As no extra space is required.

	How to handle duplicates?
	It doesn’t look possible to search in O(Logn) time in all cases when duplicates are allowed. For example consider searching 0 in {2, 2, 2, 2, 2, 2, 2, 2, 0, 2} and {2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}.
	It doesn’t look possible to decide whether to recur for the left half or right half by doing a constant number of comparisons at the middle.
	
 */

public class Program06 {
	
	public static void main(String[] args) {
		int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		int n = arr.length;
		int key = 1;
		
		int i = sortedPivotedArray(arr, 0, n - 1, key);
		if (i != -1)
			System.out.println("Index: " + i);
		else
			System.out.println("Key not found");
	}

	// Returns index of key in arr[l..h] 
    // if key is present, otherwise returns -1 
	private static int sortedPivotedArray(int[] arr, int l, int r, int key) {
		if (r < l)
			return -1;

		int m = (l + r) / 2;
		if (arr[m] == key)
			return m;
		if (arr[l] == key)
			return l;
		if (arr[r] == key)
			return r;
		
		// If arr[l...mid] first sub-array is sorted 
		if (arr[m] > arr[l]) {
			
			// As this sub-array is sorted, we can quickly check if key lies in half or other half
			if (key < arr[m] && key > arr[l])
				return sortedPivotedArray(arr, l + 1, m - 1, key);
			
			
			// If key not lies in first half sub-array, Divide other half  into two sub-arrays, 
			// such that we can quickly check if key lies in other half
			return sortedPivotedArray(arr, m + 1, r - 1, key);
		}
		
		// If arr[l..mid] first subarray is not sorted, then arr[mid... h] must be sorted subarry
		if (key > arr[m] && key < arr[r])
			return sortedPivotedArray(arr, m + 1, r - 1, key);
		return -1;
	}

}
