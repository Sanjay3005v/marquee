package july15;

public class GraphUsingAdjacencyList {
	java.util.LinkedList<String> nodes;
	java.util.LinkedList<java.util.LinkedList<String>> neighbors;

	public GraphUsingAdjacencyList(java.util.LinkedList<String> nodes) {
		this.nodes = nodes;
		neighbors = new java.util.LinkedList<>();
		for (int i = 0; i < nodes.size(); i++) {
			neighbors.add(new java.util.LinkedList<>());
		}
	}

	public static void main(String[] args) {
		java.util.LinkedList<String> list = new java.util.LinkedList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");

		GraphUsingAdjacencyList g = new GraphUsingAdjacencyList(list);
		g.add(0, 1);
		g.add(0, 3);
		g.add(1, 2);
		g.add(1, 4);
		g.add(3, 4);
		g.add(2, 4);
		g.display();
	}

	public void add(int i, int j) {
		String first = nodes.get(i);
		String second = nodes.get(j);
		neighbors.get(i).add(second);
		neighbors.get(j).add(first);
	}
	
	public void display() {
		for (int i = 0; i < nodes.size(); i++) {
			System.out.print(nodes.get(i) + " : ");
			java.util.LinkedList<String> ne = neighbors.get(i);
			for (int j = 0; j < ne.size(); j++) {
				System.out.print(ne.get(j) + (j + 1 == ne.size() ? "" : "-->"));
			}
			System.out.println();

		}
	}
}
