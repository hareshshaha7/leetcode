/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	Defanging an IP Address
	https://leetcode.com/problems/defanging-an-ip-address/
	
	Given a valid (IPv4) IP address, return a defanged version of that IP address.
	A defanged IP address replaces every period "." with "[.]".
	
	Example 1:
	Input: address = "1.1.1.1"
	Output: "1[.]1[.]1[.]1"
	
	Example 2:
	Input: address = "255.100.50.0"
	Output: "255[.]100[.]50[.]0"
	 
	
	Constraints:
	The given address is a valid IPv4 address.
 */

/**
 * @author Haresh Shaha
 * @since 12-May-2021
 *
 */
public class Program02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String address = "255.100.50.0";
		String defangIPaddr = defangIPaddr(address);
		System.out.println(defangIPaddr);
	}

	public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
