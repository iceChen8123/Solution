package com.ice.solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SolutionClosestNumbers {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		int[] all = new int[n];
		for (int a0 = 0; a0 < n; a0++) {
			all[a0] = in.nextInt();
		}
		stringBuilder.append("\n").append(calcRes(all));
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static Object calcRes(int[] all) {
		Arrays.sort(all);
		int minDiff = all[all.length - 1] - all[0] + 1;
		List<Integer> markIndex = new ArrayList<>();
		for (int ii = 0; ii < all.length - 1; ii++) {
			int diff = all[ii + 1] - all[ii];
			if (diff < minDiff) {
				minDiff = diff;
				markIndex.clear();
				markIndex.add(ii);
			} else if (diff == minDiff) {
				markIndex.add(ii);
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int ii : markIndex) {
			stringBuilder.append(" ").append(all[ii]).append(" ").append(all[ii + 1]);
		}
		return stringBuilder.toString().substring(1);
	}
}