package com.ice.solution.euler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolutionEuler7 {

	static List<Long> primeCache = new ArrayList<Long>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		primeCache.add(2L);

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < t; a0++) {
			stringBuilder.append("\n").append(calcRes(in.nextInt()));
		}
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static long calcRes(int number) {
		if (primeCache.size() < number) {
			fillCache(number);
		}
		return primeCache.get(number - 1);
	}

	private static void fillCache(long end) {
		long start = primeCache.get(primeCache.size() - 1);
		for (long aaa = start + 1;; aaa++) {
			boolean isPrime = true;
			for (int d = 2; d <= aaa / 2; d++) {
				if (aaa % d == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primeCache.add(aaa);
			}
			if (primeCache.size() >= end) {
				return;
			}
		}
	}

}