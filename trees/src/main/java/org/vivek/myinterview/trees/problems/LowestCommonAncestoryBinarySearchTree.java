package org.vivek.myinterview.trees.problems;

import org.vivek.myinterview.trees.TreeNode;

/**
 * Date 05/04/2016
 * @author Tushar Roy
 *
 * Lowest common ancestor in binary search tree.
 *
 * Time complexity O(height of tree)
 * Space complexity O(height of tree)
 * 
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LowestCommonAncestoryBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root.val > Math.max(p, q)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < Math.min(p, q)) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
