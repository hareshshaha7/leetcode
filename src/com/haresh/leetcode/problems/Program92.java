package com.haresh.leetcode.problems;
/*
    986. Interval List Intersections
    https://leetcode.com/problems/interval-list-intersections/

    You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj].
    Each list of intervals is pairwise disjoint and in sorted order.

    Return the intersection of these two interval lists.

    A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

    The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval.
    For example, the intersection of [1, 3] and [2, 4] is [2, 3].

    Example 1:
        A   --   -----   ---------- -
        B    ----   ----   --------- -
        O    -   |  --     -------- ||
    Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
    Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

    Example 2:
    Input: firstList = [[1,3],[5,9]], secondList = []
    Output: []

    Constraints:
        0 <= firstList.length, secondList.length <= 1000
        firstList.length + secondList.length >= 1
        0 <= starti < endi <= 109
        endi < starti+1
        0 <= startj < endj <= 109
        endj < startj+1
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author Haresh Shaha
 * @since 30-Dec-2021
 */
public class Program92 {

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}}, secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] result = intervalIntersection(firstList, secondList);
        for (int[] arr : result) {
            System.out.println("[" + arr[0] + ", " + arr[1] + "]");
        }
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[][]{};
        }

        int index1 = 0, index2 = 0;
        while (index1 < firstList.length && index2 < secondList.length) {
            if (firstList[index1][0] < secondList[index2][0]) {
                if (firstList[index1][1] < secondList[index2][0]) {
                    index1++;
                } else if (firstList[index1][1] < secondList[index2][1]) {
                    result.add(new int[]{secondList[index2][0], firstList[index1++][1]});
                } else {
                    result.add(new int[]{secondList[index2][0], secondList[index2++][1]});
                }
            } else {
                if (firstList[index1][0] > secondList[index2][1]) {
                    index2++;
                } else if (firstList[index1][1] < secondList[index2][1]) {
                    result.add(new int[]{firstList[index1][0], firstList[index1++][1]});
                } else {
                    result.add(new int[]{firstList[index1][0], secondList[index2++][1]});
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
