package july15;

import java.util.LinkedList;

public class GraphUsingAdjacencyMatrix {
	static class Value {
		String data;
		int index;

		Value(String data, int index) {
			this.data = data;
			this.index = index;
		}
	}

	Value nodes[];
	int matrix[][];

	public GraphUsingAdjacencyMatrix(Value nodes[]) {
		this.nodes = nodes;
		matrix = new int[nodes.length][nodes.length];
	}

	public void display() {
		System.out.print("  ");
		for (Value val : nodes) {
			System.out.print(val.data + " ");
		}
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(nodes[i].data + " ");
			for (int n : matrix[i]) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void add(int i, int j) {
		matrix[i][j] = 1;
		matrix[j][i] = 1;

	}

	public void delete(int i, int j) {
		if (matrix[i][j] == 0) {
			System.out.println("No Edges between the nodes");
		} else {
			matrix[i][j] = 0;
			matrix[j][i] = 0;
		}
	}

	public Value[] getNeighbors(Value val) {
		Value[] arr = new Value[nodes.length];
		int j = 0;
		for (int i = 0; i < nodes.length; i++) {
			if (matrix[val.index][i] == 1) {
				arr[j++] = nodes[i];
			}
		}
		return arr;
	}

	public void BFS() {

		LinkedList<Value> queue = new LinkedList<>();
		boolean[] visited = new boolean[nodes.length];
		queue.addLast(nodes[0]);
		visited[0] = true;
		while (!queue.isEmpty()) {
			Value cur = queue.removeFirst();
			for (Value val : getNeighbors(cur)) {
				if (val == null) {
					continue;
				}
				if (!visited[val.index]) {
					queue.addLast(val);
					visited[val.index] = true;
				}
			}
			System.out.print(cur.data + "  ");
		}
		System.out.println();
	}

	public void DFS() {
		LinkedList<Value> stack = new LinkedList<>();
		boolean[] visited = new boolean[nodes.length];
		stack.addLast(nodes[0]);
		visited[0] = true;
		while (!stack.isEmpty()) {
			Value cur = stack.removeLast();
			for (Value val : getNeighbors(cur)) {
				if (val == null) {
					continue;
				}
				if (!visited[val.index]) {
					stack.addLast(val);
					visited[val.index] = true;
				}
			}
			System.out.print(cur.data + "  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Value arr[] = { new Value("A", 0), new Value("B", 1), new Value("C", 2), new Value("D", 3), new Value("E", 4) };
		GraphUsingAdjacencyMatrix g = new GraphUsingAdjacencyMatrix(arr);
		g.add(0, 1);
		g.add(0, 3);
		g.add(0, 2);
		g.add(1, 4);
		g.add(3, 4);
		g.add(2, 3);
		g.display();
		g.display();
		g.BFS();
		g.DFS();
	}
}
