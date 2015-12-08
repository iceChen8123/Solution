package com.ice.solution;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class SolutionSnakesLadders {

	static TreeSet<Integer> badNodeIntegers = new TreeSet<Integer>();
	static TreeSet<Node> goodNodes = new TreeSet<Node>(new Comparator<Node>() {
		public int compare(Node o1, Node o2) {
			return o2.value - o1.value;
		}
	});
	static List<Side> sides = new ArrayList<Side>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int z = 0; z < t; z++) {
			int goodNodeNum = in.nextInt();
			for (int y = 0; y < goodNodeNum; y++) {
				int from = in.nextInt();
				int to = in.nextInt();
				goodNodes.add(new Node(from));
			}
			System.out.println("good: " + goodNodes.toString());
			System.out.println("sides: " + sides.toString());

			int badNodeNum = in.nextInt();
			for (int y = 0; y < badNodeNum; y++) {
				badNodeIntegers.add(in.nextInt());
				in.nextInt();
			}
			System.out.println("bad: " + badNodeIntegers.toString());

			processWithNodes();
		}
	}

	private static void processWithNodes() { // TODO
		Node node1 = new Node(1);
		Node node100 = new Node(100);
		goodNodes.add(node1);
		goodNodes.add(node100);
		for (Node goodnNode : goodNodes) {
			for (Node largerNode : goodNodes.headSet(goodnNode)) {
				System.out.println(largerNode.value + "   >>>>  " + goodnNode.value);
				sides.add(new Side(goodnNode, largerNode));
			}
		}
		System.out.println(sides);
	}

	static class Side {
		Node from;
		Node to;
		int length = 0;

		public Side(Node from, Node to) {
			this.from = from;
			this.to = to;
		}

		public Side(Node from, Node to, int length) {
			this.from = from;
			this.to = to;
			this.length = length;
		}

		public String toString() {
			return "Side [from=" + from + ", to=" + to + ", length=" + length + "]";
		}

	}

	static class Node {
		int value;

		public Node(int value) {
			this.value = value;
		}

		public String toString() {
			return "Node [value=" + value + "]";
		}
	}
}