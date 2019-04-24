package org.vivek.myinterview.trees.traversal;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.TreeNode;

public class DefectiveTreeGoogle {

	public static void main(String[] args) {
		System.out.println(
				"Consider a binary tree, where an arbitary node has 2 parents i.e two nodes in the tree have the same child. \n 1-Identify the defective node with 2 parents.\n 2-Correct such a node and restore the binary tree properties to that node.\n");

		TreeNode root = new TreeNode(0);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		TreeNode defective = new TreeNode(3);
		root.left = left;
		root.right = right;
		left.right = defective;
		right.right = defective;
		BTreePrinter.printNode(root);
		fixBinaryTree(root);
		BTreePrinter.printNode(root);
	}

	public static void fixBinaryTree(TreeNode root) {
		// fixTree(root, new HashSet<TNode>());
		fixTreeBFS(root);
	}

	private static void fixTreeBFS(TreeNode root) {
		if (root == null)
			return;

		Set<TreeNode> visited = new HashSet<TreeNode>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node.left != null) {
				if (visited.contains(node.left)) {
					System.out.println("Found defective : " + node.left.val);
					System.out.println("Fixed by removing left from parent : " + node.val);
					node.left = null;
				} else {
					visited.add(node.left);
					q.add(node.left);
				}
			}

			if (node.right != null) {
				if (visited.contains(node.right)) {
					System.out.println("Found defective : " + node.right.val);
					System.out.println("Fixed by removing right from parent : " + node.val);
					node.right = null;
				} else {
					visited.add(node.right);
					q.add(node.right);
				}
			}

		}

	}

	private static void fixTree(TreeNode node, Set<TreeNode> visited) {
		if (node == null)
			return;

		if (node.left != null) {
			if (visited.contains(node.left)) {
				System.out.println("Found defective : " + node.left.val);
				System.out.println("Fixed by removing left from parent : " + node.val);
				node.left = null;
			} else {
				visited.add(node.left);
				fixTree(node.left, visited);
			}
		}

		if (node.right != null) {
			if (visited.contains(node.right)) {
				System.out.println("Found defective : " + node.right.val);
				System.out.println("Fixed by removing right from parent : " + node.val);
				node.right = null;
			} else {
				visited.add(node.right);
				fixTree(node.right, visited);
			}
		}
	}

	
}