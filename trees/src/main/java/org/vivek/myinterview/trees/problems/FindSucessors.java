package org.vivek.myinterview.trees.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.TreeNode;

public class FindSucessors {

	public static void main(String[] args) {
		int[] num = { 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14 };
		Arrays.sort(num);
		TreeNode root = SortedArrayToBST.sortedArrayToBST(num);
		TreeNode target =  new TreeNode(6);
		BTreePrinter.printNode(root);
		System.out.println("Successor1 of :"+target.val);
		TreeNode temp1 = root;
		temp1 = inorderSuccessor(temp1, target);
		BTreePrinter.printNode(temp1);
		TreeNode temp2 = root;
		
		List<Queue<TreeNode>> listOfStacks = findInorderAncesstorsAndSuccessors(temp2, target);
		System.out.println("List :Ancesstors and Successors of :" +target.val);
		System.out.println("   Ancesstors of :"+target.val);
		Queue<TreeNode> ancestors = listOfStacks.get(0);
		while (!ancestors.isEmpty()) {
			TreeNode n = ancestors.poll();
			System.out.print(n.val);
		}
		System.out.println();
		System.out.println("   Successor of :"+target.val);
		Queue<TreeNode> successors = listOfStacks.get(1);
		while (!successors.isEmpty()) {
			TreeNode n = successors.poll();
			System.out.print(n.val);
		}
	
		System.out.println("   Successor of :"+target.val);
		TreeNode n = getSuccessor(temp2, new TreeNode(7));
        BTreePrinter.printNode(n);
	}

	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null)
			return null;

		TreeNode next = null;
		TreeNode currentNode = root;
		while (currentNode != null && currentNode.val != p.val) {
			if (p.val < currentNode.val) {
				next = currentNode;// grab node before it diqualifies condition

				currentNode = currentNode.left;
			} else {

				currentNode = currentNode.right;
			}
		}

		if (currentNode == null)
			return null;
		if (currentNode.left == null && currentNode.right == null)
			return null;
		if (currentNode.right == null) {
			return next;
		} else {
			currentNode = currentNode.right;// Right subtree will always be inorder sucessor as they are yet to be
											// visited
		}
		// exclude left subtree as it has been traversed as inorder ancessotors
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}

		return currentNode;
	}

	public static List<Queue<TreeNode>> findInorderAncesstorsAndSuccessors(TreeNode root, TreeNode p) {

		if (root == null)
			return null;
		Queue<TreeNode> ancestors = new LinkedList();
		Queue<TreeNode> successors = new LinkedList();
		List<Queue<TreeNode>> listOfStacks = new ArrayList<>();
		TreeNode next = null;
		TreeNode currentNode = root;
		// until this node grab all BST nodes
		while (currentNode != null && currentNode.val != p.val) {
			if (p.val < currentNode.val) {
				next = currentNode;// grab node before it diqualifies condition
				ancestors.add(next);
				currentNode = currentNode.left;
			} else {
				// traverse & collect ancesstors on way (right )
				ancestors.add(currentNode);
				currentNode = currentNode.right;
			}
		}

		if (currentNode == null) { // this means target node does not exist
			return null;
		}
		if (currentNode.left == null && currentNode.right == null) { // leaf
			listOfStacks.add(0, ancestors);
			listOfStacks.add(1, successors);// there won't be any
			return listOfStacks;
		}
		if (currentNode.right != null) {

			currentNode = currentNode.right;// Right subtree will always be inorder successor as they are yet to be
											// visited
		}
		// to discard ancesstors ,exclude left subtree as it has been traversed as
		// inorder ancessotors
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}
		// collecting ancesstors and successors
		listOfStacks.add(0, ancestors);
		// now extract succesors put in queue
		while (currentNode != null) {
			successors.add(currentNode);
			currentNode = currentNode.right;
		}

		listOfStacks.add(1, successors);
		return listOfStacks;
	}
	
	  
   static TreeNode getSuccessor( TreeNode root, TreeNode target )
    {
      if ( target.right != null )
      {
        TreeNode currNode = target.right;
        while ( currNode.left != null )
        {
          currNode = currNode.left;
        }
        return currNode;
      }
      else
      {
        TreeNode successor = null;
        TreeNode currNode = root;
        while ( currNode != null &&  currNode != target )
        {
          if ( currNode.val >= target.val )
          {
            successor = currNode;
            currNode = currNode.left;
          }
          else
          {
            currNode = currNode.right;
          }
        }
        return successor;
      }
    }

}
