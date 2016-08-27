
public class SingleListOperations{
	
	SingleNode head;
	
	public SingleListOperations(SingleNode _head){
		this.head = _head;
	}
	
	public void insertNode(int data){
		SingleNode newNode = new SingleNode(data);
		SingleNode temp=head;
		
		while(temp.next != null){
			temp = temp.next;
		}
		
		temp.next = newNode;
	}
	
	public void displayList(){
		SingleNode temp=head;
		
		while(temp!=null){
			temp.display();
			temp = temp.next;
		}
		
	}
	
	public void displayHead(){
		System.out.println("Head is "+head.data);
	}
	
	public void removeNode(int data){
		
		SingleNode temp=head;
		SingleNode prev=head;
		
		while(temp.data != data){
			prev = temp;
			temp = temp.next;
		}
		
		if(temp == head){
			temp = head.next;
			head = temp;
		}
		else{
			prev.next = temp.next;
		}
	}
}
