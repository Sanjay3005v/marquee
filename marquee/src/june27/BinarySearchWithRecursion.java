package june27;

import java.util.*;

public class BinarySearchWithRecursion {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size: ");
		int n = scan.nextInt();
		int[] nums = new int[n];
		System.out.println("Enter the elements: ");
		for (int i = 0; i < nums.length; i++) {
			nums[i] = scan.nextInt();
		}
		int target = scan.nextInt();
		Arrays.sort(nums);
		scan.close();
		System.out.println(binarySearch(nums, 0, nums.length - 1, target));
	}

	public static boolean binarySearch(int[] nums, int left, int right, int target) {
		if (left > right) {
			return false;
		}
		int mid = (left + right) / 2;
		if (nums[mid] == target) {
			return true;
		} else if (nums[mid] < target) {
			left = mid + 1;
			return binarySearch(nums, left, right, target);
		} else if (nums[mid] > target) {
			right = mid - 1;
			return binarySearch(nums, left, right, target);
		}

		return false;
	}
}
