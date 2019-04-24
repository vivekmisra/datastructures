package org.vivek.myinterview.trees.problems;

import org.vivek.myinterview.trees.TreeNode;

/**
 * Created by tushar_v_roy on 4/1/16.
 */
public class LongestConsecutiveSequence {
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        max = 0;
        longestConsecutiveUtil(root, root.val - 1, 0);
        return max;
    }

    public void longestConsecutiveUtil(TreeNode root, int prevData, int current) {
        if (root == null) {
            return;
        }

        if (root.val == prevData + 1) {
            current = current + 1;
        } else {
            current = 1;
        }
        max = Math.max(current, max);
        longestConsecutiveUtil(root.left, root.val, current);
        longestConsecutiveUtil(root.right, root.val, current);
    }
}
