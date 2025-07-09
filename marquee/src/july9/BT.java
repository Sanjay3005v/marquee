package july9;

import java.util.Scanner;

public class BT {
	Scanner scan = new Scanner(System.in);

	class Node {
		int val;
		Node left;
		Node right;

		Node(int val) {
			this.val = val;
		}
	}

	Node root;
	int size;

	public static void main(String[] args) {
		BT tree = new BT();
		tree.insert();
		tree.display();
		tree.preorder();
	}

	public void insert() {
		System.out.print("Enter the value to insert in root node: ");
		root = new Node(scan.nextInt());
		size++;
		insert(root);
	}

	public void insert(Node parent) {
		System.out.print("Does node " + parent.val + " have Left node? (y/n): ");
		char ch = scan.next().toLowerCase().charAt(0);
		if (ch == 'y') {
			System.out.print("Enter value for left child : ");
			parent.left = new Node(scan.nextInt());
			size++;
			insert(parent.left);
		}
		System.out.print("Does node " + parent.val + " have Right nodes? (y/n): ");
		char c = scan.next().toLowerCase().charAt(0);
		if (c == 'y') {
			System.out.print("Enter value for right child : ");
			parent.right = new Node(scan.nextInt());
			size++;
			insert(parent.right);
		}
	}

	public void display() {
		System.out.println("Tree Structure:");
		display(root, 0);
	}

	public void display(Node parent, int level) {
		System.out.println("  ".repeat(level) + parent.val);
		if (parent.left != null) {
			display(parent.left, level + 1);
		}
		if (parent.right != null) {
			display(parent.right, level + 1);
		}
	}

	public void preorder() {
		System.out.println("PreOrder Traversal");
		preorder(root);
	}

	public void preorder(Node parent) {
		System.out.print(parent.val + " ");
		if (parent.left != null) {
			preorder(parent.left);
		}
		if (parent.right != null) {
			preorder(parent.right);
		}
	}

	public void postorder() {
		postorder(root);
	}

	public void postorder(Node parent) {
		if (parent.left != null) {
			preorder(parent.left);
		}
		if (parent.right != null) {
			preorder(parent.right);
		}
		System.out.print(parent.val + " ");
	}

	public void inorder() {
		inorder(root);
	}

	public void inorder(Node parent) {
		if (parent.left != null) {
			preorder(parent.left);
		}
		System.out.print(parent.val + " ");
		if (parent.right != null) {
			preorder(parent.right);
		}
	}
}
