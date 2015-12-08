package com.ice.solution;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class SolutionSorting {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine().trim());
		String[] inputStrings = new String[num];
		for (int i = 0; i < num; i++) {
			inputStrings[i] = br.readLine().trim();
		}
		String[] outPutStrings = new String[num];
		for (int i = 0; i < num; i++) {
			String inString = inputStrings[i];
			outPutStrings[i] = calcOut(inString);
		}
		for (String outString : outPutStrings) {
			System.out.println(outString);
		}
	}

	private static String calcOut(String inString) {
		char[] chars = inString.toCharArray();
		NavigableSet<Character> treeSet = new TreeSet<Character>();
		treeSet = treeSet.descendingSet();

		char usefulChar = '0';
		int index = -1;
		for (int a = chars.length - 1; a >= 0; a--) {
			if (treeSet.headSet(chars[a]).size() == 0) {
				treeSet.add(chars[a]);
			} else {
				usefulChar = treeSet.headSet(chars[a]).last();
				index = a;
//				System.out.println("find: index: " + index + "  needChange: " + chars[a] + " --- Inset:"
//						+ treeSet.headSet(chars[a]) + "   usefulChar: " + new String(new char[] { usefulChar }));
				break;
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		if (index >= 0) {
			List<Character> list = new ArrayList<Character>();
			boolean firstTarget = true;
			for (int a = 0; a < chars.length; a++) {
				if (a < index) {
					stringBuilder.append(chars[a]);
				} else {
					if (chars[a] == usefulChar && firstTarget) {
						stringBuilder.append(chars[a]);
						firstTarget = false;
					} else {
						list.add(chars[a]);
					}
				}
			}
			Collections.sort(list);
			for (Character character : list) {
				stringBuilder.append(character);
			}
		} else {
			stringBuilder.append("no answer");
		}

		return stringBuilder.toString();
	}

}