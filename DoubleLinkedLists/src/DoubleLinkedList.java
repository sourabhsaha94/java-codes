
public class DoubleLinkedList {

	public static void main(String[] args) {
		DoubleNode head = new DoubleNode(0);
		
		DoubleListOperations doubleListOperations = new DoubleListOperations(head);
		
		doubleListOperations.insertNode(1);
		doubleListOperations.insertNode(2);
		doubleListOperations.insertNode(3);
		
		doubleListOperations.displayListForward();
		doubleListOperations.displayListBackward();
		
		doubleListOperations.removeNode(2);
		
		doubleListOperations.displayListForward();
		doubleListOperations.displayListBackward();
		
		doubleListOperations.removeNode(0);
		
		doubleListOperations.displayListForward();
		doubleListOperations.displayListBackward();
	}

}
