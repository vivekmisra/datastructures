package org.vivek.myinterview.trees.problems.checks;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.TreeNode;

//formatter:off

public class TreeValidations {
	
	
	public static void main(String[] args) {

		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		TreeNode root2 = new TreeNode(1);;
		root2.left = new TreeNode(3);
		root2.right = new TreeNode(2);
		System.out.println("root1:");
		BTreePrinter.printNode(root1);
		System.out.println("root2:");
		BTreePrinter.printNode(root2);
		boolean same1 =isSameTree( root1,root2);
		boolean same2 =isSameTreeByBFS( root1,root2);
		System.out.println("root1 and root 2:Same tree?="+same1 + ",root1 and root 2:Same tree by BFS?="+same2);;
		TreeNode root3 = new TreeNode(1);;
		root3.left = new TreeNode(2);
		root3.right = new TreeNode(3);		
		BTreePrinter.printNode(root3);		
		boolean same3=isSameTree( root1,root3);
		boolean same4 =isSameTreeByBFS( root1,root3);
		System.out.println("root1 and root 3:Same tree?="+same3 + ",root1 and root 3:Same tree by BFS?="+same4);;
		TreeNode root4 = new TreeNode(1);
		root4.left = new TreeNode(2);
		root4.right = new TreeNode(2);
		root4.left.left = new TreeNode(3);
		root4.left.right = new TreeNode(4);
		root4.right.left = new TreeNode(4);
		root4.right.right = new TreeNode(3);
		System.out.println("root4:");
		BTreePrinter.printNode(root4);
		boolean symmetric =isSymmetric( root4);
		System.out.println(symmetric);;
		boolean symmetricbfs =isSymmetricByBFS( root4);
		System.out.println("root4:Symmetric tree?="+symmetric + ",root4:Symmetric tree by BFS?="+symmetricbfs);;
		
		TreeNode root5 = new TreeNode(10);	    
	    root5.left = new TreeNode(20);  
	    root5.right = new TreeNode(30); 	  
	    root5.left.left = new TreeNode(40);  
	    root5.left.right = new TreeNode(50);  
	    root5.right.left = new TreeNode(60);  
	    root5.right.right = new TreeNode(70); 
		System.out.println("root5:");
		BTreePrinter.printNode(root5);
		boolean perfect5=  isPerfect(root5);
		boolean bst5=  isBST(root5);
		System.out.println("root5 :Perfect tree?="+perfect5 + ",root5:BST ?="+bst5);;
		
       TreeNode root6 = new TreeNode(20);	    
	    root6.left = new TreeNode(10);  
	    root6.right = new TreeNode(30);  
	    root6.left.left = new TreeNode(5);  
	    root6.left.right = new TreeNode(15);  
	    root6.right.left = new TreeNode(25);  
	    root6.right.right = new TreeNode(35); 
	    System.out.println("root6:");
		BTreePrinter.printNode(root6);		
		boolean perfect6=  isPerfect(root6);
		boolean bst6=  isBST(root6);
		System.out.println("root6:Perfect tree?="+perfect6 + ",root6:BST ?="+bst6);;
		
		TreeNode root7 = new  TreeNode(4);         
        root7.left = new TreeNode(2); 
        root7.right = new TreeNode(5); 
       root7.left.left = new TreeNode(1); 
        root7.left.right = new TreeNode(3);
        System.out.println("root7:");
        BTreePrinter.printNode(root7);		
        boolean perfect7=  isPerfect(root7);
		boolean bst7=  isBST(root7);
		System.out.println("root7:Perfect tree?="+perfect7 + ",root7:BST ?="+bst7);
		TreeNode root8 = new  TreeNode(4);         
        root8.left = new TreeNode(2); 
      //  root8.right = new TreeNode(5); 
       root8.left.left = new TreeNode(1); 
        root8.left.right = new TreeNode(3);
        System.out.println("root8:");
        BTreePrinter.printNode(root8);		
        boolean perfect8=  isPerfect(root8);
		boolean bst8=  isBST(root8);
		System.out.println("root8:Perfect tree?="+perfect8 + ",root8:BST ?="+bst8);
		
		TreeNode root9 = new TreeNode(1);
        root9.left = new TreeNode(2); 
        root9.right = new TreeNode(3); 
        root9.left.right = new TreeNode(5); 
       root9.left.left = new TreeNode(4); 
        root9.right.right = new TreeNode(6); 
        BTreePrinter.printNode(root9);
        boolean complete9 = isCompleteTree(root9);
        System.out.println("root9:Complete tree?="+complete9 );
        TreeNode root10 = new TreeNode(1);
        root10.left = new TreeNode(2); 
        root10.right = new TreeNode(3); 
        root10.left.right = new TreeNode(5); 
       root10.left.left = new TreeNode(4); 
        root10.right.left = new TreeNode(6); 
        BTreePrinter.printNode(root10);
        boolean complete10 = isCompleteTree(root10);
        System.out.println("root10:Complete tree?="+complete10 );
        
		TreeNode root11 = new TreeNode(26);
		root11.left = new TreeNode(10);
		root11.right = new TreeNode(3);
		root11.left.left = new TreeNode(4);
		root11.left.right = new TreeNode(6);
		root11.right.right = new TreeNode(3);
		  BTreePrinter.printNode(root11);
		 boolean sumTree11 = isSumTree(root11);
	        System.out.println("root11:Sum tree?="+sumTree11);
	}
	
	/*
	 * 100. Same Tree
	Easy
	
	Given two binary trees, write a function to check if they are the same or not.
	
	Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
	
	Example 1:
	
	Input:     1         1
	          / \       / \
	         2   3     2   3
	
	        [1,2,3],   [1,2,3]
	
	Output: true
	Example 2:
	
	Input:     1         1
	          /           \
	         2             2
	
	        [1,2],     [1,null,2]
	
	Output: false
	Example 3:
	
	Input:     1         1
	          / \       / \
	         2   1     1   2
	
	        [1,2,1],   [1,1,2]
	
	Output: false
	 */
	public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
		/*
		 * NOTE :Order of null checks is :AND --> OR . OR check comes after AND
		 * check.Otherwise if the order is reversed OR-->AND , AND check would be a dead
		 * code and result would be different
		 */
        if(p==null||q==null){
            return false;
        }
        return(p.val==q.val &&
        		isSameTree(p.left, q.left) && 
        		isSameTree(p.right,q.right));
    }
	
	public static boolean isSameTreeByBFS(TreeNode root1,TreeNode root2) {
	    Queue<TreeNode> q1 = new LinkedList<>();
	    q1.add(root1);
	    Queue<TreeNode> q2 = new LinkedList<>();
	    q2.add(root2);
	   
	    while (!q1.isEmpty() && !q2.isEmpty()) {
	        TreeNode t1 = q1.poll();
	        TreeNode t2 = q2.poll();
	        if (t1 == null && t2 == null) continue;
	        if (t1 == null || t2 == null) return false;
	        if (t1.val != t2.val) return false;
	        //add left nodes
	        q1.add(t1.left);
	        q2.add(t2.left);
	        //add right nodes
	        q1.add(t1.right);
	        q2.add(t2.right);
	    }
	    return true;
	}
	/*
	 * 101. Symmetric Tree
	Easy
	
	Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
	
	For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
	
	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3
	But the following [1,2,2,null,3,null,3] is not:
	    1
	   / \
	  2   2
	   \   \
	   3    3
	Note:
	Bonus points if you could solve it both recursively and iteratively.
	 */
	 public static boolean isSymmetric(TreeNode root) {
	       
	        return isMirror(root,root);
	    }
	    
	public static boolean isMirror(TreeNode t1, TreeNode t2) {

		
		if (t1 == null && t2 == null) {
			return true;
		}
		/*
		 * NOTE :Order of null checks is :AND --> OR . OR check comes after AND
		 * check.Otherwise if the order is reversed OR-->AND , AND check would be a dead
		 * code and result would be different
		 */
		
		if (t1 == null || t2 == null) {
			return false;
		}
		return (t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left));

	}
	
	public static boolean isSymmetricByBFS(TreeNode root) {
	    Queue<TreeNode> q = new LinkedList<>();
	    q.add(root);
	    q.add(root);
	    while (!q.isEmpty()) {
	        TreeNode t1 = q.poll();
	        TreeNode t2 = q.poll();
	        if (t1 == null && t2 == null) continue;
	        if (t1 == null || t2 == null) return false;
	        if (t1.val != t2.val) return false;
	        q.add(t1.left);
	        q.add(t2.right);
	        q.add(t1.right);
	        q.add(t2.left);
	    }
	    return true;
	}

	
/*
 * https://www.geeksforgeeks.org/check-weather-given-binary-tree-perfect-not/
 */
	// Wrapper over isPerfectRec()
	static boolean isPerfect(TreeNode root) {
		int d = findLeftLeafDepth(root);
		return isPerfectRec(root, d, 0);
	}
	
	// Returns depth of leftmost leaf.
		static int findLeftLeafDepth(TreeNode node) {
			int d = 0;
			while (node != null) {
				d++;
				node = node.left;
			}
			return d;
		}

		/*
		 * This function tests if a binary tree is perfect or not. It basically checks
		 * for two things : 1) All leaves are at same level 2) All internal nodes have
		 * two children
		 */
		static boolean isPerfectRec(TreeNode root, int d, int level) {
			// An empty tree is perfect
			if (root == null)
				return true;

			// If leaf node, then its depth must be same as
			// depth of all other leaves.
			if (root.left == null && root.right == null) {
				return (d == level + 1);
			}

			// If internal node and one child is empty
			if (root.left == null || root.right == null)
				return false;

			// Left and right subtrees must be perfect.
			return isPerfectRec(root.left, d, level + 1) && isPerfectRec(root.right, d, level + 1);
		}
		
		
	public static boolean isBST(TreeNode root){
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private static boolean isBST(TreeNode root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val > max){
            return false;
        }
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }
    /*
     * 958. Check Completeness of a Binary Tree
		Medium
		
		Given a binary tree, determine if it is a complete binary tree.
		
		Definition of a complete binary tree from Wikipedia:
		In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
		
		 
		
		Example 1:
		
		
		
		Input: [1,2,3,4,5,6]
		Output: true
		Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
		Example 2:
		
		
		
		Input: [1,2,3,4,5,null,7]
		Output: false
		Explanation: The node with value 7 isn't as far left as possible.
     */
    //
    public static boolean isComplete(TreeNode root){
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
        for( q.add(root); ( root=q.remove() )!=null; q.add(root.left), q.add(root.right) );
        while( !q.isEmpty() ) {
        	if( q.remove()!=null ) {
        		return false;
        	}
        }
        return true;
    }
    //better understanding
    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
      int node_count = countNodes(root); 
       int index = 0; 
          
     return isComplete(root, index, node_count);
   }
   
    /* This function counts the number of nodes in a binary tree */
  private static int countNodes(TreeNode root)  
   { 
       if (root == null) 
           return (0); 
       return (1 + countNodes(root.left) + countNodes(root.right)); 
   } 
  
   /* This function checks if the binary tree is complete or not */
  private  static boolean isComplete(TreeNode root, int index, int number_nodes) 
   { 
       // An empty tree is complete 
       if (root == null)         
          return true; 
  
       // If index assigned to current node is more than 
       // number of nodes in tree, then tree is not complete 
       if (index >= number_nodes) 
          return false; 
  
       // Recur for left and right subtrees 
       return (isComplete(root.left, 2 * index + 1, number_nodes) 
           && isComplete(root.right, 2 * index + 2, number_nodes)); 
  
   } 
    
   
       
    
    /*
     * https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
		Check if a given Binary Tree is SumTree
		
		Write a function that returns true if the given Binary Tree is SumTree else false.
		 A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes
		  present in its left subtree and right subtree. 
		  An empty tree is SumTree and sum of an empty tree can be considered as 0.
		   A leaf node is also considered as SumTree.
		
		Following is an example of SumTree.
		
		          26
		        /   \
		      10     3
		    /    \     \
		  4      6      3
     */
  /* A utility function to get the sum of values in tree with root 
  as root */
	static int sum(TreeNode root) {
		if (root == null)
			return 0;
		int leftCount = root.left == null ? 0 : sum(root.left);
		int rightCount = root.right == null ? 0 : sum(root.right);
		return leftCount + root.val + rightCount;
	}

 /* returns 1 if sum property holds for the given 
    node and both of its children */
	static boolean isSumTree(TreeNode node) {
		int leftSum, rightSum;

		/*
		 * If node is NULL or it's a leaf node then return true
		 */
		if ((node == null) || (node.left == null && node.right == null))
			return true;

		/* Get sum of nodes in left and right subtrees */
		leftSum = sum(node.left);
		rightSum = sum(node.right);

		/*
		 * if the node and both of its children satisfy the property return true else
		 * false
		 */
		if (node.val == leftSum + rightSum &&  isSumTree(node.left) && isSumTree(node.right) ) 
			return true;

		return false;
	}

}
