import java.util.Iterator;
import java.util.LinkedList;

public class Queue {
	
	LinkedList <String> elements;
	int size;
	
	Queue(int size){
		this.size = size;
		elements = new LinkedList<String>();
	}
	
	public void enqueue(String v){
		if(!isFull()){
			elements.addLast(v);
		}
	}
	
	public String dequeue(){
		
		return elements.poll();
		
	}

	private boolean isFull() {
		if(elements.size()==size){
			return true;
		}
		else
			return false;
	}
	
	public String displayQueue(){
		
		Iterator<String> i = elements.iterator();
		String op = "";
		while(i.hasNext()){
			
			op = op + i.next();
		}
		return op;
	}
	
}
