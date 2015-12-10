package com.ice.solution;

import java.io.IOException;
import java.util.Scanner;

public class SolutionSansaAndXOR {
	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int[] all = new int[n];
			for (int b0 = 0; b0 < n; b0++) {
				all[b0] = in.nextInt();
			}
			stringBuilder.append("\n").append(calcRes(all));
		}
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static Object calcRes(int[] all) {
		// 每个数出现的次数依次为 1(n-0) 2(n-1) 3(n-2) ...
		// (n-2)(n-(n-3))=(n-2)*3 (n-1)(n-(n-2))=(n-1)*2 n(n-(n-1))=n*1
		// 出现次数通项公式: a(n-a+1)
		int res = 0;
		if (all.length == 1) {
			res = all[0];
		} else {
			for (int ii = 1; ii <= all.length; ii++) {
				if (ii % 2 == 0 || (all.length - ii + 1) % 2 == 0) {
					// skip
				} else {
					res = res ^ all[ii - 1];
				}
			}
		}
		return res;
	}
}