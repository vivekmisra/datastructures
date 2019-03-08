/*Copyright (c) Dec 21, 2014 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package org.vivek.myinterview.priorityqueues.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergingKSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.isEmpty()) 
            return null;
       
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>();
       //add all nodes to heap so that they would be assigned priroty according to node value
        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }
        ListNode head = null, cur = null;
        //now by default lowest gets hig priority unless we change in compare method
        //polling will output ordered 
        while (!heap.isEmpty()) {
            if (head == null) {//first time
                head = heap.poll();//remove max priority(max priririty is given to lowest value as it is min heap by default)
                cur = head;//assign curr as head to continue 
            } else {//susequent calls
                cur.next = heap.poll();//deleted is next pointers
                cur = cur.next;//keep moving
            }
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }
        return head;
    }
}
