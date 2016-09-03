//pseudo-code understood from en.wikipedia.org/wiki/Breadth-first_search

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BreadthFirstSearch {

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
		
		
		String current = "";
		String goal="lugoj",start_node="bucharest";
		String[] visited = new String[Vlist.size()];
		int i,counter=0;
		
		Queue q = new Queue(Vlist.size());	//new initialization of queue
		ArrayList<Vertex> succ = new ArrayList<Vertex>();	//list of successor nodes
		
		
		q.enqueue(start_node);	//Enqueue a vertex
		visited[counter++]=start_node;
		
		
		while(q.size!=0){	//main algorithm loop of BFS
			
			current = q.dequeue();
						
			if(current.equalsIgnoreCase(goal)){
				
				System.out.println("Goal reached");
				break;
			}
			else{
				succ = g.getVertexFromLabel(current).getAdjacentVertexList();
				for(i=0;i<succ.size();i++){
					if(!checkIfVisited(visited,succ.get(i).label))
					{
						q.enqueue(succ.get(i).label);
						visited[counter++] = succ.get(i).label;
						succ.get(i).Path.addAll(g.getVertexFromLabel(current).Path);
					}
				}
			}
		}
		
		//print in a formatted manner; the entire route
		
		System.out.println("Route take from "+start_node+" to "+goal+":");
				
		for(i=g.getVertexFromLabel(goal).Path.size()-1;i>0;i--){
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
