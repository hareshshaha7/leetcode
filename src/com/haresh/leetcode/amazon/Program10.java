package com.haresh.leetcode.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	Reorder Data in Log Files
	
	You have an array of logs.  Each log is a space delimited string of words.
	
	For each log, the first word in each log is an alphanumeric identifier.  Then, either:
	Each word after the identifier will consist only of lowercase letters, or;
	Each word after the identifier will consist only of digits.
	We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
	
	Reorder the logs so that all of the letter-logs come before any digit-log.  
	The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  
	The digit-logs should be put in their original order.
	
	Return the final order of the logs.
		
	Example 1:
	Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
	Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
	
	Constraints:	
	0 <= logs.length <= 100
	3 <= logs[i].length <= 100
	logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */

public class Program10 {

	public static void main(String[] args) {
		String[] logs = { "6p tzwmh ige mc", "ns 566543603829", "ubd cujg j d yf", "ha6 1 938 376 5", "3yx 97 666 56 5", "d 84 34353 2249", "0 tllgmf qp znc", "s 1088746413789", "ys0 splqqxoflgx", "uhb rfrwt qzx r", "u lrvmdt ykmox", "ah4 4209164350", "rap 7729 8 125", "4 nivgc qo z i", "apx 814023338 8" };
		String[] reorderLogFiles = reorderLogFiles(logs);
		for (int i = 0; i < reorderLogFiles.length; i++) {
			System.out.println(reorderLogFiles[i]);
		}
	}

	public static String[] reorderLogFiles(String[] logs) {
//		List<String> digList = new ArrayList<String>();
//		Map<String, String> letMap = new HashMap<String, String>();
//
//		for (int i = 0; i < logs.length; i++) {
//			try {
//				Integer.parseInt(logs[i].split(" ")[1].substring(0, 1));
//				digList.add(logs[i]);
//			} catch (Exception e) {
//				letMap.put(logs[i], logs[i].substring(logs[i].indexOf(" ") + 1));
//			}
//		}
//		
//		List<String> letList = new ArrayList<String>(letMap.keySet());
//		Collections.sort(letList, (l1, l2) -> letMap.get(l1).equals(letMap.get(l2)) ? l1.compareTo(l2) : letMap.get(l1).compareTo(letMap.get(l2)) );
//		letList.addAll(digList);
//		
//		return letList.toArray(logs);
	
		// Best Solution
		Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
	}
}
