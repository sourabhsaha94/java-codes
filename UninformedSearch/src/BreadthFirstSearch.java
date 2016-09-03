//pseudo-code understood from en.wikipedia.org/wiki/Breadth-first_search

import java.util.ArrayList;

public class BreadthFirstSearch {

	public static void main(String[] args) {

		ArrayList<Vertex> Vlist = new ArrayList<Vertex>();	//create new list of vertex
		Vlist.add(new Vertex("a"));
		Vlist.add(new Vertex("b"));
		Vlist.add(new Vertex("c"));
		Vlist.add(new Vertex("d"));
		Vlist.add(new Vertex("e"));
		Vlist.add(new Vertex("f"));
		Vlist.add(new Vertex("g"));
		
		
		Graph g = new Graph(Vlist);
		g.addEdge("a", "b");	//add the edges to the graph
		g.addEdge("a", "c");
		g.addEdge("b", "d");
		g.addEdge("b", "e");
		g.addEdge("c", "f");
		g.addEdge("c", "g");
		
		String current = "";
		String goal="g";
		String[] visited = new String[Vlist.size()];
		int i,counter=0;
		
		Queue q = new Queue(Vlist.size());	//new initialization of queue
		ArrayList<Vertex> succ = new ArrayList<Vertex>();	//list of successor nodes
		
		
		q.enqueue("a");	//Enqueue a vertex
		visited[counter++]="a";
		
		
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
					}
				}
			}
		}
		
		for(i=0;i<visited.length;i++){
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
