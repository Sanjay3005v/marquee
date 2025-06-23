package june17;

public class Array {

	int[] arr = new int[20];
	int index = -1;

	public boolean isEmpty() {
		return index == -1;
	}

	public boolean isFull() {
		return index == arr.length - 1;
	}

	public boolean append(int num) {
		if (isFull()) {
			sizeIncrease();
		}
		arr[++index] = num;
		return true;
	}

	public boolean prepend(int num) {
		if (isFull()) {
			sizeIncrease();
		} else {
			for (int i = index; i >= 0; i--) {
				arr[i + 1] = arr[i];
			}
		}
		arr[0] = num;
		index++;
		return true;
	}

	public boolean insert(int index, int num) {
		if (index < 0 || index >= arr.length) {
			return false;
		}
		if (isFull()) {
			sizeIncrease();
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
		} else {
			for (int i = 1; i <= index; i++) {
				arr[i - 1] = arr[i];
			}
			arr[index--] = 0;
			return true;
		}
	}

	public boolean deleteLast() {
		if (isEmpty()) {
			return false;
		} else {
			arr[index--] = 0;
			return true;
		}
	}

	public boolean deleteIndex(int index) {
		if (isEmpty() || index < 0 || index >= arr.length) {
			return false;
		} else if (index == 0) {
			deleteFirst();
			return true;
		} else if (this.index == index) {
			deleteLast();
			return true;
		} else {
			for (int i = index; i < this.index; i++) {
				arr[i] = arr[i + 1];
			}
			arr[this.index--] = 0;
			return true;
		}
	}

	public void sizeIncrease() {
		int[] arr1 = new int[arr.length * 2];
		for (int i = 0; i < arr.length; i++) {
			arr1[i] = arr[i];
		}
		arr = arr1;
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
		Array a = new Array();
		a.print();
		System.out.println(a.append(25));
		System.out.println(a.append(10));
		System.out.println(a.prepend(11));
		System.out.println(a.insert(1, 23));
		System.out.println(a.insert(7, 27));
		System.out.println(a.insert(0, 30));
		System.out.println(a.deleteFirst());
		System.out.println(a.deleteLast());
		System.out.println(a.deleteIndex(2));
		a.print();
	}
}
