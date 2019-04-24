package org.vivek.myinterview.trees.traversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.BinaryTree;
import org.vivek.myinterview.trees.TreeNode;
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

	public void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}

	public void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public void postOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val + " ");
	}

	// LVR
	public void inorderItr(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode node = root;
		while (true) {
			if (node != null) {
				// Keep on stacking left nodes
				stack.addFirst(node);
				node = node.left;
			} else {
				//
				if (stack.isEmpty()) {
					break;
				}
				node = stack.pollFirst();
				System.out.println(node.val);
				// move right
				node = node.right;
			}
		}
	}

	// VLR
	public void preOrderItr(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		stack.addFirst(root);
		while (!stack.isEmpty()) {
			//
			// L
			// R
			// --- STACK
			root = stack.pollFirst();
			System.out.print(root.val + " ");// V
			if (root.right != null) {
				stack.addFirst(root.right);// R
			}
			if (root.left != null) {
				stack.addFirst(root.left);// L
			}
		}
	}

	// LRV
	public void postOrderItr(TreeNode root) {
		Deque<TreeNode> stack1 = new LinkedList<TreeNode>();
		Deque<TreeNode> stack2 = new LinkedList<TreeNode>();
		stack1.addFirst(root);
		while (!stack1.isEmpty()) {
			root = stack1.pollFirst();
			if (root.left != null) {
				stack1.addFirst(root.left);// L
			}
			if (root.right != null) {
				stack1.addFirst(root.right);// R
			}
			stack2.addFirst(root);// V
		}
		while (!stack2.isEmpty()) {
			System.out.print(stack2.pollFirst().val + " ");
		}
	}

	public void postOrderItrOneStack(TreeNode root) {
		TreeNode current = root;
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.addFirst(current);
				current = current.left;
			} else {
				TreeNode temp = stack.peek().right;
				if (temp == null) {
					temp = stack.poll();
					System.out.print(temp.val + " ");
					while (!stack.isEmpty() && temp == stack.peek().right) {
						temp = stack.poll();
						System.out.print(temp.val + " ");
					}
				} else {
					current = temp;
				}
			}
		}
	}

	/* function to print level order traversal of tree */
	void levelOrderRecursive(TreeNode root) {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++)
			traverseByLevel(root, i);
	}

	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest path
	 * from the root node down to the farthest leaf node.
	 */
	int height(TreeNode root) {
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
	void traverseByLevel(TreeNode root, int level) {
		if (root == null)
			return;
		if (level == 1) {
			System.out.print(root.val + " ");
		} else if (level > 1) {
			traverseByLevel(root.left, level - 1);
			traverseByLevel(root.right, level - 1);
		}
	}

	public List<ArrayList<Integer>> levelOrder(TreeNode root) {
		List<ArrayList<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		// Initialization
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		q.offer(null);
		List<Integer> curr = new ArrayList<>();
		while (!q.isEmpty()) {
			TreeNode tmp = q.poll();
			if (tmp != null) {
				curr.add(tmp.val);
				if (tmp.left != null)
					q.offer(tmp.left);
				if (tmp.right != null)
					q.offer(tmp.right);
			} else {
				// make a deep copy of temp row data into a new list data
				ArrayList<Integer> c_curr = new ArrayList<Integer>(curr);
				// add new list data copy to result list
				res.add(c_curr);
				// clean up the temp list for new row data
				curr.clear(); // Java will clear the reference, so have to new
								// an new ArrayList.
				// completion of a level;
				if (!q.isEmpty())
					q.offer(null);
			}
		}
		return res;
	}

	// A simple function to print leaf nodes of a binary tree
	static void traverseLeaves(TreeNode node) {
		if (node != null) {
			traverseLeaves(node.left);

			// Print it if it is a leaf node
			if (node.left == null && node.right == null)
				System.out.print(node.val + " ");
			traverseLeaves(node.right);
		}
	}

	// A function to print all left boundry nodes, except a leaf node.
	// Print the nodes in TOP DOWN manner
	static void traverseBoundaryLeft(TreeNode node) {
		if (node != null) {
			if (node.left != null) {

				// to ensure top down order, print the node
				// before calling itself for left subtree
				System.out.print(node.val + " ");
				traverseBoundaryLeft(node.left);
			} else if (node.right != null) {
				System.out.print(node.val + " ");
				traverseBoundaryLeft(node.right);
			}

			// do nothing if it is a leaf node, this way we avoid
			// duplicates in output
		}
	}

	// A function to print all right boundry nodes, except a leaf node
	// Print the nodes in BOTTOM UP manner
	static void traverseBoundaryRight(TreeNode node) {
		if (node != null) {
			if (node.right != null) {
				// to ensure bottom up order, first call for right
				// subtree, then print this node
				traverseBoundaryRight(node.right);
				System.out.print(node.val + " ");
			} else if (node.left != null) {
				traverseBoundaryRight(node.left);
				System.out.print(node.val + " ");
			}
			// do nothing if it is a leaf node, this way we avoid
			// duplicates in output
		}
	}

	// A function to do boundary traversal of a given binary tree
	static void traverseBoundary(TreeNode node) {
		if (node != null) {
			System.out.print(node.val + " ");

			// Print the left boundary in top-down manner.
			traverseBoundaryLeft(node.left);

			// Print all leaf nodes
			traverseLeaves(node.left);
			traverseLeaves(node.right);

			// Print the right boundary in bottom-up manner
			traverseBoundaryRight(node.right);
		}
	}

	/*
	 * We can print spiral order traversal in O(n) time and O(n) extra space. The
	 * idea is to use two stacks. We can use one stack for printing from left to
	 * right and other stack for printing from right to left. In every iteration, we
	 * have nodes of one level in one of the stacks. We print the nodes, and push
	 * nodes of next level in other stack.
	 */
	static void printSpiral(TreeNode node) {
		if (node == null)
			return; // NULL check

		// Create two stacks to store alternate levels
		// For levels to be printed from right to left
		Stack<TreeNode> s1 = new Stack<>();
		// For levels to be printed from left to right
		Stack<TreeNode> s2 = new Stack<>();

		// Push first level to first stack 's1'
		s1.push(node);

		// Keep printing while any of the stacks has some nodes
		while (!s1.empty() || !s2.empty()) {
			// Print nodes of current level from s1 and push nodes of
			// next level to s2
			while (!s1.empty()) {
				TreeNode temp = s1.peek();
				s1.pop();
				System.out.print(temp.val + " ");

				// Note that is right is pushed before left
				if (temp.right != null)
					s2.push(temp.right);

				if (temp.left != null)
					s2.push(temp.left);
			}

			// Print nodes of current level from s2 and push nodes of
			// next level to s1
			while (!s2.empty()) {
				TreeNode temp = s2.peek();
				s2.pop();
				System.out.print(temp.val + " ");

				// Note that is left is pushed before right
				if (temp.left != null)
					s1.push(temp.left);
				if (temp.right != null)
					s1.push(temp.right);
			}
		}
	}

	static void spiralWithOneDequeDelimiter(TreeNode root) {
		if (root == null) {
			return;
		}
		Deque<TreeNode> q = new LinkedList<>();
		q.offer(null);
		q.offerFirst(root);
		// if only delimiter(in this case null) is left in queue then break
		while (q.size() > 1) {
			root = q.peekFirst();
			while (root != null) {
				root = q.pollFirst();
				System.out.print(root.val + " ");
				if (root.left != null) {
					q.offerLast(root.left);
				}
				if (root.right != null) {
					q.offerLast(root.right);
				}
				root = q.peekFirst();
			}
			root = q.peekLast();
			while (root != null) {
				System.out.print(root.val + " ");
				root = q.pollLast();
				if (root.right != null) {
					q.offerFirst(root.right);
				}
				if (root.left != null) {
					q.offerFirst(root.left);
				}
				root = q.peekLast();
			}
		}
	}

	public static List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		Queue<TreeNode> q = new LinkedList<>();
		Queue<Integer> cols = new LinkedList<>();

		q.add(root);
		cols.add(0);

		int min = 0;
		int max = 0;

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			int col = cols.poll();

			if (!map.containsKey(col)) {
				map.put(col, new ArrayList<Integer>());
			}
			map.get(col).add(node.val);

			if (node.left != null) {
				q.add(node.left);
				cols.add(col - 1);
				min = Math.min(min, col - 1);
			}

			if (node.right != null) {
				q.add(node.right);
				cols.add(col + 1);
				max = Math.max(max, col + 1);
			}
		}

		for (int i = min; i <= max; i++) {
			res.add(map.get(i));
		}

		return res;
	}

	public static void main(String args[]) {
		BinaryTree bt = new BinaryTree();
		TreeNode head = null;
		head = bt.addNode(10, head);
		head = bt.addNode(15, head);
		head = bt.addNode(19, head);
		head = bt.addNode(17, head);
		head = bt.addNode(11, head);

		head = bt.addNode(-11, head);
		// Integer[] nums = { 1, 2, 3, 4, null, 6, null };
		Integer[] nums = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
		TreeNode root = new TreeNode(1);
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
		List<ArrayList<Integer>> listOfLevels = tt.levelOrder(root);
		for (List<Integer> levels : listOfLevels) {
			for (int val : levels) {
				System.out.print(val + "-->");
			}
		}
		System.out.println();
		
		System.out.print("Boundary  traversal:");
		TreeNode rootBoundary = new TreeNode(20);
		rootBoundary.left = new TreeNode(8);
		rootBoundary.left.left = new TreeNode(4);
		rootBoundary.left.right = new TreeNode(12);
		rootBoundary.left.right.left = new TreeNode(10);
		rootBoundary.left.right.right = new TreeNode(14);
		rootBoundary.right = new TreeNode(22); 
		rootBoundary.right.right = new TreeNode(25);
		BTreePrinter.printNode(rootBoundary);
		traverseBoundary(rootBoundary);
		System.out.println();
		
		System.out.println();
		
		System.out.print("Spiral zig zag traversal:");
		
		spiralWithOneDequeDelimiter(root);

		List<List<Integer>> vList = verticalOrder(root);
		System.out.println();
		int hd = 0;
		for (List<Integer> vorderList : vList) {
			System.out.print("vorderList for hd=" + hd);
			System.out.println();
			vorderList.forEach(item -> System.out.println(item));
			System.out.println();
			hd++;
		}
		System.out.println();
	}
}
