package july15;

import java.util.LinkedList;

public class GraphUsingAdjacencyListType2 {
	static class Value {
		String data;
		LinkedList<String> neighbors;

		public Value(String data) {
			this.data = data;
			neighbors = new LinkedList<>();
		}
	}

	LinkedList<Value> nodeList;

	public GraphUsingAdjacencyListType2(LinkedList<Value> nodeList) {
		this.nodeList = nodeList;
	}

	public void add(int i, int j) {
		Value f = nodeList.get(i);
		Value s = nodeList.get(j);
		f.neighbors.add(s.data);
		s.neighbors.add(f.data);
	}

	public void display() {
		for (Value val : nodeList) {
			System.out.print(val.data + " : ");
			for (int i = 0; i < val.neighbors.size(); i++) {
				System.out.print(val.neighbors.get(i) + (i == val.neighbors.size() - 1 ? "" : "--->"));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		LinkedList<Value> list = new LinkedList<>();
		list.add(new Value("A"));
		list.add(new Value("B"));
		list.add(new Value("C"));
		list.add(new Value("D"));
		list.add(new Value("E"));

		GraphUsingAdjacencyListType2 g = new GraphUsingAdjacencyListType2(list);
		g.add(0, 1);
		g.add(0, 3);
		g.add(1, 2);
		g.add(1, 4);
		g.add(3, 4);
		g.add(2, 4);
		g.display();

	}
}
