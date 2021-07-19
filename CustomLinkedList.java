package wiley.intern.intro;

class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}

public class CustomLinkedList {
	
	public Node head = null;
	
	public Node add(int data) {
		Node head = this.head;
		if(head==null) {
			return new Node(data);
		}
		
		Node temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		
		Node node = new Node(data);
		temp.next = node;
		return head;
	}
	
	public void traverse() {
		Node temp = this.head;
		while(temp!=null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
}

