package june17;

public class LinkedList {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.prepend(10);
		list.prepend(20);
		list.prepend(30);
		list.append(40);
		list.append(50);
		list.insert(22, 3);
		list.print();
	}
}

class SinglyLinkedList {
	Node head;
	Node tail;
	int size;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public boolean prepend(int val) {
		Node node = new Node(val);
		if (isEmpty()) {
			head = node;
			tail = node;
			size++;
			return true;
		}
		node.next = head;
		head = node;
		size++;
		return true;
	}

	public boolean append(int val) {
		Node node = new Node(val);
		if (isEmpty()) {
			head = node;
			tail = node;
			size++;
			return true;
		}
		tail.next = node;
		tail = node;
		size++;
		return true;
	}

	public boolean insert(int val, int index) {
		if (index < 0 || index > size) {
			return false;
		}
		if (index == 0) {
			prepend(val);
			return true;
		}
		if (index == size) {
			append(val);
			return true;
		}
		Node temp = head;
		Node node = new Node(val);
		for (int i = 0; i < index - 1; i++) {
			temp = temp.next;
		}
		node.next = temp.next;
		temp.next = node;
		size++;
		return true;

	}

	public void print() {
		for (Node node = head; node != null; node = node.next) {
			System.out.print(node.val + " ");
		}
	}
}

class Node {
	int val;
	Node next;

	Node(int val) {
		this.val = val;
	}
}
