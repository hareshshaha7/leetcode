/**
 * 
 */
package com.haresh.leetcode.problems;

/*
Minimum Platforms
https://www.youtube.com/watch?v=dxVcMDI7vyI&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=48

Example 1:
Input: n = 6, arr = { 900, 940, 950, 1100, 1500, 1800 }, dep = { 910, 1200, 1120, 1130, 1900, 2000 }
Output: 3

Example 2:
Input: n = 3, arr = { 900, 1100, 1235 }, dep = { 1000, 1200, 1240 }
Output: 1

Example 3:
Input: int n = 4, arr = { 900, 900, 930, 910 }, dep = { 910, 930, 940, 950 }
Output: 2
 */
import java.util.ArrayList;
import java.util.List;

/**
 * @author Haresh Shaha
 * @since 19-Aug-2021
 *
 */
public class Program82 {

	class Schedule {
		private int arr;
		private int dep;

		public Schedule(int arr, int dep) {
			super();
			this.arr = arr;
			this.dep = dep;
		}

		public int getArr() {
			return arr;
		}

		public void setArr(int arr) {
			this.arr = arr;
		}

		public int getDep() {
			return dep;
		}

		public void setDep(int dep) {
			this.dep = dep;
		}

		@Override
		public String toString() {
			return "Schedule [arr=" + arr + ", dep=" + dep + "]";
		}

	}

	public static void main(String[] args) {
		int n = 6;
		int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
		int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };
		int minPlatforms = findPlatforms(arr, dep, n);
		System.out.println(minPlatforms);
	}

	private static int findPlatforms(int[] arr, int[] dep, int n) {
		List<Schedule> schedules = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			schedules.add(new Program82().new Schedule(arr[i], dep[i]));
		}

		schedules.sort((p1, p2) -> p1.getDep() == p2.getDep() ? p1.getArr() - p2.getArr() : p1.getDep() - p2.getDep());

		int minPlatforms = 1;

		List<Schedule> lastSchedules = new ArrayList<>();
		lastSchedules.add(schedules.get(0));

		for (int i = 1; i < schedules.size(); i++) {
			int size = lastSchedules.size() - 1;
			for (int j = size; j >= 0; j--) {
				if (schedules.get(i).getArr() >= lastSchedules.get(j).getDep()) {
					lastSchedules.remove(j);
					lastSchedules.add(schedules.get(i));
					break;
				}
			}
			if (!lastSchedules.contains(schedules.get(i))) {
				lastSchedules.add(schedules.get(i));
				minPlatforms++;
			}

		}

		return minPlatforms;
	}

}