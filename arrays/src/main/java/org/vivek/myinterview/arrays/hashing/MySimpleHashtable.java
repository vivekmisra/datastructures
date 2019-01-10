package org.vivek.myinterview.arrays.hashing;

import java.util.ArrayList;

class HashEntry {
	String key;
	int value;

	// Reference to next entry
	HashEntry next;

	// Constructor
	public HashEntry(String key, int value) {
		this.key = key;
		this.value = value;
	}
}

public class MySimpleHashtable {

	private ArrayList<HashEntry> bucket;
	private int slots;
	private int size;

	// Constructor
	public MySimpleHashtable() {
		bucket = new ArrayList<>();
		slots = 10;
		size = 0;
		// initialize buckets
		for (int i = 0; i < slots; i++)
			bucket.add(null);

	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	private int getIndex(String key) {

		// hashCode is a built in function of Strings
		int hashCode = key.hashCode();
		int index = hashCode % slots;
		return index;
	}

	// Inserts a key value pair into table
	public void insert(String key, int value) {
		// Find head of the chain
		int b_Index = getIndex(key);
		HashEntry head = bucket.get(b_Index);

		// Checks if the key is already exists
		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}

		// Inserts key in the chain
		size++;
		head = bucket.get(b_Index);
		HashEntry new_slot = new HashEntry(key, value);
		new_slot.next = head;
		bucket.set(b_Index, new_slot);

		// Checks if array >60% of the array gets filled
		if ((1.0 * size) / slots >= 0.6) {
			ArrayList<HashEntry> temp = bucket;
			bucket = new ArrayList();
			slots = 2 * slots;
			size = 0;
			for (int i = 0; i < slots; i++)
				bucket.add(null);

			for (HashEntry head_Node : temp) {
				while (head_Node != null) {
					insert(head_Node.key, head_Node.value);
					head_Node = head_Node.next;
				}
			}
		}
	}
}