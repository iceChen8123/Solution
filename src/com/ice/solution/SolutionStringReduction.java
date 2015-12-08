package com.ice.solution;

import java.util.Scanner;

public class SolutionStringReduction {

	static int stringReduction(String aaa) {
		char[] chars = aaa.toCharArray();
		int numa = 0;
		int numb = 0;
		int numc = 0;
		for (char cc : chars) {
			if (cc == 'a') {
				numa++;
			}
			if (cc == 'b') {
				numb++;
			}
			if (cc == 'c') {
				numc++;
			}
		}
		// System.out.println("a: " + numa + ";b: " + numb + ";c: " + numc);
		int min = 0;
		if ((numa == 0 && numb == 0) || (numa == 0 && numc == 0) || (numb == 0 && numc == 0)) {
			if (numa != 0) {
				min = numa;
			}
			if (numb != 0) {
				min = numb;
			}
			if (numc != 0) {
				min = numc;
			}
		} else {
			int fina = numa % 2;
			int finb = numb % 2;
			int finc = numc % 2;
			if ((fina + finb + finc) == 0) {
				min = 2; // 都为0，就是2....通过数据分析的。。。
			} else if ((fina + finb + finc) == 1) {
				min = 1;
			} else if ((fina + finb + finc) == 2) {
				min = 1;
			} else if ((fina + finb + finc) == 3) {
				min = 2;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int res;
		String[] strings = new String[t];
		for (int a0 = 0; a0 < t; a0++) {
			String ss = in.next();
			strings[a0] = ss;
			res = stringReduction(ss);
			System.out.println(res);
		}
		// System.out.println("---------------------------");
		// int[] indexs = new int[] { 6, 15, 16, 18, 30, 31, 39, 70, 73, 74, 96
		// };
		// for (int iii : indexs) {
		// System.out.println(strings[iii - 1]);
		// }
	}
}
