import java.util.ArrayList;

public class DepthFirstSearch {


	public static void main(String[] args) {
		ArrayList<Vertex> Vlist = new ArrayList<Vertex>();
		Vlist.add(new Vertex("a"));
		Vlist.add(new Vertex("b"));
		Vlist.add(new Vertex("c"));
		Vlist.add(new Vertex("d"));
		Vlist.add(new Vertex("e"));
		Vlist.add(new Vertex("f"));
		Vlist.add(new Vertex("g"));
		Vlist.add(new Vertex("h"));
		Vlist.add(new Vertex("i"));
		Vlist.add(new Vertex("j"));
		
		Graph g = new Graph(Vlist);
		g.addEdge("a", "b");
		g.addEdge("a", "j");
		g.addEdge("b", "c");
		g.addEdge("c", "f");
		g.addEdge("c", "d");
		g.addEdge("d", "e");
		g.addEdge("e", "f");
		g.addEdge("f", "g");
		g.addEdge("g", "h");
		g.addEdge("h", "i");
		g.addEdge("i", "j");
		
		Stack stack = new Stack(g.Vlist.size());
		stack.push("a");
		
		stack.displayStack();
		
		String label="";
		String goal="g";
		String[] visited = new String[g.Vlist.size()];
		ArrayList<Vertex> succList = new ArrayList<Vertex>();
		
		int counter = 0 ;
		
		while(!stack.isEmpty()){
					
			label = stack.pop();
			
			stack.displayStack();
			
			visited[counter++]=label;
			
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
						if(!checkIfVisited(visited,v.label))
							stack.push(v.label);
					}
					stack.displayStack();
				}
			}
		}
			
	}

	private static boolean checkIfVisited(String[] visited, String label) {
		
		boolean flag=false;
		
		for(int i=0;i<visited.length;i++){
			if(visited[i]==label)
			{
				flag= true;
				break;
			}
		}
		
		return flag;
	}
		
}
