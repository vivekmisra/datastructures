package org.vivek.myinterview.trees;



public class BinaryTree {

	public BinaryTree() {
		// TODO Auto-generated constructor stub
	}
	public TNode addNode(int data, TNode head){
        TNode tempHead = head;
        TNode n = new TNode(data);
        if(head == null){
            head = n;
            return head;
        }
        TNode prev = null;
        while(head != null){
            prev = head;
            if(head.data < data){
                head = head.right;
            }else{
                head = head.left;
            }
        }
        if(prev.data < data){
            prev.right = n;
        }else{
            prev.left = n;
        }
        return tempHead;
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
