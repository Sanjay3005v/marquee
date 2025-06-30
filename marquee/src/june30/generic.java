package june30;

import java.util.Arrays;

public class generic {
	public static void main(String[] args) {
		GO go = new GO();
		go.add("Hello");
		go.add(123);
		go.display(); 
		GC<String> gcStr = new GC<>();
		gcStr.add("Shadow");
		gcStr.add("Knight");
		gcStr.display(); 
		GC<Integer> gcInt = new GC<>();
		gcInt.add(10);
		gcInt.add(20);
		gcInt.display(); 
	}
}

class GO {
	Object[] val = new Object[10];
	int ind = -1;

	public void add(Object val) {
		if(ind==this.val.length-1) {
			return;
		}
		this.val[++ind]=val;
	}
	public Object[] getVal() {
		return val;
	}
	public void display() {
		System.out.println(Arrays.toString(val));
	}
}
class GC<T>{
	class Node<T>{
		T data;
		@Override
		public String toString() {
			return data+"";
		}
		Node(T val){
			this.data=val;
		}
	}
	Node<T>[] val = new Node[10];
	int ind = -1;
	public void add(T val) {
		if(ind==this.val.length-1) {
			return;
		}
		this.val[++ind]=new Node(val);
	}
	public Node<T>[] getVal() {
		return val;
	}
	public void display() {
		System.out.println(Arrays.toString(val));
	}
}
