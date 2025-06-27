package june27;

public class QueueWithArrays {
	public static void main(String[] args) {
		ArrayQueue q = new ArrayQueue();
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

class ArrayQueue {
	int[] arr = new int[10];
	int rear = -1;
	int front = 0;
	int size;

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean isFull() {
		return size() == arr.length;
	}

	public int size() {
		return size;
	}

	public boolean enqueue(int val) {
		if (isFull()) {
			int[] temp = new int[arr.length * 2];
			for (int i = 0; i < size; i++) {
				int j = (front + i) % arr.length;
				temp[i] = arr[j];
			}
			arr = temp;
			front = 0;
			rear = size;
		}
		rear = (rear + 1) % arr.length;
		arr[rear] = val;
		size++;
		return true;
	}

	public int dequeue() {
		if (isEmpty()) {
			return -1;
		}
		int val = arr[front];
		front = (front + 1) % arr.length;
		size--;
		return val;
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("QueueUnderFlow");
			return -1;
		}
		return arr[front];
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("QueueUnderFlow");
			return;
		}
		for (int i = 0; i < size; i++) {
			int j = (front + i) % arr.length;
			System.out.print(arr[j] + " ");
		}
		return;
	}
}