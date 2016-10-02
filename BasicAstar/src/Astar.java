import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Astar {
	
	Graph gh;
	
	String s,g;
	
	PriorityQueue<LinkedList<Vertex>> pq;
	ArrayList<String> Visited,Expanded;	//expanded is open list, visited is closed list

	Astar(Graph gh, String start, String goal){
		this.gh = gh;
		this.s=start;
		this.g=goal;
		Comparator<LinkedList<Vertex>> comparator = new VertexComparator();
		pq = new PriorityQueue<LinkedList<Vertex>>(comparator);
		Visited = new ArrayList<String>();
		Expanded = new ArrayList<String>();
	}
	
	void executeAlgo(){
		
		ArrayList<Vertex> succList = new ArrayList<Vertex>();
		
		int loop_counter =0;
		
		calculateHcost();
		
		pq.add(gh.getVertexFromLabel(this.s).Path);	//add start state path to priority queue
		Expanded.add(this.s);	//add start state to list of expanded nodes
		
		
		while(!pq.isEmpty()){
			
			
			LinkedList<Vertex> temp=pq.poll();	//get top path with minimum cost from queue
			
			Vertex curr = temp.peek();	//get path head
			
			System.out.println(curr.label+": "+curr.priority);
			
			Visited.add(curr.label);	//add path head to visited array
			
			if(curr.label.equalsIgnoreCase(g))	//goal check
			{
				System.out.println("goal reached");
				printPath(gh.getVertexFromLabel(g));
				break;
			}
			
			else{
				
				System.out.println("visiting "+curr.label);
				
				succList = curr.getAdjacentVertexList();	//generate successor list for path head
				System.out.println("Size of succList: "+succList.size());
				for(Vertex v:succList){
					
					
					
					//check if node has been visited by a path
					if(!itContains(v.label,Visited)){
						
						v.Path.add(curr);
						v.path_cost = curr.path_cost+v.getEdge(curr).weight;
						System.out.println("expanding "+v.label+" :"+v.path_cost);
						//check if node has been previously expanded by others
						if(!itContains(v.label,Expanded)){
							
							
							Expanded.add(v.label);
							
						}
							
						v.priority = (double)v.path_cost+v.h_cost;
											
						pq.add(v.Path);
					}
				}
				
				for(String s:Expanded){
					System.out.print(s+" ");
				}
			
				System.out.println();
			}
			
			//if(loop_counter==3)
				//break;
			
			loop_counter++;
		}
	}
	
	boolean itContains(String s, ArrayList<String> list){
		
		if(list.contains(s))
			return true;
		
		return false;
	}
	
	void printPath(Vertex v){
		System.out.print(v.label+" ");
		if(!v.label.equalsIgnoreCase(s))
			printPath(v.Path.removeLast());
	}
	
	void calculateHcost(){
		
		Vertex goal = gh.getVertexFromLabel(g);
		
		for(Vertex v:gh.Vlist){
			v.h_cost = Math.sqrt(Math.pow(goal.x-v.x, 2)+Math.pow(goal.y-v.y, 2));
		}
		
	}
	
}
