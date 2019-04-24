package org.vivek.myinterview.trees.problems;

import org.vivek.myinterview.trees.TreeNode;
import org.vivek.myinterview.trees.BTreePrinter;

/**
 * http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 * Test cases: Empty tree One TNode tree All left side tree All right side tree
 * Mixed tree Full tree complete tree
 */
public class ConstructTreeFromInOrderPreOrder {

	private int index = 0;
	TreeNode root;
	static int preIndex = 0;

	public TreeNode createTree(int inorder[], int preorder[]) {
		TreeNode result = createTree(inorder, preorder, 0, inorder.length - 1);
		index = 0;
		return result;
	}

	private TreeNode createTree(int inorder[], int preorder[], int start, int end) {
		if (start > end) {
			return null;
		}
		int i;
		// preorder[0] is root
		// loop thru inorder array. First iteration with start=0 will get that
		// inorder element which is equal to preeorder[0]
		// keep on getting from inorder in subsequent iteration
		for (i = start; i <= end; i++) {
			if (preorder[index] == inorder[i]) {
				break;
			}
		}
		TreeNode node = new TreeNode(preorder[index]);
		index++;//
		node.left = createTree(inorder, preorder, start, i - 1);
		node.right = createTree(inorder, preorder, i + 1, end);
		return node;
	}

	TreeNode buildTree(int inorder[], int preorder[], int l, int h) {
		if (l > h)
			return null;

		/*
		 * Pick current node from Preorder traversal using preIndex and
		 * increment preIndex. the first iteration with preIndex=0 gives root
		 */
		int preValue = preorder[preIndex];
		TreeNode tNode = new TreeNode(preValue);
		preIndex++;
		/* If this node has no children then return */
		if (l == h)
			return tNode;

		/* Else find the index of this node in Inorder traversal */
		//the 
		int inIndex = search(inorder, l, h, preValue);
		
		

		/*
		 * Using index in Inorder traversal, construct left and right subtrees
		 */
		tNode.left = buildTree(inorder, preorder, l, inIndex - 1);
		tNode.right = buildTree(inorder, preorder, inIndex + 1, h);

		return tNode;
	}

	/* UTILITY FUNCTIONS */

	/*
	 * Function to find index of value in arr[start...end] The function assumes
	 * that value is present in inorder[]
	 */
	int search(int inorder[], int l, int h, int value) {
		int i;
		for (i = l; i <= h; i++) {
			if (inorder[i] == value)
				return i;
		}
		return i;
	}

	public static void main(String[] args) {
		ConstructTreeFromInOrderPreOrder ctr = new ConstructTreeFromInOrderPreOrder();
		char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
		int inorder[] = new int[] { 4, 2, 5, 1, 6, 3 };
		char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
		int preorder[] = new int[] { 1, 2, 4, 5, 3, 6 };
		TreeNode root = ctr.createTree(inorder, preorder);
		BTreePrinter.printNode(root);
		int len = inorder.length;
		root = ctr.buildTree(inorder, preorder, 0, len - 1);
		BTreePrinter.printNode(root);
	}
}
