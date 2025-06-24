package june17;

public class DynamicArrays {

	int[] arr = new int[5];
	int index = -1;

	public boolean isEmpty() {
		return index == -1;
	}

	public boolean isFull() {
		return index == arr.length - 1;
	}

	public int size() {
		return index + 1;
	}

	public boolean append(int num) {
		if (isFull()) {
			int[] newArr = new int[arr.length * 2];
			for (int i = 0; i < arr.length; i++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
		}
		arr[++index] = num;
		return true;
	}

	public boolean prepend(int num) {
		if (isFull()) {
			int[] newArr = new int[arr.length * 2];
			for (int i = 0; i < arr.length; i++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
		}
		for (int i = index; i >= 0; i--) {
			arr[i + 1] = arr[i];

		}
		arr[0] = num;
		index++;
		return true;
	}

	public boolean insert(int index, int num) {
		if (index < 0 || index > arr.length) {
			return false;
		}
		if (isFull()) {
			int[] newArr = new int[arr.length * 2];
			for (int i = 0; i < arr.length; i++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
		}
		if (index == 0) {
			prepend(num);
			return true;
		}
		if (this.index <= index && index < arr.length) {
			append(num);
			return true;
		} else {
			for (int i = this.index; i >= index; i--) {
				arr[i + 1] = arr[i];
			}
			arr[index] = num;
			this.index++;
			return true;
		}
	}

	public boolean deleteFirst() {
		if (isEmpty()) {
			return false;
		}

		for (int i = 1; i <= index; i++) {
			arr[i - 1] = arr[i];
		}
		arr[index--] = 0;
		if (size() <= arr.length / 2) {
			int[] newArr = new int[arr.length / 2];
			for (int i = 0; i <= index; i++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
		}
		return true;

	}

	public boolean deleteLast() {
		if (isEmpty()) {
			return false;
		}
		arr[index--] = 0;
		if (size() <= arr.length / 2) {
			int[] newArr = new int[arr.length / 2];
			for (int i = 0; i <= index; i++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
		}
		return true;
	}

	public boolean deleteIndex(int index) {
		if (isEmpty() || index < 0 || index >= arr.length) {
			return false;
		}
		if (index == 0) {
			deleteFirst();
			return true;
		}
		if (this.index == index) {
			deleteLast();
			return true;
		}

		for (int i = index; i < this.index; i++) {
			arr[i] = arr[i + 1];
		}
		arr[this.index--] = 0;
		if (size() <= arr.length / 2) {
			int[] newArr = new int[arr.length / 2];
			for (int i = 0; i <= index; i++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
		}

		return true;

	}

	public int getValue(int index) {
		if (index < 0 || index > this.index) {
			return -1;
		}
		return arr[index];
	}

	public void print() {
		if (isEmpty()) {
			System.out.println("{}");
			return;
		}
		String str = "{" + arr[0];
		for (int i = 1; i <= index; i++) {
			str += ", " + arr[i];
		}
		str += "}";
		System.out.println(str);
	}

	public static void main(String[] args) {
		DynamicArrays a = new DynamicArrays();
		a.print();
		System.out.println(a.prepend(10));
		System.out.println(a.prepend(20));
		System.out.println(a.prepend(30));
		System.out.println(a.prepend(40));
		System.out.println(a.prepend(50));
		System.out.println(a.prepend(90));
		System.out.println(a.getValue(3));
		System.out.println("Capacity=" + a.arr.length);
		System.out.println("Size=" + a.size());
		a.print();
		System.out.println(a.deleteLast());
		System.out.println("Capacity=" + a.arr.length);
		System.out.println("Size=" + a.size());
		a.print();
	}
}
