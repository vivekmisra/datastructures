package org.vivek.myinterview.trees;



public class TNode {
    public TNode left, right;
    public int data,height,size;

    public TNode(int data) {
        this.data = data;
    } 
    
    class IntegerRef{
        int height;
    }
    
    public int height(TNode root){
        if(root == null){
            return 0;
        }
        int leftHeight  = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
