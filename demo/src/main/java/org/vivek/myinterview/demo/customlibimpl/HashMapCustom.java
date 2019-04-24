package org.vivek.myinterview.demo.customlibimpl;

public class HashMapCustom<K, V> {
	public static void main(String[] args) {
		HashMapCustom<Integer, Integer> hashMapCustom = new HashMapCustom<Integer, Integer>();
		hashMapCustom.put(21, 12);
		hashMapCustom.put(25, 121);
		hashMapCustom.put(30, 151);
		hashMapCustom.put(33, 15);
		hashMapCustom.put(35, 89);
		hashMapCustom.put(25, 89);

		System.out.println("value corresponding to key 21=" + hashMapCustom.get(21));
		System.out.println("value corresponding to key 51=" + hashMapCustom.get(51));

		System.out.print("Displaying : ");
		hashMapCustom.display();

		System.out.println("\n\nvalue corresponding to key 21 removed: " + hashMapCustom.remove(21));
		System.out.println("value corresponding to key 51 removed: " + hashMapCustom.remove(51));

		System.out.print("Displaying : ");
		hashMapCustom.display();

	}

	private HashEntry<K, V>[] bucket; // Array of Entry.
	private int capacity = 4; // Initial capacity of HashMap

	@SuppressWarnings("unchecked")
	public HashMapCustom() {
		bucket = new HashEntry[capacity];
	}

	/**
	 * Method allows you put key-value pair in HashMapCustom. If the map already
	 * contains a mapping for the key, the old value is replaced. Note: method does
	 * not allows you to put null key though it allows null values. Implementation
	 * allows you to put custom objects as a key as well. Key Features:
	 * implementation provides you with following features:- >provide complete
	 * functionality how to override equals method. >provide complete functionality
	 * how to override hashCode method.
	 * 
	 * @param newKey
	 * @param data
	 */
	public void put(K newKey, V data) {
		if (newKey == null)
			return; // does not allow to store null.

		// get index as hash of key.
		int index = getIndex(newKey);
		// create new entry.
		HashEntry<K, V> newEntry = new HashEntry<K, V>(newKey, data, null);
		// previous entry.
		HashEntry<K, V> previous = null;
		
		
		// if table location does not contain any entry, store entry there.
		if (bucket[index] == null) {
			bucket[index] = newEntry;//ok
			
		} else {
			
			HashEntry<K, V> current = bucket[index];//get bucket location

			while (current != null) { // we have reached last entry of bucket.
				if (current.key.equals(newKey)) {
					if (previous == null) { // node has to be insert on first of bucket.
						newEntry.next = current.next;
						bucket[index] = newEntry;
						return;
					} else {//update value
						previous.next = newEntry;//attach
						newEntry.next = current.next;
						
						return;
					}
				}
				previous = current;//keep tracking current
				current = current.next;
			}
			previous.next = newEntry;//DONT MISS THIS
			//if it is a brand new entry, previous will be null initially but 
			//after while loop it will have previous = current  as it gets assigned that before coming out [see above]
		}
	}

	/**
	 * Method returns value corresponding to key.
	 * 
	 * @param key
	 */
	public V get(K key) {
		int index = getIndex(key);
		if (bucket[index] == null) {
			return null;
		} else {
			HashEntry<K, V> temp = bucket[index];
			while (temp != null) {
				if (temp.key.equals(key))
					return temp.value;
				temp = temp.next; // return value corresponding to key.
			}
			return null; // returns null if key is not found.
		}
	}

	/**
	 * Method removes key-value pair from HashMapCustom.
	 * 
	 * @param key
	 */
	public boolean remove(K deleteKey) {

		int index = getIndex(deleteKey);
		HashEntry<K, V> previous = null;
		if (bucket[index] == null) {
			return false;
		} else {
			
			HashEntry<K, V> current = bucket[index];

			while (current != null) { // we have reached last entry node of bucket.
				if (current.key.equals(deleteKey)) {
					if (previous == null) { // delete first entry node.
						bucket[index] = bucket[index].next;
						return true;
					} else {
						previous.next = current.next;
						return true;
					}
				}
				previous = current;
				current = current.next;
			}
			return false;
		}

	}

	/**
	 * Method displays all key-value pairs present in HashMapCustom., insertion
	 * order is not guaranteed, for maintaining insertion order refer
	 * LinkedHashMapCustom.
	 * 
	 * @param key
	 */
	public void display() {

		for (int i = 0; i < capacity; i++) {
			if (bucket[i] != null) {
				HashEntry<K, V> entry = bucket[i];
				while (entry != null) {
					System.out.print("{" + entry.key + "=" + entry.value + "}" + " ");
					entry = entry.next;
				}
			}
		}

	}

	/**
	 * Method implements hashing functionality, which helps in finding the
	 * appropriate bucket location to store our data. This is very important method,
	 * as performance of HashMapCustom is very much dependent on this method's
	 * implementation.
	 * 
	 * @param key
	 */
	private int getIndex(K key) {
		return Math.abs(key.hashCode()) % capacity;
	}

	static class HashEntry<K, V> {
		K key;
		V value;
		HashEntry<K, V> next;

		public HashEntry(K key, V value, HashEntry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
}