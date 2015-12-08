package com.ice.solution;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SolutionFindDigits {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			stringBuilder.append("\n").append(calcRes(n));
		}
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static int calcRes(int n) {
		Set<Character> alreadyD = new HashSet<Character>();
		int res = 0;
		for (char cc : (n + "").toCharArray()) {
			if (cc == '0') {
				continue;
			}
			if (alreadyD.contains(cc)) {
				res++;
			} else {
				int d = Integer.parseInt(cc + "");
				if (n % d == 0) {
					alreadyD.add(cc);
					res++;
				}
			}
		}
		return res;
	}
}