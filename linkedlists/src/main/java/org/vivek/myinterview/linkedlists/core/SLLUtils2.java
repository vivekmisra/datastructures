package org.vivek.myinterview.linkedlists.core;

import static org.vivek.myinterview.linkedlists.core.SLL2.Node;

public class SLLUtils2 {

	public SLLUtils2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SLL2 L1 = new SLL2();
		int[] dataForL = new int[] { 1,2,3,4,5};
		Node h = L1.constructList(L1, dataForL);
		System.out.print("L1::");
		L1.printLinkedList(h);
		Node middle = getFirstMiddle(h);
		System.out.print("L1 from middle::"+middle.item +" :");
		L1.printLinkedList(middle);
		System.out.println("*************************");
		int[] dataForL1 = new int[] { 3, 1, 8, 7, -1, 6 };
		Node head1 = L1.constructList(L1, dataForL1);
		System.out.print("L1::");
		L1.printLinkedList(head1);
		System.out.println();
		System.out.println("deleting middle node with value 3::");
		deleteMiddleNode(head1);
		L1.printLinkedList(head1);
		System.out.println("deleted middle node");
		/*
		 * System.out.println("L1:deleting middle::" + middleData(head1));
		 * deleteMiddleNode(head1);
		 * L1.printLinkedList(head1);
		 * 
		 * 
		 * Node cirHead = constructCircularList( L1, dataForL1) ; boolean
		 * isCircular = hasLoop(cirHead); if( isCircular){
		 * System.out.print("Circular List:"); L1.printLinkedList(cirHead); }
		 * Node loopStartNode = findLoopStart(cirHead);
		 */
		SLL2 L2 = new SLL2();
		int[] dataForL2 = new int[] { 7, 4, 12, 10, 15 };
		Node head2 = L2.constructList(L2, dataForL2);
		System.out.println("*********************");
		System.out.print("L1::");
		L1.printLinkedList(head1);
		System.out.print("L2:");
		L2.printLinkedList(head2);
 
		head1 = sort(head1);
		System.out.print("L1 SORTED:");
		L1.printLinkedList(head1);

		head2 = sort(head2);
		System.out.print("L2 SORTED:");
		L2.printLinkedList(head2);

		//Node<Integer> head = merge2LinkLists(head1, head2);
		Node<Integer> head = merge(head1, head2);
		System.out.print("Merging sorted lists L1 + L2::");
		L2.printLinkedList(head);
		
		System.out.print("Swapping nodes 3<-->12:");
		head= swapNodes(head, 3, 12);
		L2.printLinkedList(head);
		System.out.print("Swapping nodes 4<-->6:");
		head= swapNodes(head, 4, 6);
		L2.printLinkedList(head);
	}

	@SuppressWarnings("unused")
	private static Node constructCircularList(SLL2<Integer> L, int[] data) {

		for (int datum : data) {
			L.add(datum);
		}
		System.out.println("Constructing circular list part1:");
		Node<Integer> head = L.getFirstNode();
		L.printLinkedList(L.getFirstNode());
		Node<Integer> tail = L.getLastNode();
		System.out.println("Constructing circular list got tail:" + tail);
		// tail.next = L.getHead();dont do this infinte loop
		System.out.println("Constructing circular list part2:");
		L.printLinkedList(tail);
		return head;
	}

	
	static Node<Integer> sort(Node<Integer> h) {
		// Base case : if head is null
		if (h == null || h.next == null) {
			return h;
		}
		// get the middle of the list
		Node<Integer> middle = getFirstMiddle(h);
		Node<Integer> nextofmiddle = middle.next;

		// set the next of middleSLLNode to null
		middle.next = null;

		// Apply mergeSort on left list
		Node<Integer> left = sort(h);

		// Apply mergeSort on right list
		Node<Integer> right = sort(nextofmiddle);

		// Merge the left and right lists
		Node<Integer> sortedlist = merge(left, right);
		return sortedlist;
	}

	static Node<Integer> merge(Node<Integer> a, Node<Integer> b) {
		Node<Integer> result = null;
		/* Base cases */
		if (a == null)
			return b;
		if (b == null)
			return a;

		/* Pick either a or b, and recur */
		if (a.item <= b.item) {
			result = a;
			result.next = merge(a.next, b);
		} else {
			result = b;
			result.next = merge(a, b.next);
		}
		return result;

	}

	// Utility function to get the middle of the linked list(it will get first middle node in case of even nodes)
	static Node<Integer> getFirstMiddle(Node<Integer> h) {
		// Base case
		if (h == null && h.next==null)
			return null;
		Node fast = h.next;
		Node slow = h;

		// Move fast by two and slow ptr by one
		// Finally slowptr will point to middleSLLNode
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}
		}
		return slow;
	}
	// Utility function to get the middle of the linked list(it will get second middle node in case of even nodes)
	public static Node middleNode(Node head) {
		 if (head == null)
				return head;
			Node fast = head;
			Node slow = head;

			// Move fast by two and slow ptr by one
			// Finally slowptr will point to middleSLLNode
			while (fast != null && fast.next!=null) {
					slow = slow.next;
					fast = fast.next.next;
				
			}
			return slow;
       
   }
	
	/**
	 * Checks if the given linked list is a circular linked list (i.e. it
	 * contains a loop). This means a list in which a node's next pointer points
	 * to an earlier node, so as to make a loop in the linked list. For
	 * instance: A -> B -> C -> D -> E -> C [the same C as earlier]
	 * 
	 * (CCI_0205)
	 * 
	 * @param linkedList
	 *            the linked list to be tested
	 * @return true if there is a loop, false if there isn't
	 */
	 public boolean hasCycle(Node head) {
	        Node fast = head;
	        Node slow = head;
	 
	        while(fast != null && fast.next != null){
	            slow = slow.next;
	            fast = fast.next.next;
	 
	            if(slow == fast)
	                return true;
	        }
	 
	        return false;
	    }
	 
	 public Node detectLoopStartNode(Node head) {
	       
			if (head == null || head.next == null) {
		        return null;
		    }
			Node loopStartNode = null;
			 Node s = head, f = head;
			// Move fastptr by two and slow ptr by one
			// Finally slowptr will point to middleSLLNode
			while (f != null && f.next != null) {
				s = s.next;
	            f = f.next.next;

				// If slow and fast point to the same node, it means that the
				// linkedList contains a loop.
				if (s == f) {

					s= head;

					while (s != f) {
						// Keep incrementing the two pointers until they both
						// meet again. When this happens, both the pointers will
						// point to the beginning of the loop
						s = s.next; // Can't be null, as we have a loop
						f = f.next; // Can't be null, as we have a loop
					}

					loopStartNode = s;
					break;
				}
			}

			return loopStartNode;
	        
	    }

	public static void deleteMiddleNode(Node<Integer> head) {
		// if the given node is null, or the next one is null (i.e. the given
		// node is the last element of the list), return without any changes
		// as this does not meet the pre-condition of this method
		if (head == null || head.next == null) {
			return;
		}
		Node<Integer> middle = getFirstMiddle(head);
		middle.item = middle.next.item;
		middle.next = middle.next.next;
	}


	static Node<Integer> merge2LinkLists(Node<Integer> L1, Node<Integer> L2) {
		// Creates a placeholder for the result.
		Node<Integer> dummyHead = new Node<Integer>(0, null);
		Node<Integer> current = dummyHead;
		Node<Integer> p1 = L1, p2 = L2;
		while (p1 != null && p2 != null) {
			if (p1.item <= p2.item) {
				current.next = p1;
				p1 = p1.next;
			} else {
				current.next = p2;
				p2 = p2.next;
			}
			current = current.next;
		}
		if (p2 == null) {
			current.next = p1;
		
		}
		if (p1 == null) {
			current.next = p2;
			
		}

		// Appends the remaining nodes of p1 or p2.
		// current.next = p1 != null ? p1 : p2;
		return dummyHead.next;
	}
	
	
	static Node<Integer> swap(Node<Integer> L1, Node<Integer> L2) {
		// Creates a placeholder for the result.
		Node<Integer> dummyHead = new Node<Integer>(0, null);
		Node<Integer> current = dummyHead;
		Node<Integer> p1 = L1, p2 = L2;
		while (p1 != null && p2 != null) {
			if (p1.item <= p2.item) {
				current.next = p1;
				p1 = p1.next;
			} else {
				current.next = p2;
				p2 = p2.next;
			}
			current = current.next;
		}
		if (p2 == null) {
			current.next = p1;
		
		}
		if (p1 == null) {
			current.next = p2;
			
		}

		// Appends the remaining nodes of p1 or p2.
		// current.next = p1 != null ? p1 : p2;
		return dummyHead.next;
	}


	
	
	 static Node<Integer> swapNodes(Node<Integer> head_ref, int x, int y)  
	    {  
	        Node<Integer> head=head_ref; 
	        // Nothing to do if x and y are same  
	        if (x == y)  
	            return null;  
	      
	        Node<Integer> a = null, b = null;  
	      
	        // search for x and y in the linked list  
	        // and store therir pointer in a and b  
	        while (head_ref.next!=null) {  
	      
	            if ((head_ref.next).item == x) {  
	                a = head_ref;  
	            }  
	      
	            else if ((head_ref.next).item == y) {  
	                b = head_ref;  
	            }  
	      
	            head_ref = ((head_ref).next);  
	        }  
	      
	        // if we have found both a and b  
	        // in the linked list swap current  
	        // pointer and next pointer of these  
	        if (a!=null&&  b!=null) {  
	        Node<Integer> temp = a.next;  
	        a.next = b.next;  
	        b.next = temp;      
	        temp = a.next.next;  
	        a.next.next = b.next.next;  
	        b.next.next = temp;  
	        }  
	        return head; 
	    }  

}
