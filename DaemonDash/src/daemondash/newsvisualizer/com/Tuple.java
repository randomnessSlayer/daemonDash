package daemondash.newsvisualizer.com;

public class Tuple<K> implements Comparable<Tuple<K>> {
	private K key;
	private int value;

	public Tuple(K key, int value) {
		this.key = key;
		this.setValue(value);
	}

	public K getKey() {
		return key;
	}

	public int getValue() {
		return value;
	}

	public void incValue() {
		this.value++;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "<" + this.key + ", " + this.value + ">";
	}

	@Override
	public int compareTo(Tuple<K> o) {
		if (o.getValue() > this.value) {
			return 1;
		} else if (o.getValue() < this.value) {
			return -1;
		} else {
			return 0;
		}
	}
	
	@Override
	public boolean equals(Object o){
		Tuple<K> obj = (Tuple<K>) o;
		return this.key.equals(obj.getKey());
	}
}
