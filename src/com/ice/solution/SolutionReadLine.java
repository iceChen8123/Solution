package com.ice.solution;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolutionReadLine {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		for (int z = 0; z < t; z++) {
			int n = Integer.parseInt(br.readLine().trim());
			int[] ints = new int[n];
			for (int y = 0; y < n; y++) {
				ints[y] = Integer.parseInt(br.readLine().trim());
			}
			System.out.println(ints);
		}
	}

}