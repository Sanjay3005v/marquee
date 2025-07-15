package july15;

public class GraphUsingAdjacencyMatrix {
	String nodes[];
	int matrix[][];

	public GraphUsingAdjacencyMatrix(String nodes[]) {
		this.nodes = nodes;
		matrix = new int[nodes.length][nodes.length];
	}

	public void display() {
		System.out.print("  ");
		for (String str : nodes) {
			System.out.print(str + " ");
		}
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(nodes[i] + " ");
			for (int n : matrix[i]) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void add(int i, int j) {
		if (matrix[i][j] == 0) {
			System.out.println("No Edges between the nodes");
		} else {
			matrix[i][j] = 1;
			matrix[j][i] = 1;
		}
	}

	public void delete(int i, int j) {
		matrix[i][j] = 0;
		matrix[j][i] = 0;
	}

	public static void main(String[] args) {
		String arr[] = { "A", "B", "C", "D", "E" };
		GraphUsingAdjacencyMatrix g = new GraphUsingAdjacencyMatrix(arr);
		g.add(0, 1);
		g.add(0, 3);
		g.add(1, 2);
		g.add(1, 4);
		g.add(3, 4);
		g.add(2, 4);
		g.display();
		g.delete(1, 4);
		g.display();
	}
}
