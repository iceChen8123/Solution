package com.ice.solution;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SolutionTwoArrays {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[] array1 = new int[n];
			int[] array2 = new int[n];
			for (int b0 = 0; b0 < 2 * n; b0++) {
				if (b0 < n) {
					array1[b0] = in.nextInt();
				} else {
					array2[b0 % n] = in.nextInt();
				}
			}
			stringBuilder.append("\n").append(calcRes(k, array1, array2));
		}

		System.out.println(stringBuilder.toString().substring(1));
	}

	private static Object calcRes(int k, int[] array1, int[] array2) {
		Arrays.sort(array1);
		Arrays.sort(array2);
		int[] array3 = new int[array2.length];
		for (int a0 = 0; a0 < array2.length; a0++) {
			array3[a0] = array2[array2.length - 1 - a0];
		}
		String res = "YES";
		for (int a0 = 0; a0 < array3.length; a0++) {
			if ((array1[a0] + array3[a0]) < k) {
				res = "NO";
				break;
			}
		}
		return res;
	}

}