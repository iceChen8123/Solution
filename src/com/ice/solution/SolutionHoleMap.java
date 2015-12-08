package com.ice.solution;

import java.util.Scanner;

public class SolutionHoleMap {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] grid = new int[n][n];
		for (int grid_i = 0; grid_i < n; grid_i++) {
			int ii = 0;
			for (char cc : in.next().toCharArray()) {
				grid[grid_i][ii] = Integer.parseInt(cc + "");
				ii++;
			}
		}
		StringBuilder resBuilder = new StringBuilder();
		for (int ii = 0; ii < n; ii++) {
			resBuilder.append("\n");
			for (int jj = 0; jj < n; jj++) {
				if (ii == 0 || ii == n - 1 || jj == 0 || jj == n - 1) {
					resBuilder.append(grid[ii][jj]);
				} else {
					if (isHole(grid, ii, jj)) {
						resBuilder.append("X");
					} else {
						resBuilder.append(grid[ii][jj]);
					}
				}
			}
		}
		System.out.println(resBuilder.toString().substring(1));
	}

	private static boolean isHole(int[][] grid, int ii, int jj) {
		int t = grid[ii][jj];
		return (grid[ii - 1][jj] < t) && (grid[ii + 1][jj] < t) && (grid[ii][jj - 1] < t) && (grid[ii][jj + 1] < t);
	}
}
