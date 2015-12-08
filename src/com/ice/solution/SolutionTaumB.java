package com.ice.solution;

import java.util.Scanner;

public class SolutionTaumB {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < t; a0++) {
			int blackNum = in.nextInt();
			int whiteNum = in.nextInt();
			int blackCost = in.nextInt();
			int whiteCost = in.nextInt();
			int transCost = in.nextInt();

			int whiteToBlackCost = whiteCost + transCost;
			int costOnBlack = (blackCost > whiteToBlackCost) ? whiteToBlackCost : blackCost;
			int blackToWhiteCost = blackCost + transCost;
			int costOnWhite = (whiteCost > blackToWhiteCost) ? blackToWhiteCost : whiteCost;

			stringBuilder.append("\n").append(blackNum * (long) costOnBlack + whiteNum * (long) costOnWhite);
		}
		System.out.println(stringBuilder.toString().substring(1));
	}

}
