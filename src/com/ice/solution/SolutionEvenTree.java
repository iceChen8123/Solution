package com.ice.solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SolutionEvenTree {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int nodeNum = in.nextInt();
		int edgeNum = in.nextInt();
		Map<Integer, Node> nodeCache = new HashMap<Integer, Node>();
		StringBuilder stringBuilder = new StringBuilder();
		for (int a0 = 0; a0 < edgeNum; a0++) {
			int n1 = in.nextInt();
			int n2 = in.nextInt();
			Node node1 = getNode(nodeCache, n1);
			Node node2 = getNode(nodeCache, n2);
			node1.addLinkedTo(node2);
			node2.addLinkedTo(node1);
		}
		stringBuilder.append("\n").append(calcRes(nodeCache.values()));
		System.out.println(stringBuilder.toString().substring(1));
	}

	private static Object calcRes(Collection<Node> values) {
		List<Node> nodes = new ArrayList<>(values);
		int delEdge = 0;
		boolean done = false;
		while (!done) {
			int del = 0;
			for (Node node : nodes) {
				List<Node> removes = new ArrayList<>();
				for (Node subNode : node.linkedTo) {
					if (subNode.countNodesWithout(node) % 2 == 0) {
						delEdge++;
						del++;
						removes.add(subNode);
					}
				}
				node.remove(removes);
			}
			if (del == 0) {
				done = true;
			}
		}
		return delEdge;
	}

	private static Node getNode(Map<Integer, Node> nodeCache, int n1) {
		Node node1;
		if (nodeCache.containsKey(n1)) {
			node1 = nodeCache.get(n1);
		} else {
			node1 = new Node(n1);
			nodeCache.put(n1, node1);
		}
		return node1;
	}

	static class Node {
		int value;
		List<Node> linkedTo = new ArrayList<>();

		public int countNodes() {
			return countNodesWithout(this);
		}

		public void remove(List<Node> removes) {
			for (Node node : removes) {
				linkedTo.remove(node);
				node.linkedTo.remove(this);
			}
		}

		private int countNodesWithout(Node callNode) {
			List<Node> tempList = new ArrayList<>(linkedTo);
			tempList.remove(callNode);
			if (tempList.size() == 0) {
				return 1;
			}
			// System.out.println("list: " + tempList.toString());
			return countNodes(tempList) + 1;
		}

		private int countNodes(List<Node> linkedNodes) {
			int num = 0;
			for (Node node : linkedNodes) {
				num += node.countNodesWithout(this);
			}
			return num;
		}

		public Node(int value) {
			super();
			this.value = value;
		}

		public void addLinkedTo(Node node) {
			linkedTo.add(node);
		}

		@Override
		public boolean equals(Object obj) {
			return this.value == ((Node) obj).value;
		}

		@Override
		public String toString() {
			StringBuilder stringBuilder = new StringBuilder("node[value=").append(value).append(",linked=(");
			for (Node node : linkedTo) {
				stringBuilder.append(",").append(node.value);
			}
			stringBuilder.append(")]");
			return stringBuilder.toString();
		}
	}

}