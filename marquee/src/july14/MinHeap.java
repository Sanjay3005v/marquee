package july14;

public class MinHeap {
	int[] arr;
	int size;

	MinHeap(int size) {
		arr = new int[this.size];
	}

	public void display() {
		for (int i = 1; i <= size; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == arr.length;
	}

	public void add(int val) {
		if (isFull()) {
			System.out.println("Heap is Full");
			return;
		}
		arr[++size] = val;
		heapifyBottomUp(size);
	}

	public void heapifyBottomUp(int index) {
		if (index <= 1) {
			return;
		}
		int parent = index / 2;
		if (arr[index] < arr[parent]) {
			arr[parent] = (arr[parent] + arr[index]) - (arr[index] = arr[parent]);
		}
		heapifyBottomUp(parent);
	}

	public Integer peek() {
		return isEmpty() ? null : arr[1];
	}

	public void delete() {
		if (isEmpty()) {
			System.out.println("Heap is empty");
			return;
		}
		arr[1] = arr[size--];
		heapifyTopDown(1);
	}

	public void heapifyTopDown(int index) {
		int left = index * 2;
		int right = (index * 2) + 1;
		if (size < left) {
			return;
		}
		if (size == left && arr[left] < arr[index]) {
			arr[left] = (arr[left] + arr[index]) - (arr[index] = arr[left]);
		} else {
			int min = arr[left] < arr[right] ? left : right;
			if (arr[index] > arr[min]) {
				arr[min] = (arr[min] + arr[index]) - (arr[index] = arr[min]);
				heapifyTopDown(min);
			}
		}
	}

	public static void main(String[] args) {
		MinHeap hp = new MinHeap(10);
		System.out.println(hp.peek());
		hp.add(10);
		hp.add(12);
		hp.add(5);
		hp.add(19);
		hp.add(3);
		System.out.println(hp.peek());
		hp.display();
//		hp.delete();
//		hp.display();
	}
}
