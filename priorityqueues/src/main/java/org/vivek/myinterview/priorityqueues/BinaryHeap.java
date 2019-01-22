/*Copyright (c) Dec 25, 2014 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: BinaryHeap.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */


package org.vivek.myinterview.priorityqueues;

import java.util.Arrays;

public class BinaryHeap<AnyType extends Comparable<? super AnyType>>{
	// Construct the binary heap.
	public BinaryHeap( ){
		this( DEFAULT_CAPACITY );
	}

	// Construct the binary heap.
	@SuppressWarnings("unchecked")
	public BinaryHeap( int capacity ){
		currentSize = 0;
		heap = (AnyType[]) new Comparable[ capacity + 1 ];
	}

	// Construct the binary heap given an array of items.
	@SuppressWarnings("unchecked")
	public BinaryHeap( AnyType [ ] items ){
		currentSize = items.length;
		heap = (AnyType[]) new Comparable[ ( currentSize + 2 ) * 11 / 10 ];

		int i = 1;
		for( AnyType item : items )
			heap[ i++ ] = item;
		buildHeap( );
	}

	// Insert into the priority queue, maintaining heap order.  Duplicates are allowed.
	public void insert( AnyType x ){
		if( currentSize == heap.length - 1 )
			enlargeArray( heap.length * 2 + 1 );

		// Percolate up
		int hole = ++currentSize;
		for( ; hole > 1 && x.compareTo( heap[ hole / 2 ] ) < 0; hole /= 2 )
			heap[ hole ] = heap[ hole / 2 ];
		heap[ hole ] = x;
	}


	@SuppressWarnings("unchecked")
	private void enlargeArray( int newSize ){
		AnyType [] old = heap;
		heap = (AnyType []) new Comparable[ newSize ];
		for( int i = 0; i < old.length; i++ )
			heap[ i ] = old[ i ];		
	}

	// Find the smallest item in the priority queue.
	public AnyType findMin( ){
		if( isEmpty( ) )
			return null;
		//	throw new UnderflowException( );
		return heap[ 1 ];
	}

	// Remove the smallest item from the priority queue.
	public AnyType deleteMin( ){
		if( isEmpty( ) )
			return null;
		//	throw new UnderflowException( );

		AnyType minItem = findMin( );
		heap[ 1 ] = heap[ currentSize-- ];
		percolateDown( 1 );

		return minItem;
	}
	
	// Remove the smallest item from the priority queue.
		public AnyType deleteMax( ){
			if( isEmpty( ) )
				return null;
			//	throw new UnderflowException( );

			AnyType minItem = findMin( );
			heap[ 1 ] = heap[ currentSize-- ];
			percolateDown( 1 );

			return minItem;
		}

	// Establish heap order property from an arbitrary arrangement of items. Runs in linear time.
	private void buildHeap( ){
		for( int i = currentSize / 2; i > 0; i-- )
			percolateDown( i );
	}

	// Test if the priority queue is logically empty.
	public boolean isEmpty( ){
		return currentSize == 0;
	}

	// Make the priority queue logically empty.
	public void makeEmpty( ){
		currentSize = 0;
	}

	private static final int DEFAULT_CAPACITY = 10;

	private int currentSize;      // Number of elements in heap
	private AnyType [ ] heap; // The heap array

	// Internal method to percolate down in the heap.
	private void percolateDown( int hole ){
		int child;
		AnyType tmp = heap[ hole ];

		for( ; hole * 2 <= currentSize; hole = child ){
			child = hole * 2;
			if( child != currentSize &&
					heap[ child + 1 ].compareTo( heap[ child ] ) < 0 )
				child++;
			if( heap[ child ].compareTo( tmp ) < 0 )
				heap[ hole ] = heap[ child ];
			else
				break;
		}
		heap[ hole ] = tmp;
	}

	// Test program
	public static void main( String [ ] args ){
		int numItems = 10000;
		BinaryHeap<Integer> h = new BinaryHeap<Integer>( );
		int i = 37;
		int arr[] = new int[] {100,20,10,40,30,50,60,70,80,75};
		System.out.println("Before heapify: "+Arrays.toString(arr));	
		for (int k:arr) {
			h.insert(k);
		}
		System.out.println("After heapify: [");
		for (int k:arr) {
			System.out.print(h.deleteMin()+",");;
		}
		System.out.println("]");
/*
 * 
 * 
		for( i = 37; i != 0; i = ( i + 37 ) % numItems )
			h.insert( i );
		for( i = 1; i < numItems; i++ )
			if( h.deleteMin( ) != i )
				System.out.println( "Oops! " + i );*/
	}
}
