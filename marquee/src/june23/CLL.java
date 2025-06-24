package june23;

public class CLL {
	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
		list.prepend(10);
		list.prepend(20);
		list.prepend(30);
		list.append(40);
		list.append(50);
		list.insert(22, 3);
		list.print();
		System.out.println(list.getVal(3));
		list.delete(4);
		list.print();
	}
}

class CircularLinkedList {
	Node head;
	Node tail;
	int size;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public boolean insert(int val, int index) {
		if (index < 0) {
			return false;
		}
		Node node = new Node(val);
		if (isEmpty()) {
			head = node;
			tail = node;
			node.next = node;

		} else if (index == 0) {
			tail.next = node;
			node.next = head;
			head = node;

		} else if (index >= size) {
			tail.next = node;
			node.next = head;
			tail = node;

		} else {
			Node temp = head;
			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}
			node.next = temp.next;
			temp.next = node;
		}
		size++;
		return true;
	}

	public boolean append(int val) {
		return insert(val, size);
	}

	public boolean prepend(int val) {
		return insert(val, 0);
	}

	public boolean delete(int index) {
		if(isEmpty() || index<0 || index>size-1) {
			return false;
		}
		else {
			if(size()==1) {
				head=tail=null;
			}
			else {
				if(index==0) {
					head=head.next;
					tail.next=head;
				}
				else if(index==size-1){
					Node temp=head;
					for(int i=1;i<size-1;i++) {
						temp=temp.next;
					}
					tail=temp;
					tail.next=head;
				}
				else {
					Node temp=head;
					for(int i=1;i<index-1;i++) {
						temp=temp.next;
					}
					temp.next=temp.next.next;
				}
			}
		}
		size--;
		return true;
	}
	public boolean deleteFirst() {
		return delete(0);
	}
	public boolean deleteLast() {
		return delete(size-1);
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

	public void print() {
		if (isEmpty()) {
			return;
		}
		Node temp = head;
		for (int i = 0; i < size; i++) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}

class Node {
	int val;
	Node next;

	Node(int val) {
		this.val = val;
	}
}
