package july18;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

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
		//o.addFirst("first");
		o.addLast("last");
		//System.out.println(o);
		o.remove(1);// index
		o.remove("last");
		o.remove(a.remove("list"));
		//o.removeFirst();
		o.removeLast();
		o.add(15);
		o.add(25);
		//System.out.println(o);
		//o.removeAll(o);
//		System.out.println(o);
		//System.out.println();
		o.add(new Pen("red", 10));
//		System.out.println(o);
//		System.out.println();
		Iterator itr = o.iterator();
		while(itr.hasNext()) {
			Object val = itr.next();
			if (val instanceof Integer) {
				Integer new_name = (Integer) val;
				
				System.out.print(new_name+"  ");
				
			}
			
		}
		System.out.println();
		for(Object val:o) {
			System.out.print(val+"   ");
		}
		System.out.println();
		ListIterator li = o.listIterator();
		System.out.println(li.next());
		System.out.println(li.nextIndex());
	}
}
