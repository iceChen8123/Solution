package com.ice.solution;

import java.math.BigInteger;
import java.util.Scanner;

public class SolutionMaximizingXOR {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger lll = new BigInteger(in.next());
		BigInteger rrr = new BigInteger(in.next());

		int need = (int) (Math.pow(2, rrr.toString(2).length()) - 1) ^ rrr.intValue();
		if (need > lll.intValue()) {
			System.out.println((int) (Math.pow(2, rrr.toString(2).length()) - 1));
		}
	}
}
