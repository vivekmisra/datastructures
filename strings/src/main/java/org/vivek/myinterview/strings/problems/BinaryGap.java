package org.vivek.myinterview.strings.problems;

public class BinaryGap {

	public BinaryGap() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println(solutionLoop(22));
		System.out.println(findConsecutiveBinaryGap(5) );
		System.out.println(findConsecutiveBinaryGap(1041));
		System.out.println(findConsecutiveBinaryGap(1162));
		System.out.println(findConsecutiveBinaryGap(561892));
		System.out.println(findConsecutiveBinaryGap(66561));
		System.out.println(findConsecutiveBinaryGap(6291457));// 20
		System.out.println(findConsecutiveBinaryGap(74901729));// 4
		System.out.println(findConsecutiveBinaryGap(1376796946));// 5
		System.out.println(findConsecutiveBinaryGap(1073741825));// 29
		System.out.println(findConsecutiveBinaryGap(1610612737) == solutionLoop(1610612737));// 28
	}

	public static int findConsecutiveBinaryGap(int N) {
		System.out.println("N="+N +",Binary:");
		String s = Integer.toBinaryString(N);
		System.out.print(s);
		System.out.println();
		int[] counts = new int[256];
		int count = 0;
		char currChar;
		int max = 0;
		char c = '0';
		if (s.charAt(0) != '1' || s.charAt(s.length() - 1) != '1') {
			return 0;
		} else {
			for (int i = 1; i < s.length() - 1; i++) {
				currChar = s.charAt(i);
				if (currChar == c) {// match
					counts[c]++;
					if (counts[c] > max) {// return accumulated counts if you have
						max = counts[c];
					}
				} else if (currChar == '1') {
					counts[c] = 0;
				}
			}
		}
		return max+1;

	}

	static int solutionLoop(int n) {
		int current = 0;
		int max = 0;
		while (n > 0) {
			if (n % 2 == 0)
				++current;
			else {
				max = Math.max(max, current);
				current = 0;
			}
			n /= 2;
		}
		return max;
	}

	static int solutionRecursion(int n) {
		return solution(n, 0, 0);
	}

	static int solution(int n, int max, int current) {
		if (n == 0)
			return max;
		else if (n % 2 == 0)
			return solution(n / 2, max, current + 1);
		else
			return solution(n / 2, Math.max(max, current), 0);
	}
}
