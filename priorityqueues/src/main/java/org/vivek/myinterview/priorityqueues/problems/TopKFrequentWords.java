package org.vivek.myinterview.priorityqueues.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:

Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.

Example 2:

Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.

 */
public class TopKFrequentWords {

	public TopKFrequentWords() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		String[] words= {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		int k = 4;
		List<String> l= topKFrequent(words,  k);
		for(String s : l) {
			System.out.println(s);
		}
	}
/*The idea is to keep a count of each word in a HashMap and then insert in a Priority Queue.
While inserting in pq, if the count of two words is same then insert based on string compare of the keys.*/
	
	public static List<String> topKFrequent(String[] words, int k) {
         //1-create the result container
		List<String> result = new LinkedList<>();
		//2-create a ds container to store inputs
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			if (map.containsKey(words[i]))
				map.put(words[i], map.get(words[i]) + 1);
			else
				map.put(words[i], 1);
		}
		  //3-construct PQ with comparator implemented : here we compare words freq count  ..if same then do string compare(stored as key)  else diff of their freq count(stored as value)
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,
				b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());

		//4-insert in PQ & apply filter if any :the whole entry (K,V)-->(Word as String, count as Integer)
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			pq.offer(entry);
			if (pq.size() > k) {//filter after insertion -throw out those who have count>k
				pq.poll();
			}
		}
         //5-poll PQ in result container
		while (!pq.isEmpty())
			result.add(0, pq.poll().getKey());

		return result;
	}
}
