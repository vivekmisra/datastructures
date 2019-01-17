package org.vivek.myinterview.linkedlists.core;


public class SLLImpl {
	private int length = 0;
	SLLNode head;

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param head the head to set
	 */
	public void setHead(SLLNode head) {
		this.head = head;
	}

	public SLLImpl() {
		length = 0;
		head = null;
	}
	
	public SLLImpl(Integer data) {		
		this.head = new SLLNode(data,null);
		++length;
	}
	public SLLImpl(Integer data,SLLNode next) {		
		this.head = new SLLNode(data,next);
	
		++length;
	}

	/**
	 * @return the head
	 */
	public SLLNode getHead() {
		return head;
	}

	public SLLNode getTail(SLLNode head) {
		return getLast(head);
	}



	// purge
	public void purge() {
		this.head = null;

	}

	public SLLNode find(Integer data) {
		SLLNode node = getHead();// runner
		while (node != null && node.data.equals(data)) {
			node = node.next;
		}
		return node;
	}
	
	
	
	 public SLLNode addNode(Integer  data){
	        SLLNode temp = head;
	        SLLNode n = null;
	    
	         n =  new SLLNode(data);
	      
	        if(head == null){
	            return n;
	        }
	        
	        while(head.next != null){
	            head = head.next;
	        }
	        
	        head.next = n;
	        return temp;
	    }

	public SLLNode addAtFront(Integer data,SLLNode head) { 
		SLLNode node = null;
		if (head == null) {
			node = new SLLNode(data, null);			
			++length;
		} else {
			node = new SLLNode(data, head);
			node.next = head;
			head = node;//node is new head
			++length;
		}
		return node;

	}
	
	// Remove and return the node at the end of the list
	public SLLNode getLast(SLLNode head) {
		SLLNode tail = null;
		if (head == null) {
			return null;
		} else {
			// Whether to iterate or not
			if (head.next != null) {
				// more than 1 node
				while (head.next != null) {//iterate over head
					tail = head.next;//grab the next node
					head = head.next;
				}
				//by this time tail represents last node
				tail.next = null;//since it is last node,it is tail
			} else {//just 1 node
				tail = head;
				tail.next = null;
			}
		}
		return tail;
	}

	public SLLNode addNodeAtEnd(Integer data,SLLNode head) {
		SLLNode tail = null;
		SLLNode temp = head;
		//create a new node with input data
		SLLNode newNode = new SLLNode(data,null);
		if (head == null) {	//first element		
			++length;
			head=newNode;//this is new head
			tail = head;//both are same			
			return head;
		} else {		
			tail = getLast(head);//get last
			tail.next = newNode;	//link to n		
			newNode.next = null;  //making n as new tail
			tail = newNode; //making n as new tail
			++length;
			return temp;
		}
		
	}
	// Remove and return the node at the head of the list
		public  void removeFromBegin() {
			if (head != null) {
				head = head.next;// new head
				// reduce the length of the list
				--length;
			}
		}
		
		
		public void printLinkedList(SLLNode head) {
			
			while (head != null) {
				if(head.next!=null){
					System.out.print(head.data + "->");
				}else{
					System.out.print(head.data + "->NULL");
				}
				head = head.next;
			}
			System.out.println();
		}
		
		public static void main(String args[]){
			SLLImpl l = new SLLImpl();
					
			SLLNode head = null;
	        head = l.addNodeAtEnd(1, head);
	        head = l.addNodeAtEnd(2, head);
	        head = l.addNodeAtEnd(3, head);
	        head =l.addNodeAtEnd(4, head);
	        head = l.addNodeAtEnd(5, head);
	        head = l.addNodeAtEnd(6, head);
	        
	        
	        head = l.addAtFront(-1, head);
	        head = l.addAtFront(-2, head);
	        head = l.addAtFront(-3, head);
	        head =l.addAtFront(-4, head);
	        head = l.addAtFront(-5, head);
	        head = l.addAtFront(-6, head);
	        l.printLinkedList(head);
	        System.out.println("Size:"+ l.getLength());
		}
}
