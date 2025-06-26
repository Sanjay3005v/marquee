package june26;

public class StackWithLL {
	public static void main(String[] args) {
		StackLL list = new StackLL();
		list.push(10);
		list.push(20);
		list.push(30);
		list.push(40);
		list.push(50);
		list.display();
		System.out.println(list.pop());
		System.out.println(list.pop());
		System.out.println(list.pop());
		System.out.println(list.pop());
		System.out.println(list.pop());
		System.out.println(list.pop());
		list.display();
	}
	
}
class StackLL{
	Node top;
	
	public boolean isEmpty() {
		return top==null;
	}
	public void push(int val) {
		Node node = new Node(val);
		node.next=top;
		top=node;
		return;
	}
	public int pop() {
		if (isEmpty()) {
			System.out.println("StackUnderflow");
			return -1;
		}
		int val=top.val;
		top=top.next;
		return val;
	}
	public int peek() {
		if (isEmpty()) {
			System.out.println("StackUnderflow");
			return -1;
		}
		return top.val;
	}
	public void display() {
		if (isEmpty()) {
			System.out.println("StackUnderflow");
			return;
		}
		Node node = top;
		do {
			System.out.print(node.val+" ");
			node=node.next;
		}while(node!=null);
		return;
	}
}
class Node{
	int val;
	Node next;
	Node(int val){
		this.val = val;
	}
}
