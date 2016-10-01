import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Astar {
	
	Graph gh;
	
	String s,g;
	
	PriorityQueue<LinkedList<Vertex>> pq;
	ArrayList<String> Visited,Expanded;

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
		
		calculateHcost();
		
		pq.add(gh.getVertexFromLabel(this.s).Path);
		Expanded.add(this.s);
		
		
		while(!pq.isEmpty()){
			
			LinkedList<Vertex> temp=pq.poll();
			
			Vertex curr = temp.peek();
			System.out.println(curr.label+": "+curr.priority);
			Visited.add(curr.label);
			if(curr.label.equalsIgnoreCase(g))
			{
				System.out.println("goal reached");
				for(String s:Visited){
					System.out.print(s+" ");
				}
				break;
			}
			
			else{
				System.out.println("visiting "+curr.label);
				
				succList = curr.getAdjacentVertexList();
				
				for(Vertex v:succList){
					
					//check if node has been visited by a path
					if(!itContains(v.label,Visited)){
						
						
						
						//check if node has been previously expanded by others
						if(!itContains(v.label,Expanded)){
							
							Expanded.add(v.label);
							
						}
							
						v.priority = (double)v.path_cost+v.h_cost;
						v.Path.addAll(curr.Path);
						System.out.println("expanding "+v.label+" :"+v.path_cost);
						
						pq.add(v.Path);
					}
				}
				
				for(String s:Expanded){
					System.out.print(s+" ");
				}
			
				System.out.println();
			}
		}
	}
	
	boolean itContains(String s, ArrayList<String> list){
		
		if(list.contains(s))
			return true;
		
		return false;
	}
	
	void calculateHcost(){
		
		Vertex goal = gh.getVertexFromLabel(g);
		
		for(Vertex v:gh.Vlist){
			v.h_cost = Math.sqrt(Math.pow(goal.x-v.x, 2)+Math.pow(goal.y-v.y, 2));
		}
		
	}
	
}
