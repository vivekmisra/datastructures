package com.interview.array;

public class FindOdds {

	public FindOdds() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		oddNumbers(97, 98);
	}

	static int[] oddNumbers(int l, int r) {
		boolean bOdd = (l % 2 == 1) && (r % 2 == 1);
		boolean bEven = (l % 2 == 0) && (r % 2 == 0);
		boolean lOddAndrEven = (l % 2 == 1) && (r % 2 == 0);
		boolean lEvenAndrOdd = (l % 2 == 0) && (r % 2 == 1);
		int size = 0;
		if (r == l) {
			int[] oddNumbers = new int[1];
			oddNumbers[0] = l;
			System.out.println(oddNumbers[0]);
			return oddNumbers;
		}
		if (bOdd) {
			size = (r - l) / 2 + 1;
			return popualateOdds(size, l, r);

		} else if (bEven) {
			l = l + 1;// min range element becomes odd
			r = r - 1;// max range element becomes odd
			size = (r - l) / 2 + 1;
			if (r == l) {
				int[] oddNumbers = new int[1];
				oddNumbers[0] = l;
				System.out.println(oddNumbers[0]);
				return oddNumbers;
			} else {
				return popualateOdds(size, l, r);
			}
		} else if (lOddAndrEven) {
			r = r - 1; // max range element becomes odd
			size = (r - l) / 2 + 1;
			if (r == l) {
				int[] oddNumbers = new int[1];
				oddNumbers[0] = l;
				System.out.println(oddNumbers[0]);
				return oddNumbers;
			} else {
				return popualateOdds(size, l, r);
			}
		} else if (lEvenAndrOdd) {
			size = (r - l) / 2 + 1;
			l = l + 1; // min range element becomes odd
			if (r == l) {
				int[] oddNumbers = new int[1];
				oddNumbers[0] = l;
				System.out.println(oddNumbers[0]);
				return oddNumbers;
			} else {
				return popualateOdds(size, l, r);
			}
		}
		return null;

	}

	static int[] popualateOdds(int size, int l, int r) {
		int[] oddNumbers = new int[size];
		int i = 0;
		while (l <= r) {
			if (i < size) {
				oddNumbers[i] = l;
				System.out.println(oddNumbers[i]);
				l = l + 2;
				i++;
			}

		}
		return oddNumbers;
	}
}
