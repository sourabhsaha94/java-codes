import java.util.*;

public class MinHeapDemo
{
  
  int size = 0;
  int capacity;
  int[] heap;
  
  public MinHeapDemo(int _capacity){
    this.capacity = _capacity;
    this.heap = new int[capacity];
  }
  
  public void ensureCapacity(){
    if(size>=capacity){
      heap = Arrays.copyOf(heap,capacity*2);
    }
  }
  
  public int getParentIndex(int childIndex){return (childIndex-1)/2;}
  public int getLeftChildIndex(int parentIndex){return (parentIndex*2 + 1);}
  public int getRightChildIndex(int parentIndex){return (parentIndex*2 + 2);}
  
  public boolean hasParent(int index){return (index-1)/2 >= 0;}
  public boolean hasLeftChild(int index){return (index*2 + 1)< size;}
  public boolean hasRightChild(int index){return (index*2 + 2)< size;}
  
  public int getParent(int childIndex){return heap[(childIndex-1)/2];}
  public int getLeftChild(int parentIndex){return heap[(parentIndex*2 + 1)];}
  public int getRightChild(int parentIndex){return heap[(parentIndex*2 + 2)];}
  
  public int peek(){
    return heap[0];
  }
  
  public int poll(){
    int item = heap[0];//remove the root
    heap[0] = heap[size-1];//put the last element as root
    size--;//decrement heap size
    
    heapifyDown();
    return item;
  }
  
  public void add(int value){
    ensureCapacity();
    heap[size] = value;//add element to last position
    size++;
    
    heapifyUp();
  }
  
  public void swap(int index1, int index2){
    int temp = heap[index1];
    heap[index1] = heap[index2];
    heap[index2] = temp;
  }
  
  public void heapifyUp(){
    int index = size-1; // last index of the heap
    
    while(hasParent(index) && getParent(index) > heap[index])//if there is a parent and its value if more than current then swap
    {
      swap(getParentIndex(index),index);
      index = getParentIndex(index);
    }
  }
  
  public void heapifyDown(){
    int index = 0; //root of the heap, needed to  be put in right place
    
    while(hasLeftChild(index)){// if left child present, if not left child then no right child also
      
      int smallerChildIndex = getLeftChildIndex(index);	//get index of the smallest child
      
      if(hasRightChild(index) && getRightChild(index)<getLeftChild(index)){	//compare siblings
        smallerChildIndex = getRightChildIndex(index);
      }
         
      if(heap[index]<heap[smallerChildIndex]){// if parent smaller than child, heap is ordered
        break;
      }
      else{
        swap(index,smallerChildIndex);//swap child with parent
      }
     	
       index = smallerChildIndex;//make child new parent
                          
    }
  }
  
  public void printHeap(){
    for(int i=0;i<size;i++){
      System.out.print(heap[i]+" ");
    }
    System.out.println();
  }
  
  
  public static void main(String[] args)
  {
    Random num = new Random();
    
    MinHeapDemo minHeap = new MinHeapDemo(10);
   
    minHeap.add(num.nextInt(100));
    minHeap.add(num.nextInt(100));
    minHeap.add(num.nextInt(100));
    minHeap.add(num.nextInt(100));
    minHeap.add(num.nextInt(100));
    
    minHeap.printHeap();
    
    System.out.println(minHeap.peek());
     
    System.out.println(minHeap.poll());
    
    minHeap.printHeap();
    
    System.out.println(minHeap.peek());
    
    minHeap.printHeap();
   
    minHeap.add(0);
    System.out.println(minHeap.peek());
    minHeap.printHeap();
   
  }
}
