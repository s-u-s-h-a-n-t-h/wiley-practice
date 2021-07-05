package wiley.intern.intro;

//void method() throws Exception{
//	
//}
//
//static class Node{
//	int data;
//	Node prev;
//	Node next;
//	Node(int data){
//		this.data = data;
//		this.prev = null;
//		this.next = null;
//	}
//	
//}
//
//static Node add(Node head, int data) {
//	if(head==null) {
//		System.out.println("add, Inside if");
//		return null;
//	}
//	Node temp = head;
//	while(temp.next!=null) {
//		temp = temp.next;
//	}
//	Node node = new Node(data);
//	temp.next = node;
//	node.prev = temp;
//	return head;
//}
//
//static Node remove(Node head) {
//	if(head==null) {
//		System.out.println("Inside if");
//		return null;
//	}
//	if(head.next==null) {
//		head = null;
//		return null;
//	}
//	Node temp = head;
//	Node prevTemp = temp;
//	temp = temp.next;
//	while(temp.next!=null) {
//		prevTemp=temp;
//		temp=temp.next;
//	}
//	prevTemp.next = null;
//	temp.prev = null;
//	temp = null;
//	return head;
//}
//
//static void display(Node head) {
//	Node temp = head;
//	while(temp!=null) {
//		System.out.println(temp.data);
//		temp = temp.next;
//	}
//}


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employ implements Comparable<Employ>{
	String name;
	String city;
	double salary;
	
	Employ(String name, String city, double salary){
		this.name = name;
		this.city = city;
		this.salary = salary;
	}

@Override public int compareTo(Employ emp){
	if(city.compareTo(emp.city)>0) {
		return 1;
	}
	else if(city.compareTo(emp.city)<0) {
		return -1;
	}
	else {
		if(salary>emp.salary) {
			return 1;
		}
		else if(salary<emp.salary) {
			return -1;
		}
		else {
			return 0;
		}
	}
	}
}
	


public class Scratch{
	
	
	public static void main(String args[]) {
		List<Employ> l = new ArrayList<Employ>();
		l.add(new Employ("Sushanth", "Banglore", 10000.0));
		l.add(new Employ("Shubham", "Delhi", 10000.0));
		l.add(new Employ("Anil", "Banglore", 2000.0));
		
		for(Employ emp: l) {
			System.out.println(emp.name);
			System.out.println(emp.city);
			System.out.println(emp.salary);
			System.out.println();
		}
		
		System.out.println("--------------------------");
		
		Collections.sort(l);
		
		for(Employ emp: l) {
			System.out.println(emp.name);
			System.out.println(emp.city);
			System.out.println(emp.salary);
			System.out.println();
		}
		
	}
}
