package com.ice.solution;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SolutionPairs {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int diff = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		int[] nums = new int[n];
		for (int a0 = 0; a0 < n; a0++) {
			nums[a0] = in.nextInt();
		}
		stringBuilder.append("\n").append(calcRes(nums, diff));
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static Object calcRes(int[] nums, int diff) {
		Arrays.sort(nums);
		int[] reverseNums = new int[nums.length];
		for (int a0 = 0; a0 < nums.length; a0++) {
			reverseNums[a0] = nums[nums.length - 1 - a0];
		}
		int counter = 0;
		int jj = 0;
		for (int num : reverseNums) {
			while (jj < reverseNums.length) {
				if ((num - reverseNums[jj]) > diff) {
					break;
				} else if ((num - reverseNums[jj]) == diff) {
					counter++;
					jj++;
				} else {
					jj++;
				}
			}
		}
		return counter;
	}
}