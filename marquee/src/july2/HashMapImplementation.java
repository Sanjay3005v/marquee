package july2;

public class HashMapImplementation {

	public class HashMap<K, V> {

		class Entry<K, V> {
			private K key;
			private V value;
 
			Entry(K key, V value) {
				this.key = key;
				this.value = value;
			}

			@Override
			@SuppressWarnings("unchecked")
			public boolean equals(Object obj) {
				if (this == obj) return true;
				if (obj == null || getClass() != obj.getClass()) return false;

				Entry<K, V> other = (Entry<K, V>) obj;

				return key == null ? other.key == null : key.equals(other.key);
			}


			@Override
			public int hashCode() {
				return key == null ? 0 : key.hashCode();
			}

			@Override
			public String toString() {
				return "[" + key + " " + value + "]";
			}

			public K getKey() {
				return key;
			}

			public void setKey(K key) {
				this.key = key;
			}

			public V getValue() {
				return value;
			}

			public void setValue(V value) {
				this.value = value;
			}
		}

		class Node<K, V> {
			Entry<K, V> val;
			Node<K, V> next;

			Node(Entry<K, V> val) {
				this.val = val;
			}
		}

		Node<K, V>[] arr = (Node<K, V>[]) new Node[10];
		int size = 0;

		public int hashFun(K key) {
			return key == null ? 0 : Math.abs(key.hashCode()) % arr.length;
		}

		public boolean put(K key, V value) {
			if ((size * 1.0) / arr.length >= 0.75) {
				resize();
			}

			int index = hashFun(key);
			if (arr[index] == null) {
				arr[index] = new Node<>(new Entry<>(key, value));
			} else {
				Node<K, V> temp = arr[index];
				while (true) {
					if (temp.val.key == null || key == null
							? temp.val.key == key
							: temp.val.key.equals(key)) {
						temp.val.value = value; 
						return false;
					}
					if (temp.next == null) break;
					temp = temp.next;
				}
				temp.next = new Node<>(new Entry<>(key, value)); 
			}
			size++;
			return true;
		}

		private void resize() {
			Node<K, V>[] temp = arr;
			arr = (Node<K, V>[]) new Node[temp.length * 2];
			size = 0;
			for (Node<K, V> node : temp) {
				while (node != null) {
					put(node.val.key, node.val.value);
					node = node.next;
				}
			}
		}

		public boolean contains(K key) {
			int index = hashFun(key);
			Node<K, V> temp = arr[index];
			while (temp != null) {
				if (temp.val.key == null || key == null
						? temp.val.key == key
						: temp.val.key.equals(key)) {
					return true;
				}
				temp = temp.next;
			}
			return false;
		}

		public V getValue(K key) {
			int index = hashFun(key);
			Node<K, V> temp = arr[index];
			while (temp != null) {
				if (temp.val.key == null || key == null
						? temp.val.key == key
						: temp.val.key.equals(key)) {
					return temp.val.value;
				}
				temp = temp.next;
			}
			return null;
		}

		public void display() {
			for (Node<K, V> node : arr) {
				while (node != null) {
					System.out.print(node.val + " ");
					node = node.next;
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMapImplementation().new HashMap<>();

		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(1, "Four");

		System.out.println("Custom HashMap contents:");
		System.out.println("Value for key 5: " + map.getValue(5));
		map.display();
	}
}
