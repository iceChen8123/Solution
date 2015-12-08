package com.ice.solution.euler;

import java.io.IOException;
import java.util.Scanner;

public class SolutionReadInt {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			stringBuilder.append("\n").append(calcHeight(n));
		}
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static int calcHeight(int n) {
		if (n == 0) {
			return 1;
		}
		if (n % 2 == 0) {
			return calcHeight(n - 1) + 1;
		} else {
			return calcHeight(n - 1) * 2;
		}
	}
}