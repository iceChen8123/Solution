package com.ice.solution;

import java.io.IOException;
import java.util.Scanner;

public class SolutionAngryProfessor {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < t; a0++) {
			int num = in.nextInt();
			int minnum = in.nextInt();
			int[] stuTimes = new int[num];
			for (int a1 = 0; a1 < num; a1++) {
				stuTimes[a1] = in.nextInt();
			}
			stringBuilder.append("\n").append(calcRes(stuTimes, minnum));
		}
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static Object calcRes(int[] stuTimes, int minnum) {
		int inTimeStuNum = 0;
		for (int stuTime : stuTimes) {
			if (stuTime <= 0) {
				inTimeStuNum++;
			}
		}
		if (inTimeStuNum >= minnum) {
			return "NO";
		} else {
			return "YES";
		}
	}

}