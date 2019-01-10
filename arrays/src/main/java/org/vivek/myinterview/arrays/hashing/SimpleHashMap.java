package org.vivek.myinterview.arrays.hashing;
/*
 * http://whileonefork.blogspot.com/2011/02/hashmap-101-build-your-own.html
 */
public class SimpleHashMap<K, V> {

	private int DEFAULT_BUCKET_COUNT = 128;

	private AnEntry<K, V>[] buckets;

	public SimpleHashMap() {
		buckets = new AnEntry[DEFAULT_BUCKET_COUNT];
	}

	/*
	 * The first operation we'll implement is get. We'll need to identify what
	 * bucket to use, then cycle through the 0..N entries for that bucket to see
	 * if any of them have the exact key we are interested in:
	 */
	public V get(K key) {
		throwIfKeyNull(key);

		AnEntry<K, V> entry = buckets[bucketIndexForKey(key)];
		while (entry != null && !key.equals(entry.getKey())) {
			entry = entry.getNext();
		}
		return entry != null ? entry.getValue() : null;
	}

	/*
	 * Next, put. If there is nothing at all in the bucket we can just create a
	 * new entry and shove it in. If there is already 1..N things there we need
	 * to search through them all. If we find one with the exact same key we'll
	 * update it, otherwise we'll just shove a new entry on the end:
	 */
	public void put(K key, V value) {
		throwIfKeyNull(key);

		int bucketIndex = bucketIndexForKey(key);
		AnEntry<K, V> entry = buckets[bucketIndex];

		if (null != entry) {
			boolean done = false;
			while (!done) {
				if (key.equals(entry.getKey())) {
					entry.setValue(value);
					done = true;
				} else if (entry.getNext() == null) {
					entry.setNext(new AnEntry<K, V>(key, value));
					done = true;
				}
				entry = entry.getNext();
			}
		} else {
			// nothing there at all; just shove the new entry in
			buckets[bucketIndex] = new AnEntry<K, V>(key, value);
		}
	}

	/**
	 * THIS SHOULDN'T ACTUALLY BE PUBLIC; IT IS SO JUST FOR CLARIFICATION UNIT
	 * TEST PURPOSES
	 * 
	 */
	public int bucketIndexForKey(K key) {
		int bucketIndex = key.hashCode() % buckets.length;
		return bucketIndex;
	}

	private void throwIfKeyNull(K key) {
		if (key == null) {
			throw new IllegalArgumentException("key may not be null");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
