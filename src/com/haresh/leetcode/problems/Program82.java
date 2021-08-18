/**
 * 
 */
package com.haresh.leetcode.problems;

/*
	N meeting in one room
	https://leetcode.com/problems/meeting-rooms/
	https://www.youtube.com/watch?v=II6ziNnub1Q&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=45
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author Haresh Shaha
 * @since 18-Aug-2021
 *
 */
public class Program82 {

	class Meetings {
		private int startTime;
		private int endTime;
		private int meetingNumber;

		public Meetings(int startTime, int endTime, int meetingNumber) {
			super();
			this.startTime = startTime;
			this.endTime = endTime;
			this.meetingNumber = meetingNumber;
		}

		public int getStartTime() {
			return startTime;
		}

		public int getEndTime() {
			return endTime;
		}

		public int getMeetingNumber() {
			return meetingNumber;
		}

		@Override
		public String toString() {
			return "Meetings [startTime=" + startTime + ", endTime=" + endTime + ", meetingNumber=" + meetingNumber
					+ "]";
		}
	}

	public static void main(String[] args) {
		int n = 6;
		int[] arr1 = { 1, 0, 3, 8, 5, 8 };
		int[] arr2 = { 2, 6, 4, 9, 7, 9 };
		int[] process = process(n, arr1, arr2);
		for (int num : process) {
			System.out.println(num);
		}
	}

	private static int[] process(int n, int[] start, int[] finish) {
		List<Meetings> meetings = new ArrayList<>();
		for (int i = 0; i < start.length; i++) {
			meetings.add(new Program82().new Meetings(start[i], finish[i], i + 1));
		}

		meetings.sort((m1, m2) -> m1.getEndTime() == m2.getEndTime() ? m1.getMeetingNumber() - m2.getMeetingNumber()
				: m1.getEndTime() - m2.getEndTime());

		List<Integer> result = new ArrayList<Integer>();
		Meetings time_limit = meetings.get(0);
		for (int i = 1; i < meetings.size(); i++) {
			if (meetings.get(i).getStartTime() >= time_limit.getEndTime()) {
				result.add(time_limit.getMeetingNumber());
				time_limit = meetings.get(i);
			}
		}
		result.add(time_limit.getMeetingNumber());
		return result.stream().sorted().mapToInt(i -> i).toArray();

	}

}
