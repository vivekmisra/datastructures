package org.vivek.myinterview.trees.traversal;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.TNode;

public class InOrderRecursive {
	static Integer arr[] = { 50, 25, 1, 12, 75, 62, 100 };
	static TNode root = null;

	public InOrderRecursive() {
		// TODO Auto-generated constructor stub
		root = null;
	}

	static TNode treeins(Integer arr[]) {
		for (int i = 0; i < arr.length; i++) {
			TNode root = insert(arr[i]);
		}
		return root;

	}

	// This method mainly
	// calls insertRec()
	static TNode insert(Integer data) {

		return root = insertRec(root, data);
	}

	/*
	 * A recursive function to insert a new key in BST
	 */
	static TNode insertRec(TNode root, Integer data) {

		/*
		 * If the tree is empty, return a new node
		 */
		if (root == null) {
			root = new TNode(data);
			return root;
		}

		/*
		 * Otherwise, recur down the tree
		 */

		 boolean compareValue = (root.data> data);
  System.out.println("root =" +root.data +",data="+ data);
		if (compareValue) {
			root.left = insertRec(root.left, data);
	    }else { 
			root.right = insertRec(root.right, data);
	    }
		System.out.println( "returning root =" +root.data );
		if(root.left!= null) {
			System.out.println("...root.left=" + root.left.data );
		}else {
			System.out.println("....root.left=" + null );
		}
		if(root.right!= null) {
			System.out.println("...root.right=" + root.right.data );
		}else {
			System.out.println("...root.right=" + null );
		}
		/* return the root */
		return root;
	}

	public static void inOrder(TNode root) {
		if (root != null) {
			if (root.left != null) {
				// System.out.print("-->");
				inOrder(root.left);
			}
			System.out.print(" ");
			System.out.print(root.data);
			if (root.right != null) {
				// System.out.print("-->");
				inOrder(root.right);
			}
		}
	}

	private static TNode constructTree() {
		TNode root = new TNode(50);
		TNode n11L = new TNode(25);
		TNode n12R = new TNode(75);
		TNode n11L_21L = new TNode(1);
		TNode n11L_22R = new TNode(12);
		TNode n12R_21L = new TNode(62);
		TNode n12R_22R = new TNode(100);

		root.left = n11L;
		root.right = n12R;

		n11L.left = n11L_21L;
		n11L.right = n11L_22R;
		n12R.left = n12R_21L;
		n12R.right = n12R_22R;

		return root;
	}

	public static void main(String[] args) {

		// BTreePrinter.printNode(constructTree());
		// inOrder(constructTree());
		BTreePrinter.printNode(treeins(arr));
		inOrder(treeins(arr));

	}

}
