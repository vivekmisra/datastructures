package org.vivek.myinterview.priorityqueues;

import java.util.Arrays;

public class BinaryHeapMax {

	int[] heap;
    int size;
    
    // Constructor initializes instance variables
    public BinaryHeapMax(int maxSize) {
        heap = new int[maxSize];
        size = 0;
    }
    
    // Push an element on to the queue
    public void push(int val) {
        // If the queue is full then throw an exception
        if (size == heap.length) throw new IllegalStateException();
        
        // Put the value in the next available space in the queue
        int pos = size;
        heap[pos] = val;
        
        // While val is bigger than its parent, swap it with its parent
        while (pos > 0) {
            // Get the parent and compare the values
            int parent = (pos+1) / 2 - 1;
            if (heap[parent] > heap[pos]) break;
            swapIndices(parent, pos);
            pos = parent;
        }
        
        // We added an element so increment the size
        size++;
    }
    
    // Pop the max element from the queue
    public int pop() {
        // If the queue is empty, throw an exception
        if (size == 0) throw new IllegalStateException ();

        // The top of the heap is the first item in the array, so save it off
        // to the side so we don't lose it
        int toReturn = heap[0];
        
        // Move the bottom item in the heap to the first position. We don't need
        // to remove it from the array because we have the size variable
        heap[0] = heap[size - 1];
        size--;
        
        // Bubble down the top element to the right spot
        int pos = 0;
        // We're going to be swapping with the children and any pos >= size / 2
        // doesn't have any children
        while (pos < size / 2) {
            int leftChild = pos * 2 + 1;
            int rightChild = leftChild + 1;
            // If the right child exists and is greater than the left child, 
            // compare it to the current position
            if (rightChild < size && heap[leftChild] < heap[rightChild]) { // Only swap if the value is less than the child if (heap[pos] >= heap[rightChild]) break;
                swapIndices(pos, rightChild);
                pos = rightChild;
            } else {
                // Do the same comparison with the left child
                if (heap[pos] >= heap[leftChild]) break;
                swapIndices(pos, leftChild);
                pos = leftChild;   
            }
        }
        
        return toReturn;
    }
	public void print() {
		for (int i = 0; i <= size / 2; i++) {
			System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + heap[2 * i+1] + " RIGHT CHILD :"
					+ heap[2 * i + 2]);
			System.out.println();
		}
	}
    // Swap the values at the indices
    private void swapIndices(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    
    public static void main(String[] arg) {
		System.out.println("The Max Heap is ");
		BinaryHeapMax maxHeap = new  BinaryHeapMax(20)  ;
		maxHeap.push(5);
		maxHeap.push(3);
		maxHeap.push(17);
		maxHeap.push(10);
		maxHeap.push(84);
		maxHeap.push(19);
		maxHeap.push(6);
		maxHeap.push(22);
		maxHeap.push(9);
		maxHeap.print();
		System.out.println("The max val is>>> " + maxHeap.pop());
		maxHeap = new  BinaryHeapMax(18)  ;
		int arr[] = new int[] {100,20,10,40,30,50,60,70,80,75};
		System.out.println("Before heapify: "+Arrays.toString(arr));	
		for (int k:arr) {
			maxHeap.push(k);
		}
		maxHeap.print();
		System.out.println("The max val is>>> " + maxHeap.pop());
		System.out.println("After heapify: [");
		for (int k:arr) {
			System.out.print(maxHeap.pop()+",");;
		}
		System.out.println("]");
    }
}