package org.vivek.myinterview.arrays.numbers;

import java.util.BitSet;
import java.util.Random;

public class BitSetExample {
	public static int N_BITS = 16;

	public BitSetExample() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// Constructors of BitSet class
		/*
		 * BitSet is a class defined in the java.util package. It creates an array of
		 * bits represented by boolean values. The size of the array is flexible and can
		 * grow to accommodate additional bit as needed. Because it is an array, the bit
		 * values can be accessed by non-negative integers as an index. The interesting
		 * aspect of BitSet is that it is easy to create and manipulate bit sets that
		 * basically represents a set of boolean flags.
		 */
		BitSet bs1 = new BitSet();
		BitSet bs2 = new BitSet(6);
		printBits("inital bit pattern of bs1: ", bs1);

		printBits("inital bit pattern of bs2: ", bs2);

		/*
		 * set is BitSet class method expalined in next articles
		 */
		bs1.set(0);
		bs1.set(1);
		bs1.set(2);
		bs1.set(4);

		// assign values to bs2
		bs2.set(4);
		bs2.set(6);
		bs2.set(5);
		bs2.set(1);
		bs2.set(2);
		bs2.set(3);

		// Printing the 2 Bitsets
		System.out.println("bs1  : " + bs1);
		System.out.println("bs2  : " + bs2);
		bs2.and(bs1);
		printBits("bs2 AND b1, bs2 = ", bs2);

		System.out.println("No. of set values in bs1=" + bs1.cardinality());
		System.out.println("No. of set values in bs2=" + bs2.cardinality());

		bs1.or(bs2);
		printBits("bs1 OR bs2, bs1 = ", bs1);

		bs2.xor(bs1);
		printBits("bs2 XOR bs1, bs2 = ", bs2);

		printBits("bs1 = ", bs1);
		System.out.println("indexes where bit is set in b1 " + bs1.toString());
		printBits("b2 = ", bs2);
		System.out.println("indexes where bit is set in b2 " + bs2.toString());
	}

	public static void setRandomBits(BitSet b) {
		Random r = new Random();
		for (int i = 0; i < N_BITS / 2; i++)
			b.set(r.nextInt(N_BITS));

	}

	public static void printBits(String prompt, BitSet b) {
		System.out.print(prompt + " ");
		for (int i = 0; i < N_BITS; i++) {
			System.out.print(b.get(i) ? "1" : "0");
		}
		System.out.println();
	}

}
