package com.ice.solution;

import java.io.IOException;
import java.util.Scanner;

public class SolutionSherlockAndArray {
	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int[] all = new int[n];
			for (int b0 = 0; b0 < n; b0++) {
				all[b0] = in.nextInt();
			}
			stringBuilder.append("\n").append(calcRes(all));
		}
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static Object calcRes(int[] all) {
		if (all.length == 1) {
			return "YES";
		}

		int rightSum = 0;
		int leftSum = 0;
		for (int aa : all) {
			rightSum += aa;
		}
		if (0 == rightSum - all[0]) {
			return "YES";
		}

		rightSum = rightSum - all[0];
		leftSum = all[0];
		for (int ii = 1; ii < all.length - 1; ii++) {
			rightSum = rightSum - all[ii];
			if (leftSum == rightSum) {
				return "YES";
			}
			leftSum += all[ii];
		}
		if (leftSum == 0) {
			return "YES";
		}
		return "NO";
	}
}