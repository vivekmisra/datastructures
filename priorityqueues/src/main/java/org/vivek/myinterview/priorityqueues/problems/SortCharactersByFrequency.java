package org.vivek.myinterview.priorityqueues.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortCharactersByFrequency {

	public SortCharactersByFrequency() {

	}

	public static void main(String[] args) {
		String s = "cccaaa";
		System.out.println(frequencySort(s));
		s = "Aabb";
		System.out.println(frequencySort(s));
		s = "tree";
		System.out.println(frequencySort(s));
	}

	public static String frequencySort(String s) {
		String str = "";
		Map<Character, Integer> map = new HashMap();
		/*for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}*/
		//create a ds container to store inputs -for loop for better understanding
		for (int i = 0; i <s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		}
		  //construct PQ with what to compare from container -here we compare ASCII values of characters
		Queue<Integer> pq = new PriorityQueue<>((n1, n2) ->n1==n2?n1-n2: n2 - n1);
		for (Character c : map.keySet()) {
			pq.add(map.get(c));
		}
		while (!pq.isEmpty()) {
			int max = pq.poll();
			for (Character c : map.keySet()) {
				if (map.get(c) == max) {
					while (max > 0) {
						str += c;
						max--;
					}
					map.remove(c);
					break;
				}
			}
		}
		return str;
	}
}
