package july18;

import java.util.ArrayList;

class Pen {
	int price;
	String color;

	Pen(String color, int price) {
		this.color = color;
		this.price = price;
	}
}

public class Arraylist {

	public static void main(String[] args) {
		ArrayList o = new ArrayList();
		ArrayList a = new ArrayList();
		o.add(10);
		o.add(a);
		o.add(200L);
		o.add(true);
		a.add(null);
		a.add("list");
		a.add(200.5132);
		o.add(o);
		o.addAll(a);
		o.addFirst("first");
		o.addLast("last");
		System.out.println(o);
		o.remove(1);// index
		o.remove("last");
		o.remove(a.remove("list"));
		o.removeFirst();
		o.removeLast();
		System.out.println(o);
		o.removeAll(o);
		System.out.println(o);
		System.out.println();
		o.add(new Pen("red", 10));
		System.out.println(o);
	}
}
