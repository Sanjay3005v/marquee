package july10;

import java.util.LinkedList;

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

		System.out.println("Display");
		tree.display();

		System.out.println("========================");
		System.out.println("Contains 9? " + tree.contains(9)); // false
		System.out.println("Contains 7? " + tree.contains(7)); // true

		tree.inorder();
		tree.preorder();
		tree.postorder();
		tree.levelorder();
		System.out.println();
		System.out.println("========================");
		System.out.println("Minimum value: " + tree.findMin().val);

		System.out.println("========================");
		tree.delete(3);
		tree.display();

		System.out.println("========================");
		tree.delete(15);
		tree.display();

		System.out.println("========================");
		tree.delete(5);
		tree.display();

		System.out.println("========================");
		tree.inorder();
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

	public void delete(int val) {
		root = delete(root, val);
	}

	public Node delete(Node node, int val) {
		if (node == null) {
			return null;
		}
		if (node.val < val) {
			node.right = delete(node.right, val);
		} else if (node.val > val) {
			node.left = delete(node.left, val);
		} else {
			if (node.left != null && node.right != null) {
				int min = findMin(node.right).val;
				node.val = min;
				node.right = delete(node.right, min);
			} else if (node.left != null) {
				size--;
				return node.left;
			} else if (node.right != null) {
				size--;
				return node.right;
			} else {
				size--;
				return null;
			}
		}
		return node;
	}

	public void preorder() {
		System.out.println();
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
		System.out.println();
		System.out.println("PostOrder Traversal");
		postorder(root);
	}

	public void postorder(Node parent) {
		if (parent.left != null) {
			postorder(parent.left);
		}
		if (parent.right != null) {
			postorder(parent.right);
		}
		System.out.print(parent.val + " ");
	}

	public void inorder() {
		System.out.println();
		System.out.println("InOrder Traversal");
		inorder(root);
	}

	public void inorder(Node parent) {
		if (parent.left != null) {
			inorder(parent.left);
		}
		System.out.print(parent.val + " ");
		if (parent.right != null) {
			inorder(parent.right);
		}
	}

	public void levelorder() {
		System.out.println();
		System.out.println("levelOrder Traversal");
		levelorder(root);
	}

	public void levelorder(Node parent) {
		LinkedList<Node> queue = new LinkedList<>();

		queue.addLast(parent);
		while (!queue.isEmpty()) {
			Node node = queue.peek();
			if (node.left != null) {
				queue.addLast(node.left);
			}
			if (node.right != null) {
				queue.addLast(node.right);
			}
			System.out.print(node.val + " ");
			queue.removeFirst();
		}
	}

	public void display() {
		display(root, 0);
	}

	public void display(Node node, int level) {
		if (node == null) {
			return;
		}

		display(node.right, level + 1);

		System.out.println("   ".repeat(level) + node.val);

		display(node.left, level + 1);
	}

}
