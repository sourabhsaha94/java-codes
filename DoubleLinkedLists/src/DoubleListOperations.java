
public class DoubleListOperations {
	
	DoubleNode head;
	
	public DoubleListOperations(DoubleNode head){
		this.head = head;
	}
	
	public void insertNode(int data){
		DoubleNode temp = head;
		DoubleNode newNode = new DoubleNode(data);
		
		while(temp.next != null){
			temp=temp.next;
		}
		
		temp.next = newNode;
		newNode.prev = temp;
		
	}
	
	public void displayListForward(){
		DoubleNode temp = head;
		
		
		while(temp!=null){
			temp.displayNode();
			temp = temp.next;
		}
		
	}
	
	public void displayListBackward(){
		DoubleNode temp = head;
		
		while(temp.next !=null){
			temp = temp.next;
		}
		
		while(temp!=null){
			temp.displayNode();
			temp = temp.prev;
		}
	}
	
	public void removeNode(int data){
		
		DoubleNode temp = head;
		
		while(temp.data != data){
			temp = temp.next;
		}
		
		if(temp == head){
			head = temp.next;
			temp.next.prev=null;
		}
		else{
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
		}
	}
	
}
