package june28;

public class HashTable<T> {
	public static void main(String[] args) {
		HashTable<Integer> ht = new HashTable<>();

		ht.insert(10);
		ht.insert(20);
		ht.insert(15);
		ht.insert(25);
		ht.insert(30);

		System.out.print("HashTable contents: ");
		ht.display();

		System.out.println("Contains 15? " + ht.contains(15));
		System.out.println("Contains 99? " + ht.contains(99));

		ht.insert(10);
		System.out.print("After inserting duplicate 10: ");
		ht.display();
	}

	Node<T>[] arr = new Node[10];
	int size;

	public int hashFunction(T key) {
		return Math.abs(key.hashCode() % arr.length);
	}

	public void display() {
		if (size == 0) {
			System.out.println("[]");
			return;
		}
		for (Node<T> node : arr) {
			if (node != null) {
				while (node != null) {
					System.out.print(node.val + " ");
					node = node.next;
				}
			}
		}
		System.out.println();
	}

	public boolean contains(T key) {
		Node<T> node = arr[hashFunction(key)];
		while (node != null) {
			if (node.val.equals(key)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	public boolean insert(T key) {
		int index = hashFunction(key);
		if (arr[index] != null) {
			Node<T> node = arr[index];
			while (node.next != null) {
				node = node.next;
			}
			node.next = new Node<>(key);
		} else {
			arr[index] = new Node<>(key);
		}
		size++;
		return true;
	}
}

class Node<T> {
	T val;
	Node<T> next;

	Node(T val) {
		this.val = val;
	}
}
