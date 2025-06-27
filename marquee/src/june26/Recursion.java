package june26;

import java.util.Scanner;

public class Recursion {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number1: ");
		int n = scan.nextInt();
		System.out.println("Enter the number2: ");
		int p = scan.nextInt();
		scan.close();
		evennums(n);
		oddnums(n);
		System.out.println(sum(n));
		System.out.println(pow(n, p));
		System.out.println(multiply(n, p));
		divisibleBy2and3(n);
	}
	
	public static int multiply(int n, int p) {
		if(p==0) {
			return 0;
		}
		return n+multiply(n,p-1);
	}
	public static int pow(int n,int p) {
		if(p<=0) {
			return 1;
		}
		return n*pow(n,p-1);
	}
	public static int sum(int n) {
		if (n == 1) {
			return 1;
		}
		return n + sum(n - 1);
	}

	public static void evennums(int n) {
		if (n < 2) {
			System.out.println();
			return;
		}
		if (n % 2 == 0) {
			System.out.print(n + " ");
		}
		evennums(n - 1);
	}

	public static void oddnums(int n) {
		if (n < 1) {
			System.out.println();
			return;
		}
		if (n % 2 == 1) {
			System.out.print(n + " ");
		}
		oddnums(n - 1);
	}

	public static void divisibleBy2and3(int n) {
		if (n < 1) {
			System.out.println();
			return;
		}
		if (n % 2 == 0 && n % 3 == 0) {
			System.out.print(n + " ");
		}
		divisibleBy2and3(n - 1);
	}
}
