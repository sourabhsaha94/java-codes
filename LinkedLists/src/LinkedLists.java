
public class LinkedLists {

	
	public static void main(String[] args) {
		SingleNode head =new SingleNode(0);
		
		SingleListOperations List = new SingleListOperations(head);
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
