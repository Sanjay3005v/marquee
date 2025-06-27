package june27;

import java.util.Scanner;

public class PalindromeWithRecursion {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the String: ");
		String str = scan.next();
		scan.close();
		System.out.println(palindrome(str));
	}

	public static boolean palindrome(String str) {
		if (str.length() < 2) {
			return true;
		}
		return str.charAt(0) == str.charAt(str.length() - 1) ? palindrome(str.substring(1, str.length() - 1)) : false;
	}
}
