
public class QueueArray {
	
	int rear,front,size;
	Integer elements[];
	
	public QueueArray(int Size){
		this.size = Size;
		elements = new Integer[Size];
		rear=front=0;
		for(int i=0;i<Size;i++){
			elements[i]=Integer.MIN_VALUE;
		}
		
	}
	
	public boolean isEmpty(){
		if((rear%size-front%size)==0 && elements[rear%size]==Integer.MIN_VALUE){
			return true;
		}
		else return false;
	}
	public boolean isFull(){
		if((rear%size-front%size)==0 && elements[rear%size]!=Integer.MIN_VALUE){
			return true;
		}
		else
			return false;
	}
	
	public void add(Integer element){
		if(!isFull()){
			elements[rear%size]=element;
			rear++;
		}
		else
			System.out.println("Queue is full");
	}
	
	public void remove(){
		if(!isEmpty()){
			elements[front%size]=Integer.MIN_VALUE;
			front++;
		}
		else
			System.out.println("Queue is empty");
	}
	
	public void display(){
		
		for(int i=0;i<size;i++){
			if(elements[i]!=Integer.MIN_VALUE)
				System.out.println(elements[i]);
		}
		System.out.println("Front is "+front%size+" Rear is "+(rear-1)%size);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QueueArray q = new QueueArray(5);
		q.add((int) (Math.random()*10));
		q.add((int) (Math.random()*10));
		q.add((int) (Math.random()*10));
		q.add((int) (Math.random()*10));
		q.add((int) (Math.random()*10));
		q.display();
		q.remove();
		q.remove();
		q.display();
	}

}
