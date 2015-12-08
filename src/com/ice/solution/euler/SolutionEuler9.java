package com.ice.solution.euler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolutionEuler9 {

	static Map<Integer, Long> sptCache = new HashMap<Integer, Long>();

	public static void main(String[] args) throws NumberFormatException, IOException {

//		for (int a = 3000; a > 2000; a--) {
//			init(a);
//			System.out.println(calcRes(a));
//		}

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < t; a0++) {
			int nextInt = in.nextInt();
			init(nextInt);
			stringBuilder.append("\n").append(calcRes(nextInt));
		}
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static void init(int number) {
		for (int a = 1; a <= number / 3; a++) {
			for (int b = a + 1; b <= number / 2; b++) {
				int c = number - a - b;
				int c2 = a * a + b * b;
				if (c * c == c2) {
					int fi = a * b * c;
					if (sptCache.containsKey(number)) {
						if (sptCache.get(number) < fi) {
							sptCache.put(number, (long) fi);
						}
					} else {
						sptCache.put(number, (long) fi);
					}
					break;
				}
			}
		}
	}

	private static long calcRes(int number) {
		Long t = sptCache.get(number);
		if (t != null && t != 0) {
			return t;
		} else {
			return -1;
		}
	}
}