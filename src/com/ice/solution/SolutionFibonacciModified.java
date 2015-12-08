package com.ice.solution;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SolutionFibonacciModified {

	static int a;
	static int b;
	static TreeSet<BigInteger> list = new TreeSet<BigInteger>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		a = in.nextInt();
		b = in.nextInt();
		int n = in.nextInt();
		list.add(new BigInteger(a + ""));
		list.add(new BigInteger(b + ""));
		list.add(new BigInteger(b * b + a + ""));

		BigInteger result = calcR(n);
		list.add(result);
		System.out.println(result.toString());

		// System.out.println(list);
		// System.out.println(list.last());
		// System.out.println(list.last().toString());
		// System.out.println(list.last().toString().length());
	}

	private static BigInteger calcR(int n) {
		if (n == 1) {
			return new BigInteger(a + "");
		} else if (n == 2) {
			return new BigInteger(b + "");
		} else if (n == 3) {
			return new BigInteger(b * b + a + "");
		} else {
			BigInteger last = calcR(n - 1);
			list.add(last);
			return last.pow(2).add(calcR(n - 2));
		}
	}

}