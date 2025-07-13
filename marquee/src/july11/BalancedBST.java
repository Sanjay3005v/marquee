package july11;

public class BalancedBST {
	class Node {
		int val;
		Node left;
		Node right;
		int height;

		Node(int val) {
			this.val = val;
		}
	}

	Node root;
	int size;

	public static void main(String[] args) {	
		BalancedBST tree = new BalancedBST();
		int[] arr = { 10, 5, 15, 3, 7, 12, 20 };
		for (int val : arr) {
			tree.add(val);
		}
		tree.display();
	}

	public int height(Node node) {
		return node == null ? -1 : node.height;
	}

	public void add(int val) {
		root = add(root, val);
	}

	public Node add(Node parent, int val) {
		if (parent == null) {
			size++;
			return new Node(val);
		}
		if (parent.val > val) {
			parent.left = add(parent.left, val);
		} else if (parent.val < val) {
			parent.right = add(parent.right, val);
		}
		size++;
		parent.height = Math.max(height(parent.left), height(parent.right))+1;
		return parent;
	}

//	public Node Rotate(Node node) {
//		if (height(node.left) - height(node.right) > 1) {
//			
//		}
//	}

	public Node leftRotate(Node node) {
		Node mid = node.right;
		Node ro = mid.left;
		mid.left = node;
		mid.right = ro;
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		mid.height = Math.max(height(mid.left), height(mid.right)) + 1;
		return mid;
	}

	public Node rightRotate(Node node) {
		Node mid = node.left;
		Node ro = mid.right;
		mid.right = node;
		node.left = ro;
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		mid.height = Math.max(height(mid.left), height(mid.right)) + 1;
		return mid;
	}

	public void display() {
		System.out.println("Display");
		display(root, 0);
	}

	public void display(Node node, int level) {
		if (node == null) {
			return;
		}
		display(node.right, level + 1);
		System.out.println("|    ".repeat(level >= 1 ? level - 1 : level) + (level >= 1 ? "|--->" : "") + node.val + ","
				+ node.height);
		display(node.left, level + 1);
	}
}
