package org.vivek.myinterview.trees.traversal;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.TreeNode;

public class PreOrderRecursive {

	public PreOrderRecursive() {
		// TODO Auto-generated constructor stub
	}
	
	public static void preOrder(TreeNode root){
		if(root != null) {
			System.out.print(root.val);
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
	
	private static TreeNode constructTree() {
        TreeNode root = new TreeNode(50);
        TreeNode n11L = new TreeNode(25);
        TreeNode n12R = new TreeNode(75);
        TreeNode n11L_21L = new TreeNode(1);
        TreeNode n11L_22R = new TreeNode(12);
        TreeNode n12R_21L = new TreeNode(62);
        TreeNode n12R_22R = new TreeNode(100);
        
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
