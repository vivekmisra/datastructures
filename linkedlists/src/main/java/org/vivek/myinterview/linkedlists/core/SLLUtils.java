package org.vivek.myinterview.linkedlists.core;



public class SLLUtils {
	private int length = 0;
	SLLNode head;

	public SLLUtils() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the head
	 */
	public SLLNode getHead() {
		return head;
	}

	public SLLNode getTail() {
		return getLast(head);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SLL L1 = new SLL();
		int[] dataForL1 = new int[] {3,1,8,7,-1,6};
		SLLNode head1 = constructList(L1,dataForL1);
		System.out.print("L1::");
		L1.printLinkedList(head1);
		System.out.println("L1:deleting middle::" + middleData(head1));
		deleteMiddleNode(head1);
		L1.printLinkedList(head1);		
		head1 = mergeSort(head1);
		System.out.print("L1 SORTED:"); 
		L1.printLinkedList(head1);
		
		SLLNode cirHead = constructCircularList( L1, dataForL1) ;
		boolean isCircular = hasLoop(cirHead);
		if( isCircular){
			System.out.print("Circular List:");
			L1.printLinkedList(cirHead);
		}
		SLLNode loopStartNode = findLoopStart(cirHead);
		
		SLL L2 = new SLL(); 
		int[] dataForL2 = new int[] {7,4,12,10,15};
		SLLNode head2=constructList(L2,dataForL2);; 
		System.out.print("L2:");
		printLinkedList(head2);
		head2 = mergeSort(head2);
		System.out.print("L2 SORTED:"); 
		printLinkedList( head2);
		
		SLLNode head =merge(head1,head2);
		System.out.print("Merging sorted lists L1 + L2::"); 
		printLinkedList( head);
	}

	public SLLNode reverse() {
		SLLNode current = head;
		SLLNode rev = null;
		while (current != null) {
            SLLNode newNode = new SLLNode(head.data,null);
            newNode.next = rev;
            rev= newNode;
			current = current.next;
		}
		return current;

	}

	public static SLLNode constructList(SLL L1,int[] data) {
		//SLLNode head1 = null;
		for(int datum : data) {
		   L1.insertAtEnd(datum);
		}		
		return L1.getHead();
	}
	
	public static SLLNode getLast(SLLNode head) {
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
	
	private static SLLNode constructCircularList(SLL L,int[] data) {
		SLLNode head = null;
		for(int datum : data) {
		    L.insertAtEnd(datum);
		}
		System.out.println("Constructing circular list part1:");
		printLinkedList(L.getHead());
		SLLNode tail = getLast(L.getHead());
		System.out.println("Constructing circular list got tail:"+ tail);
		//tail.next = L.getHead();dont do this infinte loop
		System.out.println("Constructing circular list part2:");
		printLinkedList(tail);
		return head;
	}

	public static Integer middleData(SLLNode head) {
		if (head == null || head.next == null) {
			return head.data;
		}

		SLLNode slow = head;
		SLLNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
	}
	public static void deleteMiddleNode(SLLNode head) {
		// if the given node is null, or the next one is null (i.e. the given
		// node is the last element of the list), return without any changes
		// as this does not meet the pre-condition of this method
		if (head == null ||head.next == null) {
			return;
		}
		SLLNode middle = getMiddle(head);
		middle.data=middle.next.data;
		middle.next =middle.next.next;
	}
	

	

	static SLLNode mergeSort(SLLNode h) {
		// Base case : if head is null
		if (h == null || h.next == null) {
			return h;
		}

		// get the middle of the list
		SLLNode middle = getMiddle(h);
		SLLNode nextofmiddle = middle.next;

		// set the next of middleSLLNode to null
		middle.next = null;

		// Apply mergeSort on left list
		SLLNode left = mergeSort(h);

		// Apply mergeSort on right list
		SLLNode right = mergeSort(nextofmiddle);

		// Merge the left and right lists
		SLLNode sortedlist = sortedMerge(left, right);
		return sortedlist;
	}
	
	static SLLNode  sortedMerge(SLLNode a, SLLNode b) {
		SLLNode result = null;
		/* Base cases */
		if (a == null)
			return b;
		if (b == null)
			return a;

		/* Pick either a or b, and recur */
		if (a.data <= b.data) {
			result = a;
			result.next = sortedMerge(a.next, b);
		} else {
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return result;

	}

	// Utility function to get the middle of the linked list
	static SLLNode getMiddle(SLLNode h) {
		// Base case
		if (h == null)
			return h;
		SLLNode fastptr = h.next;
		SLLNode slowptr = h;

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



	static SLLNode merge(SLLNode L1, SLLNode L2) {
		// Creates a placeholder for the result.
		SLLNode dummyHead = new SLLNode(0, null);
		SLLNode current = dummyHead;
		SLLNode p1 = L1, p2 = L2;
		while (p1 != null && p2 != null) {
			if (p1.data <= p2.data) {
				current.next = p1;
				p1 = p1.next;
			} else {
				current.next = p2;
				p2 = p2.next;
			}
			current = current.next;
		}

		// Appends the remaining nodes of p1 or p2.
		current.next = p1 != null ? p1 : p2;
		return dummyHead.next;
	}
	
	
	
	
	/**
	 * Checks if the given linked list is a circular linked list (i.e. it
	 * contains a loop). This means a list in which a node's next pointer points
	 * to an earlier node, so as to make a loop in the linked list. For
	 * instance:
	 * 			A -> B -> C -> D -> E -> C [the same C as earlier]  
	 * 
	 *  (CCI_0205)
	 * 
	 * @param linkedList
	 *            the linked list to be tested
	 * @return true if there is a loop, false if there isn't
	 */
	public static boolean hasLoop(SLLNode head) {
		if (head == null ) {
			return false;
		}

		SLLNode slow = head;
		SLLNode fast = head.next;
		
		
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
			}else{
				return false;
			}
		}
		return false;

		/*while (true) {
			slow = slow.getNext();

			if (fast.getNext() != null) {
				fast = fast.getNext().getNext();
			} else {
				return false;
			}

			if (slow == null || fast == null) {
				return false;
			}

			if (slow == fast) {
				return true;
			}
		}*/
	}
	
	
	public static SLLNode findLoopStart(SLLNode head) {
		if (head== null ) {
			return null;
		}
		SLLNode loopStartNode = null;	
		SLLNode slow = head;
		SLLNode fast = head;
		// Move fastptr by two and slow ptr by one
		// Finally slowptr will point to middleSLLNode
		while (slow != null && fast != null) {
			slow = slow.getNext();
			if (fast.getNext() == null) {
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
					slow = slow.getNext(); // Can't be null, as we have a loop
					fast = fast.getNext(); // Can't be null, as we have a loop
				}

				loopStartNode = slow;
				break;
			}
		}

		return loopStartNode;
	}


	public static void printLinkedList(SLLNode head) {

		while (head != null) {
			if (head.next != null) {
				System.out.print(head.data + "->");
			} else {
				System.out.print(head.data + "->NULL");
			}
			head = head.next;
		}
		System.out.println();
	}

}
