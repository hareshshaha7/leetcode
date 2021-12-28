package com.haresh.leetcode.problems;

/*
    38. Count and Say
    https://leetcode.com/problems/count-and-say/

    The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
    countAndSay(1) = "1"
    countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
    To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. Then for each group, say the number of characters, then say the character.
    To convert the saying into a digit string, replace the counts with a number and concatenate every saying.

    For example, the saying and conversion for digit string "3322251":
    Given a positive integer n, return the nth term of the count-and-say sequence.

    Example 1:
    Input: n = 1
    Output: "1"
    Explanation: This is the base case.

    Example 2:
    Input: n = 4
    Output: "1211"
    Explanation:
        countAndSay(1) = "1"
        countAndSay(2) = say "1" = one 1 = "11"
        countAndSay(3) = say "11" = two 1's = "21"
        countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"

    Constraints:
        1 <= n <= 30
 */

/**
 * @author Haresh Shaha
 * @since 07-Sep-2021
 *
 */
public class Program88 {
    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        int n = 4;
        String result = countAndSay(n);
        System.out.println(result);
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String s = countAndSay(n - 1);
        return pronounce(s);
    }

    public static String pronounce(String s) {
        char lastNumber = s.charAt(0);
        int lastNumberCount = 1;
        StringBuilder pronunciation = new StringBuilder();

        for (int i = 1; i < s.length(); i++) {
            if (lastNumber == s.charAt(i)) {
                lastNumberCount++;
            }
            else {
                pronunciation.append(lastNumberCount);
                pronunciation.append(lastNumber);
                lastNumber = s.charAt(i);
                lastNumberCount = 1;
            }
        }

        pronunciation.append(lastNumberCount);
        pronunciation.append(lastNumber);
        return pronunciation.toString();
    }
}
