package org.vivek.myinterview.linkedlists.core;

import static org.vivek.myinterview.linkedlists.core.SLL2.Node;

import java.util.HashSet;
import java.util.Set;

import com.interview.linklist.Node;

public class SLLUtils2 {

	public SLLUtils2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SLL2 L1 = new SLL2();
		int[] dataForL = new int[] { 1, 2, 3, 4, 5 };
		Node h = L1.constructList(L1, dataForL);
		System.out.print("L1::");
		L1.printLinkedList(h);
		Node middle = getFirstMiddle(h);
		System.out.print("L1 from middle::" + middle.item + " :");
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
		System.out.println("Reversing::");
		L1.printLinkedList(reverse(head1));
		/*
		 * System.out.println("L1:deleting middle::" + middleData(head1));
		 * deleteMiddleNode(head1); L1.printLinkedList(head1);
		 * 
		 * 
		 * Node cirHead = constructCircularList( L1, dataForL1) ; boolean isCircular =
		 * hasLoop(cirHead); if( isCircular){ System.out.print("Circular List:");
		 * L1.printLinkedList(cirHead); } Node loopStartNode = findLoopStart(cirHead);
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
		System.out.println();
		;
		System.out.print("Deleting 2nd from end of L2 :");
		removeNthFromEnd(head2, 2);
		L2.printLinkedList(head2);
		System.out.println();
		;
		// Node<Integer> head = merge2LinkLists(head1, head2);
		Node<Integer> head = merge(head1, head2);
		System.out.print("Merging sorted lists L1 + L2::");
		L2.printLinkedList(head);

		System.out.print("Swapping nodes 3<-->12:");
		head = swapNodes(head, 3, 12);
		L2.printLinkedList(head);
		System.out.print("Swapping nodes 4<-->6:");
		head = swapNodes(head, 4, 6);
		L2.printLinkedList(head);

		/*SLL2 L4 = new SLL2();
		int[] dataForL4 = new int[] { 4, 1, 8, 4, 5 };
		int[] dataForL5 = new int[] { 5, 0, 1, 8, 4, 5 };
		Node head4 = L4.constructList(L4, dataForL4);
		L4.printLinkedList(head4);
		SLL2 L5 = new SLL2();
		Node head5 = L5.constructList(L5, dataForL5);
		L5.printLinkedList(head5);*/

		//Node intersected = getIntersectionNode(head4, head5);
		//System.out.println("Intersecting node:" + intersected.item);
		
		SLL2 L6 = new SLL2();
		int[] dataForL6 = new int[] { 1, 3,2,3,3 };
		Node head6 = L6.constructList(L6, dataForL6);
		L6.printLinkedList(head6);
		SLLUtils2 sll = new SLLUtils2();
		head6 = sll.removeAll(3, head6);
		L6.printLinkedList(head6);
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

	/*
	 * RECURSIVE SOLUTION https://leetcode.com/problems/merge-two-sorted-lists/ 21.
	 * Merge Two Sorted Lists Easy
	 * 
	 * Merge two sorted linked lists and return it as a new list. The new list
	 * should be made by splicing together the nodes of the first two lists.
	 * 
	 * Example:
	 * 
	 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
	 */
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

	/*
	 * ITERATIVE SOLUTION https://leetcode.com/problems/merge-two-sorted-lists/ 21.
	 * Merge Two Sorted Lists Easy
	 * 
	 * Merge two sorted linked lists and return it as a new list. The new list
	 * should be made by splicing together the nodes of the first two lists.
	 * 
	 * Example:
	 * 
	 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
	 */
	static Node<Integer> merge2LinkLists(Node<Integer> L1, Node<Integer> L2) {
		// Creates a placeholder for the result.
		Node<Integer> resultHead = new Node<Integer>(0, null);
		Node<Integer> current = resultHead;
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
		return resultHead.next;
	}

	// Utility function to get the middle of the linked list(it will get first
	// middle node in case of even nodes)
	static Node<Integer> getFirstMiddle(Node<Integer> h) {
		// Base case
		if (h == null && h.next == null)
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

	// Utility function to get the middle of the linked list(it will get second
	// middle node in case of even nodes)
	public static Node middleNode(Node head) {
		if (head == null)
			return head;
		Node fast = head;
		Node slow = head;

		// Move fast by two and slow ptr by one
		// Finally slowptr will point to middleSLLNode
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

		}
		return slow;

	}

	/**
	 * 141. Linked List Cycle https://leetcode.com/problems/linked-list-cycle/ Given
	 * a linked list, determine if it has a cycle in it.
	 * 
	 * To represent a cycle in the given linked list, we use an integer pos which
	 * represents the position (0-indexed) in the linked list where tail connects
	 * to. If pos is -1, then there is no cycle in the linked list.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: head = [3,2,0,-4], pos = 1 Output: true Explanation: There is a cycle
	 * in the linked list, where tail connects to the second node.
	 * 
	 * 
	 * Checks if the given linked list is a circular linked list (i.e. it contains a
	 * loop). This means a list in which a node's next pointer points to an earlier
	 * node, so as to make a loop in the linked list. For instance: A -> B -> C -> D
	 * -> E -> C [the same C as earlier]
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

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
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

				s = head;

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

	/*
	 * 19. Remove Nth Node From End of List Medium
	 * 
	 * Given a linked list, remove the n-th node from the end of list and return its
	 * head.
	 * 
	 * Example:
	 * 
	 * Given linked list: 1->2->3->4->5, and n = 2.
	 * 
	 * After removing the second node from the end, the linked list becomes
	 * 1->2->3->5.
	 */
	public static Node removeNthFromEnd(Node head, int n) {
		Node dummy = new Node(0);
		dummy.next = head;
		int length = 0;
		Node first = head;
		while (first != null) {
			length++;
			first = first.next;
		}
		length -= n;
		first = dummy;
		while (length > 0) {
			length--;
			first = first.next;
		}
		first.next = first.next.next;
		return dummy.next;
	}

	static Node reverse(Node head) {
		// Return a new list containing the same items as the list,
		// but in the reverse order.
		Node rev = null; // rev will be the reversed list.
		Node current = head; // For running through the nodes of list.
		while (current != null) {
			// construct a new node
			Node newNode = new Node();
			// copy the data to new node from runner
			newNode.item = current.item;
			// "Push" the next node of list onto the front of rev.
			newNode.next = rev;
			rev = newNode;
			// Move on to the next node in the list.
			current = current.next;
		}
		return rev;
	} // end reverse()

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

	static Node<Integer> swapNodes(Node<Integer> head_ref, int x, int y) {
		Node<Integer> head = head_ref;
		// Nothing to do if x and y are same
		if (x == y)
			return null;

		Node<Integer> a = null, b = null;

		// search for x and y in the linked list
		// and store therir pointer in a and b
		while (head_ref.next != null) {

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
		if (a != null && b != null) {
			Node<Integer> temp = a.next;
			a.next = b.next;
			b.next = temp;
			temp = a.next.next;
			a.next.next = b.next.next;
			b.next.next = temp;
		}
		return head;
	}

	/**
	 * 
	 * 
	 * 234. Palindrome Linked List Easy
	 * https://leetcode.com/problems/palindrome-linked-list/ Picture: node at front,
	 * node at end, they compare and move towards each other
	 * 
	 * [] - [] - [] - [] - [] - [] - NULL (f)-> <-(e)
	 * 
	 * -(e) recursions foward and then back -(f) move to next if values equal
	 */

	public static Node getIntersectionNode1(Node<Integer> headA, Node<Integer> headB) {
		// boundary check
		if (headA == null || headB == null)
			return null;

		Node a = headA;
		Node b = headB;

		// if a & b have different len, then we will stop the loop after second
		// iteration
		while (a != b) {
			// for the end of first iteration, we just reset the pointer to the head of
			// another linkedlist
			if (a == null) {
				a = headB;
			} else {
				a = a.next;
			}
			if (b == null) {
				b = headA;
			} else {
				b = b.next;
			}
		}

		return a;
	}

	public static Node<Integer> getIntersectionNode(Node<Integer> headA, Node<Integer> headB) {
		Set<Node> set = new HashSet<>();

		Node<Integer> n1Current = headA;
		while (n1Current != null) {
			set.add(n1Current);//keep adding
			n1Current = n1Current.next;
		}

		Node n2Current = headB;

		while (n2Current != null) {
			if (set.contains(n2Current)) {
				return n2Current;
			}
			n2Current = n2Current.next;
		}

		return null;
	}

	public static Node SortedIntersect(Node<Integer> headA, Node<Integer> headB) {
		Node head = null, tail = null;

		// Once one or the other list runs out -- we're done
		while (headA != null && headB != null) {
			if (headA.item == headB.item) {
				if (head == null) {
					tail = head = new Node(headA.item, head);
				} else {
					tail = tail.next = new Node(headA.item, tail.next);
				}

				headA = headA.next;
				headB = headB.next;
			}

			// advance the smaller list
			else if (headA.item < headB.item)
				headA = headA.next;
			else
				headB = headB.next;
		}
		return head;
	}
	
	public Node removeAll(int n, Node head) {
		Node dummyHead = new Node(0, null);
		dummyHead.next = head;
		Node current = dummyHead;

		while (current.next != null) {
			if (current.next.item.equals(n)) {
				Node next = current.next;
				current.next = next.next;
			} else {
				current = current.next;
			}
		}

		return dummyHead.next;

	}

}
