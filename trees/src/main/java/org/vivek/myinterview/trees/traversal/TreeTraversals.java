package org.vivek.myinterview.trees.traversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.BinaryTree;
import org.vivek.myinterview.trees.TNode;
import org.vivek.myinterview.trees.problems.ConstructCompleteBinaryTreeFromArray;


/**
 * Youtube link - https://youtu.be/nzmtCFNae9k Youtube link -
 * https://youtu.be/elQcrJrfObg Youtube link - https://youtu.be/qT65HltK2uE
 * Youtube link - https://youtu.be/ZM-sV9zQPEs
 * 
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 * http://www.geeksforgeeks.org/iterative-preorder-traversal/
 */
public class TreeTraversals {

	public void inOrder(TNode root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	public void preOrder(TNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public void postOrder(TNode root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

	public void inorderItr(TNode root) {
		Deque<TNode> stack = new LinkedList<TNode>();
		TNode node = root;
		while (true) {
			if (node != null) {
				stack.addFirst(node);
				node = node.left;
			} else {
				if (stack.isEmpty()) {
					break;
				}
				node = stack.pollFirst();
				System.out.println(node.data);
				node = node.right;
			}
		}
	}

	public void preOrderItr(TNode root) {
		Deque<TNode> stack = new LinkedList<TNode>();
		stack.addFirst(root);
		while (!stack.isEmpty()) {
			root = stack.pollFirst();
			System.out.print(root.data + " ");
			if (root.right != null) {
				stack.addFirst(root.right);
			}
			if (root.left != null) {
				stack.addFirst(root.left);
			}
		}
	}

	public void postOrderItr(TNode root) {
		Deque<TNode> stack1 = new LinkedList<TNode>();
		Deque<TNode> stack2 = new LinkedList<TNode>();
		stack1.addFirst(root);
		while (!stack1.isEmpty()) {
			root = stack1.pollFirst();
			if (root.left != null) {
				stack1.addFirst(root.left);
			}
			if (root.right != null) {
				stack1.addFirst(root.right);
			}
			stack2.addFirst(root);
		}
		while (!stack2.isEmpty()) {
			System.out.print(stack2.pollFirst().data + " ");
		}
	}

	public void postOrderItrOneStack(TNode root) {
		TNode current = root;
		Deque<TNode> stack = new LinkedList<TNode>();
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.addFirst(current);
				current = current.left;
			} else {
				TNode temp = stack.peek().right;
				if (temp == null) {
					temp = stack.poll();
					System.out.print(temp.data + " ");
					while (!stack.isEmpty() && temp == stack.peek().right) {
						temp = stack.poll();
						System.out.print(temp.data + " ");
					}
				} else {
					current = temp;
				}
			}
		}
	}

	/* function to print level order traversal of tree */
	void levelOrderRecursive(TNode root) {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++)
			traverseByLevel(root, i);
	}

	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 */
	int height(TNode root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	/* Print nodes at the given level */
	void traverseByLevel(TNode root, int level) {
		if (root == null)
			return;
		if (level == 1) {
			System.out.print(root.data + " ");
		} else if (level > 1) {
			traverseByLevel(root.left, level - 1);
			traverseByLevel(root.right, level - 1);
		}
	}

	public ArrayList<ArrayList<Integer>> levelOrder(TNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return res;
		// Initialization
		Queue<TNode> q = new LinkedList<TNode>();
		q.offer(root);
		q.offer(null);
		ArrayList<Integer> curr = new ArrayList<Integer>();
		while (!q.isEmpty()) {
			TNode tmp = q.poll();
			if (tmp != null) {
				curr.add(tmp.data);
				if (tmp.left != null)
					q.offer(tmp.left);
				if (tmp.right != null)
					q.offer(tmp.right);
			} else {
				ArrayList<Integer> c_curr = new ArrayList<Integer>(curr);
				res.add(c_curr);
				curr.clear(); // Java will clear the reference, so have to new
								// an new ArrayList.
				// completion of a level;
				if (!q.isEmpty())
					q.offer(null);
			}
		}
		return res;
	}
	
	
	public static void main(String args[]) {
		BinaryTree bt = new BinaryTree();
		TNode head = null;
		head = bt.addNode(10, head);
		head = bt.addNode(15, head);
		head = bt.addNode(19, head);
		head = bt.addNode(17, head);
		head = bt.addNode(11, head);

		head = bt.addNode(-11, head);
		Integer[] nums = { 1, 2, 3, 4, null, 6, null };
		TNode root = new TNode(1);
		root = ConstructCompleteBinaryTreeFromArray.insertLevelOrder(nums, root, 0);
		BTreePrinter.printNode(root);

		TreeTraversals tt = new TreeTraversals();
		System.out.print("PreOrder:");
		tt.preOrder(root);
		System.out.println();
		System.out.print("InOrder:");
		tt.inOrder(root);
		System.out.println();
		System.out.print("PostOrder:");
		tt.postOrder(root);
		System.out.println();
		System.out.print("BFS:");
		tt.levelOrderRecursive(root);
		System.out.println();
		System.out.print("BFS It:");
		ArrayList<ArrayList<Integer>> listOfLevels = tt.levelOrder(root);
		for (List<Integer> levels : listOfLevels) {
			for (int val : levels) {
				System.out.print(val + "-->");
			}
		}
		
	}
}
