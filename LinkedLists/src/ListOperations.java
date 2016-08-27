
public class ListOperations {
	
	Node head;
	
	public ListOperations(Node _head){
		this.head = _head;
	}
	
	public void insertNode(int data){
		Node newNode = new Node(data);
		Node temp=head;
		
		while(temp.next != null){
			temp = temp.next;
		}
		
		temp.next = newNode;
	}
	
	public void displayList(){
		Node temp=head;
		
		while(temp!=null){
			temp.display();
			temp = temp.next;
		}
		
	}
	
	public void displayHead(){
		System.out.println("Head is "+head.data);
	}
	
	public void removeNode(int data){
		
		Node temp=head;
		Node prev=head;
		
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
