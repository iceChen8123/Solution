package com.ice.solution.euler;

import java.io.IOException;
import java.util.Scanner;

public class SolutionEuler1 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < t; a0++) {
			stringBuilder.append("\n").append(calcRes(in.nextLong()));
		}
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static long calcRes(long nextInt) {
		long sum = 0;
		long numOf3 = 0;
		if (nextInt % 3 == 0) {
			numOf3 = (nextInt - 1) / 3;
		} else {
			numOf3 = nextInt / 3;
		}
		long numOf5 = 0;
		if (nextInt % 5 == 0) {
			numOf5 = (nextInt - 1) / 5;
		} else {
			numOf5 = nextInt / 5;
		}
		long numOf15 = 0;
		if (nextInt % 15 == 0) {
			numOf15 = (nextInt - 1) / 15;
		} else {
			numOf15 = nextInt / 15;

		}
		sum = numOf3 * 3 + (numOf3 * (numOf3 - 1) / 2 * 3) + numOf5 * 5 + (numOf5 * (numOf5 - 1) / 2 * 5) - numOf15
				* 15 - (numOf15 * (numOf15 - 1) / 2 * 15);
		return sum;
	}
}