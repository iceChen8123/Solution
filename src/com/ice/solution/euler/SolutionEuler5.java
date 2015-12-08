package com.ice.solution.euler;

import java.io.IOException;
import java.util.Scanner;

public class SolutionEuler5 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < t; a0++) {
			stringBuilder.append("\n").append(calcRes(in.nextInt()));
		}
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static long calcRes(int number) {
		// TODO
		return 0;
	}

}