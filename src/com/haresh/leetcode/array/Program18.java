package com.haresh.leetcode.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/*
	Minimum Parking Space
	
	You are operating a paking lot. People come and park their cars for time they booked in advance.Each parking booking consists of start and end time.One parking space can hold one car at a time.Find out the minimum numer of parking space needed to accomadate all the bookings.

	int minParkingSpace(int [][] parking start and end time){
	
		params: start and end time of each parking. e.g.
		[
			[0,10],
			[5,20]
		]
		
		The first parking booking start at time=0 and ends at time=10,The second parking booking starts at time=5 and ends at time=20, 0<=time<=Integer.MAX_VALUE. The array is not sorted.
		
		Returns: min number of parking required.
	
	}
	
	NOTE: If start of parking coincides with the end of another parking.You can cosider there is no extra space
	
	Sample I/p:
	4
	5,10 0,20 25,40 35,45
	
	Sample O/P: 2
	
	Explanation:
	We need two parking spaces since at any point of time there are at max two car parked
	
	Space1:(0,20),(25,40)
	Space 2:(5,10),(35,45)
*/

public class Program18 {
	
	class ParkingRecord implements Comparator<ParkingRecord>{
		private int time;
		private boolean isArrived;
		
		public ParkingRecord() {
		}

		public ParkingRecord(int time, boolean isArrived) {
			this.time = time;
			this.isArrived = isArrived;
		}

		@Override
		public int compare(ParkingRecord p1, ParkingRecord p2) {
			return p1.time - p2.time;
		}
		
	}
	
	static int minParkingSpaces(int[][] parkingStartEndTimes) {
		List<ParkingRecord> parkingRecords = new ArrayList<Program18.ParkingRecord>();
		
		for (int i = 0; i < parkingStartEndTimes.length; i++) {
			parkingRecords.add(new Program18().new ParkingRecord(parkingStartEndTimes[i][0], true));
			parkingRecords.add(new Program18().new ParkingRecord(parkingStartEndTimes[i][1], false));
		}
		
		parkingRecords.sort(new Program18(). new ParkingRecord());
		
		int minParkingLots = 0;
		int counter = 0;
		for (ParkingRecord parkingRecord : parkingRecords) {
			if(parkingRecord.isArrived) {
				counter++;
				if (minParkingLots < counter)
					minParkingLots = counter;
			}
			else {
				counter--;
			}
		}
		return minParkingLots;
	}
	// DO NOT MODIFY ANYTHING BELOW THIS LINE!!

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine().trim());
		int[][] parkingStartEndTimeList = new int[n][2];
		String[] parkingStartEndTimes = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			String[] parkingStartEndTime = parkingStartEndTimes[i].split(",");
			for (int j = 0; j < parkingStartEndTime.length; j++) {
				parkingStartEndTimeList[i][j] = Integer.parseInt(parkingStartEndTime[j]);
			}
		}

		int out = minParkingSpaces(parkingStartEndTimeList);
		System.out.println(out);

		wr.close();
		br.close();
	}
}
