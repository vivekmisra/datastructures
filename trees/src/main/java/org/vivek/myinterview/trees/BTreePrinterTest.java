package org.vivek.myinterview.trees;

public class BTreePrinterTest {
	// static Integer arr[] = { 50, 25, 1, 12, 75, 62, 100 };
	/*static TNode root = null;

	private static TNode<Integer> test1() {
		TNode<Integer> root = new TNode<Integer>(2);
		TNode<Integer> n11 = new TNode<Integer>(7);
		TNode<Integer> n12 = new TNode<Integer>(5);
		TNode<Integer> n21 = new TNode<Integer>(2);
		TNode<Integer> n22 = new TNode<Integer>(6);
		TNode<Integer> n23 = new TNode<Integer>(3);
		TNode<Integer> n24 = new TNode<Integer>(6);
		TNode<Integer> n31 = new TNode<Integer>(5);
		TNode<Integer> n32 = new TNode<Integer>(8);
		TNode<Integer> n33 = new TNode<Integer>(4);
		TNode<Integer> n34 = new TNode<Integer>(5);
		TNode<Integer> n35 = new TNode<Integer>(8);
		TNode<Integer> n36 = new TNode<Integer>(4);
		TNode<Integer> n37 = new TNode<Integer>(5);
		TNode<Integer> n38 = new TNode<Integer>(8);

		root.left = n11;
		root.right = n12;

		n11.left = n21;
		n11.right = n22;
		n12.left = n23;
		n12.right = n24;

		n21.left = n31;
		n21.right = n32;
		n22.left = n33;
		n22.right = n34;
		n23.left = n35;
		n23.right = n36;
		n24.left = n37;
		n24.right = n38;

		return root;
	}

	private static TNode test2() {
		TNode root = new TNode(2);
		TNode<Integer> n11 = new TNode<Integer>(7);
		TNode<Integer> n12 = new TNode<Integer>(5);
		TNode<Integer> n21 = new TNode<Integer>(2);
		TNode<Integer> n22 = new TNode<Integer>(6);
		TNode<Integer> n23 = new TNode<Integer>(9);
		TNode<Integer> n31 = new TNode<Integer>(5);
		TNode<Integer> n32 = new TNode<Integer>(8);
		TNode<Integer> n33 = new TNode<Integer>(4);

		root.left = n11;
		root.right = n12;

		n11.left = n21;
		n11.right = n22;

		n12.right = n23;
		n22.left = n31;
		n22.right = n32;

		n23.left = n33;

		return root;
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

	
	 * A recursive function to insert a new key in BST
	 
	static TNode insertRec(TNode root, Integer data) {

		
		 * If the tree is empty, return a new node
		 
		if (root == null) {
			root = new TNode(data);
			return root;
		}

		
		 * Otherwise, recur down the tree
		 

		//int compareValue = (root.data).compareTo(data);

		if (compareValue > 0) {//if parent is more than child (incoming) data, then insert left node
			root.left = insertRec(root.left, data);
		} else if (compareValue < 0) {//if parent is less than child (incoming) data, then insert right node
			root.right = insertRec(root.right, data);
		}

		 return the root 
		return root;
	}

	public static void main(String[] args) {

		BTreePrinter.printNode(test1());
		BTreePrinter.printNode(test2());

	}*/
}
