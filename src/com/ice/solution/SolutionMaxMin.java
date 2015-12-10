package com.ice.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SolutionMaxMin {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int K = Integer.parseInt(in.readLine());
		int[] list = new int[N];

		for (int i = 0; i < N; i++)
			list[i] = Integer.parseInt(in.readLine());

		int unfairness = calcRes(K, list);

		System.out.println(unfairness);
	}

	private static int calcRes(int nums, int[] all) {
		Arrays.sort(all);
		if (nums >= all.length) {
			return all[all.length - 1] - all[0];
		}
		int min = 2000000000;
		for (int a = 0; a < all.length - nums + 1; a++) {
			int temp = all[nums + a - 1] - all[a];
			// System.out.println(all[nums + a - 1] + "-" + all[a] + "  :  " +
			// temp);

			if (min > temp) {
				min = temp;
			}
		}
		return min;
	}
}
