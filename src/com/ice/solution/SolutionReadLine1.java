package com.ice.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolutionReadLine1 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder stringBuilder = new StringBuilder();
		int t = Integer.parseInt(br.readLine().trim());
		for (int a0 = 0; a0 < t; a0++) {
			boolean isFunny = true;
			String string = br.readLine().trim().toLowerCase();
			char[] chars = string.toCharArray();
			int length = chars.length;
			for (int a = 1; a < length - 1; a++) {
				if (Math.abs(chars[a] - chars[a - 1]) != Math.abs(chars[length - a - 1] - chars[length - a])) {
					isFunny = false;
				}
			}
			if (isFunny) {
				stringBuilder.append("\n").append("Funny");
			} else {
				stringBuilder.append("\n").append("Not Funny");
			}
		}
		System.out.println(stringBuilder.toString().substring(1));
	}
}