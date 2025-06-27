package june27;

public class QueueWithLL {
	public static void main(String[] args) {
		LinkedListQueue q = new LinkedListQueue();
		System.out.println(q.peek());
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.enqueue(60);
		q.enqueue(60);
		q.enqueue(60);
		q.enqueue(60);
		q.enqueue(60);
		q.enqueue(60);
		q.enqueue(60);
		q.enqueue(60);
		q.enqueue(60);
		q.enqueue(60);
		System.out.println(q.peek());
		System.out.println(q.dequeue());
		q.display();
	}
}

class LinkedListQueue {
	Node front;
	Node rear;
	int size;

	public boolean isEmpty() {
		return front == null;
	}

	public int size() {
		return size;
	}

	public void enqueue(int val) {
		Node node = new Node(val);
		if (isEmpty()) {
			front = rear = node;
		} else {
			rear.next = node;
			rear = node;
		}
		size++;
		return;
	}

	public int dequeue() {
		if (isEmpty()) {
			System.out.println("QueueUnderFlow");
			return -1;
		}
		int val = front.val;
		if (size() == 1) {
			front = null;
			rear = null;
		} else {
			front = front.next;
		}
		size--;
		return val;
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("QueueUnderFlow");
			return -1;
		}
		return front.val;
	}

	public void display() {
		for (Node node = front; node != null; node = node.next) {
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
