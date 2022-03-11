package com.haresh.leetcode.problems;

/*
    189. [Medium] Rotate Array
    https://leetcode.com/problems/rotate-array/

    Given an array, rotate the array to the right by k steps, where k is non-negative.

    Example 1:
    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
        rotate 1 steps to the right: [7,1,2,3,4,5,6]
        rotate 2 steps to the right: [6,7,1,2,3,4,5]
        rotate 3 steps to the right: [5,6,7,1,2,3,4]

    Example 2:
    Input: nums = [-1,-100,3,99], k = 2
    Output: [3,99,-1,-100]
    Explanation:
        rotate 1 steps to the right: [99,-1,-100,3]
        rotate 2 steps to the right: [3,99,-1,-100]

    Constraints:
        1 <= nums.length <= 105
        -231 <= nums[i] <= 231 - 1
        0 <= k <= 105

    Follow up:
        Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
        Could you do it in-place with O(1) extra space?
 */

/**
 * @author Haresh Shaha
 * @since 11-Mar-2022
 */
public class Program168 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println("Array before Rotation: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        rotate1(nums, k);
        System.out.println();
        System.out.println("Array after Rotation: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        rotate2(nums1, k);
        System.out.println();
        System.out.println("Array after Rotation: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    // Solution with extra space
    public static void rotate1(int[] nums, int k) {
        if (nums.length < 2)
            return;

        int length = nums.length;
        k = k % length;
        if (k == 0)
            return;

        int index = length - k;
        int[] result = new int[length];
        int i = 0;
        while (index < length) {
            result[i++] = nums[index++];
        }

        index = 0;
        while (index < length - k) {
            result[i++] = nums[index++];
        }

        for (i = 0; i < length; i++) {
            nums[i] = result[i];
        }
    }


    /**
     * The basic idea is that,
     * for example, nums = [1,2,3,4,5,6,7] and k = 3,
     * first we reverse [1,2,3,4], it becomes[4,3,2,1];
     * then we reverse[5,6,7], it becomes[7,6,5],
     * finally we reverse the array as a whole, it becomes[4,3,2,1,7,6,5] ---> [5,6,7,1,2,3,4].
     * <p>
     * Reverse is done by using two pointers, one point at the head and the other point at the tail,
     * after switch these two, these two pointers move one position towards the middle.
     */
    public static void rotate2(int[] nums, int k) { // Without using extra space
        if (nums.length < 2)
            return;

        int length = nums.length;
        k = k % length;
        if (k == 0)
            return;

        reverse(nums, 0, length - k - 1);
        reverse(nums, length - k, length - 1);
        reverse(nums, 0, length - 1);
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
