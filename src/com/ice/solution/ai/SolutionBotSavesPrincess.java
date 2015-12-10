package com.ice.solution.ai;

import java.util.Scanner;

public class SolutionBotSavesPrincess {

	static void displayPathtoPrincess(int n, String[] grid) {
		char[][] adds = new char[n][n];
		Pos bot = new Pos();
		Pos princess = new Pos();
		for (int ii = 0; ii < grid.length; ii++) {
			for (int jj = 0; jj < grid[0].length(); jj++) {
				adds[ii][jj] = grid[ii].charAt(jj);
				if (adds[ii][jj] == 'm') {
					bot.x = ii;
					bot.y = jj;
				}
				if (adds[ii][jj] == 'p') {
					princess.x = ii;
					princess.y = jj;
				}
			}
		}
		int shu = bot.x - princess.x;
		int heng = bot.y - princess.y;
		for (int i = 0; i < Math.abs(heng); i++) {
			if (heng > 0) {
				System.out.println("LEFT");
			} else if (heng < 0) {
				System.out.println("RIGHT");
			}
		}
		for (int i = 0; i < Math.abs(shu); i++) {
			if (shu > 0) {
				System.out.println("UP");
			} else if (shu < 0) {
				System.out.println("DOWN");
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m;
		m = in.nextInt();
		String grid[] = new String[m];
		for (int i = 0; i < m; i++) {
			grid[i] = in.next();
		}

		displayPathtoPrincess(m, grid);
	}

	static class Pos {
		int x;
		int y;

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}

	}
}