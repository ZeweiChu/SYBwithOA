package monoids;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import library.Monoid;

public class MapMonoid<K, V> implements Monoid<Map<K, V>> {
	@Override
	public Map<K, V> join(Map<K, V> x, Map<K, V> y) {
		HashMap<K, V> tmp = new HashMap<>(x);
		tmp.putAll(y);
		return tmp;
	}

	@Override
	public Map<K, V> empty() {
		return Collections.emptyMap();
	}

}
