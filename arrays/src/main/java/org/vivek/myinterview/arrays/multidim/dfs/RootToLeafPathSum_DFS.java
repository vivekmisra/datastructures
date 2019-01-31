package org.vivek.myinterview.arrays.multidim.dfs;

import java.util.ArrayList;
import java.util.List;

/*
 * For example, given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
the method returns the following:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class RootToLeafPathSum_DFS {
	public List<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;

		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(root.val);
		dfs(root, sum - root.val, result, l);
		return result;
	}

	public void dfs(TreeNode t, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> l) {
		if (t.left == null && t.right == null && sum == 0) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(l);
			result.add(temp);
		}

		// search path of left node
		if (t.left != null) {
			l.add(t.left.val);
			dfs(t.left, sum - t.left.val, result, l);
			l.remove(l.size() - 1);
		}

		// search path of right node
		if (t.right != null) {
			l.add(t.right.val);
			dfs(t.right, sum - t.right.val, result, l);
			l.remove(l.size() - 1);
		}
	}
	
	class TreeNode {
	    public TreeNode left, right;
	    public int val,height,size;

	    public TreeNode(int data) {
	        this.val = data;
	    } 
	    
	    class IntegerRef{
	        int height;
	    }
	    
	   
	}
}
