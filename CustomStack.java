package wiley.intern.intro;


public class CustomStack {
	int i;
	int size;
	public int[] stack;
	
	public CustomStack(int size) {
		this.i = -1;
		this.size = size;
		stack = new int[size];
	}
	
	
	public boolean isEmpty() {
		return (this.i<0);
	}
	
	public boolean isFull() {
		return (this.i==this.size-1);
	}
	
	public void push(int ele) {
		if(this.isFull()) {
			System.out.println("Stack over flow");
			return;
		}
		
		this.i++;
		this.stack[i] = ele;
	}
	
	public int pop() {
		if(this.isEmpty()) {
			return -1;
		}
		int ele = this.stack[this.i];
		this.i--;
		return ele;
	}
	
	public int peek() {
		if(this.isEmpty()) {
			return -1;
		}
		return this.stack[this.i];
	}
}

