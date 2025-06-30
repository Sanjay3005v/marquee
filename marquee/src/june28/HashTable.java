package june28;

public class HashTable {
	public static void main(String[] args) {
	    HashTable ht = new HashTable();

	}


	Node[] arr = new Node[10];
	int size;

	public int hashFunction(int key) {
		return key % arr.length;
	}

	public void display() {
		if (size == 0) {
			System.out.println("[]");
			return;
		}
		for (Node node : arr) {
			if (node != null) {
				while (node != null) {
					System.out.print(node.val + " ");
					node = node.next;
				}
			}
		}
		System.out.println();
	}

	public boolean contains(int key) {
		Node node =arr[hashFunction(key)];
		while(node!=null) {
			if(node.val==key) {
				return true;
			}
			node=node.next;
		}
		return false;
	}

	public boolean insert(int key) {
		if (arr[hashFunction(key)] != null) {
			Node node = arr[hashFunction(key)];
			while (node.next != null) {
				node = node.next;
			}
			node.next = new Node(key);
		} else {
			arr[hashFunction(key)] = new Node(key);
		}
		size++;
		return true;
	}
}

class Node {
	int val;
	Node next;

	Node(int val) {
		this.val = val;
	}
}
