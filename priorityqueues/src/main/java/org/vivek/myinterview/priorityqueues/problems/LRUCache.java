package org.vivek.myinterview.priorityqueues.problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/lru-cache/
 *  
 *  Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2  capacity  );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

 */
public class LRUCache {
    PriorityQueue<Integer> queue = null;
    HashMap<Integer, Pair>cache = new HashMap();
    int cap = 0;
    int globalAge = 0;
    private class Pair
    {
        int value;
        int age;
        public Pair(int value, int age)
        {
            this.value = value;
            this.age = age;
        }
        
        @Override
        public String toString()
        {
            return "" + value + ":" + age; 
        }
    }

	class TComparator<Integer> implements Comparator<Integer> 
    {
         
       @Override
       public int compare(Integer arg0, Integer arg1) 
       {
           if (cache.get(arg0).age < cache.get(arg1).age)
           {
               return -1;
           }
           else
           {
               return 1;
           }
       }
    }
    public LRUCache(int capacity) 
    {
        cache = new HashMap();
        cap = capacity;
        TComparator<Integer> comparator = new TComparator(); 
        queue = new PriorityQueue<Integer>(capacity, comparator);
    }
    
    public int get(int key) 
    {
        Pair entry = cache.get(key);
        if (null != entry)
        {
            cache.put(key, new Pair(entry.value, ++globalAge));
            queue.remove(key);
            queue.add(key);
            return entry.value;
        }
        return -1;
    }
    
    public void put(int key, int value) 
    {
        cache.put(key, new Pair(value, ++globalAge));
        if (cache.size() > cap)
        {
            Integer expired = queue.poll();
            cache.remove(expired);
        }
        queue.remove(key);
        queue.add(key);
    }
}
