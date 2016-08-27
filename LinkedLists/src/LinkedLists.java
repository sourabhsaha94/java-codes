
public class LinkedLists {

	
	public static void main(String[] args) {
		Node head =new Node(0);
		
		ListOperations List = new ListOperations(head);
		List.insertNode(1);
		List.insertNode(2);
		List.insertNode(3);
		List.displayList();
		List.displayHead();
		List.removeNode(2);
		List.displayList();
		List.displayHead();
		List.removeNode(0);
		List.displayList();
		List.displayHead();
		List.removeNode(1);
		List.displayList();
		List.displayHead();
	}
	
}
