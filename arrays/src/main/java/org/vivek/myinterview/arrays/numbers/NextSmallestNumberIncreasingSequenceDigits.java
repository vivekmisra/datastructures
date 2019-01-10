package org.vivek.myinterview.arrays.numbers;

public class NextSmallestNumberIncreasingSequenceDigits {
	/**
	 * http://www.careercup.com/question?id=4857362737266688 Test cases :
	 * 
	 * 26 -> 27 ;123 -> 124 ;179 -> 189; 189 -> 234; 623 -> 678 ;987 -> 1234 The
	 * problem can be divided into 2 patterns. One in which there is valid
	 * increasing seq and other where there is no such seq. Obviously check for
	 * firstDigit <lastDigit will be part of logic. if firstDigit <lastDigit, you
	 * still need to check if rest of remaining digits contained between are in
	 * increasing sequence For this you can check diff of lastElement with next
	 * element traversing reverse. If diff is negative, it is not an increasing
	 * sequence. Next, task is to check pattern rule inside increasing seq digits.
	 * if all digits are <9 then you can simply add 1. But if lastDigit is 9, then
	 * you need to check all previous element traversing reverse.
	 */
	public NextSmallestNumberIncreasingSequenceDigits() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println(" getCorrectIncreasingSequenceDigits(" + 8 + ")=" + getCorrectIncreasingSequenceDigits(8));
		System.out.println(" getCorrectIncreasingSequenceDigits(" + 3259 + ")=" + getCorrectIncreasingSequenceDigits(3259));
		System.out.println(" getCorrectIncreasingSequenceDigits(" + 3529 + ")=" + getCorrectIncreasingSequenceDigits(3259));
		System.out.println(
				" getCorrectIncreasingSequenceDigits(" + 3917 + ")=" + getCorrectIncreasingSequenceDigits(3917));

		System.out.println(
				" getCorrectIncreasingSequenceDigits(" + 3129 + ")=" + getCorrectIncreasingSequenceDigits(3129));
		System.out
				.println(" getCorrectIncreasingSequenceDigits(" + 123 + ")=" + getCorrectIncreasingSequenceDigits(123));
		System.out.println(
				" getCorrectIncreasingSequenceDigits(" + 1234 + ")=" + getCorrectIncreasingSequenceDigits(1234));

		System.out.println(" getCorrectIncreasingSequenceDigits(" + 26 + ")=" + getCorrectIncreasingSequenceDigits(26));
		System.out.println(" getCorrectIncreasingSequenceDigits(" + 29 + ")=" + getCorrectIncreasingSequenceDigits(29));

		System.out.println(" getCorrectIncreasingSequenceDigits(" + 91 + ")=" + getCorrectIncreasingSequenceDigits(91));

		System.out
				.println(" getCorrectIncreasingSequenceDigits(" + 179 + ")=" + getCorrectIncreasingSequenceDigits(179));
		System.out
				.println(" getCorrectIncreasingSequenceDigits(" + 189 + ")=" + getCorrectIncreasingSequenceDigits(189));
		System.out
				.println(" getCorrectIncreasingSequenceDigits(" + 623 + ")=" + getCorrectIncreasingSequenceDigits(623));
		System.out
				.println(" getCorrectIncreasingSequenceDigits(" + 987 + ")=" + getCorrectIncreasingSequenceDigits(987));
		System.out.println(
				" getCorrectIncreasingSequenceDigits(" + 3197 + ")=" + getCorrectIncreasingSequenceDigits(3197));

		System.out.println(
				" getCorrectIncreasingSequenceDigits(" + 31879 + ")=" + getCorrectIncreasingSequenceDigits(31879));

	}

	static Integer getCorrectIncreasingSequenceDigits(Integer n) {
		Integer[] digits = getDigitsArray(n);
		int len = digits.length;
		if (len == 0) {
			return -1;
		}
		if (len == 1) {
			return n;
		}
		int firstDigit = digits[0];
		int lastDigit = digits[len - 1];
		int digitIndexToBeIncremented = -1;
		boolean isIncreasingSeq = false;
		int roundingFlagIndex = -1;
		boolean roundFlagAbove = false;
		for (int i = len - 2; i >= 0; i--) {
			if (firstDigit < lastDigit & (i + 1) >= 0) {
				int diff = digits[i + 1] - digits[i];
				if (diff > 0) {
					isIncreasingSeq = true;
					roundingFlagIndex = 0;
				} else {
					roundingFlagIndex = i;
					isIncreasingSeq = false;
					break;
				}
			}
		}

		if (!isIncreasingSeq && (roundingFlagIndex == 1)) {
			roundFlagAbove = true;
		} else {
			roundFlagAbove = false;
		}

		if (isIncreasingSeq) {
			// case1
			if (lastDigit == 9) {
				int i = len - 1;
				while (i > 0) {
					int diff = 9 - digits[i];
					if (diff >= 2) {
						digitIndexToBeIncremented = i;
						break;
					}
					i--;
				}
				if (digitIndexToBeIncremented != -1) {
					digits[digitIndexToBeIncremented]++;
				} else {
					int roundedNumber = roundAbove(n, len);
					digits = getDigitsArray(roundedNumber);
					firstDigit = digits[0];
					constructIncreasingSeqArray(digits, firstDigit);
				}
				// case2
			} else if (lastDigit < 9) {
				digits[len - 1]++;
			}

		} else {// case3
			if (firstDigit < lastDigit) {
				if (roundFlagAbove) {

					int roundedNumber = roundAbove(n, len);
					digits = getDigitsArray(roundedNumber);
					firstDigit = digits[0];
					constructIncreasingSeqArray(digits, firstDigit);
				} else if (!roundFlagAbove) {
					int roundedNumber = roundBelow(n, len);
					digits = getDigitsArray(roundedNumber);
					firstDigit = digits[0];
					constructIncreasingSeqArray(digits, firstDigit);
				}
			}

			if (firstDigit > lastDigit & !isIncreasingSeq) {
				if (firstDigit <= 9 && lastDigit < 9) {
					if (firstDigit == 9) {
						int roundedNumber = roundAbove(n, len);
						digits = getDigitsArray(roundedNumber);
						firstDigit = digits[0];
						constructIncreasingSeqArray(digits, firstDigit);
					} else {
						int roundedNumber = roundBelow(n, len);
						digits = getDigitsArray(roundedNumber);
						firstDigit = digits[0];
						constructIncreasingSeqArray(digits, firstDigit);
					}
				}
			}

		}

		n = getNumberFromDigitsArray(digits);
		return n;
	}

	static Integer[] getDigitsArray(int n) {
		NumberOfDigits noOfDigits = new NumberOfDigits();
		int length = noOfDigits.divideAndConquer(n);
		Integer[] digits = new Integer[length];
		int i = length - 1;
		while (i >= 0) {
			digits[i] = n % 10;
			n = n / 10;
			i--;
		}
		return digits;
	}

	static Integer getNumberFromDigitsArray(Integer[] digits) {
		int num = 0;
		for (int digit : digits) {
			num = 10 * num + digit;
		}
		return num;
	}

	private static void constructIncreasingSeqArray(Integer[] digits, int firstDigit) {
		int i = 1;
		while (i < digits.length) {
			digits[i] = ++firstDigit;
			i++;
		}

	}

	static int roundAbove(int num, int len) {
		int rounded = 0;

		StringBuilder sb = new StringBuilder("1");
		for (int i = 0; i < len - 1; i++) {
			sb.append((char) ('0'));
		}
		int factor = Integer.valueOf(sb.toString());

		rounded = ((num + (factor - 1)) / factor) * factor;

		return rounded;
	}

	static int roundBelow(int num, int len) {
		StringBuilder sb = new StringBuilder("1");
		for (int i = 0; i < len - 1; i++) {
			sb.append((char) ('0'));
		}
		int factor = Integer.valueOf(sb.toString());

		int rounded = 0;

		rounded = ((num - (factor - 1)) / factor) * factor + factor;

		return rounded;
	}

}
