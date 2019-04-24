package org.vivek.myinterview.trees;



public class TreeNode {
    public TreeNode left, right;
    public int val,height,size;

    public TreeNode() {
        
    } 
    public TreeNode(int data) {
        this.val = data;
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
