package org.vivek.myinterview.trees.traversal;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.TNode;

public class DefectiveTreeGoogle {

	public static void main(String[] args) {
		System.out.println(
				"Consider a binary tree, where an arbitary node has 2 parents i.e two nodes in the tree have the same child. \n 1-Identify the defective node with 2 parents.\n 2-Correct such a node and restore the binary tree properties to that node.\n");

		TNode root = new TNode(0);
		TNode left = new TNode(1);
		TNode right = new TNode(2);
		TNode defective = new TNode(3);
		root.left = left;
		root.right = right;
		left.right = defective;
		right.right = defective;
		BTreePrinter.printNode(root);
		fixBinaryTree(root);
		BTreePrinter.printNode(root);
	}

	public static void fixBinaryTree(TNode root) {
		// fixTree(root, new HashSet<TNode>());
		fixTreeBFS(root);
	}

	private static void fixTreeBFS(TNode root) {
		if (root == null)
			return;

		Set<TNode> visited = new HashSet<TNode>();
		Queue<TNode> q = new LinkedList<TNode>();

		q.add(root);

		while (!q.isEmpty()) {
			TNode node = q.poll();
			if (node.left != null) {
				if (visited.contains(node.left)) {
					System.out.println("Found defective : " + node.left.data);
					System.out.println("Fixed by removing left from parent : " + node.data);
					node.left = null;
				} else {
					visited.add(node.left);
					q.add(node.left);
				}
			}

			if (node.right != null) {
				if (visited.contains(node.right)) {
					System.out.println("Found defective : " + node.right.data);
					System.out.println("Fixed by removing right from parent : " + node.data);
					node.right = null;
				} else {
					visited.add(node.right);
					q.add(node.right);
				}
			}

		}

	}

	private static void fixTree(TNode node, Set<TNode> visited) {
		if (node == null)
			return;

		if (node.left != null) {
			if (visited.contains(node.left)) {
				System.out.println("Found defective : " + node.left.data);
				System.out.println("Fixed by removing left from parent : " + node.data);
				node.left = null;
			} else {
				visited.add(node.left);
				fixTree(node.left, visited);
			}
		}

		if (node.right != null) {
			if (visited.contains(node.right)) {
				System.out.println("Found defective : " + node.right.data);
				System.out.println("Fixed by removing right from parent : " + node.data);
				node.right = null;
			} else {
				visited.add(node.right);
				fixTree(node.right, visited);
			}
		}
	}

	
}