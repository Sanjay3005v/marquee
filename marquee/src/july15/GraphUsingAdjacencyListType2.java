package july15;

import java.util.LinkedList;

public class GraphUsingAdjacencyListType2 {
	static class Value {
		String data;
		int index;
		LinkedList<Value> neighbors;

		public Value(String data, int index) {
			this.data = data;
			this.index = index;
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
		f.neighbors.add(s);
		s.neighbors.add(f);
	}

	public void display() {
		for (Value val : nodeList) {
			System.out.print(val.data + " : ");
			for (int i = 0; i < val.neighbors.size(); i++) {
				System.out.print(val.neighbors.get(i).data + (i == val.neighbors.size() - 1 ? "" : "--->"));
			}
			System.out.println();
		}
	}

	public void BFS() {
		LinkedList<Value> queue = new LinkedList<Value>();
		boolean[] visited = new boolean[nodeList.size()];
		queue.addLast(nodeList.get(0));
		visited[0] = true;
		while (!queue.isEmpty()) {
			Value cur = queue.removeFirst();
			for (Value val : cur.neighbors) {
				if (!visited[val.index]) {
					queue.addLast(val);
					visited[val.index] = true;
				}
			}
			System.out.print(cur.data + " ");
		}

	}

	public static void main(String[] args) {
		LinkedList<Value> list = new LinkedList<>();
		list.add(new Value("A", 0));
		list.add(new Value("B", 1));
		list.add(new Value("C", 2));
		list.add(new Value("D", 3));
		list.add(new Value("E", 4));

		GraphUsingAdjacencyListType2 g = new GraphUsingAdjacencyListType2(list);
		g.add(0, 1);
		g.add(0, 3);
		g.add(1, 2);
		g.add(1, 4);
		g.add(3, 4);
		g.add(2, 4);
		g.display();
		g.BFS();

	}
}
