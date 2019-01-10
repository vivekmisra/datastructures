package org.vivek.myinterview.trees.traversal;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.TNode;

public class PreOrderRecursive {

	public PreOrderRecursive() {
		// TODO Auto-generated constructor stub
	}
	
	public static void preOrder(TNode root){
		if(root != null) {
			System.out.print(root.data);
			if(root.left!=null) {
			System.out.print("-->");
			preOrder(root.left);
			}
			if(root.right!=null) {
				System.out.print("-->");
			
			preOrder(root.right);
			}
		}
		//System.out.println();
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

	        BTreePrinter.printNode(constructTree());
	        preOrder(constructTree());

	    }

}
