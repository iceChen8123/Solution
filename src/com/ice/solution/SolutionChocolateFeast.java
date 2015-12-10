package com.ice.solution;

import java.io.IOException;
import java.util.Scanner;

public class SolutionChocolateFeast {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < t; a0++) {
			int money = in.nextInt();
			int cost = in.nextInt();
			int transChoco = in.nextInt();
			stringBuilder.append("\n").append(calcRes(money, cost, transChoco));
		}
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static Object calcRes(int money, int cost, int transChoco) {
		int buychocoNum = money / cost;
		int total = buychocoNum;
		int wrapperNum = buychocoNum;
		while (wrapperNum >= transChoco) {
			total += wrapperNum / transChoco;
			wrapperNum = wrapperNum % transChoco + wrapperNum / transChoco;
		}
		return total;
	}
}