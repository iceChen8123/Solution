package com.ice.solution;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SolutionMakeItAnagram {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		String aaa = in.nextLine();
		String bbb = in.nextLine();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(calcRes(aaa, bbb));
		System.out.println(stringBuilder.toString());
	}

	private static Object calcRes(String aaa, String bbb) {
		char[] achars = aaa.toCharArray();
		char[] bchars = bbb.toCharArray();
		Arrays.sort(achars);
		Arrays.sort(bchars);
		// System.out.println(new String(achars) + ":" + new String(bchars));
		int counter = 0;
		int ia = 0;
		int ib = 0;
		while ((ia < achars.length) && (ib < bchars.length)) {
			if (achars[ia] < bchars[ib]) {
				ia++;
				counter++;
			} else if (achars[ia] == bchars[ib]) {
				ia++;
				ib++;
			} else if (achars[ia] > bchars[ib]) {
				ib++;
				counter++;
			}
		}
		if (ia < achars.length) {
			// System.out.println("ia: " + ia);
			counter += (achars.length - ia);
		}
		if (ib < bchars.length) {
			// System.out.println("ib: " + ib);
			counter += (bchars.length - ib);
		}
		return counter;
	}
}