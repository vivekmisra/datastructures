package org.vivek.myinterview.trees.problems;

import java.util.Arrays;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.TreeNode;

public class KthMaxValueNode {

	public KthMaxValueNode() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] num = { 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14 };
		Arrays.sort(num);
		TreeNode root = SortedArrayToBST.sortedArrayToBST(num);
		TreeNode temp1 = root;
		BTreePrinter.printNode(temp1);
		int kthMax= KthMaxValueNode.findKthMax(root, 3);
		System.out.println("kthMax="+kthMax);
	}

	public static int findKthMax(TreeNode root, int k) {

		// Perform In-Order Traversal to get sorted array. (ascending order)
		// Return value at index [length - k]
		StringBuilder result = new StringBuilder(); // StringBuilder is immutable
		result = inOrderTraversal(root, result);

		String[] array = result.toString().split(","); // Spliting String into array of strings
		if ((array.length - k) >= 0)
			return Integer.parseInt(array[array.length - k]);

		return -1;
	}

	// Helper recursive function to traverse tree using inorder traversal
	// and return result in StringBuilder
	public static StringBuilder inOrderTraversal(TreeNode root, StringBuilder result) {

		if (root.left != null) {
			inOrderTraversal(root.left, result);
		}
		result.append(root.val + ",");

		if (root.right != null) {
			inOrderTraversal(root.right, result);
		}

		return result;
	}

}
