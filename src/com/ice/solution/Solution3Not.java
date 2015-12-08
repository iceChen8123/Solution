package com.ice.solution;


import java.util.Scanner;

public class Solution3Not {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder result = new StringBuilder();
		int t = in.nextInt();
		for (int tt = 0; tt < t; tt++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			int oneCounter = 0;
			boolean canGoThrough = true;
			if (n < m) { // n==m时?
				for (int i = 0; i < n; i++) {
					if (arr[i] > 0) {
						oneCounter++;
						if (oneCounter == m) {
							canGoThrough = false;
						}
					} else {
						oneCounter = 0;
					}
				}
				for (int i = 0; i < n; i++) {

				}
			}
			if (canGoThrough) {
				result.append("\n").append("YES");
			} else {
				result.append("\n").append("NO");
			}
		}
		System.out.println(result.toString().substring(1));
	}

}