package org.vivek.myinterview.linkedlists.core;

import java.util.ListIterator;
import java.util.NoSuchElementException;

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
		// assert isElementIndex(index);
		Node<E> node = null;
		if (index < (length >> 1)) {
			node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}

		}
		return node;
	}
	// ############################################END:GET######################################################################
	// ############################################START:ADD/REMOVE#############################################################

	public void addFirst(E e) {
		linkFirst(e);
	}

	public void addLast(E e) {
		linkLast(e);
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
		final Node<E> l = last;
		// final Node<E> newNode = new Node<>(l, e, null);
		final Node<E> newNode = new Node<>(e, null);
		last = newNode;
		if (l == null)
			first = newNode;
		else
			l.next = newNode;
		length++;

	}

	private E unlinkLast(Node<E> l) {
		// assert l == last && l != null;
		final E element = l.item;
		Node<E> prev = null;
		l.item = null;
		Node<E> temp = first;
		while (first.next != null && first.next.next != null) {
			prev = first.next;
			first = first.next;
		}
		last = prev;
		first = temp;// restore head

		last.next = null;
		length--;

		return element;
	}

	E unlink(Node<E> node) {
		final E element = node.item;
		final Node<E> next = node.next;
		if (next == null) {
			node.next = null;
		}
		node.item = null;
		length--;
		return element;
	}

	// ############################################END:ADD/REMOVE#############################################################
	@Override
	public String toString() {
		return "SLLImpl2 [length=" + length + ", first=" + first + ", last=" + last + ", size()=" + size()
				+ ", getFirst()=" + getFirst() + "]";
	}

	public void printLinkedList(Node head) {

		while (head != null) {
			if (head.next != null) {
				System.out.print(head.item + "->");
			} else {
				System.out.print(head.item + "->NULL");
			}
			head = head.next;
		}
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
		System.out.println("get first:"+ll.getFirst());
		System.out.println("get last:"+ll.getLast());
		System.out.println("remove first:");
		ll.removeFirst();
		ll.printLinkedList(ll.first);
		System.out.println("add first:");
		ll.addFirst(4);
		ll.printLinkedList(ll.first);
		System.out.println("remove last:");
		ll.removeLast();
		ll.printLinkedList(ll.first);
		System.out.println("add last:");
		ll.addLast(1);
		ll.printLinkedList(ll.first);
	}

}
