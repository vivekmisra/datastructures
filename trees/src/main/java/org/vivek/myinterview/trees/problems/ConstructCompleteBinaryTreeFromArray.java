package org.vivek.myinterview.trees.problems;

import java.util.Arrays;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.TreeNode;

public class ConstructCompleteBinaryTreeFromArray {

	public static void main(String[] args) {
		Integer[] nums = { 1, 2, 3, 4, null,6,null };
		TreeNode root = new TreeNode(1);
		root = insertLevelOrder(nums, root, 0);
		BTreePrinter.printNode(root);
	}

	// Function to insert nodes in level order
	public static TreeNode insertLevelOrder(Integer[] arr, TreeNode root, int i) {
		// Base case for recursion
		if (i < arr.length) {
			TreeNode temp = new TreeNode(arr[i]);
			root = temp;

			// insert left child
			if (root.left != null) {
				root.left = insertLevelOrder(arr, root.left, 2 * i + 1);
			} else {
				root.left = insertLevelOrder(arr, null, 2 * i + 1);
			}

			// insert right child
			if (root.right != null) {
				root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
			} else {
				root.right = insertLevelOrder(arr, null, 2 * i + 2);
			}
		}
		return root;
	}
	
}
