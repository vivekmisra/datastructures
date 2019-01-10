package org.vivek.myinterview.arrays.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberManipulationUtils {

	public NumberManipulationUtils() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 3917;
		int n = findSmallestNumberGreaterThanGiveNumberIncreasingSequence(input);
		System.out.println(" findSmallestNumberGreaterThanGiveNumberIncreasingSequence(" + input + ")=" + n);
		String inputStr = String.valueOf(input);
		System.out.println(" inputStr =" + inputStr);
		n = Integer.parseInt(nextSequence(inputStr));
		System.out.println(" nextString(" + input + ")=" + n);

		System.out.println(" findSmallestNumberGreaterThanGiveNumberIncreasingSequence(" + 109 + ")="
				+ findSmallestNumberGreaterThanGiveNumberIncreasingSequence(109));
		System.out.println(" nextSequence(" + 109 + ")=" + nextSequence("109"));
		System.out.println(" findSmallestNumberGreaterThanGiveNumberIncreasingSequence(" + 129 + ")="
				+ findSmallestNumberGreaterThanGiveNumberIncreasingSequence(129));
		System.out.println(" nextSequence(" + 129 + ")=" + nextSequence("129"));

		System.out.println("getDigitsArray(" + 129 + ")=" + Arrays.deepToString(getDigitsArray(129)));

	
		System.out.println(" getSmallestNumberGreaterThanGivenNumberWithIncreasingSequenceDigits(" + 3917 + ")="
				+ getSmallestNumberGreaterThanGivenNumberWithIncreasingSequenceDigits(3917));
		System.out.println(" getSmallestNumberGreaterThanGivenNumberWithIncreasingSequenceDigits(" + 123 + ")="
				+ getSmallestNumberGreaterThanGivenNumberWithIncreasingSequenceDigits(123));
		System.out.println(" getSmallestNumberGreaterThanGivenNumberWithIncreasingSequenceDigits(" + 26 + ")="
				+ getSmallestNumberGreaterThanGivenNumberWithIncreasingSequenceDigits(26));
		System.out.println(" getSmallestNumberGreaterThanGivenNumberWithIncreasingSequenceDigits(" + 179 + ")="
				+ getSmallestNumberGreaterThanGivenNumberWithIncreasingSequenceDigits(179));
		System.out.println(" getSmallestNumberGreaterThanGivenNumberWithIncreasingSequenceDigits(" + 189 + ")="
				+ getSmallestNumberGreaterThanGivenNumberWithIncreasingSequenceDigits(189));
		System.out.println(" getSmallestNumberGreaterThanGivenNumberWithIncreasingSequenceDigits(" + 623 + ")="
				+ getSmallestNumberGreaterThanGivenNumberWithIncreasingSequenceDigits(623));
		System.out.println(" getSmallestNumberGreaterThanGivenNumberWithIncreasingSequenceDigits(" + 987 + ")="
				+ getSmallestNumberGreaterThanGivenNumberWithIncreasingSequenceDigits(987));
		System.out.println(" getSmallestNumberGreaterThanGivenNumberWithIncreasingSequenceDigits(" + 3129 + ")="
				+ getSmallestNumberGreaterThanGivenNumberWithIncreasingSequenceDigits(3197));

	}

	/**
	 * http://www.careercup.com/question?id=4857362737266688 Test cases : 6 2 3 -> 6
	 * 7 8 1 2 3 -> 1 2 4 1,7,9 -> 1,8,9 1,8,9 -> 2,3,4 9,8,7 -> 1,2,3,4 2,6 -> 2,7
	 */

	public static String nextString(String num) {
		char[] numArr = num.toCharArray();

		boolean canBeIncrementedWithinTheSameNumberOfDigit = true;

		for (int i = 0; i < numArr.length; i++) {

			if ((10 - (numArr[i] - '0')) < (numArr.length - 1 - i)) {
				canBeIncrementedWithinTheSameNumberOfDigit = false;
				break;
			}

		}

		if (canBeIncrementedWithinTheSameNumberOfDigit) {

			for (int i = 0; i < numArr.length; i++) {
				numArr[i] = ++numArr[i];
			}
			System.out.println("newNumArr=" + new String(numArr));
			return new String(numArr);

		} else {
			char[] newNumArr = new char[numArr.length + 1];
			for (int i = 0; i <= numArr.length; i++) {
				newNumArr[i] = (char) ('0' + (i + 1));
			}
			System.out.println("newNumArr=" + new String(newNumArr));
			return new String(newNumArr);
		}

	}

	static int findSmallestNumberGreaterThanGiveNumberIncreasingSequence(int n) {
		String input = String.valueOf(n);
		// input = "189";
		char[] inputArray = input.toCharArray();
		int inputLength = inputArray.length;
		int firstDigit = Integer.parseInt(String.valueOf(input.charAt(0)));
		int lastDigit = Integer.parseInt(String.valueOf(input.charAt(inputLength - 1)));
		boolean validSeq = (firstDigit < 9 && (firstDigit < lastDigit));
		int index = 0;
		String s = "0";
		if (input.length() < 1) {
			System.out.println("Invalid input");
			return -1;
		} else if (input.length() == 1) {
			System.out.println("no smaller number possible");
			return Integer.parseInt(input);
		} else if ((inputLength == 2) && validSeq) {
			lastDigit++;
			s = String.valueOf(firstDigit) + String.valueOf(lastDigit);
			return Integer.parseInt(s);
		} else {
			if (validSeq) {
				if (lastDigit <= 9 && firstDigit < 9) {
					++index;
					if (index < inputLength - 1) {
						s = checkAndIncrement(input, inputLength, index, firstDigit, lastDigit);

					}
					return Integer.parseInt(s);
				} else {

					s = checkAndIncrement(input, inputLength, index, firstDigit, lastDigit);
					return Integer.parseInt(s);
				}

			} else {
				if (firstDigit >= 9) {
					firstDigit = 1;
					String strFirstDigit = String.valueOf(firstDigit);
					StringBuffer sb = new StringBuffer(strFirstDigit);
					int currentIndex = 0;
					input = appendZeros(inputLength, sb, currentIndex);
					inputLength = input.length();
					lastDigit = 0;
					s = checkAndIncrement(input, inputLength, index, firstDigit, lastDigit);
					return Integer.parseInt(s);
				} else if (lastDigit >= 9 && firstDigit < 9) {

					String strFirstDigit = String.valueOf(firstDigit);
					StringBuffer sb = new StringBuffer(strFirstDigit);
					int currentIndex = 0;
					input = appendZeros(inputLength, sb, currentIndex);
					inputLength = input.length();
					lastDigit = 0;
					s = checkAndIncrement(input, inputLength, index, firstDigit, lastDigit);
					return Integer.parseInt(s);

				} else if (lastDigit <= 9 && firstDigit < 9) {
					s = checkAndIncrement(input, inputLength, index, firstDigit, lastDigit);
					return Integer.parseInt(s);
				}

			}

		}

		System.out.println(validSeq);
		return Integer.parseInt(s);

	}

	private static String appendZeros(int inputLength, StringBuffer sb, int currentIndex) {
		String input;
		while (currentIndex < inputLength) {
			sb.append("0");
			currentIndex++;
		}
		input = sb.toString();
		return input;
	}

	static String checkAndIncrement(String s, int inputLength, int currentIndex, int firstDigit, int lastDigit) {
		StringBuilder sb = new StringBuilder(inputLength);
		String strDigit = s.substring(1, 2);

		if ((firstDigit > lastDigit)) {

			s = "" + firstDigit;
			currentIndex = 1;
			sb = new StringBuilder(s);
			while (currentIndex < inputLength) {
				firstDigit++;
				s = String.valueOf(firstDigit);
				sb.append(s);
				currentIndex++;
			}
			s = sb.toString();
			return s;

		}

		if (currentIndex == inputLength - 2) {
			Integer previousDigit = Integer.parseInt(String.valueOf(s.charAt(currentIndex - 1)));
			Integer currentDigit = Integer.parseInt(String.valueOf(s.charAt(currentIndex)));

			if ((currentDigit < lastDigit - 1) && (currentDigit > previousDigit)) {
				currentDigit++;
				s = "" + previousDigit + currentDigit + lastDigit;

				return s;
			} else if ((currentDigit < previousDigit) && lastDigit >= 0) {

				currentDigit = previousDigit + 1;
				lastDigit = currentDigit + 1;
				s = previousDigit + "" + currentDigit + lastDigit;

				return s;
			} else if ((currentDigit > previousDigit) && lastDigit > currentDigit && lastDigit < 9) {

				lastDigit++;
				s = previousDigit + "" + currentDigit + lastDigit;

				return s;
			} else if (currentDigit > previousDigit && lastDigit > currentDigit && lastDigit == 9) {
				firstDigit++;
				s = String.valueOf(firstDigit);
				sb = new StringBuilder(s);
				currentIndex = 0;
				while (currentIndex < inputLength - 1) {
					sb.append("0");
					currentIndex++;
				}
				String input = sb.toString();
				inputLength = input.length();
				lastDigit = 0;
				s = checkAndIncrement(input, inputLength, 0, firstDigit, lastDigit);

				return s;
			}
		} else {
			firstDigit++;
			lastDigit = 0;
			sb.insert(0, firstDigit);
			s = sb.toString();
			int currentInputLength = s.length();
			while (currentInputLength < inputLength) {
				sb.append(0);
				currentInputLength++;
			}

			// sb.insert(inputLength-1, lastDigit);
			s = sb.toString();
			s = checkAndIncrement(s, inputLength, 1, firstDigit, lastDigit);

		}
		return s;

	}

	static String ref = "123456789";
	static int max = 123456789;

	public static String nextSequence(String str) {
		int num = Integer.parseInt(str);
		if (num > max)
			return "";

		int k = str.length();
		for (int i = 0; i <= ref.length() - k; i++) {
			int candidate = Integer.parseInt(ref.substring(i, i + k));
			if (candidate > num) {
				return "" + candidate;
			}
		}

		if (k + 1 <= ref.length())
			return ref.substring(0, k + 1);

		return "";
	}

	static int getSmallestNumberGreaterThanGivenNumberWithIncreasingSequenceDigits(int n) {

		n = getCorrectIncreasingSequenceDigits(n);
		/*
		 * if ((firstDigit < 9) && (lastDigit <= 9)) { isValidSequenceOfDigits =
		 * checkValidIncreasingSequenceDigits(digits); if (isValidSequenceOfDigits) { if
		 * (lastDigit < 9) { // constructIncreasingSeqArray(digits, firstDigit); //
		 * number = getNumberFromDigitsArray(digits); number = n + 1; } else { int
		 * roundedNumber = roundAbove(n); digits = getDigitsArray(roundedNumber);
		 * firstDigit = digits[0]; constructIncreasingSeqArray(digits, firstDigit);
		 * number = getNumberFromDigitsArray(digits);
		 * 
		 * } } else { int roundedNumber = roundBelow(n); digits =
		 * getDigitsArray(roundedNumber); firstDigit = digits[0];
		 * constructIncreasingSeqArray(digits, firstDigit); number =
		 * getNumberFromDigitsArray(digits); } } else { int roundedNumber =
		 * roundAbove(n); digits = getDigitsArray(roundedNumber); firstDigit =
		 * digits[0]; constructIncreasingSeqArray(digits, firstDigit); number =
		 * getNumberFromDigitsArray(digits); }
		 */

		return n;
	}

	private static void constructIncreasingSeqArray(Integer[] digits, int firstDigit) {
		int i = 1;
		while (i < digits.length) {
			digits[i] = ++firstDigit;
			i++;
		}

	}

	static int getLastDigit(int n) {
		int r = n % 10;
		return r;
	}

	static int getFirstDigit(int n) {
		while (n / 10 > 0) {
			n = n / 10;
		}
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

	static Integer getCorrectIncreasingSequenceDigits(Integer n) {
		Integer[] digits = getDigitsArray(n);
		int len = digits.length;
		int firstDigit = digits[0];
		int lastDigit = digits[len - 1];
		boolean isIncreasingSeq = false;
		for (int i = len - 1; i > 0; i--) {
			if (firstDigit < lastDigit & (i - 1) >= 0) {
				int diff = lastDigit - digits[i - 1];
				if (diff > 0) {
					isIncreasingSeq = true;
					if (firstDigit < 9 && lastDigit <= 9) {
						if (lastDigit == 9) {
							// check diff : lastDigit - (any)previousDigit >2 ,if yes ,increment else
							// resetAbove
							if (diff >= 2) {
								digits[i-1] = ++digits[i-1];
								break;
							}else {
								int roundedNumber = roundAbove(n);
								digits = getDigitsArray(roundedNumber);
								firstDigit = digits[0];
								constructIncreasingSeqArray(digits, firstDigit);
								break;
							}

						}
					}
				} else {
					isIncreasingSeq = false;
					break;
				}

			}
		}

		
		if (firstDigit < lastDigit & !isIncreasingSeq) {
			int roundedNumber = roundAbove(n);
			digits = getDigitsArray(roundedNumber);
			firstDigit = digits[0];
			constructIncreasingSeqArray(digits, firstDigit);
		} else if (firstDigit > lastDigit & !isIncreasingSeq) {
			if (firstDigit <= 9 && lastDigit < 9) {
				if (firstDigit == 9) {
					// resetAbove
					int roundedNumber = roundAbove(n);
					digits = getDigitsArray(roundedNumber);
					firstDigit = digits[0];
					constructIncreasingSeqArray(digits, firstDigit);
				} else {
					int roundedNumber = roundBelow(n);
					digits = getDigitsArray(roundedNumber);
					firstDigit = digits[0];
					constructIncreasingSeqArray(digits, firstDigit);
				}
			}
		}
		n = getNumberFromDigitsArray(digits);
		return n;
	}

	static int roundAbove(int num) {
		int rounded = ((num + 99) / 100) * 100;
		return rounded;
	}

	static int roundBelow(int num) {
		int rounded = 0;
		if (num > 100) {
			rounded = ((num - 99) / 100) * 100 + 100;
		}
		return rounded;
	}
}
