package com.ice.solution;

import java.util.Scanner;

public class SolutionServiceLane {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int t = in.nextInt();
		int width[] = new int[n];
		for (int width_i = 0; width_i < n; width_i++) {
			width[width_i] = in.nextInt();
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < t; a0++) {
			int i = in.nextInt();
			int j = in.nextInt();
			stringBuilder.append("\n").append(calcRes(width, i, j));
		}
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static Object calcRes(int[] width, int i, int j) {
		int min = 4;
		for (int ii = i; ii <= j; ii++) {
			if (min > width[ii]) {
				min = width[ii];
			}
		}
		return min;
	}
}
