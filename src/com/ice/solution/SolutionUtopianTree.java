package com.ice.solution;
import java.io.IOException;
import java.util.Scanner;

public class SolutionUtopianTree {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int z = 0; z < t; z++) {
			int n = in.nextInt();
			int[] ints = new int[n];
			for (int y = 0; y < n; y++) {
				ints[y] = in.nextInt();
			}
			System.out.println();
			for (int i : ints) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}