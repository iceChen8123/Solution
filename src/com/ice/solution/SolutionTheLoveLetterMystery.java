package com.ice.solution;

import java.io.IOException;
import java.util.Scanner;

public class SolutionTheLoveLetterMystery {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < t; a0++) {
			stringBuilder.append("\n").append(calcRes(in.next()));
		}
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static Object calcRes(String text) {
		int length = (text.length() % 2 == 0) ? (text.length() / 2) : (text.length() - 1) / 2;
		char[] fronts = text.substring(0, length).toCharArray();
		char[] backs = text.substring(length + 1).toCharArray();
		if (text.length() % 2 == 0) {
			fronts = text.substring(0, length).toCharArray();
			backs = text.substring(length).toCharArray();
		} else {
			fronts = text.substring(0, length).toCharArray();
			backs = text.substring(length + 1).toCharArray();
		}
		int total = 0;
		for (int ii = 0; ii < length; ii++) {
			if (fronts[ii] != backs[length - 1 - ii]) {
				total += Math.abs(fronts[ii] - backs[length - 1 - ii]);
			}
		}
		return total;
	}
}