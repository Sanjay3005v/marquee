package june26;

public class StackWithArrays {

	public static void main(String[] args) {
		ArrayStack list = new ArrayStack();
		list.push(10);
		list.push(20);
		list.push(30);
		list.push(40);
		list.push(50);
		System.out.println(list.pop());
		System.out.println(list.pop());
		list.display();
	}

}

class ArrayStack {
	int[] arr = new int[10];
	int top = -1;

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == arr.length - 1;
	}

	public void push(int val) {
		if (isFull()) {
			int[] temp = new int[arr.length * 2];
			for (int i = 0; i < arr.length; i++) {
				temp[i] = arr[i];
			}
			arr = temp;
		}
		arr[++top] = val;
		return;
	}

	public int pop() {
		if (isEmpty()) {
			System.err.println("StackUnderflow");
			return -1;
		}
		if (top < arr.length / 2) {
			int[] temp = new int[arr.length / 2];
			for (int i = 0; i <= top; i++) {
				temp[i] = arr[i];
			}
			arr = temp;
		}
		return arr[top--];
	}

	public int peek() {
		if (isEmpty()) {
			System.err.println("StackUnderFlow");
			return -1;
		} else {
			return arr[top];
		}
	}

	public void display() {
		if (isEmpty()) {
			System.out.println();
		} else {
			for (int i = 0; i <= top; i++) {
				System.out.print(arr[i] + " ");
			}
		}
	}
}
