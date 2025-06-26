package june25;

import java.util.Arrays;

public class Sort {
	public static void main(String[] args) {
		int[] arr = { 9, 5, 8, 7, 6, 4, 2, 1, 3 };
		insertion(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void bubble(int[] arr) {
		boolean swap;
		for (int i = 0; i < arr.length - 1; i++) {
			swap = false;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swap = true;
				}
			}
			if (!swap) {
				break;
			}
		}
	}

	public static void selection(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}

	public static void insertion(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}
}
