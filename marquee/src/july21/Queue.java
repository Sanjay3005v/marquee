package july21;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Queue {
	public static void main(String[] args) {
		PriorityQueue q = new PriorityQueue<>(new changeP());

		q.add(10);
		q.add(7);
		q.add(12);
		q.add(3);
		q.add(11);
		System.out.println(q.peek());
		System.out.println(q.poll());
		System.out.println(q);
	}

}

class changeP implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub

		return o2.compareTo(o1);
	}
}
