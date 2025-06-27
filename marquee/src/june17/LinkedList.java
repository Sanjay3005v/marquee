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
		System.out.println(list.getVal(3));
		list.deleteIndex(4);
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

	public void prepend(int val) {
		Node node = new Node(val);
		if (isEmpty()) {
			head = node;
			tail = node;
			size++;
			return;
		}
		node.next = head;
		head = node;
		size++;
		return;
	}

	public void append(int val) {
		Node node = new Node(val);
		if (isEmpty()) {
			head = node;
			tail = node;
			size++;
			return;
		}
		tail.next = node;
		tail = node;
		size++;
		return;
	}

	public boolean insert(int val, int index) {
		if (index == 0) {
			prepend(val);
			return true;
		}
		if (index >= size) {
			append(val);
			return true;
		}
		if (index < 0) {
			return false;
		} else {
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

	}

	public boolean deleteFirst() {
		if (isEmpty()) {
			return false;
		}
		if (size == 1) {
			head = null;
			tail = null;
			size--;
			return true;

		}
		head = head.next;
		size--;
		return true;

	}

	public boolean deleteLast() {
		if (isEmpty()) {
			return false;
		}
		if (size() == 1) {
			head = null;
			tail = null;
			size--;
			return true;
		}
		Node temp = head;
		for (int i = 1; i < size - 1; i++) {
			temp = temp.next;
		}
		tail = temp;
		tail.next = null;
		size--;
		return true;
	}

	public boolean deleteIndex(int index) {
		if (isEmpty() || index < 0 || index >= size()) {
			return false;
		}
		if (index == 0) {
			deleteFirst();
			return true;
		}
		if (index == size() - 1) {
			deleteLast();
			return false;
		}
		Node node = head;
		for (int i = 0; i < index - 2; i++) {
			node = node.next;
		}
		node.next = node.next.next;
		size--;
		return true;
	}

	public int getVal(int index) {
		if (isEmpty() || index < 0 || index >= size()) {
			return -1;
		}
		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node.val;
	}

	public void print() {
		for (Node node = head; node != null; node = node.next) {
			System.out.print(node.val + " ");
		}
		System.out.println();
	}
}

class Node {
	int val;
	Node next;

	Node(int val) {
		this.val = val;
	}
}
