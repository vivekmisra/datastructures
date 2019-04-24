package org.vivek.myinterview.trees.problems;

import java.util.Arrays;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.TreeNode;

public class FindAncestors {
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		//int[] num = { 2, 4, 5, 6, 8, 9, 10, 12, 14 };
		int[] num = { 2, 4, 5, 6, 7,8, 9,10, 11, 12, 14 };
		Arrays.sort(num);
		TreeNode root = SortedArrayToBST.sortedArrayToBST(num);
		TreeNode temp1 = root;
		BTreePrinter.printNode(temp1);
		System.out.println("Ancestors:");
		System.out.println(findAncestors(root, 4));
		System.out.println("predecessor:");
		TreeNode node = predecessor(root, 4);
		BTreePrinter.printNode(node);

		
		

	}
	
	
	
	public static String findAncestors(TreeNode root, int k) {
		if (root == null) {
			return "null";
		}
		StringBuilder ancestors = new StringBuilder();
		//TNode current = root;
		while (root != null) {
			if (k > root.val) {
				ancestors.append(root.val);
				ancestors.append(",");
				root = root.right;
			} else if (k < root.val) {
				ancestors.append(root.val);
				ancestors.append(",");
				root = root.left;
			} else {
				return ancestors.toString().substring(0, ancestors.toString().length() - 1);
			}

		}
		return "";
	}

	// predecessor

	public static TreeNode predecessor(TreeNode root, int k) {
		if (root == null)
			return null;

		/*
		 * if ( k>root.data) { return predecessor(root.right, p); } else if
		 * ( k<root.data) { return predecessor(root.left, p); // return
		 * (right != null) ? right : root; }
		 * 
		 * return (root.left != null) ? root.left : root;
		 */
		StringBuilder ancestors = new StringBuilder();
		TreeNode current = root;
		if(root.left==null && root.right==null) {
			return null;
		}
		while (current != null) {
			if (k >= current.val) {
				current = current.right;
			} else if (k < current.val) {
				current = current.left;				
			}
			if(current.left==null && current.right==null) {
				return null;
			}
			return (current.right != null) ? current.right : current;
		}
		return current;

	}
	
  

	

}
