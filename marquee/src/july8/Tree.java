package july8;

import java.util.Scanner;

public class Tree {

	class Node {
		int val;
		Node[] arr;

		Node(int val) {
			this.val = val;
		}
	}

	Node root;
	int size;
	Scanner scan = new Scanner(System.in);

	public void add() {
		System.out.print("Enter the value to insert in root node: ");
		root = new Node(scan.nextInt());
		size++;
		add(root);
	}

	public void add(Node parent) {
		System.out.print("Does node " + parent.val + " have child nodes? (y/n): ");
		char ch = scan.next().toLowerCase().charAt(0);
		if (ch == 'y') {
			System.out.print("Enter number of child nodes for " + parent.val + ": ");
			int num = scan.nextInt();
			parent.arr = new Node[num];
			for (int i = 0; i < num; i++) {
				System.out.print("Enter value for child " + (i + 1) + ": ");
				Node node = new Node(scan.nextInt());
				parent.arr[i] = node;
				size++; 
				add(node); 
			}
		}
	}

	public void display() {
		System.out.println("\nTree Structure:");
		display(root, 0);
	}

	public void display(Node parent, int level) {
		System.out.println("  ".repeat(level) + parent.val);
		if (parent.arr != null) {
			for (Node node : parent.arr) {
				display(node, level + 1);
			}
		}
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.add();
		System.out.println("\nTotal nodes in tree: " + tree.size);
		tree.display();
	}
}
