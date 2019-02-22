package org.vivek.myinterview.trees.problems;

import java.util.Arrays;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.TNode;

public class FindAncestors {
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		//int[] num = { 2, 4, 5, 6, 8, 9, 10, 12, 14 };
		int[] num = { 2, 4, 5, 6, 7,8, 9,10, 11, 12, 14 };
		Arrays.sort(num);
		TNode root = SortedArrayToBST.sortedArrayToBST(num);
		TNode temp1 = root;
		BTreePrinter.printNode(temp1);
		System.out.println("Ancestors:");
		System.out.println(findAncestors(root, 4));
		

		
		

	}

	public static String findAncestors(TNode root, int k) {
		if (root == null) {
			return "null";
		}
		StringBuilder ancestors = new StringBuilder();
		TNode current = root;
		while (current != null) {
			if (k > current.data) {
				ancestors.append(current.data);
				ancestors.append(",");
				current = current.right;
			} else if (k < current.data) {
				ancestors.append(current.data);
				ancestors.append(",");
				current = current.left;
			} else {
				return ancestors.toString().substring(0, ancestors.toString().length() - 1);
			}

		}
		return "";
	}

	// predecessor

	public static TNode predecessor(TNode root, TNode p) {
		if (root == null)
			return null;

		/*
		 * if ( p.data>root.data) { return predecessor(root.right, p); } else if
		 * ( p.data<root.data) { return predecessor(root.left, p); // return
		 * (right != null) ? right : root; }
		 * 
		 * return (root.left != null) ? root.left : root;
		 */
		StringBuilder ancestors = new StringBuilder();
		TNode current = root;
		while (current != null) {

			if (p.data >= current.data) {

				current = current.right;

			} else if (p.data < current.data) {

				current = current.left;
				// return (current.left != null) ? current.left : current;
			}
			return (current.right != null) ? current.right : current;
		}
		return current;

	}

	

}
