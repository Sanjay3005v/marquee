package july8;

import java.util.Scanner;

public class Tree {

	class Node {
		int val;
		Node arr[];

		Node(int val) {
			this.val = val;
		}
	}
	Node root;
	int size;
	Scanner scan = new Scanner(System.in);
	public void add() {
		System.out.println("Enter the value to insert in root node");
		root = new Node(scan.nextInt());
		size++;
	}
	public void add(Node parent) {
		System.out.println("Enter yes for child nodes : "+parent.val);
		char ch = scan.next().toLowerCase().charAt(0);
		if(ch=='y') {
			System.out.println("Enter the number of child nodes : "+parent.val);
			int num = scan.nextInt();
			parent.arr=new Node[num];
			for(int i=0;i<num;i++) {
				System.out.println("Enter the value to insert : ");
				Node node = new Node(scan.nextInt());
				parent.arr[i]=node;
				add(parent.arr[i]);
			}
		}
	}
	public static void main(String[] args) {
		
	}
}
