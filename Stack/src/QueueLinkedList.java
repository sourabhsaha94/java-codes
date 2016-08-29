import java.util.Queue;

public class QueueLinkedList {

	QueueNode front,rear;
	int numItems=0,size;
	
	public QueueLinkedList(QueueNode head,int size){
		this.front=this.rear=head;
		this.size=size;
	}
	
	public void add(int data){
		QueueNode temp=front;
		QueueNode node=new QueueNode(data);
		
		if(numItems<size)	//queue is not full
		{
			while(temp!=rear){
				temp=temp.next;
			}
			temp.next = node;
			rear = node;
			numItems++;
		}
		else
		{
			System.out.println("Full");
		}
	}
	
	public void remove(){
		QueueNode temp=front;
		
		if(numItems>0)	//queue is not empty
		{
			numItems--;
			front = front.next; 
		}
		else
			System.out.println("Empty");
	}
	
	public void display(){
		QueueNode temp = front.next;
		while(temp!=null){
			temp.display();
			temp=temp.next;
		}
		System.out.println("Front is "+front.data+"Rear is "+rear.data);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			QueueNode front = new QueueNode(-1);
			QueueLinkedList q = new QueueLinkedList(front,5);
			q.add(1);
			q.add(2);
			q.add(3);
			q.add(4);
			q.add(5);
			q.display();
			q.remove();
			q.remove();
			q.display();
	}

}
