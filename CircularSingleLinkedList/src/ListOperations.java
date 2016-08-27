
public class ListOperations {

	Node head;
	
	public ListOperations(Node head){
		this.head = head;
	}
	
	public void insertNode(int data){
		
		Node temp = head;
		
		Node newNode = new Node(data);
		
		while(temp.next!=head){
			temp=temp.next;
		}
		
		temp.next=newNode;
		newNode.next = head;
	}
	
	public void displayList(){
		
		Node temp = head;
		
		do{
			temp.displayNode();
			temp = temp.next;
		}while(temp!=head);
	}
	
	public void removeNode(int data){
		Node temp = head;
		Node prev = head;
		
		while(temp.data!=data){
			prev=temp;
			temp=temp.next;
			
			if(temp==head){
			break;
			}
		}
		if(temp==head){		//and check here if searching is finished with no result
			do{
				prev = prev.next;
			}while(prev.next!=head);
			
			prev.next = temp.next;
			temp= temp.next;
			head = temp;
		}
		else{
			prev.next = temp.next;
			temp = temp.next;
		}
	}
}
