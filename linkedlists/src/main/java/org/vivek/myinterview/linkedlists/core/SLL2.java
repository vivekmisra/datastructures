package org.vivek.myinterview.linkedlists.core;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
//import java.util.LinkedList.Node;

public class SLL2<E> {
	private static class Node<E> {
		E item;
		Node<E> next;

		Node(E element, Node<E> next) {
			this.item = element;
			this.next = next;

		}
	}

	transient int length = 0;
	transient Node<E> first;
	transient Node<E> last;
	LinkedList ll = new LinkedList();

	/**
	 * @return the length
	 */
	public int size() {
		return length;
	}

	// ############################################START:GET######################################################################
	public E getFirst() {
		final Node<E> f = first;
		if (f == null)
			throw new NoSuchElementException();
		return f.item;
	}

	public E getLast() {
		final Node<E> l = last;
		if (l == null)
			throw new NoSuchElementException();
		return l.item;
	}

	public void setFirst(Node<E> first) {
		this.first = first;
	}

	Node<E> node(int index) {
		Node<E> node = null;
		Node<E> nodeAtIndex = null;
		if (index < length-1) {
			node = first;
			for (int i = 0; i < index; i++){
				if(node.next!=null){
					node  = node.next;
				
				}else{
					node =null;
				}
			 
			}

		} else if (index >= length-1) {
			node = last;
		}
		return node;
	}

	// ############################################END:GET######################################################################
	// ############################################START:ADD/REMOVE#############################################################

	public boolean add(E e) {
		linkLast(e);
		return true;
	}

	public void addFirst(E e) {
		linkFirst(e);
	}

	public void addLast(E e) {
		linkLast(e);
	}

	public void add(int index, E element) {
		if(index>length ||index <-1){
			throw new IndexOutOfBoundsException("Incorrect Index");
		}
		if (index == length) {
			linkLast(element);
		} else {
			linkBefore(element, node(index));
		}

	}

	public E removeFirst() {
		final Node<E> f = first;
		if (f == null)
			throw new NoSuchElementException();
		return unlinkFirst(f);
	}

	public E removeLast() {
		final Node<E> l = last;
		if (l == null)
			throw new NoSuchElementException();
		return unlinkLast(l);

	}

	public boolean remove(Object o) {
		if (o == null) {
			for (Node<E> node = first; node != null; node = node.next) {
				if (node.item == null) {
					unlink(node);
					return true;
				}
			}
		} else {
			for (Node<E> node = first; node != null; node = node.next) {
				if (o.equals(node.item)) {
					unlink(node);
					return true;
				}
			}
		}
		return false;
	}

	Node<E> previous(Node<E> node) {
		final Node<E> f = first;
		Node<E> prev = null;
		if (first == null) {
			prev = null;
		}
		if (first.next == node) {
			prev = first;

		} else {
			Node<E> temp = first;
			while (first != null) {
				if (first.next == node) {
					prev = first;
					break;
				}
				first = first.next;
			}
			first = temp;
		}

		return prev;

	}

	void linkBefore(E e, Node<E> succ) {
		// assert succ != null;
		final Node<E> pred = previous(succ);
		final Node<E> newNode = new Node<>(e, succ);

		if (pred == null){
			first = newNode;
		}else{
			pred.next = newNode;
			newNode.next = succ;
		}
		length++;

	}

	private void linkFirst(E e) {
		final Node<E> f = first;
		final Node<E> newNode = new Node<>(e, f);
		first = newNode;
		if (f == null) {
			last = newNode;
		}
		length++;
	}

	private E unlinkFirst(Node<E> f) {
		// assert f == first && f != null;
		final E element = f.item;
		final Node<E> next = f.next;
		f.item = null;
		f.next = null; // help GC
		first = next;
		if (next == null)
			last = null;

		length--;

		return element;
	}

	void linkLast(E e) {
		final Node<E> node = last;
		final Node<E> newNode = new Node<>(e, null);

		if (node == null) {// there is no last
			first = newNode;
			last = newNode;
		} else {
			node.next = newNode;
			last = newNode;
		}
		length++;

	}

	private E unlinkLast(Node<E> node) {
		final E element = node.item;
		Node<E> prev = null;
		if (first == null) {
			return null;
		} else {
			// get prev
			Node<E> temp = first;
			prev = previous(node);
			node.item = null;// delink item
			last = prev;
		}
		if (prev == null) {
			first = null;
		} else {
			prev.next = null;// now prev is last
		}
		length--;

		return element;
	}

	E unlink(Node<E> node) {
		final E element = node.item;
		final Node<E> next = node.next;
		Node<E> prev = null;
		if (first == null) {
			return null;
		} else {
			// get prev
			prev = previous(node);
			node.item = null;// delink item
		}

		if (next == null) {
			prev.next = null;
			last = prev;
			node = null;
		} else {
			prev.next = next;
			node = null;
		}
		length--;
		return element;
	}

	// ############################################END:ADD/REMOVE#############################################################
	@Override
	public String toString() {
		return "SLLImpl2 [length=" + length + ", first=" + first + ", last=" + last + ", size()=" + size()
				+ ", getFirst()=" + getFirst() + "]";
	}

	public void printLinkedList(Node<E> head) {
		Node<E> temp = head;
		while (head != null) {
			if (head.next != null) {
				System.out.print(head.item + "->");
			} else {
				System.out.print(head.item + "->NULL");
			}
			head = head.next;
		}
		head = temp;
		System.out.println();
	}

	public static void main(String args[]) {
		SLL2<Integer> ll = new SLL2<Integer>();
		ll.addFirst(2);
		ll.addFirst(3);
		ll.addFirst(4);
		ll.addLast(1);

		System.out.println(ll.size());
		ll.printLinkedList(ll.first);

		System.out.println("get first:" + ll.getFirst());
		System.out.println("get last:" + ll.getLast());

		System.out.println("remove first:");
		ll.removeFirst();
		System.out.println("size="+ll.size());
		ll.printLinkedList(ll.first);

		System.out.println("add first:");
		ll.addFirst(4);
		System.out.println("size="+ll.size());
		ll.printLinkedList(ll.first);

		System.out.println("remove last:");
		ll.removeLast();
		System.out.println("size="+ll.size());
		ll.printLinkedList(ll.first);

		System.out.println("add last:");
		ll.addLast(1);
		System.out.println("size="+ll.size());
		ll.printLinkedList(ll.first);
        
		System.out.println("add:");
		ll.add(8);
		System.out.println("size="+ll.size());
		ll.printLinkedList(ll.first);

		System.out.println("add 6 at index 3:");
		ll.add(3, 6);
		System.out.println("size="+ll.size());
		ll.printLinkedList(ll.first);

		System.out.println("remove 3:");
		ll.remove(3);
		System.out.println("size="+ll.size());
		ll.printLinkedList(ll.first);
		

		
		Node<Integer> n = ll.node(2);
		ll.printLinkedList(ll.first);
		System.out.println("node at index 2:" +n.item);
		System.out.println("size="+ll.size());
		
		
		n = ll.node(6);
		ll.printLinkedList(ll.first);
		System.out.println("node at index 6:"+n.item);
		System.out.println("size="+ll.size());

		System.out.println("add node(9) at index 7:");
		ll.add(7, new Integer(9));
		ll.printLinkedList(ll.first);
		System.out.println("size="+ll.size());
		
		System.out.println("add node(-1) at index 7:");
		ll.add(-1, new Integer(9));
		ll.printLinkedList(ll.first);
		System.out.println("size="+ll.size());
	}

}
