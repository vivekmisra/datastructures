package org.vivek.myinterview.trees.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.TNode;

public class DoesNodeExistCompleteTree {

	public static void main(String[] args) {

		Integer[] nums = { 1, 2, 3, 4, 5, 6, null };

		// root = ConstructCompleteBinaryTreeFromArray.insertLevelOrder(nums,
		// root, 0);
		TNode root = new TNode(1);
		root.left = new TNode(2);
		root.right = new TNode(3);
		root.left.left = new TNode(4);
		root.left.right = new TNode(5);
		root.right.left = new TNode(6);
		root.right.right = null;

		BTreePrinter.printNode(root);
		boolean exist = doesNodeExist(root, 7);
		System.out.println("exist=" + exist);
		boolean complete = isComplete(root);
		System.out.println("complete =" + complete );
	}

	public static boolean isComplete(TNode root) {
		Queue<TNode> queue = new LinkedList<TNode>();
		queue.offer(root);
		boolean foundFirstNonFull = false;
		while (!queue.isEmpty()) {
			root = queue.poll();
			if (foundFirstNonFull) {
				if (root.left != null || root.right != null) {
					return false;
				}
				continue;
			}
			if (root.left != null && root.right != null) {
				queue.offer(root.left);
				queue.offer(root.right);
			} else if (root.left != null) {
				queue.offer(root.left);
				foundFirstNonFull = true;
			} else if (root.right != null) {
				return false;
			} else {
				foundFirstNonFull = true;
			}
		}
		return true;
	}

	/*
	 * Put target into stack and divide target /= 2 and repeat as long as target
	 * > 1 While poping element from the stack, check if I should go left child
	 * or right child. If the value is not found, return false
	 */
	static boolean doesNodeExist(TNode root, int target) {
		if (root == null)
			return false;
		Stack<Integer> stack = new Stack<>();
		int temp = target;
		while (temp > 1) {
			stack.push(temp);
			temp = temp/2;//hop to parent index
		}
		while (!stack.isEmpty()) {
			if (stack.pop() % 2 == 0){//even index nodes are left child
				root = root.left;
			}else{
				root = root.right;
			}
			if (root == null)
				return false;
		}
		return true;
	}
}
