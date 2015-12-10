package com.ice.solution;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SolutionMarkAndToys {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] toyPrices = new int[n];
		for (int a0 = 0; a0 < n; a0++) {
			toyPrices[a0] = in.nextInt();
		}
		System.out.println(calcRes(k, toyPrices));
	}

	private static Object calcRes(int k, int[] toyPrices) {
		Arrays.sort(toyPrices);
		int cost = 0;
		for (int a0 = 1; a0 <= toyPrices.length; a0++) {
			cost += toyPrices[a0 - 1];
			if (cost == k) {
				return a0;
			} else if (cost > k) {
				return a0 - 1;
			}
		}
		return 0;
	}
}