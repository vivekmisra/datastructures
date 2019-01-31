package org.vivek.myinterview.linkedlists.core;



public class SLLUtils2 {

	public SLLUtils2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SLL2 L1 = new SLL2();
		int[] dataForL1 = new int[] { 3, 1, 8, 7, -1, 6 };
		SLL2.Node head1 = L1.constructList(L1, dataForL1);
		System.out.print("L1::");
		L1.printLinkedList(head1);
		/*
		 * System.out.println("L1:deleting middle::" + middleData(head1));
		 * deleteMiddleNode(head1);
		 * 
		 * 
		 * SLL2.Node cirHead = constructCircularList( L1, dataForL1) ; boolean
		 * isCircular = hasLoop(cirHead); if( isCircular){
		 * System.out.print("Circular List:"); L1.printLinkedList(cirHead); }
		 * SLL2.Node loopStartNode = findLoopStart(cirHead);
		 */
		SLL2 L2 = new SLL2();
		int[] dataForL2 = new int[] { 7, 4, 12, 10, 15 };
		SLL2.Node head2 = L2.constructList(L2, dataForL2);
		;
		System.out.print("L2:");
		L2.printLinkedList(head2);

		head1 = mergeSort(head1);
		System.out.print("L1 SORTED:");
		L1.printLinkedList(head1);

		head2 = mergeSort(head2);
		System.out.print("L2 SORTED:");
		L2.printLinkedList(head2);

		SLL2.Node<Integer> head = merge2LinkLists(head1, head2);
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
	private static SLL2.Node constructCircularList(SLL2<Integer> L, int[] data) {

		for (int datum : data) {
			L.add(datum);
		}
		System.out.println("Constructing circular list part1:");
		SLL2.Node<Integer> head = L.getFirstNode();
		L.printLinkedList(L.getFirstNode());
		SLL2.Node<Integer> tail = L.getLastNode();
		System.out.println("Constructing circular list got tail:" + tail);
		// tail.next = L.getHead();dont do this infinte loop
		System.out.println("Constructing circular list part2:");
		L.printLinkedList(tail);
		return head;
	}

	public static Integer middleData(SLL2.Node<Integer> head) {
		if (head == null || head.next == null) {
			return head.item;
		}

		SLL2.Node<Integer> slow = head;
		SLL2.Node<Integer> fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.item;
	}

	public static void deleteMiddleNode(SLL2.Node<Integer> head) {
		// if the given node is null, or the next one is null (i.e. the given
		// node is the last element of the list), return without any changes
		// as this does not meet the pre-condition of this method
		if (head == null || head.next == null) {
			return;
		}
		SLL2.Node<Integer> middle = getMiddle(head);
		middle.item = middle.next.item;
		middle.next = middle.next.next;
	}

	static SLL2.Node<Integer> mergeSort(SLL2.Node<Integer> h) {
		// Base case : if head is null
		if (h == null || h.next == null) {
			return h;
		}

		// get the middle of the list
		SLL2.Node<Integer> middle = getMiddle(h);
		SLL2.Node<Integer> nextofmiddle = middle.next;

		// set the next of middleSLLNode to null
		middle.next = null;

		// Apply mergeSort on left list
		SLL2.Node<Integer> left = mergeSort(h);

		// Apply mergeSort on right list
		SLL2.Node<Integer> right = mergeSort(nextofmiddle);

		// Merge the left and right lists
		SLL2.Node<Integer> sortedlist = sortedMerge(left, right);
		return sortedlist;
	}

	static SLL2.Node<Integer> sortedMerge(SLL2.Node<Integer> a, SLL2.Node<Integer> b) {
		SLL2.Node<Integer> result = null;
		/* Base cases */
		if (a == null)
			return b;
		if (b == null)
			return a;

		/* Pick either a or b, and recur */
		if (a.item <= b.item) {
			result = a;
			result.next = sortedMerge(a.next, b);
		} else {
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return result;

	}

	// Utility function to get the middle of the linked list
	static SLL2.Node<Integer> getMiddle(SLL2.Node<Integer> h) {
		// Base case
		if (h == null)
			return h;
		SLL2.Node fastptr = h.next;
		SLL2.Node slowptr = h;

		// Move fastptr by two and slow ptr by one
		// Finally slowptr will point to middleSLLNode
		while (fastptr != null) {
			fastptr = fastptr.next;
			if (fastptr != null) {
				slowptr = slowptr.next;
				fastptr = fastptr.next;
			}
		}
		return slowptr;
	}

	static SLL2.Node<Integer> merge2LinkLists(SLL2.Node<Integer> L1, SLL2.Node<Integer> L2) {
		// Creates a placeholder for the result.
		SLL2.Node<Integer> dummyHead = new SLL2.Node<Integer>(0, null);
		SLL2.Node<Integer> current = dummyHead;
		SLL2.Node<Integer> p1 = L1, p2 = L2;
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
	
	
	static SLL2.Node<Integer> swap(SLL2.Node<Integer> L1, SLL2.Node<Integer> L2) {
		// Creates a placeholder for the result.
		SLL2.Node<Integer> dummyHead = new SLL2.Node<Integer>(0, null);
		SLL2.Node<Integer> current = dummyHead;
		SLL2.Node<Integer> p1 = L1, p2 = L2;
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
	public static boolean hasLoop(SLL2.Node head) {
		if (head == null) {
			return false;
		}

		SLL2.Node slow = head;
		SLL2.Node fast = head.next;

		// Move fastptr by two and slow ptr by one
		// Finally slowptr will point to middleSLLNode
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				slow = slow.next;
				fast = fast.next;
				if (slow == fast) {
					return true;
				}
			} else {
				return false;
			}
		}
		return false;

		/*
		 * while (true) { slow = slow.getNext();
		 * 
		 * if (fast.getNext() != null) { fast = fast.getNext().getNext(); } else
		 * { return false; }
		 * 
		 * if (slow == null || fast == null) { return false; }
		 * 
		 * if (slow == fast) { return true; } }
		 */
	}

	public static SLL2.Node findLoopStart(SLL2.Node head) {
		if (head == null) {
			return null;
		}
		SLL2.Node loopStartNode = null;
		SLL2.Node slow = head;
		SLL2.Node fast = head;
		// Move fastptr by two and slow ptr by one
		// Finally slowptr will point to middleSLLNode
		while (slow != null && fast != null) {
			slow = slow.next;
			if (fast.next == null) {
				loopStartNode = null;
				break;
			}
			fast = fast.next.next;

			// If slow and fast point to the same node, it means that the
			// linkedList contains a loop.
			if (slow == fast) {

				slow = head;

				while (slow != fast) {
					// Keep incrementing the two pointers until they both
					// meet again. When this happens, both the pointers will
					// point to the beginning of the loop
					slow = slow.next; // Can't be null, as we have a loop
					fast = fast.next; // Can't be null, as we have a loop
				}

				loopStartNode = slow;
				break;
			}
		}

		return loopStartNode;
	}
	 static SLL2.Node<Integer> swapNodes(SLL2.Node<Integer> head_ref, int x, int y)  
	    {  
	        SLL2.Node<Integer> head=head_ref; 
	        // Nothing to do if x and y are same  
	        if (x == y)  
	            return null;  
	      
	        SLL2.Node<Integer> a = null, b = null;  
	      
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
	        SLL2.Node<Integer> temp = a.next;  
	        a.next = b.next;  
	        b.next = temp;      
	        temp = a.next.next;  
	        a.next.next = b.next.next;  
	        b.next.next = temp;  
	        }  
	        return head; 
	    }  

}
