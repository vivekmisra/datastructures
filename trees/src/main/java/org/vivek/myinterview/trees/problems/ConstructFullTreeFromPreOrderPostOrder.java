package org.vivek.myinterview.trees.problems;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.TNode;
import org.vivek.myinterview.trees.traversal.TreeTraversals;

/**
 * http://www.geeksforgeeks.org/full-and-complete-binary-tree-from-given-preorder-and-postorder-traversals/
 * Full tree is a tree with all nodes with either 0 or 2 child. Never has 1
 * child. Test cases Empty tree Tree with big on left side Tree with big on
 * right side
 */
public class ConstructFullTreeFromPreOrderPostOrder {
	static int preindex;

	public TNode constructTree(int preorder[], int postorder[]) {

		return constructTree(preorder, postorder, 0, postorder.length - 2, 0);

	}

	private TNode constructTree(int preorder[], int postorder[], int low, int high, int index) {

		if (low > high || index >= preorder.length - 1) {
			TNode node = new TNode();
			node.data = preorder[index];
			return node;
		}

		TNode node = new TNode();
		node.data = preorder[index];
		int i = 0;
		for (i = low; i <= high; i++) {
			if (preorder[index + 1] == postorder[i]) {
				break;
			}
		}
		node.left = constructTree(preorder, postorder, low, i - 1, index + 1);
		node.right = constructTree(preorder, postorder, i + 1, high - 1, index + i - low + 2);
		return node;
	}

	// A recursive function to construct Full
	// from pre[] and post[]. preIndex is used
	// to keep track of index in pre[]. l is
	// low index and h is high index for the
	// current subarray in post[]
	static TNode buildTree(int pre[], int post[], int l, int h, int size) {

		// Base case
		if (preindex >= size || l > h)
			return null;

		// The first node in preorder traversal is
		// root. So take the node at preIndex from
		// preorder and make it root, and increment
		// preIndex
		int preValue = pre[preindex];
		TNode root = new TNode(preValue);
		preindex++;

		// If the current subarry has only one
		// element, no need to recur or
		// preIndex > size after incrementing
		if (l == h || preindex >= size)
			return root;
		//the next preorder value is left child
        int nextpreValue =pre[preindex];//preIndex is already incremented
        // find this pre order value in postorder and return its index
		int postIndex = search( post, l, h,nextpreValue);
		// Use the index of element found in
		// postorder to divide postorder array
		// in two parts. Left subtree and right subtree
		if (postIndex <= h) {
			root.left = buildTree(pre, post, l, postIndex, size);
			root.right = buildTree(pre, post, postIndex + 1, h, size);
		}
		return root;
	}

	private static int search( int[] post, int l, int h,int preValue) {
		int i;
		// Search the next element of pre[] in post[]
		for (i = l; i <= h; i++) {
			if (post[i] == preValue)
				break;
		}
		return i;
	}

	// The main function to construct Full
	// Binary Tree from given preorder and
	// postorder traversals. This function
	// mainly uses constructTreeUtil()
	static TNode createTree(int pre[], int post[], int size) {
		preindex = 0;
		return buildTree(pre, post, 0, size - 1, size);
	}

	public static void main(String args[]) {
		ConstructFullTreeFromPreOrderPostOrder cft = new ConstructFullTreeFromPreOrderPostOrder();
		//int preorder[] = { 1, 2, 3, 6, 7, 8, 9 };
		//int postorder[] = { 2, 6, 8, 9, 7, 3, 1 };
		 int preorder[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 }; 
	        int postorder[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 }; 
		TNode root = cft.constructTree(preorder, postorder);
	    //BTreePrinter.printNode(root);
		TreeTraversals tt = new TreeTraversals();
		System.out.println("Inorder:");
		
		tt.inOrder(root);
		System.out.println();
		System.out.println("Preorder:");
		
		tt.preOrder(root);
		System.out.println();
		System.out.println("Postorder:");
		
		tt.postOrder(root);
		System.out.println();
		BTreePrinter.printNode(root);
		
		
		 int size = preorder.length; 
	      root = createTree(preorder, postorder, size); 
	      BTreePrinter.printNode(root);
	}
}
