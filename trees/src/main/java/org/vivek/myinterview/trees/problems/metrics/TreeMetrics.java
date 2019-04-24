package org.vivek.myinterview.trees.problems.metrics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.TreeNode;





class TreeLevelDetails{
	  Integer levelNumber=1;
	  Integer  levelSum;
	  Double averageLevelSum;
	  /*TreeLevelDetails( ){
		  this.levelNumber = 1;
	  }
	  TreeLevelDetails( Integer levelNumber){
		  this.levelNumber = levelNumber;
	  }*/
	  
	  
}

public class TreeMetrics {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		BTreePrinter.printNode(root);
		int minimumDepth = minimumDepth(root);
		System.out.println("Minimum Depth=" + minimumDepth);
		int minDepth1 = minDepth1(root);
		System.out.println("Minimum Depth1=" +minDepth1);
		int height = height(root);
		System.out.println("Maximum Depth or heightof tree=" + height);
		int height2 = height2(root);
		System.out.println("Maximum Depth or heightof tree2=" + height2);

		System.out.println("Sum of all node dats is : " + diameter(root));
		System.out.println("Sum of all nodes data in tree  : " +sumOfAllNodeData(root) );
		System.out.println("Level by level  Sum of nodes data in tree  : " );
		List<Integer> sumList = sumAtEachLevel(root);
		sumList.forEach(levelSum ->System.out.println(levelSum));
		System.out.println();
		System.out.println("Level by level  max Sum of nodes data in tree  : " +maxsumLevel(root) );
		
		System.out.println("Average of nodes data  at each level in tree  : "  );
		List<Double> avgLevelValueList =  averageOfEachLevelNodeData(root) ;
		avgLevelValueList.forEach(avg ->System.out.println(avg));
		
		TreeNode root1 = new TreeNode(4);
		root1.left = new TreeNode(5);
		root1.right = new TreeNode(6);
		root1.left.left = new TreeNode(4);
		root1.left.left.left= new TreeNode(5);
		root1.right.left = new TreeNode(1);
		//root1.right.left.left = new TNode(7);
		//root1.right.left.left.left = new TNode(1);
		root1.right.right = new TreeNode(7);
		root1.right.right.right = new TreeNode(8);
		root1.right.right.left = new TreeNode(9);
		BTreePrinter.printNode(root1);
		int count = countDistinctNodes(root1);
		System.out.println("DISTINCT:"+count);
	
      
	}

	//@formatter:off
	/* Function to calculate the minimum depth of the tree */
	/*
	 * Given a binary tree, find its minimum depth. 
	 * The minimum depth is the number of nodes along the shortest path 
	 * from root node down to the nearest leaf node.
	 * 
	 * For example, minimum height of below Binary Trees is 2.
	 *  10
        /    
      5  
      
           1
          / \
         /   \
        2     3
       / \
      /   \
	 4     5
	 
	 *
	 */
	//@formatter:on
	static int minimumDepth(TreeNode root) {
		// Corner case. Should never be hit unless the code is
		// called on root = NULL
		if (root == null) {
			return 0;
		}
          //here we shud look for nearest leaf
		// Base case : Leaf Node. This accounts for height = 1.
		if (root.left == null && root.right == null) {
			return 1;
		}

		// If left subtree is NULL, recur for right subtree after incrementing current
		// node count
		if (root.left == null) {
			return minimumDepth(root.right) + 1;
		}

		// If right subtree is NULL, recur for left subtree after incrementing current
		// node count
		if (root.right == null) {
			return minimumDepth(root.left) + 1;
		}
		int minimumLeftSubTreeCount = minimumDepth(root.left);
		int minimumRightSubTreeCount = minimumDepth(root.right);
		// minimum is min of both leftSubtreeCount and righSubTreecount plus counting
		// rooot(adding 1)
		int minimum = Math.min(minimumLeftSubTreeCount, minimumRightSubTreeCount) + 1;

		return minimum;
	}
	//easier
	static int minDepth1(TreeNode root)  
    { 
		if (root == null) {
			return 0;
		}else if (root.left == null && root.right == null) {
          //here we shud look for nearest leaf
		// Base case : Leaf Node. This accounts for height = 1.
		
			return 1;
		}
        else 
        { 
            /* compute the depth of each subtree */
            int lDepth = minDepth1(root.left); 
            int rDepth = minDepth1(root.right); 
   
            /* use the larger one */
            return (1 + Math.min(lDepth, rDepth)); 
        } 
    } 
	
	//HEIGHT
	  static int maxDepth(TreeNode node)  
	    { 
	        if (node == null) 
	            return 0; 
	        else 
	        { 
	            /* compute the depth of each subtree */
	            int lDepth = maxDepth(node.left); 
	            int rDepth = maxDepth(node.right); 
	   
	            /* use the larger one */
	            return (1 + Math.max(lDepth, rDepth));  
	        } 
	    } 
	  
	  static int height(TreeNode node)  
	    { 
	        if (node == null) 
	            return 0; 
	        else 
	        { 
	            /* compute the depth of each subtree */
	            int lHeight = height(node.left); 
	            int rHeight = height(node.right); 
	   
	            /* use the larger one */
	            return (1 + Math.max(lHeight, rHeight)); 
	        } 
	    } 
	       

	static int height2(TreeNode root) {
		// Corner case. Should never be hit unless the code is
		// called on root = NULL
		if (root == null) {
			return 0;
		}

		// Base case : Leaf Node. This accounts for height = 1.
		if (root.left == null && root.right == null) {
			return 1;
		}

		// If left subtree is NULL, recur for right subtree after incrementing current
		// node count
		if (root.left == null) {
			return height(root.right) + 1;
		}

		// If right subtree is NULL, recur for left subtree after incrementing current
		// node count
		if (root.right == null) {
			return height(root.left) + 1;
		}
		int maxLeftSubTreeCount = height(root.left);
		int maxRightSubTreeCount = height(root.right);
		// maximum is min of both leftSubtreeCount and righSubTreecount plus counting
		// rooot(adding 1)
		int maximum = Math.max(maxLeftSubTreeCount, maxRightSubTreeCount) + 1;

		return maximum;
	}

	//@formatter:on
	/*
	 *
	 * Diameter of a Binary Tree
	 * https://www.geeksforgeeks.org/diameter-of-a-binary-tree/ The diameter of a
	 * tree (sometimes called the width) is the number of nodes on the longest path
	 * between two end nodes.
	 * 
	 * The diameter of a tree T is the largest of the following quantities:
	 * 
	 * A)the diameter of T’s left subtree B)the diameter of T’s right subtree C)the
	 * longest path between leaves that goes through the root of T (this can be
	 * computed from the heights of the subtrees of T)
	 * 
	 * ThErefore Diameter of Tree T =max(A,B,C)
	 */
	static int diameter(TreeNode root) {
		/* base case if tree is empty */
		if (root == null)
			return 0;

		/* get the height of left and right sub trees */
		int lheight = height(root.left);
		int rheight = height(root.right);
		// get the longest path between leaves that goes through the root of T
		int longestPathBetweenLeaves = lheight + rheight + 1;

		/* get the diameter of left and right subtrees */
		int ldiameter = diameter(root.left);
		int rdiameter = diameter(root.right);
		int maxSubTreeDiameter = Math.max(ldiameter, rdiameter);

		/*
		 * Return max of following three 1) Diameter of left subtree 2) Diameter of
		 * right subtree 3) Height of left subtree + height of right subtree + 1
		 */
		return Math.max(longestPathBetweenLeaves, maxSubTreeDiameter);

	}
	
	
	 static int sumOfAllNodeData(TreeNode root) {
		int sum = 0;
		if (root == null)
			return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode tmp = q.poll();
			sum += tmp.val;
			if (tmp.left != null)
				q.offer(tmp.left);
			if (tmp.right != null)
				q.offer(tmp.right);
		}
		return sum;
	}
	
	
	static List<Integer> sumAtEachLevel(TreeNode root) {
		List<Integer> list = new LinkedList<>();
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				int count = queue.size();
				int sum = 0;
				///loop over current level queue
				//add level sum as a element of list 
				for (int i = 0; i < count; i++) {
					TreeNode cur = queue.poll();
					sum += cur.val;
					if (cur.left != null) {
						queue.offer(cur.left);
					}
					if (cur.right != null) {
						queue.offer(cur.right);
					}
				}
				list.add(sum );
			}
			return list;
		}
	
	
	static int maxsumLevel(TreeNode root) {
		List<Integer> list = new LinkedList<>();
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			int localSum = 0;
			int maxSum = Integer.MIN_VALUE;
			while (!queue.isEmpty()) {
				int count = queue.size();
				int sum = 0;
				//loop over current level queue
				//find level sum and find max 
				for (int i = 0; i < count; i++) {
					TreeNode cur = queue.poll();
					sum += cur.val;
					if (cur.left != null) {
						queue.offer(cur.left);
					}
					if (cur.right != null) {
						queue.offer(cur.right);
					}
				}
				localSum = sum;
				if (localSum > maxSum) {
					maxSum = localSum;
					
				}
				list.add(sum );
			}
			return maxSum;
		}
	
	  static List<Double> averageOfEachLevelNodeData(TreeNode root) {
		List<Double> list = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int count = queue.size();
			double sum = 0;
			//loop over current level queue
			//find level sum and divide by queue size
			for (int i = 0; i < count; i++) {
				TreeNode cur = queue.poll();
				sum += cur.val;
				if (cur.left != null)
					queue.offer(cur.left);
				if (cur.right != null)
					queue.offer(cur.right);
			}
			list.add(sum / count);
		}
		return list;
	}
	
		
	  public static int countDistinctNodes(TreeNode T) {
	        // write your code in Java SE 8
	      Set<Integer> uniq = new HashSet<>();
			if(T == null){
				return 0;
			}
			return getDistinctNodeCount(T, uniq);
		}
		
		private static int getDistinctNodeCount(TreeNode root, Set<Integer> set){
			
			if( root==null){
				int max = set.size()-1;
				return max;
			}
			int leftCount = 0;
			int rightCount  = 0;
			if(set.add(root.val)){
			    leftCount = getDistinctNodeCount(root.left, set);
				rightCount = getDistinctNodeCount(root.right, set);
				
			}
			else{
				leftCount = getDistinctNodeCount(root.left, set);
				rightCount = getDistinctNodeCount(root.right,set);
				
			}
			return Math.max(leftCount, rightCount);
		}

		

		 public boolean rootToLeafSum(TreeNode root, int sum, List<TreeNode> path){
		        if(root == null){
		            return false;
		        }
		       //leaf check
		        if(root.left == null && root.right == null){
		            if(root.val == sum){
		                path.add(root);
		                return true;
		            }else{
		                return false;
		            }
		        }
		        if(rootToLeafSum(root.left, sum-root.val, path) || rootToLeafSum(root.right, sum - root.val, path)){
		            path.add(root);
		            return true;
		        }
		        return false;
		    }
		 /*
		  * 222. Count Complete Tree Nodes
			Medium

			Given a complete binary tree, count the number of nodes.
			
			Note:
			
			Definition of a complete binary tree from Wikipedia:
			In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
			
			Example:
			
			Input: 
			    1
			   / \
			  2   3
			 / \  /
			4  5 6
			
			Output: 6
		  */
		 public static int countNodesOfCompleteBinaryTree(TreeNode root) {
		        int[] nodes = new int[1];
		           countNodes(root, nodes);
		           return nodes[0];
		       }
		       
		       static void countNodes(TreeNode root, int[] nodes) {
		           
		           if(root == null) {
		               return;
		           }
		           
		           nodes[0]++;
		           
		           countNodes(root.left, nodes);
		           countNodes(root.right, nodes);
		       }
   
}
