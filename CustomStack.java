package wiley.intern.intro;

import java.util.ArrayList;

public class CustomStack {
	public ArrayList<Integer> stack = new ArrayList<Integer>();
	
	public boolean isEmpty() {
		return (this.stack.size()==0);
	}
	
	public void push(int ele) {
		this.stack.add(ele);
	}
	
	public int pop() {
		if(this.isEmpty()) {
			return -1;
		}
		return this.stack.remove(this.stack.size()-1);
	}
	
	public int peek() {
		if(this.isEmpty()) {
			return -1;
		}
		return this.stack.get(this.stack.size()-1);
	}
}

