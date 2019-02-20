package org.vivek.myinterview.trees.problems;

import java.util.Arrays;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.TNode;

public class SortedArrayToBST {

	public static void main(String[] args) {
		int[] num={2,4,5,6,8,9,10,12,14};
		Arrays.sort(num);
		TNode root = sortedArrayToBST(num);
		BTreePrinter.printNode(root);

	}
	public static TNode sortedArrayToBST(int[] num) {
		if (num.length == 0)
			return null;
 
		return sortedArrayToBST(num, 0, num.length - 1);
	}
 
	public static TNode sortedArrayToBST(int[] num, int start, int end) {
		if (start > end)
			return null;
 
		int mid = (start + end) / 2;
		TNode root = new TNode(num[mid]);
		root.left = sortedArrayToBST(num, start, mid - 1);
		root.right = sortedArrayToBST(num, mid + 1, end);
 
		return root;
	}

}
