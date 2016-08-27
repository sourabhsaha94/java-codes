
public class LinkedListMain {

	public static void main(String[] args) {
		
		Node head = new Node(0);
		head.next = head;
		
		ListOperations list = new ListOperations(head);
		list.insertNode(1);
		list.insertNode(2);
		list.insertNode(3);
		list.displayList();
		list.removeNode(0);
		list.displayList();
		list.removeNode(2);
		list.displayList();

	}

}
