package com.ice.solution.euler;

import java.io.IOException;
import java.util.Scanner;

public class SolutionEuler11LargestProductInAGrid {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int[][] grid = new int[20][20];
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < 400; a0++) {
			grid[a0 / 20][a0 % 20] = in.nextInt();
		}
		System.out.println("--------------------------");
		for (int[] gr : grid) {
			for (int i : gr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

		System.out.println(calcRes(grid));
	}

	private static long calcRes(int[][] grid) {

		return 0;
	}
}