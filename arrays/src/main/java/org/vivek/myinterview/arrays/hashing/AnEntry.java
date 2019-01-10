package org.vivek.myinterview.arrays.hashing;

public class AnEntry<K, V> {
	private AnEntry<K, V> next;
	private final K key;
	private V value;

	public AnEntry(K key, V value) {
		this.key = key;
		this.setValue(value);
	}

	public K getKey() {
		return key;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public V getValue() {
		return value;
	}

	public void setNext(AnEntry<K, V> next) {
		this.next = next;
	}

	public AnEntry<K, V> getNext() {
		return next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
