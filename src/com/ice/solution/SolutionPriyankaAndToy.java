package com.ice.solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SolutionPriyankaAndToy {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		int[] weights = new int[t];
		for (int a0 = 0; a0 < t; a0++) {
			weights[a0] = in.nextInt();
		}
		stringBuilder.append("\n").append(calcRes(weights));

		System.out.println(stringBuilder.toString().substring(1));
	}

	private static Object calcRes(int[] weights) {
		Arrays.sort(weights);
		int money = 0;
		List<Integer> needPro = new ArrayList<Integer>();
		for (int aa = 0; aa < weights.length; aa++) {
			if (aa != 0 && (weights[aa] - weights[aa - 1]) > 4) {
				money += calcMoney(needPro);
				needPro.clear();
				needPro.add(weights[aa]);
			} else {
				needPro.add(weights[aa]);
			}
			if (aa == weights.length - 1) {
				money += calcMoney(needPro);
				needPro.clear();
			}
		}
		return money;
	}

	private static int calcMoney(List<Integer> needPro) {
		int total = 0;
		if ((needPro.get(needPro.size() - 1) - needPro.get(0)) <= 4) {
			total += 1;
		} else {
			int afterAdd4 = -1;
			for (Integer ii : needPro) {
				if (afterAdd4 < ii) {
					afterAdd4 = ii + 4;
					total++;
				}
			}
		}
		return total;
	}
}