package com.haresh.leetcode.problems;

/*
    1046. [Easy] Last Stone Weight
    https://leetcode.com/problems/last-stone-weight/

    You are given an array of integers stones where stones[i] is the weight of the ith stone.

    We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together.
    Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
        If x == y, both stones are destroyed, and
        If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
    At the end of the game, there is at most one stone left.

    Return the smallest possible weight of the left stone. If there are no stones left, return 0.

    Example 1:
    Input: stones = [2,7,4,1,8,1]
    Output: 1
    Explanation:
        We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
        we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
        we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
        we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.

    Example 2:
    Input: stones = [1]
    Output: 1

    Constraints:
        1 <= stones.length <= 30
        1 <= stones[i] <= 1000
 */

import java.util.*;

/**
 * @author Haresh Shaha
 * @since 08-APR-2022
 */
public class Program185 {
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        // In an interview, you should only discuss either BucketSort or PriorityQueue (max head) solutions.
        System.out.println(lastStoneWeight(stones));
        System.out.println(lastStoneWeight1(stones));
        System.out.println(lastStoneWeight2(stones));
    }

    /**
     * At every step of the algorithm, we need to know the top heaviest stone.
     * The most efficient way to retrieve the max for large input sizes is to use a max heap,
     * which in Java is a PriorityQueue (min heap) with a reverse comparator:
     * <p>
     * Time : O(n log (n))
     * Space : O(n)
     */
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : stones) {
            queue.add(i);
        }
        int x;
        int y;
        while (queue.size() > 1) {
            y = queue.poll();
            x = queue.poll();
            if (y > x) {
                queue.offer(y - x);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }

    public static int lastStoneWeight1(int[] stones) {
        if (stones.length == 1)
            return stones[0];

        if (stones.length == 2)
            return Math.abs(stones[0] - stones[1]);

        List<Integer> list = new ArrayList<>();
        for (int size : stones) {
            list.add(size);
        }

        while (list.size() > 1) {
            list.sort(Collections.reverseOrder());
            int num1 = list.remove(0);
            int num2 = list.remove(0);
            list.add(Math.abs(num1 - num2));
        }
        return list.remove(0);
    }

    /**
     * So if we know that the number of stones is quite small, can we do even better than the PriorityQueue?
     * What is a very fast sorting algorithm for small sets, better than building a heap? Sort in place in the array!
     * Don't waste time building new objects or copies of the input.
     * <p>
     * Time : O( n^2 log(n) ) because for every stone n, we sort the array O(nlog(n))
     * Space : O(1) space, no extra space, sort in place
     */
    public static int lastStoneWeight2(int[] stones) {
        Arrays.sort(stones);
        for (int i = stones.length - 1; i > 0; i--) {
            stones[i - 1] = stones[i] - stones[i - 1];
            Arrays.sort(stones);
        }
        return stones[0];
    }
}
