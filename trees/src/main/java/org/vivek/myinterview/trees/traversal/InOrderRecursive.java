package org.vivek.myinterview.trees.traversal;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.TreeNode;

public class InOrderRecursive {
	static Integer arr[] = { 50, 25, 1, 12, 75, 62, 100 };
	static TreeNode root = null;

	public InOrderRecursive() {
		// TODO Auto-generated constructor stub
		root = null;
	}

	static TreeNode treeins(Integer arr[]) {
		for (int i = 0; i < arr.length; i++) {
			TreeNode root = insert(arr[i]);
		}
		return root;

	}

	// This method mainly
	// calls insertRec()
	static TreeNode insert(Integer data) {

		return root = insertRec(root, data);
	}

	/*
	 * A recursive function to insert a new key in BST
	 */
	static TreeNode insertRec(TreeNode root, Integer data) {

		/*
		 * If the tree is empty, return a new node
		 */
		if (root == null) {
			root = new TreeNode(data);
			return root;
		}

		/*
		 * Otherwise, recur down the tree
		 */

		boolean compareValue = (root.val > data);
		System.out.println("root =" + root.val + ",data=" + data);
		if (compareValue) {
			root.left = insertRec(root.left, data);
		} else {
			root.right = insertRec(root.right, data);
		}
		System.out.println("returning root =" + root.val);
		if (root.left != null) {
			System.out.println("...root.left=" + root.left.val);
		} else {
			System.out.println("....root.left=" + null);
		}
		if (root.right != null) {
			System.out.println("...root.right=" + root.right.val);
		} else {
			System.out.println("...root.right=" + null);
		}
		/* return the root */
		return root;
	}

	public static void inOrder(TreeNode root) {
		if (root != null) {
			if (root.left != null) {
				// System.out.print("-->");
				inOrder(root.left);
			}
			System.out.print(" ");
			System.out.print(root.val);
			if (root.right != null) {
				// System.out.print("-->");
				inOrder(root.right);
			}
		}
	}

	private static TreeNode constructTree() {
		TreeNode root = new TreeNode(50);
		TreeNode n11L = new TreeNode(25);
		TreeNode n12R = new TreeNode(75);
		TreeNode n11L_21L = new TreeNode(1);
		TreeNode n11L_22R = new TreeNode(12);
		TreeNode n12R_21L = new TreeNode(62);
		TreeNode n12R_22R = new TreeNode(100);

		root.left = n11L;
		root.right = n12R;

		n11L.left = n11L_21L;
		n11L.right = n11L_22R;
		n12R.left = n12R_21L;
		n12R.right = n12R_22R;

		return root;
	}

	public static void main(String[] args) {

		// BTreePrinter.printNode(constructTree());
		// inOrder(constructTree());
		BTreePrinter.printNode(treeins(arr));
		inOrder(treeins(arr));

	}

}
