package org.vivek.myinterview.trees.problems;

import java.util.Arrays;
import java.util.Stack;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.TNode;



public class FindSucessors {

	public static void main(String[] args) {
		int[] num = { 2, 4, 5, 6, 7,8, 9,10, 11, 12, 14 };
		Arrays.sort(num);
		TNode root = SortedArrayToBST.sortedArrayToBST(num);
		
		BTreePrinter.printNode(root);
		System.out.println("Successor1:");
		TNode temp1 = root;
        temp1=inorderSuccessor(temp1, new TNode(9));
         BTreePrinter.printNode(temp1);
       
        
	}
	
	 public static TNode inorderSuccessor(TNode root, TNode p) {
		 if(root==null)
		        return null;
		 
		    TNode next = null;
		    TNode currentNode = root;
		    while(currentNode!=null && currentNode.data!=p.data){
		        if( p.data<currentNode.data){
		            next = currentNode;//grab node before it diqualifies condition
		            currentNode = currentNode.left;
		        }else{
		            currentNode= currentNode.right;
		        }
		    }
		 
		    if(currentNode==null)        
		        return null;
		    if(currentNode.left==null && currentNode.right==null)	
		    	return null;
		    if(currentNode.right==null){
		        return next;
		    }else{
		      currentNode = currentNode.right;//toppling just below target
	        }
		    //left subtree below target
		    while(currentNode.left!=null){
		        currentNode = currentNode.left;
		    }
		    return currentNode;
	    }

	  


}
