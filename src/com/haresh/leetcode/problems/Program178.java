package com.haresh.leetcode.problems;

/*
    1029. [Medium] Two City Scheduling
    https://leetcode.com/problems/two-city-scheduling/

    A company is planning to interview 2n people. Given the array costs where costs[i] = [aCosti, bCosti], the cost of flying the ith person to city a is aCosti, and the cost of flying the ith person to city b is bCosti.

    Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.

    Example 1:
    Input: costs = [[10,20],[30,200],[400,50],[30,20]]
    Output: 110
    Explanation:
        The first person goes to city A for a cost of 10.
        The second person goes to city A for a cost of 30.
        The third person goes to city B for a cost of 50.
        The fourth person goes to city B for a cost of 20.
        The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.

    Example 2:
    Input: costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
    Output: 1859

    Example 3:
    Input: costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
    Output: 3086

    Constraints:
        2 * n == costs.length
        2 <= costs.length <= 100
        costs.length is even.
        1 <= aCosti, bCosti <= 1000
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Haresh Shaha
 * @since 26-Mar-2022
 */
public class Program178 {
    public static void main(String[] args) {
        int[][] costs = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        int minCost = twoCitySchedCost(costs);
        System.out.println(minCost);

        // Slower in performance
        minCost = twoCitySchedCost1(costs);
        System.out.println(minCost);
    }

    /*
        EXPLANATION:-
            The problem is to send n persons to city A
            and n persons to city B with minimum cost.

            The idea is to send each person to city A.
            costs = [[10,20],[30,200],[400,50],[30,20]]

            So, totalCost = 10 + 30 + 400 + 30 = 470

            Now, we need to send n persons to city B.
            Which persons do we need to send city B?

            Here, we need to minimize the cost.
            We have already paid money to go to city A.
            So, Send the persons to city B who get more refund
            so that our cost will be minimized.

            So, maintain refunds of each person
            refund[i] = cost[i][1] - cost[i][0]

            So, refunds of each person
                refund = [10, 170, -350, -10]

            Here, refund +ve means we need to pay
                         -ve means we will get refund.

            So, sort the refund array.

            refund = [-350, -10, 10, 170]

            Now, get refund for N persons,
            totalCost += 470 + -350 + -10 = 110

            So, minimum cost is 110
     */
    public static int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        int[] refund = new int[n];
        int minCost = 0, index = 0;
        for (int[] cost : costs) {
            refund[index++] = cost[1] - cost[0];
            minCost += cost[0];
        }
        Arrays.sort(refund);
        for (int i = 0; i < n / 2; i++) {
            minCost += refund[i];
        }
        return minCost;
    }

    public static int twoCitySchedCost1(int[][] costs) {
//        Arrays.sort(costs, (a, b) -> {
//            return (a[0] - a[1]) - (b[0] - b[1]);
//        });
        Arrays.sort(costs, Comparator.comparingInt(a -> (a[0] - a[1])));

        int price = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            price += costs[i][0];
        }
        for (int i = costs.length / 2; i < costs.length; i++) {
            price += costs[i][1];
        }
        return price;
    }
}
