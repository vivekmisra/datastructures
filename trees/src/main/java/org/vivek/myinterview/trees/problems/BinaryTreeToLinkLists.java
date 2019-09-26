package org.vivek.myinterview.trees.problems;

import java.util.Stack;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.TreeNode;

/**
 * http://www.careercup.com/question?id=6241652616200192 Test cases: 0,1 or more
 * nodes in the tree
 */
public class BinaryTreeToLinkLists {

	public void flattenRecursive(TreeNode root) {
		if (root == null)
			return;

		lastleaf(root);
	}

	TreeNode lastleaf(TreeNode node) {
		TreeNode left = node.left;
		TreeNode right = node.right;

		if (left == null && right == null) {
			return node;
		}

		if (left != null) {
			TreeNode leaf = lastleaf(left);
			leaf.right = right;
			node.right = left;
			node.left = null;
			node = leaf;
		}
		if (right != null) {
			return lastleaf(right);
		} else {
			return node;
		}

	}

	public static void flattenIterative(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.empty()) {
			TreeNode current = stack.pop();
			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}

			if (!stack.empty()) {
				current.right = stack.peek();

			}
			current.left = null;
		}

	}

	TreeNode root;

	// head --> Pointer to head node of created doubly linked list
	 TreeNode head;

	// Initialize previously visited node as NULL. This is
	// static so that the same value is accessible in all recursive
	// calls
	static TreeNode prev = null;

	void  convertBinaryTreeToDoubleyLinkList(TreeNode root) {
		// Base case
		if (root == null)
			return;

		// Recursively convert left subtree
		convertBinaryTreeToDoubleyLinkList(root.left);

		// Now convert this node
		if (prev == null)
			head = root;
		else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;

		// Finally convert right subtree
		convertBinaryTreeToDoubleyLinkList(root.right);
		
	}

	public static void main(String args[]) {
		int in[] = { -6, 0, 15, 10, 3, 25, 2 };
		int pre[] = { 10, 15, -6, 0, 25, 3, 2 };
		ConstructTreeFromInOrderPreOrder ct = new ConstructTreeFromInOrderPreOrder();
		TreeNode root = ct.createTree(in, pre);
		BTreePrinter.printNode(root);
		BinaryTreeToLinkLists bt = new BinaryTreeToLinkLists();
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);
		BTreePrinter.printNode(root);
		bt.flattenRecursive(root);
		BTreePrinter.printNode(root);
		System.out.println("Binary tree to DLL********************");
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);
		BTreePrinter.printNode(root);
		bt.convertBinaryTreeToDoubleyLinkList(root);
		printList(bt.head);
	}

	static void printList(TreeNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.right;
		}
	}

}
