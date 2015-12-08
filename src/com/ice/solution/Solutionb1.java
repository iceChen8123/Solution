package com.ice.solution;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solutionb1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		Set[] numsets = new HashSet[n - m + 1];
		for (int a = 0; a < n - m + 1; a++) {
			numsets[a] = new HashSet();
		}

		int max = 0;

		int next = 0;
		for (int i = 0; i < n; i++) {
			next = in.nextInt();
			if (m == n) {
				numsets[0].add(next);
			} else {
				if (i <= m) {
					for (int a = 0; a < i; a++) {
						numsets[a].add(next);
					}
				} else {
					for (int a = m + (i - m); a < i; a++) {
						numsets[a].add(next);
					}
				}
			}
		}
		for (Set numsSet : numsets) {
			if (numsSet.size() > max) {
				max = numsSet.size();
			}
		}
		System.out.println(max);
	}

}