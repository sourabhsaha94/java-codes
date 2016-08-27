public class SingleNode{
	
	int data;
	SingleNode next;
	public SingleNode(int data){
		this.data = data;
		this.next = null;
	}
	
	public void display(){
		System.out.println("Data is: "+data);
	}
}