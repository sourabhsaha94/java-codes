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
		
		pq.add(gh.getVertexFromLabel(s).Path);
		System.out.println(1);
		while(!pq.isEmpty()){
		
			LinkedList<Vertex> currentPath = pq.poll();
			
			Vertex parent = currentPath.getFirst();
			
			if(parent.label.equalsIgnoreCase(g)){
				System.out.println("Goal match");
				break;
			}
			else{
				
				succList = parent.getAdjacentVertexList();
				
				for(Vertex child:succList){
					
					child.Path.addAll(parent.Path);
					pq.add(child.Path);
				}
			}
			break;
		}
		
		for(LinkedList<Vertex> l:pq){
			for(Vertex v:l){
				System.out.print(v.label+" ");
			}
			System.out.println();
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
