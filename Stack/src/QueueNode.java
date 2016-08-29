
public class QueueNode {
	
	int data;
	QueueNode next;
	
	public QueueNode(int data){
		this.data = data;
		next=null;
	}
	public void display(){
		System.out.println(data);
	}
}
