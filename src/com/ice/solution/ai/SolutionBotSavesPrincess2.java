package com.ice.solution.ai;

import java.util.Scanner;

public class SolutionBotSavesPrincess2 {

	static void nextMove(int n, int r, int c, String[] grid) {
		char[][] adds = new char[n][n];
		Pos bot = new Pos();
		bot.hang = r;
		bot.lie = c;
		Pos princess = new Pos();
		for (int ii = 0; ii < grid.length; ii++) {
			for (int jj = 0; jj < grid[0].length(); jj++) {
				adds[ii][jj] = grid[ii].charAt(jj);
				if (adds[ii][jj] == 'p') {
					princess.hang = ii;
					princess.lie = jj;
				}
			}
		}
		int heng = bot.lie - princess.lie;
		int shu = bot.hang - princess.hang;
		for (int i = 0; i < Math.abs(heng); i++) {
			if (heng > 0) {
				System.out.println("LEFT");
				return;
			} else if (heng < 0) {
				System.out.println("RIGHT");
				return;
			}
		}
		for (int i = 0; i < Math.abs(shu); i++) {
			if (shu > 0) {
				System.out.println("UP");
				return;
			} else if (shu < 0) {
				System.out.println("DOWN");
				return;
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n, r, c;
		n = in.nextInt();
		r = in.nextInt();
		c = in.nextInt();
		String grid[] = new String[n];

		for (int i = 0; i < n; i++) {
			grid[i] = in.next();
		}

		nextMove(n, r, c, grid);

	}

	static class Pos {
		int hang;
		int lie;

		@Override
		public String toString() {
			return "Pos [hang=" + hang + ", lie=" + lie + "]";
		}

	}
}