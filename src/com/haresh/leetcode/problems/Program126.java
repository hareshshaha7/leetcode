package com.haresh.leetcode.problems;

/*
    605. Can Place Flowers
    https://leetcode.com/problems/can-place-flowers/

    You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

    Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
    return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.

    Example 1:
    Input: flowerbed = [1,0,0,0,1], n = 1
    Output: true

    Example 2:
    Input: flowerbed = [1,0,0,0,1], n = 2
    Output: false

    Constraints:
        1 <= flowerbed.length <= 2 * 104
        flowerbed[i] is 0 or 1.
        There are no two adjacent flowers in flowerbed.
        0 <= n <= flowerbed.length
 */

/**
 * @author Haresh Shaha
 * @since 18-Jan-2022
 */
public class Program126 {
    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 2;
        boolean canPlaceFlowers = canPlaceFlowers(flowerbed, n);
        System.out.println(canPlaceFlowers);
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i++] = 1;
                count++;
            }
            if (count >= n)
                return true;
            i++;
        }
        return false;
    }
}
