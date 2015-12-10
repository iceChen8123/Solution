package com.ice.solution.ai;

import java.io.IOException;
import java.util.Scanner;

public class SolutionReadInt {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int target = in.nextInt();
		int t = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		int[] all = new int[t];
		for (int a0 = 0; a0 < t; a0++) {
			all[a0] = in.nextInt();
		}
		stringBuilder.append("\n").append(calcRes(all, target));
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static int calcRes(int[] all, int target) {
		int index = 0;
		for (int t : all) {
			if (t == target) {
				break;
			}
			index++;
		}
		return index;
	}
}