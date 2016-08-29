import java.util.Stack;

public class StackArray {

	int StackSize  = 0;
	int StackTop = -1;
	Integer elements[];
	
	
	public StackArray(int StackSize){
		this.StackSize = StackSize;
		this.StackTop=-1;
		elements = new Integer[StackSize];
		for(int i=0;i<StackSize;i++){
			elements[i]=Integer.MIN_VALUE;
		}
	}
	
	public boolean isFull(){
		if(StackTop==StackSize-1){
			return true;
		}
		else return false;
	}
	
	public boolean isEmpty(){
		if(StackTop==-1){
			return true;
		}
		else return false;
	}
	
	public void push(int element){
		if(!isFull()){
		StackTop++;
		elements[StackTop]=element;
		System.out.println("Element pushed: "+elements[StackTop]);
		}else{
			System.out.println("Stack is Full");
		}
	}
	
	public void pop(){
		if(!isEmpty()){
			System.out.println("Element popped: "+elements[StackTop]);
			elements[StackTop]=Integer.MIN_VALUE;
			StackTop--;
		}else{
			System.out.println("Stack is Empty");
		}
	}
	
	public String getStackTop(){
		if(!isEmpty())
		return elements[StackTop].toString();
		else
			return "Stack Empty";
	}
	
	public void display(){
		for(int i=StackTop;i>-1;i--){
			System.out.println(elements[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackArray stack = new StackArray(10);
		stack.push((int) (Math.random()*10));
		stack.push((int) (Math.random()*10));
		stack.push((int) (Math.random()*10));
		stack.push((int) (Math.random()*10));
		stack.display();
		System.out.println("Stack Top is: "+stack.getStackTop());
		stack.pop();
		stack.pop();
		stack.display();
		System.out.println("Stack Top is: "+stack.getStackTop());
	}

}
