package july10;

public class BST {

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
		BST tree = new BST();
		int[] arr = { 10, 5, 15, 3, 7, 12, 20 };
		for (int val : arr) {
			tree.add(val);
		}
		tree.display();
		System.out.println("========================");
		System.out.println(tree.contains(9));
	}

	public void add(int val) {
		root = add(root, val);
	}

	public Node add(Node node, int val) {
		if (node == null) {
			size++;
			return new Node(val);
		}
		if (node.val > val) {
			node.left = add(node.left, val);
		}
		if (node.val < val) {
			node.right = add(node.right, val);
		}
		return node;
	}

	public boolean contains(int val) {
		return contains(root, val);
	}

	public boolean contains(Node node, int val) {
		if (node == null) {
			return false;
		}
		if (node.val == val) {
			return true;
		} else if (node.val > val) {
			return contains(node.left, val);
		} else {
			return contains(node.right, val);
		}
	}

	public Node findMin() {
		return findMin(root);
	}

	public Node findMin(Node node) {
		if (node.left == null) {
			return node;
		}
		return findMin(node.left);
	}

	public void display() {
		display(root, 0);
	}

	private void display(Node node, int level) {
		if (node == null) {
			return;
		}

		display(node.right, level + 1);

		System.out.println("   ".repeat(level) + node.val);

		display(node.left, level + 1);
	}

}
