package org.vivek.myinterview.trees.problems.metrics;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.vivek.myinterview.trees.BTreePrinter;
import org.vivek.myinterview.trees.TNode;



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

		TNode root = new TNode(1);
		root.left = new TNode(2);
		root.right = new TNode(3);
		root.left.left = new TNode(4);
		root.left.right = new TNode(5);
		BTreePrinter.printNode(root);
		int minimumDepth = minimumDepth(root);
		System.out.println("Minimum Depth=" + minimumDepth);
		int height = height(root);
		System.out.println("Maximum Depth or heightof tree=" + height);

		System.out.println("Sum of all node dats is : " + diameter(root));
		System.out.println("Sum of all nodes data in tree  : " +sumOfAllNodeData(root) );
		System.out.println("Level by level  Sum of nodes data in tree  : " );
		List<Integer> sumList = sumAtEachLevel(root);
		sumList.forEach(levelSum ->System.out.println(levelSum));
		System.out.println("Average of nodes data  at each level in tree  : "  );
		List<Double> avgLevelValueList =  averageOfEachLevelNodeData(root) ;
		avgLevelValueList.forEach(avg ->System.out.println(avg));

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
	static int minimumDepth(TNode root) {
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

	static int height(TNode root) {
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
	static int diameter(TNode root) {
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
	
	
	 static int sumOfAllNodeData(TNode root) {
		int sum = 0;
		if (root == null)
			return 0;
		Queue<TNode> q = new LinkedList<TNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			TNode tmp = q.poll();
			sum += tmp.data;
			if (tmp.left != null)
				q.offer(tmp.left);
			if (tmp.right != null)
				q.offer(tmp.right);
		}
		return sum;
	}
	
	
	static List<Integer> sumAtEachLevel(TNode root) {
		List<Integer> list = new LinkedList<>();
			Queue<TNode> queue = new LinkedList<>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				int count = queue.size();
				int sum = 0;
				for (int i = 0; i < count; i++) {
					TNode cur = queue.poll();
					sum += cur.data;
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
	
	
	static List<Integer>maxsumLevel(TNode root) {
		List<Integer> list = new LinkedList<>();
			Queue<TNode> queue = new LinkedList<>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				int count = queue.size();
				int sum = 0;
				for (int i = 0; i < count; i++) {
					TNode cur = queue.poll();
					sum += cur.data;
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
	
	  static List<Double> averageOfEachLevelNodeData(TNode root) {
		List<Double> list = new LinkedList<>();
		Queue<TNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int count = queue.size();
			double sum = 0;
			for (int i = 0; i < count; i++) {
				TNode cur = queue.poll();
				sum += cur.data;
				if (cur.left != null)
					queue.offer(cur.left);
				if (cur.right != null)
					queue.offer(cur.right);
			}
			list.add(sum / count);
		}
		return list;
	}
	
   
}
