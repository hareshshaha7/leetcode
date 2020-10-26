package com.haresh.leetcode.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Program07 {

	class PairString {
		String item1;
		String item2;

		public PairString(String item1, String item2) {
			this.item1 = item1;
			this.item2 = item2;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<PairString> associationPairList = new ArrayList<PairString>();
//		associationPairList.add(new PairString("item1", "item2"));
//		associationPairList.add(new PairString("item3", "item4"));
//		associationPairList.add(new PairString("item4", "item5"));

		List<String> largestAssociationList = largestItemAssociation(associationPairList);
		for (String association : largestAssociationList) {
			System.out.println(association);
		}
	}

	private static List<String> largestItemAssociation(List<PairString> associationPairList) {
		List<String> largestAssociationList = new ArrayList<String>();

		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (PairString associationPair : associationPairList) {
			if (!map.containsKey(associationPair.item1))
				map.put(associationPair.item1, new ArrayList<String>());

			map.get(associationPair.item1).add(associationPair.item2);

		}

		for (PairString associationPair : associationPairList) {
			List<String> associationList = new ArrayList<String>();
			String second = associationPair.item2;
			map.containsKey(second);

		}

		return null;
	}

}
