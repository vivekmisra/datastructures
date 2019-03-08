package org.vivek.myinterview.trees.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.TNode;

public class FindSucessors {

	public static void main(String[] args) {
		int[] num = { 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14 };
		Arrays.sort(num);
		TNode root = SortedArrayToBST.sortedArrayToBST(num);

		BTreePrinter.printNode(root);
		System.out.println("Successor1 of 5:");
		TNode temp1 = root;
		temp1 = inorderSuccessor(temp1, new TNode(5));
		BTreePrinter.printNode(temp1);
		TNode temp2 = root;
		List<Queue<TNode>> listOfStacks = findInorderAncesstorsAndSuccessors(temp2, new TNode(5));
		System.out.println("List :Ancesstors and Successors of 5:");
		System.out.println("   Ancesstors of 5:");
		Queue<TNode> ancestors = listOfStacks.get(0);
		while (!ancestors.isEmpty()) {
			TNode n = ancestors.poll();
			System.out.print(n.data);
		}
		System.out.println();
		System.out.println("   Successor of 5:");
		Queue<TNode> successors = listOfStacks.get(1);
		while (!successors.isEmpty()) {
			TNode n = successors.poll();
			System.out.print(n.data);
		}

	}

	public static TNode inorderSuccessor(TNode root, TNode p) {
		if (root == null)
			return null;

		TNode next = null;
		TNode currentNode = root;
		while (currentNode != null && currentNode.data != p.data) {
			if (p.data < currentNode.data) {
				next = currentNode;// grab node before it diqualifies condition

				currentNode = currentNode.left;
			} else {

				currentNode = currentNode.right;
			}
		}

		if (currentNode == null)
			return null;
		if (currentNode.left == null && currentNode.right == null)
			return null;
		if (currentNode.right == null) {
			return next;
		} else {
			currentNode = currentNode.right;// Right subtree will always be inorder sucessor as they are yet to be
											// visited
		}
		// exclude left subtree as it has been traversed as inorder ancessotors
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}

		return currentNode;
	}

	public static List<Queue<TNode>> findInorderAncesstorsAndSuccessors(TNode root, TNode p) {

		if (root == null)
			return null;
		Queue<TNode> ancestors = new LinkedList();
		Queue<TNode> successors = new LinkedList();
		List<Queue<TNode>> listOfStacks = new ArrayList<>();
		TNode next = null;
		TNode currentNode = root;
		// until this node grab all BST nodes
		while (currentNode != null && currentNode.data != p.data) {
			if (p.data < currentNode.data) {
				next = currentNode;// grab node before it diqualifies condition
				ancestors.add(next);
				currentNode = currentNode.left;
			} else {
				// traverse & collect ancesstors on way (right )
				ancestors.add(currentNode);
				currentNode = currentNode.right;
			}
		}

		if (currentNode == null) { // this means target node does not exist
			return null;
		}
		if (currentNode.left == null && currentNode.right == null) { // leaf
			listOfStacks.add(0, ancestors);
			listOfStacks.add(1, successors);// there won't be any
			return listOfStacks;
		}
		if (currentNode.right != null) {

			currentNode = currentNode.right;// Right subtree will always be inorder successor as they are yet to be
											// visited
		}
		// to discard ancesstors ,exclude left subtree as it has been traversed as
		// inorder ancessotors
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}
		// collecting ancesstors and successors
		listOfStacks.add(0, ancestors);
		// now extract succesors put in queue
		while (currentNode != null) {
			successors.add(currentNode);
			currentNode = currentNode.right;
		}

		listOfStacks.add(1, successors);
		return listOfStacks;
	}

}
