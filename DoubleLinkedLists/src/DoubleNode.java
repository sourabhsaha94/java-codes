
public class DoubleNode {
	
	int data;
	DoubleNode next;
	DoubleNode prev;
	
	public DoubleNode(int _data){
		this.data =_data;
		next = null;
		prev = null;
	}
	
	public void displayNode(){
		System.out.println("Data is "+data);
	}	
	
}
