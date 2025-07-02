package june28;

public class HashTable<T> {
	public static void main(String[] args) {
		HashTable<Object> ht = new HashTable<>();

		System.out.println("inserting");
		System.out.println(ht.insert(42));
		System.out.println(ht.insert("Batman"));
		System.out.println(ht.insert(0.14));
		System.out.println(ht.insert('A'));
		System.out.println(ht.insert(true));
		System.out.println(ht.insert(null));

		ht.display();

		System.out.println("duplicate check");
		System.out.println(ht.insert(42));
		System.out.println(ht.insert("Batman"));
		System.out.println(ht.insert(null));

		ht.display();

		System.out.println("contains");
		System.out.println( ht.contains(42));
		System.out.println( ht.contains("Batman"));
		System.out.println(ht.contains(0.14));
		System.out.println(ht.contains('A'));
		System.out.println(ht.contains(true));
		System.out.println(ht.contains(null));
		System.out.println(ht.contains("Joker"));
		System.out.println(ht.contains(545));

		System.out.println("deleting");
		System.out.println(ht.delete(0.14));
		System.out.println(ht.delete("Batman"));
		System.out.println(ht.delete(null));
		System.out.println(ht.delete(4525));
		System.out.println(ht.delete("Joker"));
		System.out.println(ht.delete(null));

		ht.display();

	}

	Node<T>[] arr = new Node[10];
	int size;

	public int hashFunction(T key) {
		if (key == null) return 0;
		return Math.abs(key.hashCode()) % arr.length;
	}

	public void display() {
		if (size == 0) {
			System.out.println("[]");
			return;
		}
		for (Node<T> node : arr) {
			while (node != null) {
				System.out.print(node.val + " ");
				node = node.next;
			}
		}
		System.out.println();
	}

	public boolean contains(T key) {
		int index = hashFunction(key);
		Node<T> node = arr[index];
		while (node != null) {
			if ((key == null && node.val == null) || (key != null && key.equals(node.val))) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	public boolean insert(T key) {
		if((size/arr.length)>0.75) {
			
		}
		int index = hashFunction(key);
		Node<T> node = arr[index];

		if (node == null) {
			arr[index] = new Node<>(key);
			size++;
			return true;
		}

		while (node != null) {
			if ((key == null && node.val == null) || (key != null && key.equals(node.val))) {
				return false; 
			}
			if (node.next == null) {
				break;
			}
			node = node.next;
		}
		node.next = new Node<>(key);
		size++;
		return true;
	}

	public boolean delete(T key) {

		Node<T> curr = arr[hashFunction(key)];
		Node<T> prev = null;

		while (curr != null) {
			if ((key == null && curr.val == null) || (key != null && key.equals(curr.val))) {
				if (prev == null) {
					arr[hashFunction(key)] = curr.next;
				} else {
					prev.next = curr.next;
				}
				size--;
				return true;
			}
			prev = curr;
			curr = curr.next;
		}
		return false;
	}
}

class Node<T> {
	T val;
	Node<T> next;

	Node(T val) {
		this.val = val;
	}
}
