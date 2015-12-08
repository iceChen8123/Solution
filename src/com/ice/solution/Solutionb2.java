package com.ice.solution;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solutionb2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		String s;
		StringTokenizer st;
		Player Player[] = new Player[N];
		Checker check = new Checker();
		for (int i = 0; i < N; i++) {
			s = br.readLine().trim();
			st = new StringTokenizer(s);
			Player[i] = new Player();
			Player[i].name = st.nextToken();
			Player[i].score = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(Player, check.desc);
		for (int i = 0; i < Player.length; i++) {
			System.out.printf("%s %s\n", Player[i].name, Player[i].score);
		}

	}
}

class Player {
	String name;
	int score;
}

class Checker implements Comparator<Player> {
	static Checker asc = new Checker(true);
	static Checker desc = new Checker(false);

	private boolean sortAsAsc = true;

	public Checker() {
	}

	public Checker(boolean asc) {
		sortAsAsc = asc;
	}

	public int compare(Player player1, Player player2) {
		if (player1.score != player2.score) {
			return (player1.score - player2.score) * (sortAsAsc ? 1 : -1);
		} else {
			return player1.name.compareTo(player2.name) * (sortAsAsc ? 1 : -1);
		}
	}
}