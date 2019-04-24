package org.vivek.myinterview.trees;

import org.vivek.myinterview.trees.traversal.TreeTraversals;



/**
 * Date 07/04/2014
 * @author tusroy
 *
 * Video link - https://youtu.be/rbg7Qf8GkQ4
 *
 * Write a program to insert into an AVL tree.
 * 
 * AVL tree is self balancing binary tree. Difference of height of left or right subtree
 * cannot be greater than one.
 * 
 * There are four different use cases to insert into AVL tree
 * left left - needs ones right rotation
 * left right - needs one left and one right rotation
 * right left - needs one right and one left rotation
 * right right - needs one left rotation
 * 
 * Follow rotation rules to keep tree balanced.
 * 
 * At every node we will also keep height of the tree so that we don't
 * have to recalculate values again.
 * 
 * Runtime complexity to insert into AVL tree is O(logn).
 * 
 * References 
 * http://en.wikipedia.org/wiki/AVL_tree
 * http://www.geeksforgeeks.org/avl-tree-set-1-insertion/
 * 
 */
public class AVLTree {

    private TreeNode leftRotate(TreeNode root){
    	 System.out.println("leftRotate on root:" +root.val + " resulting in new root :" +root.right.val);
    	
        TreeNode newRoot = root.right;
        root.right = root.right.left;
        newRoot.left = root;
        root.height = setHeight(root);
        root.size = setSize(root);
        newRoot.height = setHeight(newRoot);
        newRoot.size = setSize(newRoot);
        return newRoot;
    }
    
    private TreeNode rightRotate(TreeNode root){
    	 System.out.println("rightRotate on root:" +root.val+ " resulting in new root :" +root.left.val);;
        TreeNode newRoot = root.left;
        root.left = root.left.right;
        newRoot.right = root;
        root.height = setHeight(root);
        root.size = setSize(root);
        newRoot.height = setHeight(newRoot);
        newRoot.size = setSize(newRoot);
        return newRoot;
    }

    private int setHeight(TreeNode root){
       int height = height(root);
        System.out.println("height for root:" +root.val + " is :"+ height );
        return  height;
    }
    
    private int height(TreeNode root){
    	 int rootLeftHeight=0,rootRightHeight=0;
    	
        if(root == null){
            return 0;
        }else {
        	 if(null!=root.left) {
              	rootLeftHeight=height(root.left);
              }
              if(null!=root.right) {
              	rootRightHeight=height(root.right);
              }
            return 1 + Math.max(rootLeftHeight, rootRightHeight);
        }
    }
    
    private int setSize(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max((root.left != null ? root.left.size : 0), (root.right != null ? root.right.size : 0));
    }
    
    public TreeNode insert(TreeNode root, int data){
        if(root == null){
            return new TreeNode(data);
        }
        if( data >= root.val){
            root.right = insert(root.right,data);
        }
        else{
            root.left = insert(root.left,data);
        }
        System.out.println("printng before checking balance atr root:" +root.val);
        BTreePrinter.printNode(root);
        int balance = balance(root.left, root.right);
        System.out.println("checked balance at root:" +root.val + ",balance=" +balance);
        if(balance > 1){
        	System.out.println("START :balance > 1:");
        	if(null!=root.left.left) {
        	System.out.println(" root.left.left=" +root.left.left.val + ",height(root.left.left)=" +height(root.left.left));
        	}else{
        		System.out.println(" root.left.left is null");	
        	}
        	if(null!=root.left.right) {
        	System.out.println(" root.left.right=" +root.left.right + ",height(root.left.right)=" +height(root.left.right));
        	}else {
        		System.out.println(" root.left.right is null");	
        	}
        	if(height(root.left.left) >= height(root.left.right)){
            	System.out.println(" LL");
            	root = rightRotate(root);
               // System.out.println("After rightRotation LL:");
                //BTreePrinter.printNode(root);
            	 System.out.println("END :balance > 1:");
            }else{
            	System.out.println("Intiated LR");
                root.left = leftRotate(root.left);
                root = rightRotate(root);
                System.out.println("Done LR");
                System.out.println("END :balance > 1:");
            }
        }else if(balance < -1){
            if(height(root.right.right) >= height(root.right.left)){
                root = leftRotate(root);
            }else{
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }
        }
        else{
        	 System.out.println("Setting height of root:" +root.val);
            root.height = setHeight(root);
          	 System.out.println("=> height of root:" + root.height);
            root.size = setSize(root);
        }
        //System.out.println("After  finalrightRotation LL:");
        //BTreePrinter.printNode(root);
        return root;
    }
    
    private int balance(TreeNode rootLeft, TreeNode rootRight){
    	int rootLeftData=0 , rootLeftHeight=0,rootRightData=0 ,rootRightHeight=0;
    	if(null!=rootLeft){
    		 rootLeftData = rootLeft.val;
    		 rootLeftHeight=height(rootLeft);
    	}
    	if(null!=rootRight){
    		rootRightData = rootRight.val;
    		rootRightHeight=height(rootRight);
   	}
    	System.out.println("left: "+ rootLeftData +",left height: "+ rootLeftHeight +"+,rootRight="+rootRightData+",right height="+rootRightHeight);
    	//System.out.println("left height: "+ height(rootLeft) +",rootRight="+height(rootRight));
    	int diff = height(rootLeft) - height(rootRight);
    	System.out.println("Diff in height="+diff);
        return diff;
    }
    
    public static void main(String args[]){
    	TreeNode root = test1();
    	System.out.println("***Initial Binary tree:****");
    	//BTreePrinter.printNode(test1());
    	TreeNode bstroot =constructBinarySearchTree();
    	BTreePrinter.printNode(bstroot);
       
       // BTreePrinter.printNode(bstroot);
       // TNode avlroot = constructAVLTree();
    	System.out.println("***Initial AVL tree:****");
    	AVLTree avlTree = new AVLTree();
    	TreeNode avlroot = constructAVLTree();
    	 BTreePrinter.printNode(avlroot);
    	 System.out.println("***********************************************" );
    	TreeNode avlroot2 =  constructAVLTree2();
    	
    	 BTreePrinter.printNode(avlroot2);
    	 System.out.println("***********************************************" );
    	 System.out.println("***Add 4 to Initial AVL tree with root:" + avlroot.val);
    	avlroot = avlTree.insert(avlroot, 4);
    	 BTreePrinter.printNode(avlroot);
        System.out.println("*****************************START:LR DEMO*****************************");
        
        avlroot =  constructAVLTreeForLR();
        BTreePrinter.printNode(avlroot);
        //now force LR
        avlroot = avlTree.insert(avlroot, 3);
        BTreePrinter.printNode(avlroot);
        System.out.println("*****************************END:LR DEMO*****************************");
    }

	private static TreeNode constructBinarySearchTree() {
		BinaryTree bt = new BinaryTree();
        TreeNode head = null;
     
        head = bt.addNode(10, head);
        head = bt.addNode(8, head);
        head = bt.addNode(7, head);
        head = bt.addNode(6, head);
        head = bt.addNode(15, head);
        head = bt.addNode(12, head);
        head = bt.addNode(17, head);
        head = bt.addNode(16, head);
        head = bt.addNode(18, head);
       head = bt.addNode(4, head);
       
        return head;
	}

	private static TreeNode constructAVLTree() {
		AVLTree avlTree = new AVLTree();
        TreeNode root = null;
        /*root = avlTree.insert(root, -10);
        root = avlTree.insert(root, 2);
        root = avlTree.insert(root, 13);
        root = avlTree.insert(root, -13);
        root = avlTree.insert(root, -15);
        root = avlTree.insert(root, 15);
        root = avlTree.insert(root, 17);
        root = avlTree.insert(root, 20);*/
        System.out.println("***Start  AVL tree add 10 root :****");
        root = avlTree.insert(root, 10);
        BTreePrinter.printNode(root);
        
        System.out.println("*** AVL tree: add 8  :****");
        root = avlTree.insert(root, 8);
        BTreePrinter.printNode(root);
        
         System.out.println("*** AVL tree: add 6  :****");
        root = avlTree.insert(root, 6); 
        BTreePrinter.printNode(root);
        
        System.out.println("*** AVL tree: add 7  :****");
        root = avlTree.insert(root, 7); 
        BTreePrinter.printNode(root);
        
        System.out.println("*** AVL tree: add 15  :****");
        root = avlTree.insert(root, 15);
        BTreePrinter.printNode(root);
        
        System.out.println("*** AVL tree: add 12  :****");
        root = avlTree.insert(root, 12);
        BTreePrinter.printNode(root);
        
        System.out.println("*** AVL tree: add 17  :****");
        root = avlTree.insert(root, 17);
        BTreePrinter.printNode(root);
        
        System.out.println("*** AVL tree: add 16  :****");
        root = avlTree.insert(root, 16);
        BTreePrinter.printNode(root);
        
        System.out.println("*** AVL tree: add 18  :****");
        root = avlTree.insert(root, 18);   
        BTreePrinter.printNode(root);
        
        System.out.println("*** End:AVL tree: root :" + root.val);
        
       
		return root;
	}
	
	private static TreeNode constructAVLTree2() {
		AVLTree avlTree = new AVLTree();
        TreeNode root = null;
        int[] arr = {6,7,12,15,17,18,16,8,10};
        System.out.println("***Start  AVL tree add 6 root :****");
        for(int k : arr) {
        	  root = avlTree.insert(root, k);
              BTreePrinter.printNode(root);
        }
       
      
        System.out.println("*** End:AVL tree: root :" + root.val);
        
       
		return root;
	}
	
	private static TreeNode constructAVLTreeForLR() {
		AVLTree avlTree = new AVLTree();
        TreeNode root = null;
        int[] arr = {10,7,4,2,9,13,14,16};
        System.out.println("***Start  constructAVLTreeForLR :****");
        for(int k : arr) {
        	System.out.println("constructAVLTreeForLR=====>> insert :"+k);
        	  root = avlTree.insert(root, k);
              BTreePrinter.printNode(root);
        }
       
      
        System.out.println("*** End:AVLconstructAVLTreeForLR root :" + root.val);
        
       
		return root;
	}
	
	private static TreeNode test1() {
		TreeNode root = new TreeNode(10);
		TreeNode n1 = new TreeNode(8);
		TreeNode n2 = new TreeNode(7);
		TreeNode n3 = new TreeNode(6);
		//TNode n4 = new TNode(4);
		//TNode n5 = new TNode(9);
		TreeNode n6 = new TreeNode(15);
		TreeNode n7 = new TreeNode(12);
		TreeNode n8 = new TreeNode(16);
		TreeNode n9 = new TreeNode(17);
		TreeNode n10 = new TreeNode(18);
	
		

		root.left = n1;
		root.right = n6;

		n1.left = n2;
		//n1.right = n5;
		n2.left = n3;
		//n3.left = n4;

		n6.left = n7;
		n6.right = n9;
		n9.left = n8;
		n9.right = n10;
		

		return root;
	}
}
