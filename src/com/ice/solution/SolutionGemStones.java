package com.ice.solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SolutionGemStones {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		String[] stoneStrings = new String[t];
		for (int a0 = 0; a0 < t; a0++) {
			stoneStrings[a0] = in.next();
		}
		stringBuilder.append("\n").append(calcRes(stoneStrings));
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static Object calcRes(String[] stoneStrings) {
		List<Character>[] stoneList = new ArrayList[stoneStrings.length];
		int aa = 0;
		for (String stone : stoneStrings) {
			char[] chars = stone.toCharArray();
			stoneList[aa] = new ArrayList();
			Arrays.sort(chars);
			for (char cc : chars) {
				stoneList[aa].add(cc);
			}
			aa++;
		}

		Set<Character> baoshi = new HashSet<Character>();
		for (char cc : stoneList[0]) {
			if (!baoshi.contains(cc)) {
				boolean isBaoshi = true;
				for (int index = 1; index < stoneList.length; index++) {
					if (Collections.binarySearch(stoneList[index], cc) < 0) {
						isBaoshi = false;
						break;
					}
				}
				if (isBaoshi) {
					baoshi.add(cc);
				}
			}
		}
		return baoshi.size();
	}
}