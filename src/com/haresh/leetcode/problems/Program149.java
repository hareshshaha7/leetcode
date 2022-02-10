package com.haresh.leetcode.problems;

/*
    67. [Easy] Add Binary
    https://leetcode.com/problems/add-binary/

    Given two binary strings a and b, return their sum as a binary string.

    Example 1:
    Input: a = "11", b = "1"
    Output: "100"

    Example 2:
    Input: a = "1010", b = "1011"
    Output: "10101"

    Constraints:
        1 <= a.length, b.length <= 104
        a and b consist only of '0' or '1' characters.
        Each string does not contain leading zeros except for the zero itself.
 */

/**
 * @author Haresh Shaha
 * @since 10-Feb-2022
 */
public class Program149 {
    public static void main(String[] args) {
        String a = "11", b = "1";
        String addition = addBinary(a, b);
        System.out.println("Faster: " + addition);

        a = "1010";
        b = "1011";
        addition = addBinary(a, b);
        System.out.println("Faster: " + addition);

        a = "0";
        b = "0";
        addition = addBinary(a, b);
        System.out.println("Faster: " + addition);

        a = "11";
        b = "111";
        addition = addBinary(a, b);
        System.out.println("Faster: " + addition);

        a = "11";
        b = "0";
        addition = addBinary(a, b);
        System.out.println("Faster: " + addition);
    }

    public static String addBinary(String a, String b) {
        if (a == null || a.length() == 0)
            return b;
        if (b == null || b.length() == 0)
            return a;

        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            int num1 = i >= 0 ? Character.getNumericValue(a.charAt(i)) : 0;
            int num2 = j >= 0 ? Character.getNumericValue(b.charAt(j)) : 0;
            result.append(num1 ^ num2 ^ carry);
            carry = (num1 + num2 + carry) / 2;
            i--;
            j--;
        }

        return result.reverse().toString();
    }
}
