//pseudo-code understood from en.wikipedia.org/wiki/Depth-first_search

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DepthFirstSearch {


	public static void main(String[] args) throws IOException {
		ArrayList<Vertex> Vlist = new ArrayList<Vertex>();	//create new list of vertex
		ArrayList<Vertex> Temp = new ArrayList<Vertex>();
		
		FileReader f = new FileReader("cities.txt");	//new reader for getting city names
		BufferedReader bufferedReader1 = new BufferedReader(f);
		
		
		String line;
		String[] splitString;
		boolean flag=true;	//to mark duplicate values
		
		while((line = bufferedReader1.readLine())!= null){	//to fill temp array with all city names including duplicates
			splitString = line.split(",");
			Temp.add(new Vertex(splitString[0]));
			Temp.add(new Vertex(splitString[1]));
		}
		
		bufferedReader1.close();
		
		Vlist.add(Temp.get(0));
		
		for(Vertex v : Temp){	//to remove duplicate entries from temp into vlist
			flag=true;
			for(Vertex v1:Vlist){
				if(v.label.equalsIgnoreCase(v1.label)){
					flag=true;
					break;
				}else
				{
					flag=false;
				}
			}
			if(!flag){
				Vlist.add(v);
			}
		}
		
		
		Graph g = new Graph(Vlist);
		
		FileReader f1 = new FileReader("cities.txt");	//new reader required for getting edges
		
		BufferedReader bufferedReader2 = new BufferedReader(f1);
		
		while((line = bufferedReader2.readLine())!= null){	//to fill temp array with all city names including duplicates
			splitString = line.split(",");
			g.addEdge(splitString[0], splitString[1]);
		}
		
		bufferedReader2.close();
		
		
		
		Stack stack = new Stack(g.Vlist.size());	//initialize the stack of size equals number of vertices
		String label="";
		
		String goal="bucharest",start_node="lugoj";	//enter the goal and start node
		
		String[] visited = new String[g.Vlist.size()];	//store all the nodes already taken into consideration
		ArrayList<Vertex> succList = new ArrayList<Vertex>();	//store all the successive vertices of a given vertex
		
		int counter = 0 ;	//to iterate through the visited array
				
		stack.push(start_node);	//push first node on stack
		
		
		visited[counter++]=start_node;
		
		while(!stack.isEmpty()){	//main loop of the DFS algorithm
					
			label = stack.pop();
			
			if(label.equalsIgnoreCase(goal))
			{
				System.out.println("Goal reached");
				break;
			}
			else
			{
				
				succList = g.getVertexFromLabel(label).getAdjacentVertexList();
				for(Vertex v:succList)
					{
						if(!checkIfVisited(visited,v.label)){
							visited[counter++]=v.label;
							stack.push(v.label);
							v.Path.addAll(g.getVertexFromLabel(label).Path);
						}
							
					}
			}
		}
		
		//print in a formatted manner; the entire route
		
		System.out.println("Route take from "+start_node+" to "+goal+":");
		
		for(int i=g.getVertexFromLabel(goal).Path.size()-1;i>0;i--){
				System.out.print(g.getVertexFromLabel(goal).Path.get(i).label+" > ");
		}
		System.out.print(g.getVertexFromLabel(goal).Path.get(0).label);
		
	}

	private static boolean checkIfVisited(String[] visited, String label) {
	
		for(int i=0;i<visited.length;i++){
			if(label.equalsIgnoreCase(visited[i]))
				return true;
		}
		return false;
	}
		
}
