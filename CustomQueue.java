package wiley.intern.intro;

public class CustomQueue {
	int front, rear;
	int size;
	
	int[] queue;
	
	public CustomQueue(int size) {
		this.size = size;
		queue = new int[size];
		front = -1;
		rear = 0;
	}
	
	public void enqueue(int ele) {
		if(this.rear==this.size) {
			System.out.println("Queue is full, cannot add " + ele);
			return;
		}
		
		if(this.front==-1) {
			this.front = 0;
		}
		this.queue[this.rear] = ele;
		this.rear++;
	}
	
	public int dequeue() {
		if(this.front==-1 || this.front==this.rear) {
			return -1;
		}
		
		int e = this.queue[this.front];
		this.front++;
		return e;
	}
	
}

