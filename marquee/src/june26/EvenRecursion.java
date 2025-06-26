package june26;

import java.util.Scanner;

public class EvenRecursion {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int n = scan.nextInt();
		scan.close();
		evennums(n);
		oddnums(n);
		divisibleBy2and3(n);
	}
	public static void evennums(int n) {
		if(n<2) {
			System.out.println();
			return;
		}
		if(n%2==0) {
			System.out.print(n+" ");
		}
		evennums(n-1);
	}
	public static void oddnums(int n) {
		if(n<1) {
			System.out.println();
			return;
		}
		if(n%2==1) {
			System.out.print(n+" ");
		}
		oddnums(n-1);
	}
	public static void divisibleBy2and3(int n) {
		if(n<1) {
			System.out.println();
			return;
		}
		if(n%2==0 && n%3==0) {
			System.out.print(n+" ");
		}
		divisibleBy2and3(n-1);
	}
}
