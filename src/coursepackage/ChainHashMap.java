package coursepackage;

import java.util.ArrayList;

public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {

	private UnsortedTableMap<K, V>[] table; // initialized within createTable

	public ChainHashMap() {
		super();
	}

	public ChainHashMap(int cap) {
		super(cap);
	}

	public ChainHashMap(int cap, int p) {
		super(cap, p);
	}

	@Override
	@SuppressWarnings({ "unchecked" })
	protected void createTable() {
		table = (UnsortedTableMap<K, V>[]) new UnsortedTableMap[capacity];
	}

	@Override
	protected V bucketGet(int h, K k) {
		UnsortedTableMap<K, V> bucket = table[h];
		if (bucket == null)
			return null;
		return bucket.get(k);
	}

	@Override
	protected V bucketPut(int h, K k, V v) {
		UnsortedTableMap<K, V> bucket = table[h];
		if (bucket == null)
			bucket = table[h] = new UnsortedTableMap<>();
		int oldSize = bucket.size();
		V answer = bucket.put(k, v);
		n += (bucket.size() - oldSize); // size may have increased
		return answer;
	}

	@Override
	protected V bucketRemove(int h, K k) {
		UnsortedTableMap<K, V> bucket = table[h];
		if (bucket == null)
			return null;
		int oldSize = bucket.size();
		V answer = bucket.remove(k);
		n -= (oldSize - bucket.size()); // size may have decreased
		return answer;
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		ArrayList<Entry<K, V>> buffer = new ArrayList<>();
		for (int h = 0; h < capacity; h++)
			if (table[h] != null)
				for (Entry<K, V> entry : table[h].entrySet())
					buffer.add(entry);
		return buffer;
	}
}
