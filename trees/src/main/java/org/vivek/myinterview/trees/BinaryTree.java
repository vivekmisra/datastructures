package org.vivek.myinterview.trees;



public class BinaryTree {

	public BinaryTree() {
		// TODO Auto-generated constructor stub
	}
	public TreeNode addNode(int data, TreeNode head){
        TreeNode tempHead = head;
        TreeNode n = new TreeNode(data);
        if(head == null){
            head = n;
            return head;
        }
        TreeNode prev = null;
        while(head != null){
            prev = head;
            if(head.val < data){
                head = head.right;
            }else{
                head = head.left;
            }
        }
        if(prev.val < data){
            prev.right = n;
        }else{
            prev.left = n;
        }
        return tempHead;
    }
    
    class IntegerRef{
        int height;
    }
    
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight  = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
