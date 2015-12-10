package com.ice.solution;

import java.io.IOException;
import java.util.Scanner;

public class SolutionInsertionSort {

	static int shiftTimes = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int[] all = new int[size];
		for (int a0 = 0; a0 < size; a0++) {
			all[a0] = in.nextInt();
		}
		if (size == 1) {
			System.out.print(all[0] + " ");
			return;
		}

		for (int ai = 1; ai < all.length; ai++) {
			if (all[ai - 1] > all[ai]) {
				all = insertionSortedList(all, ai);
			}
//			for (int num : all) {
//				System.out.print(num + " ");
//			}
//			System.out.println();
		}
		System.out.println(shiftTimes);
	}

	private static int[] insertionSortedList(int[] all, int endIndex) {
		int tagNum = all[endIndex];
		while (true) {
			if (all[endIndex - 1] > tagNum) {
				all[endIndex] = all[endIndex - 1];
				shiftTimes++;
			} else {
				all[endIndex] = tagNum;
				break;
			}
			endIndex--;
			if (endIndex <= 0) {
				all[0] = tagNum;
				break;
			}
		}
		return all;
	}
}