package july14;

public class MinHeap {
	int[] arr;
	int size;

	MinHeap(int size) {
		arr = new int[size];
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
		if(isFull()) {
			System.out.println("Heap is Full");
			return;
		}
		arr[++size]=val;
		heapifyBottomUp(size);
	}
	public void heapifyBottomUp(int index) {
		if(index<=1) {
			return;
		}
		int parent = index/2;
		if(arr[index]<arr[parent]) {
			arr[parent] = (arr[parent]+arr[index])-(arr[index]=arr[parent]);
		}
		heapifyBottomUp(parent);
	}
	public static void main(String[] args) {
		MinHeap hp = new MinHeap(10);
		hp.add(10);
		hp.add(12);
		hp.add(5);
		hp.add(19);
		hp.add(3);
		hp.display();
	}
}
