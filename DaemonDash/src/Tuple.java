
public class Tuple<K> {
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
}
