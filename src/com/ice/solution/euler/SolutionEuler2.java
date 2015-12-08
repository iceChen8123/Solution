package com.ice.solution.euler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class SolutionEuler2 {

	static List<Long> fbs = new ArrayList<Long>();
	static TreeSet<Node> evens = new TreeSet<Node>(new Comparator<Node>() {

		public int compare(Node o1, Node o2) {
			return (o1.value - o2.value) > 0 ? 1 : -1;
		}
	});

	public static void main(String[] args) throws NumberFormatException, IOException {

		fbs.add(1L);
		fbs.add(2L);
		evens.add(new Node(2, 2));

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < t; a0++) {
			stringBuilder.append("\n").append(calcRes(in.nextLong()));
		}
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static long calcRes(long number) {
		if (fbs.get(fbs.size() - 1) < number) {
			fillCache(number);
		}
		long sum = 0;
		// System.out.println(number + " : " + evens.headSet(new Node(number,
		// number)));
		for (Node node : evens.headSet(new Node(number, number))) {
			sum += node.value;
		}
		return sum;
	}

	private static void fillCache(long end) {
		for (int aaa = fbs.size();; aaa++) {
			long eee = fbs.get(aaa - 2) + fbs.get(aaa - 1);
			fbs.add(eee);
			if (eee % 2 == 0) {
				evens.add(new Node(eee, aaa));
			}
			if (eee > end) {
				return;
			}
		}
	}

	static class Node {
		long value;
		long index;

		public Node(long value, long index) {
			super();
			this.value = value;
			this.index = index;
		}

		public String toString() {
			return value + " ";
		}

	}
}