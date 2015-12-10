package com.ice.solution;

import java.io.IOException;
import java.util.Scanner;

public class SolutionTheGridSearch { // TODO

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < t; a0++) {
			int rowForAll = in.nextInt();
			int colForAll = in.nextInt();
			int[][] allNums = new int[rowForAll][colForAll];
			for (int rr = 0; rr < rowForAll; rr++) {
				String str = in.next();
				for (int strI = 0; strI < str.length(); strI++) {
					allNums[rr][strI] = Integer.parseInt("" + str.charAt(strI));
				}
			}

			int rowForS = in.nextInt();
			int colForS = in.nextInt();
			int[][] nums = new int[rowForS][colForS];
			for (int rr = 0; rr < rowForS; rr++) {
				String str = in.next();
				for (int strI = 0; strI < str.length(); strI++) {
					nums[rr][strI] = Integer.parseInt("" + str.charAt(strI));
				}
			}
			stringBuilder.append("\n").append(calcRes(allNums, nums));
		}
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static Object calcRes(int[][] allNums, int[][] nums) {

		int ii = 0;
		int jj = 0;
		for (int[] iis : allNums) {
			for (int iiis : iis) {
				boolean found = true;
				for (int rrr = 0; rrr < nums.length; rrr++) {
					for (int ccc = 0; ccc < nums[0].length; ccc++) {
						// System.out.println(ii + " :: " + jj + " :: " + rrr +
						// " :: " + ccc + " :: ");
						if (allNums[ii + rrr][jj + ccc] != nums[rrr][ccc]) {
							found = false;
							break;
						}
					}
					if (!found) {
						break;
					}
				}
				if (found) {
					return "YES";
				}

				jj++;
				if (jj > allNums.length - nums.length) {
					jj = 0;
					break;
				}
			}
			ii++;
			if (ii > allNums[0].length - nums[0].length) {
				return "NO";
			}
		}

		return null;
	}
}