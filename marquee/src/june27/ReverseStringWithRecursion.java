package june27;

import java.util.Scanner;

public class ReverseStringWithRecursion {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the String: ");
		String str = scan.next();
		scan.close();
		System.out.println(reverse(str));
	}
	public static String reverse(String str) {
		if(str.length()==0) {
			return "";
		}
		return str.charAt(str.length()-1)+reverse(str.substring(0,str.length()-1));
	}
}
