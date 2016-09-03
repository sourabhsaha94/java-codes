//pseudo-code understood from en.wikipedia.org/wiki/Depth-first_search

import java.util.ArrayList;

public class DepthFirstSearch {


	public static void main(String[] args) {
		ArrayList<Vertex> Vlist = new ArrayList<Vertex>();	//create and add all vertices
		Vlist.add(new Vertex("a"));
		Vlist.add(new Vertex("b"));
		Vlist.add(new Vertex("c"));
		Vlist.add(new Vertex("d"));
		Vlist.add(new Vertex("e"));
		Vlist.add(new Vertex("f"));
		Vlist.add(new Vertex("g"));
		
		Graph g = new Graph(Vlist);	//initialize graph with vertex list
		g.addEdge("a", "b");	//add the edges to the graph
		g.addEdge("a", "c");
		g.addEdge("b", "d");
		g.addEdge("b", "e");
		g.addEdge("c", "f");
		g.addEdge("c", "g");
		
		Stack stack = new Stack(g.Vlist.size());	//initialize the stack of size equals number of vertices
		stack.push("a");	//push first node on stack
		
		stack.displayStack();
		
		String label="";
		String goal="e";
		String[] visited = new String[g.Vlist.size()];	//store all the nodes already taken into consideration
		ArrayList<Vertex> succList = new ArrayList<Vertex>();	//store all the successive vertices of a given vertex
		
		int counter = 0 ;	//to iterate through the visited array
		
		visited[counter++]="a";
		
		while(!stack.isEmpty()){	//main loop of the DFS algorithm
					
			label = stack.pop();
			
			stack.displayStack();
			
			if(label.equalsIgnoreCase(goal))
			{
				System.out.println("Goal reached");
				break;
			}
			else
			{
				
				succList = g.getVertexFromLabel(label).getAdjacentVertexList();
				if(!succList.isEmpty())
				{
					for(Vertex v:succList)
					{
						if(!checkIfVisited(visited,v.label)){
							visited[counter++]=v.label;
							stack.push(v.label);
						}
							
					}
					stack.displayStack();
				}
			}
		}
		for(int i=0;i<visited.length;i++){
			System.out.println(visited[i]);
		}
		
	}

	private static boolean checkIfVisited(String[] visited, String label) {
	
		for(int i=0;i<visited.length;i++){
			if(label.equalsIgnoreCase(visited[i]))
				return true;
		}
		return false;
	}
		
}
