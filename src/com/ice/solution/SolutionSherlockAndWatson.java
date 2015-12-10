package com.ice.solution;

import java.io.IOException;
import java.util.Scanner;

public class SolutionSherlockAndWatson {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int kRight = in.nextInt();
		int queryNum = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		int[] all = new int[n];
		for (int a0 = 0; a0 < n; a0++) {
			all[a0] = in.nextInt();
		}
		int[] qAll = new int[queryNum];
		for (int a0 = 0; a0 < queryNum; a0++) {
			qAll[a0] = in.nextInt();
		}
		stringBuilder.append("\n").append(calcRes(all, kRight, qAll));
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static Object calcRes(int[] all, int kRight, int[] queryIndexs) {
		StringBuilder sbBuilder = new StringBuilder();
		if (kRight % all.length == 0) {// 原数组
			for (int index : queryIndexs) {
				sbBuilder.append("\n").append(all[index]);
			}
		} else {
			int startIndex = all.length - kRight % all.length;
			for (int a : queryIndexs) {
				int index = startIndex + a;
				if (index < all.length) {
					sbBuilder.append("\n").append(all[index]);
				} else {
					sbBuilder.append("\n").append(all[index % all.length]);
				}
			}
		}
		return sbBuilder.toString().substring(1);
	}

}