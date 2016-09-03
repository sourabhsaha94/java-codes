
public class Stack {
	
	int size;
	int top=-1;
	
	String[] elements;
	
	Stack(int size){	//stack initialization by making all vacant spots as null
		this.size=size;
		this.top =-1;
		
		elements = new String[size];
		for(int i=0;i<elements.length;i++){
			elements[i]=null;
		}
	}
	
	public boolean isEmpty(){	//check if stack is empty
		if(top==-1)
			return true;
		else
			return false;
		
	}	
	
	public String pop(){	//remove top of stack
		
		if(!isEmpty()){
			return elements[top--];
		}
		else
			return null;
		
	}
	
	public boolean isFull(){	//check if stack is full
		
		if(top==size-1)
			return true;
		else
			return false;
		
	}
	
	public void push(String data){	//add data to top of stack
		if(!isFull()){
			top++;
			elements[top] = data;
		}
	}
	
	public void displayStack(){	//display stack contents in LIFO order
		
		if(!isEmpty())
			for(int i=top;i>=0;i--){
				System.out.println(elements[i]);
			}
		else
			System.out.println("Empty");
		
		System.out.println("--------------");
	}
}
