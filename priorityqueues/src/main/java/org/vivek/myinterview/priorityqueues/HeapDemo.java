/*Copyright (c) Dec 19, 2018 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: HeapDemo.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package org.vivek.myinterview.priorityqueues;

import java.util.Arrays;

//Java program to implement Max Heap 
public class HeapDemo {
	private  int[] heapArray;
	private int size;
	private int maxsize;
	public HeapDemo() {
		
	}

	// Constructor to initialize an
	// empty max heap with given maximum
	// capacity.
	public HeapDemo(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		this.heapArray = new int[this.maxsize + 1];
		// this.heapArray[0] = Integer.MAX_VALUE;
	}
	/*public HeapDemo(int[] heapArray) {
		this.maxsize = heapArray.length;
		this.size = 0;
		this.heapArray = heapArray;
		// this.heapArray[0] = Integer.MAX_VALUE;
	}*/

	private int getMaximum() {
		if (this.size == 0) {
			return -1;
		}
		/*
		 * for (int i = 0; i <= size; i++) { System.out.print( " PARENT >: " +
		 * heapArray[i] ); System.out.println(); }
		 */
		return this.heapArray[0];
	}
	
	private int[] getHeapArray() {
		
		return this.heapArray;
	}

	// Returns position of parent
	private int getParent(int i) {
		return i / 2;
	}

	// Below two functions return left and
	// right children.
	private int getLeftChild(int i) {
		return (2 * i) + 1;
	}

	private int getRightChild(int i) {
		return (2 * i) + 2;
	}

	// Returns true of given node is leaf
	private boolean isLeaf(int i) {
		if (i >= (size / 2) && i <= size) {
			return true;
		}
		return false;
	}

	private void swap(int fpos, int spos) {
		int tmp;
		tmp = heapArray[fpos];
		heapArray[fpos] = heapArray[spos];
		heapArray[spos] = tmp;
	}

	// A recursive function to max heapify the given
	// subtree. This function assumes that the left and
	// right subtrees are already heapified, we only need
	// to fix the root.
	private void maxHeapify(int i) {
		if (isLeaf(i))
			return;
		int l = getLeftChild(i);
		int r = getRightChild(i);

		if (heapArray[l] > heapArray[i] || heapArray[r] > heapArray[i]) {// either child greater

			if (heapArray[l] > heapArray[r]) {
				swap(i, l);
				maxHeapify(l);
			} else {
				swap(i, r);
				maxHeapify(r);
			}
		}
	}

	// Inserts a new element to max heap
	public void insert(int data) {

		this.size++;
		heapArray[size] = data;
		// Traverse up and fix violated property
		int i = this.size;
		while (heapArray[i] > heapArray[i / 2]) {
			swap(i, i / 2);
			i = i / 2;
		}
	}

	public void print() {
		for (int i = 0; i <= size / 2; i++) {
			System.out.print(" PARENT : " + heapArray[i] + " LEFT CHILD : " + heapArray[2 * i+1] + " RIGHT CHILD :"
					+ heapArray[2 * i + 2]);
			System.out.println();
		}
	}

	// Remove an element from max heap
	public int extractMax() {
		int popped = this.heapArray[0];
		this.heapArray[0] = this.heapArray[size--];
		maxHeapify(0);
		return popped;
	}
	
	private void maxHeapify(int[] heapArray, int index, int heapSize) {
		int largest = index;
		while (largest < heapSize / 2) { // check parent nodes only
			//int left = (2 * index) + 1; // left child
			//int right = (2 * index) + 2; // right child
			int left = getLeftChild(index);
			int right = getRightChild(index);

			if (left < heapSize && heapArray[left] > heapArray[index]) {
				largest = left;
			}
			if (right < heapSize && heapArray[right] > heapArray[largest]) {
				largest = right;
			}
			if (largest != index) { // swap parent with largest child
				swap2(heapArray, index, largest);
				index = largest;
			
			} else
				break; // if heap property is satisfied
		} // end of while
	}

	private void swap2(int[] heapArray, int index, int largest) {
		int temp = heapArray[index];
		heapArray[index] = heapArray[largest];
		heapArray[largest] = temp;
	}

	public void buildMaxHeap(int[] heapArray, int heapSize) {
		// swap largest child to parent node
		for (int i = (heapSize - 1) / 2; i >= 0; i--) {
			maxHeapify(heapArray, i, heapSize);
		}
	}

	public static void main(String[] arg) {
		System.out.println("The Max Heap is ");
		HeapDemo maxHeap = new HeapDemo(15);
		maxHeap.insert(5);
		maxHeap.insert(3);
		maxHeap.insert(17);
		maxHeap.insert(10);
		maxHeap.insert(84);
		maxHeap.insert(19);
		maxHeap.insert(6);
		maxHeap.insert(22);
		maxHeap.insert(9);

		maxHeap.print();
		System.out.println("The max val is>>> " + maxHeap.getMaximum());
		System.out.println("The max val is " + maxHeap.extractMax());
		int arr[] = new int[] {100,20,10,40,30,50,60,70,80,75};
		maxHeap = new HeapDemo(20);
		System.out.println("Before heapify: "+Arrays.toString(arr));	
		for (int k:arr) {
			maxHeap.insert(k);
		}
		maxHeap.print();
		//System.out.println("2The max val is " + maxHeap.extractMax());
		System.out.println("After heapify: "+Arrays.toString(maxHeap.getHeapArray()));	
		
		
        int[] heapArray = { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16 };
		
		System.out.println("Before heapify: "+Arrays.toString(heapArray));		
		new HeapDemo().buildMaxHeap(heapArray, heapArray.length);
		System.out.println("After heapify: "+Arrays.toString(heapArray));
		
		 int arr2[] = new int[] {100,20,10,40,30,50,60,70,80,75};
		 System.out.println("Before heapify: "+Arrays.toString(arr2));		
			new HeapDemo().buildMaxHeap(arr2, arr2.length);
			System.out.println("After heapify: "+Arrays.toString(arr2));

	}
}
