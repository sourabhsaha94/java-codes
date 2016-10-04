/*Definition of expanded as mentioned by the homework assignment corresponds to the Visited arrayList below*/


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
		
		boolean minFlag;
		
		calculateHcost();
		
		pq.add(gh.getVertexFromLabel(this.s).Path);	//add start state path to priority queue
		
		Expanded.add(this.s);	//add start state to list of expanded nodes
		
		
		while(!pq.isEmpty()){
			
			minFlag=true;
			
			LinkedList<Vertex> temp=pq.poll();	//get top path with minimum cost from queue
			
			Vertex curr = temp.peek();	//get path head
			
			Visited.add(curr.label);	//add path head to visited array
			
			if(curr.label.equalsIgnoreCase(g))	//goal check
			{
				System.out.println("goal reached");
				int count=printPath(gh.getVertexFromLabel(g),0);
				System.out.println("Visited nodes:" +count);
				System.out.println("Expanded nodes:" +Visited.size());
				break;
			}
			
			else{
				
				
				succList = curr.getAdjacentVertexList();	//generate successor list for path head
			
				System.out.println("");
				for(Vertex v:succList){
					
					minFlag=true;
					
					System.out.println(curr.label+" expanding "+v.label+" :"+v.h_cost);
					
					for(LinkedList<Vertex> l:pq){
						if(v.label.equalsIgnoreCase(l.peek().label)){
							if((curr.path_cost + v.getEdge(curr).weight+v.h_cost)>l.peek().priority)
								minFlag=false;	
						}
							
					}
					
					//check if node has been visited by a path
					if(!itContains(v.label,Visited)){
						
										
						if (minFlag) {
							
							v.Path.add(curr);

							v.path_cost = curr.path_cost + v.getEdge(curr).weight;

							// check if node has been previously expanded by
							// others
							if (!itContains(v.label, Expanded)) {

								Expanded.add(v.label);
							}

							v.priority = (double) v.path_cost+v.h_cost;

							pq.add(v.Path);
							System.out.println("QueueTop: "+pq.peek().peek().label+" :"+pq.peek().peek().priority);
							System.out.println("");
						}

					}
					else
					{
						System.out.println("Not considered\n");
					}
				}
				
				for(LinkedList<Vertex> l:pq){
					System.out.println(l.peek().label+" :"+l.peek().priority);
					
				}
				
			}
		}
		for (String s:Visited) {
			System.out.print(s+" ");
		}
	}
	
	boolean itContains(String s, ArrayList<String> list){
		
		for(String t:list){
			if(s.equalsIgnoreCase(t))
				return true;
		}
		
		return false;
	}
	
	int printPath(Vertex v,int count){
		System.out.print(v.label+" ");
		count=count+1;
		if(!v.label.equalsIgnoreCase(s))
			count=printPath(v.Path.removeLast(),count);
		return count;
	}
	
	void calculateHcost(){
		
		Vertex goal = gh.getVertexFromLabel(g);
		
		for(Vertex v:gh.Vlist){
			v.h_cost = Math.sqrt(Math.pow((69.5 * (goal.lat - v.lat)),2) + Math.pow(69.5 * Math.cos((goal.lat + v.lat)/360 * Math.PI) * (goal.lon-v.lon),2));
		}
		
	}
	
}
