package june28;

public class HashTable<T> {
	public static void main(String[] args) {
		HashTable<Object> ht = new HashTable<>();

		System.out.println("==== Inserting mixed types ====");
		System.out.println("Insert 42: " + ht.insert(42));
		System.out.println("Insert \"Batman\": " + ht.insert("Batman"));
		System.out.println("Insert 3.14: " + ht.insert(3.14));
		System.out.println("Insert 'A': " + ht.insert('A'));
		System.out.println("Insert true: " + ht.insert(true));
		System.out.println("Insert null: " + ht.insert(null));

		ht.display();

		System.out.println("==== Duplicate Insertions ====");
		System.out.println("Insert duplicate 42: " + ht.insert(42));
		System.out.println("Insert duplicate \"Batman\": " + ht.insert("Batman"));
		System.out.println("Insert duplicate null: " + ht.insert(null));

		ht.display();

		System.out.println("==== Contains Checks ====");
		System.out.println("Contains 42: " + ht.contains(42));
		System.out.println("Contains \"Batman\": " + ht.contains("Batman"));
		System.out.println("Contains 3.14: " + ht.contains(3.14));
		System.out.println("Contains 'A': " + ht.contains('A'));
		System.out.println("Contains true: " + ht.contains(true));
		System.out.println("Contains null: " + ht.contains(null));
		System.out.println("Contains \"Joker\": " + ht.contains("Joker"));
		System.out.println("Contains 999: " + ht.contains(999));

		System.out.println("==== Deletion Tests ====");
		System.out.println("Delete 3.14: " + ht.delete(3.14));
		System.out.println("Delete \"Batman\": " + ht.delete("Batman"));
		System.out.println("Delete null: " + ht.delete(null));
		System.out.println("Delete 999: " + ht.delete(999));
		System.out.println("Delete \"Joker\": " + ht.delete("Joker"));
		System.out.println("Delete null again: " + ht.delete(null));

		ht.display();

		System.out.println(" All test cases executed.");
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
		int index = hashFunction(key);
		Node<T> curr = arr[index];
		Node<T> prev = null;

		while (curr != null) {
			if ((key == null && curr.val == null) || (key != null && key.equals(curr.val))) {
				if (prev == null) {
					arr[index] = curr.next;
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
