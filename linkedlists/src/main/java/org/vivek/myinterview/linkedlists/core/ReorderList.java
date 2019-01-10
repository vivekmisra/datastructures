package org.vivek.myinterview.linkedlists.core;

/**
 * Definition for singly-linked list.
 * public class SLLNode {
 *     int val;
 *     SLLNode next;
 *     SLLNode(int x) { val = x; }
 * }
 */
public class ReorderList {
	
	
	public static void main(String[] args) {
		ReorderList rl = new ReorderList();
		SLLImpl L1 = new SLLImpl();
		int[] dataForL1 = new int[] {3,1,8,7,-1,6};
		SLLNode head = SLLUtils.constructList(L1,dataForL1);
		System.out.println("L1 ORIGINAL:");
		SLLUtils.printLinkedList(head);
		rl.reorderList(head);
		System.out.println("L1 REORDERED:");
		SLLUtils.printLinkedList(head);
		
	}
	
	
    public void reorderList(SLLNode head) {
      	SLLNode l = removeLast(head);
    	if(head.next !=null) {
    		SLLNode headNext = head.next;
    		head.next= null;
    		head.next = l;
    		l.next = headNext;
    		reorderList(headNext);
    	}else{
            l=head;
            
        }
    	
    }



 private SLLNode getLast(SLLNode head) {
		SLLNode tail = null;
		if (head == null) {
			return null;
		} else {
			// pointer will move to last so we need to grab original head
			SLLNode p = head;
			while (head.next != null) {
				tail = head.next;
				head = head.next;
			}		
			tail.next = null;
			head=p;//reset head 
		}
		return tail;
	}
    
   private SLLNode findPreviousNode(SLLNode head,SLLNode targetNode){
		   SLLNode current_node =head;
		   while(current_node.next != null) {
		       if(current_node.next == targetNode) {
		          return current_node;
		       }else{
		          current_node = current_node.next;
		       }
		   }
		   return null;
	}
    
    private SLLNode removeLast(SLLNode head) {

		SLLNode last = getLast(head);
		SLLNode previousNodetail = findPreviousNode(head,last);
		SLLNode tail = previousNodetail;
		tail.next = null;
		return last;
		
	}
    
}