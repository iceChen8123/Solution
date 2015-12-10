package com.ice.solution;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SolutionCutTheSticks {

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
		StringBuilder sbBuilder = new StringBuilder();
		Arrays.sort(all);
		int last = 0;
		for (int ii = 0; ii < all.length; ii++) {
			if (all[ii] > last) {
				last = all[ii];
				sbBuilder.append("\n").append(all.length - ii);
			}
		}
		return sbBuilder.toString().substring(1);
	}
}