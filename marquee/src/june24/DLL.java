package june24;

public class DLL {
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.append(10);
		list.append(20);
		list.append(30);
		list.prepend(10);
		list.prepend(20);
		list.prepend(30);
		list.insert(50, 3);
		list.deleteFirst();
		list.deleteLast();
		list.print();
		list.delete(3);
		list.print();
		list.printReverse();
		System.out.println(list.size());

	}

}

class DoublyLinkedList {
	Node head;
	Node tail;
	int size;

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return size;
	}

	public void append(int val) {
		Node node = new Node(val);
		if (isEmpty()) {
			head = tail = node;

		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
		size++;
		return;
	}

	public void prepend(int val) {
		Node node = new Node(val);
		if (isEmpty()) {
			head = tail = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
		size++;
		return;

	}

	public boolean insert(int val, int index) {
		if (index < 0) {
			return false;
		}
		if (index == 0) {
			prepend(val);
			return true;
		}
		if (index >= size) {
			append(val);
			return true;
		}
		Node node = new Node(val);
		if (isEmpty()) {
			head = tail = node;
		} else {
			Node temp = head;
			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}
			node.next = temp.next;
			node.prev = temp;
			temp.next = node;
			node.next.prev = node;
		}
		size++;
		return true;
	}

	public boolean deleteFirst() {
		if (isEmpty()) {
			return false;
		}
		if (size == 0) {
			head = tail = null;
		} else {
			head = head.next;
			head.prev = null;
		}
		size--;
		return true;
	}
	public boolean deleteLast() {
		if(isEmpty()) {
			return false;
		}
		if(size==1) {
			head=tail=null;
		}
		else{
			tail=tail.prev;
			tail.next=null;
		}
		size--;
		return true;
	}
	public boolean delete(int index) {
		if(isEmpty()||index<0||index>=size) {
			return false;
		}
		if(size()==1) {
			head=tail=null;
			
		}
		else if(index==0){
			deleteFirst(); 
		}
		else if(index==size-1) {
			deleteLast();
		}
		else {
			Node temp = head;
			for(int i=0;i<index-1;i++) {
				temp=temp.next;
			}
			temp.next=temp.next.next;
			temp.next.prev=temp;
		}
		size--;
		return true;
	}
	public void print() {
		if (isEmpty()) {
			return;
		} else {
			for (Node node = head; node != null; node = node.next) {
				System.out.print(node.val + " ");
			}
			System.out.println();
			return;
		}
	}
	public void printReverse() {
		if (isEmpty()) {
			return;
		} else {
			for (Node node = tail; node != null; node = node.prev) {
				System.out.print(node.val + " ");
			}
			System.out.println();
			return;
		}
	}
	public int getVal(int index) {
		if(index>=0 && index<size){
			Node temp=head;
			for(int i=0;i<index;i++) {
				temp=temp.next;
			}
			return temp.val;
		}
		return -1;
	}
}

class Node {
	int val;
	Node next;
	Node prev;

	Node(int val) {
		this.val = val;
	}
}
