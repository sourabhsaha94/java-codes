
public class Stack {
	
	int size;
	int top=-1;
	
	String[] elements;
	
	Stack(int size){
		this.size=size;
		this.top =-1;
		
		elements = new String[size];
		for(int i=0;i<elements.length;i++){
			elements[i]=null;
		}
	}
	
	public boolean isEmpty(){
		if(top==-1)
			return true;
		else
			return false;
		
	}	
	
	public String pop(){
		
		if(!isEmpty()){
			return elements[top--];
		}
		else
			return null;
		
	}
	
	public boolean isFull(){
		
		if(top==size-1)
			return true;
		else
			return false;
		
	}
	
	public void push(String data){
		if(!isFull()){
			top++;
			elements[top] = data;
		}
	}
	
	public void displayStack(){
		
		if(!isEmpty())
			for(int i=top;i>=0;i--){
				System.out.println(elements[i]);
			}
		else
			System.out.println("Empty");
		
		System.out.println("--------------");
	}
}
