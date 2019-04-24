package org.vivek.myinterview.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class TwoDArrayIterator implements Iterator<Integer> {
	
	// Set local variables
    private int[][] Array2D;
    private int pos = 0; // The position of our cursor
    private List list;// What we are going to return
    private int maxIterations;
    private boolean shouldRemove;
    private final int firstIndex = 0;
    
    // The default constructor
    public TwoDArrayIterator(int[][] Array2D) {
        this.Array2D = Array2D;
        this.shouldRemove = false;
        copyArray(Array2D);
    }
    
    /**
     * Move through array while hasNext() is true
     */
    @Override
    public boolean hasNext() {
        return pos < maxIterations; // Start at 0 and move up
    }
   
   /**
    * When called will print all the values in the 2D
    * Array
    */
    @Override
    public Integer next() throws NoSuchElementException {
        
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        
        // Get value then remove it from the list
        Integer result = (Integer) list.get(firstIndex);
        pos++;
        shouldRemove = true; // Remove values from the List
        remove();
        return result;
    }
    
    /**
     * Set max iterations based on the number of int values in  
     * the initial 2D Array
     */    
     public void setMaxIterations(List list) {
        if(list != null) {
            maxIterations = list.size();
        }
    }
    
    /** 
     * Copy values into the collection while skipping over 
     * null values with a nested for-loop
     */
     private void copyArray(int[][] array) {
        list = new ArrayList<Integer>();
        
        // Loop though all values
        for (int[] data : array) {
            for (int val : data) {
                list.add(val);
            }
        }
        
        // Set total number of iterations
        setMaxIterations(getList());
    }
    
    /** 
     * Remove previous element returned by iterator
     */    
     public void remove() {
        if(shouldRemove) {
            list.remove(firstIndex);
            shouldRemove = false;
        }
    }
    
    public List getList() {
        return this.list;
    }
    
    // Test the code
    public static void main(String[] args) {
        
    // Create some 2D Array
    int[][] Array2D = { {1, 2}, {3}, {} , 
                            {5, 6}, {}, {7, 8, 9, 10} };
     // Create the class to iterate through the 2D Array
    TwoDArrayIterator ai = new TwoDArrayIterator(Array2D);
        
     while(ai.hasNext()) {
        System.out.println(ai.next());
     }
     
     // Test the List is empty
     System.out.println(ai.getList());
        
    }
}