package wiley.intern.intro;

public class CustomCircularQueue {
	int size;
	int front, rear;
	int[] circularQ;
	
	public CustomCircularQueue(int size){
		circularQ = new int[size];
		front = -1;
		rear = -1;
	}
	
	public void enqueue(int ele) {
		if((this.front==0 && this.rear==this.size-1) || (this.rear+1 ==this.front)) {
			System.out.println("Queue is full");
			return;
		}
		if(this.front==-1) {
			this.front = 0;
		}
		
		this.rear =  (this.rear+1)%size;
		circularQ[this.rear] = ele;
	}
	
	public int dequeue() {
		if(this.front==-1) {
			return -1;
		}
		int e = this.circularQ[this.front];
		
		if(this.front==this.rear) {
			this.front = -1;
			this.rear = -1;
		}
		else {
			this.front = (this.front+1)%size;
		}
		return e;
	}
	
}

