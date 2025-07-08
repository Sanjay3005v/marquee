package july2;

public class HashMapImplemetation {

	public class HashMap<K, V> {

		class Entry<K, V> {
			private K key;
			private V value;

			Entry(K key, V value) {
				this.key = key;
				this.value = value;
			}

			@Override
			public boolean equals(Object obj) {
				// only we'll consider only the key not the value

				// first we have to downcast
				Entry<K, V> o1 = (Entry<K, V>) obj;
				return key.equals(o1.key);
			}

			@Override
			public int hashCode() {
				// TODO Auto-generated method stub
				return key.hashCode();
			}

			@Override
			public String toString() {
				// TODO Auto-generated method stub
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
			Node next;

			Node(Entry<K, V> val) {
				this.val = val;
			}
		}

		// here after new keyword we don't need to pass placeholder since it's not
		// constructor it won't accept.
		// if creating object for Node we should pass that placeholder
		Node<K, V> arr[] = new Node[10];
		int size = 0;

		public int hashFun(K key) {
			return key == null ? 0 : key.hashCode() % arr.length;
		}

		// HTgenerics<Entry<K,V>> ht=new HTgenerics<>();

		public boolean put(K key, V value) {
			int index = hashFun(key);
			if ((size * 1.0) / arr.length >= 0.75) {
				Node<K, V> narr[] = new Node[(int) (1.5 * arr.length)];
				Node<K, V> temp[] = arr;
				size = 0;
				arr = narr;
				for (Node<K, V> node : temp) {
					while (node != null) {
						put(node.val.key, node.val.value);
						node = node.next;
					}
				}
			}
			if (arr[index] == null) {
				arr[index] = new Node(new Entry<K, V>(key, value));
			} else {
				Node<K, V> temp = arr[index];
				while (true) {
					// temp.val is equivalent to node object, with that we're accessing key
					if (temp.val.key == null || key == null ? temp.val.key == key : temp.val.key.equals(key)) {

						temp.val.value = value; // if we have duplicate key, we should update the value
						return false;
					}
					if (temp.next == null)
						break; // if we're giving this condition in while, we can't compare the lastnode with
								// the if condition
					// so we're making while condition as true
					temp = temp.next;
				}
				// we've traversed upto the last node, in the lastnode's next pointer we're
				// creating the object
				temp.next = new Node(new Entry<K, V>(key, value));
			}
			size++;
			return true;
		}

		public boolean contains(K key) {
			int index = hashFun(key);
			Node<K, V> temp = arr[index];
			while (temp != null) {
				if (temp.val.key == null || key == null ? temp.val.key == key : temp.val.key.equals(key))
					return true;
				temp = temp.next;
			}
			return false;
		}

		public V getValue(K key) {
			int index = hashFun(key);
			Node<K, V> temp = arr[index];
			while (temp != null) {
				if (temp.val.key.equals(key))
					return temp.val.value;
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

		public static void main(String[] args) {
			HashMap<Integer, String> map = new HashMap<>();

			map.put(1, "One");
			map.put(2, "Two");
			map.put(3, "Three");
			map.put(1, "four");

			System.out.println("Custom HashMap contents:");
			System.out.println(map.getValue(5));
			map.display();
		}

	}

}