package com.ice.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SolutionIceCreamParlor {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < t; a0++) {
			int money = in.nextInt();
			int n = in.nextInt();
			int[] all = new int[n];
			for (int b0 = 0; b0 < n; b0++) {
				all[b0] = in.nextInt();
			}
			stringBuilder.append("\n").append(calcResByBina(money, all));
		}
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static Object calcResByBina(int money, int[] all) {
		ArrayList<Node> costList = new ArrayList<>();
		for (int ii = 0; ii < all.length; ii++) {
			costList.add(new Node(all[ii], ii + 1));
		}
		Comparator<Node> comparator = new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return (o1.cost < o2.cost) ? -1 : ((o1.cost == o2.cost) ? 0 : 1);
			}
		};
		Collections.sort(costList, comparator);
		for (int ii = 0; ii < all.length; ii++) {
			int higherIndex = Collections.binarySearch(costList, new Node(money - all[ii], 99999), comparator);
			if (higherIndex > -1) {
				if (money == all[ii] * 2) {
					if (higherIndex < costList.size()
							&& costList.get(higherIndex).cost == costList.get(higherIndex + 1).cost) {
						return (ii + 1) + " " + (costList.get(higherIndex + 1).index);
					}
					if (higherIndex > 0 && costList.get(higherIndex - 1).cost == costList.get(higherIndex).cost) {
						return (ii + 1) + " " + (costList.get(higherIndex).index);
					}
				} else {
					return (ii + 1) + " " + (costList.get(higherIndex).index);
				}
			}
		}
		return null;
	}

	static class Node {
		int cost;
		int index;

		public Node(int cost, int index) {
			super();
			this.cost = cost;
			this.index = index;
		}

		@Override
		public String toString() {
			return "Node [cost=" + cost + ", index=" + index + "]";
		}

	}
}
