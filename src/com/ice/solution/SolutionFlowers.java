package com.ice.solution;

import java.util.Arrays;
import java.util.Scanner;

public class SolutionFlowers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] flowersCosts = new int[n];
		for (int a0 = 0; a0 < n; a0++) {
			flowersCosts[a0] = in.nextInt();
		}
		int cost = 0;
		if (k >= n) {
			for (int flowerCost : flowersCosts) {
				cost += flowerCost;
			}
		} else {
			Arrays.sort(flowersCosts);
			int count = 0;
			for (int a = flowersCosts.length - 1; a > -1; a--) {
				cost += (flowersCosts[a] * (count / k + 1));
				count++;
			}
		}
		System.out.println(cost);
	}
}
