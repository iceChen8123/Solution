package com.ice.solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class SolutionTheMaximumSubarray {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int z = 0; z < t; z++) {
			int n = in.nextInt();
			NewList sumList = new NewList();
			for (int y = 0; y < n; y++) {
				sumList.add(Long.parseLong(in.nextInt() + ""));
			}
			sumList.cutHeadAndTailNeg();

			Long maxNotCon = calcNotConMax(sumList);

			Long maxCon = Long.MIN_VALUE;
			if (sumList.getMax() > maxCon) {
				maxCon = sumList.getMax();
			}
			if (maxCon > 0) {
				maxCon = findMax(sumList, maxCon);
			}
			System.out.println(maxCon + " " + maxNotCon);
		}
	}

	private static Long findMax(NewList sumList, Long maxCon) {
		// System.out.println(sumList);
		sumList.cutHeadAndTailNeg();
		if (sumList.size() == 1) {
			return sumList.getMax() > maxCon ? sumList.getMax() : maxCon;
		} else {
			NewNodeList nodeList = transNewListToNodeList(sumList);
			NewList sumListnew = new NewList();
			for (Node node : nodeList) {
				sumListnew.addNode(node);
			}
			if (sumListnew.getMax() > maxCon) {
				maxCon = sumListnew.getMax();
			}
			return findMax(sumListnew, maxCon);
		}
	}

	private static NewNodeList transNewListToNodeList(NewList sumList) {
		NewNodeList nodeList = new NewNodeList();
		int index = 1;
		Node node = new Node();
		for (Long num : sumList) {
			if (index == 1) {
				node.value = num;
				node.head = num;
			} else if (index % 2 == 0) {
				node.value = node.value + num;
			} else {
				node.value = node.value + num;
				nodeList.add(node);
				node = new Node();
				node.value = num;
				node.head = num;
			}
			index++;
		}
		return nodeList;
	}

	private static Long calcNotConMax(NewList sumList) {
		Long maxNotCon = 0l;
		if (sumList.getMax() <= 0) {
			maxNotCon = sumList.getMax();
		} else {
			for (Long integer : sumList) {
				if (integer > 0) {
					maxNotCon += integer;
				}
			}
		}
		return maxNotCon;
	}

	static class Node {
		private long value;
		private long head;

		public long getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public long getHead() {
			return head;
		}

		public void setHead(int head) {
			this.head = head;
		}

	}

	static class NewNodeList extends ArrayList<Node> {

		private Long lastin = 0l;

		private TreeSet<Node> treeSet = new TreeSet<Node>(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				return (int) (o1.value - o2.value);
			}
		});

		public Long getMax() {
			return treeSet.last().value;
		}

		public void cutHeadAndTailNeg() {
			if (treeSet.last().value >= 0) {
				if (get(size() - 1).value < 0) {
					remove(size() - 1);
				}
				if (get(0).value < 0) {
					remove(0);
				}
			}
		}

		public boolean add(Node node) {
			treeSet.add(node);
			if (treeSet.size() > 0 && ((node.value > 0 && lastin > 0) || (node.value < 0 && lastin < 0))) { // 不是第一个，且为同号
				Long lastvalue = get(size() - 1).value;
				get(size() - 1).value = lastvalue + node.value - node.head;
				treeSet.add(get(size() - 1));
			} else {
				if (node.value != 0) {
					super.add(node);
				}
			}
			recordLast(node);
			return true;
		}

		private void recordLast(Node node) {
			lastin = node.value;
		}
	}

	static class NewList extends ArrayList<Long> {

		private Long lastin = 0l;

		private TreeSet<Long> treeSet = new TreeSet<Long>();

		public Long getMax() {
			return treeSet.last();
		}

		public void cutHeadAndTailNeg() {
			if (treeSet.last() >= 0) {
				if (get(size() - 1) < 0) {
					remove(size() - 1);
				}
				if (get(0) < 0) {
					remove(0);
				}
			}
		}

		public void addNode(Node node) {
			treeSet.add(node.value);

			if ((node.value >= 0 && lastin >= 0) || (node.value <= 0 && lastin <= 0)) {
				if (size() == 0) {
					super.add(node.value);
				} else {
					Long last = get(size() - 1);
					set(size() - 1, last + node.value - node.head);
					treeSet.add(get(size() - 1));
				}
			} else {
				super.add(node.value);
			}
			recordLast(node.value);
		}

		public boolean add(Long e) {
			treeSet.add(e);
			if ((e >= 0 && lastin >= 0) || (e <= 0 && lastin <= 0)) { // 与上一个为同号
				if (size() == 0) {
					super.add(e);
				} else {
					Long last = get(size() - 1);
					set(size() - 1, last + e);
					treeSet.add(last + e);
				}
			} else {
				super.add(e);
			}
			recordLast(e);
			return true;
		}

		private void recordLast(Long e) {
			lastin = e;
		}
	}
}