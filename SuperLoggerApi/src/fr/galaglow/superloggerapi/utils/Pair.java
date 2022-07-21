package fr.galaglow.superloggerapi.utils;

public class Pair<K, V> {

	private final K first;
	private final V second;

	public Pair(K first, V value) {
		this.first = first;
		this.second = value;
	}

	public K getFirst() {
		return first;
	}

	public V getSecond() {
		return second;
	}
}
