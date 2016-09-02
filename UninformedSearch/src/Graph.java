import java.util.ArrayList;

public class Graph {

	ArrayList <Vertex> Vlist;
	ArrayList<Edge> Elist;
	
	public Graph(ArrayList<Vertex> v){
		this.Vlist = new ArrayList<Vertex>();
		this.Elist = new ArrayList<Edge>();
		
		for(Vertex vert:v){
			this.Vlist.add(vert);
		}
	}
	
	public void addEdge(Vertex one, Vertex two){
		Edge e = new Edge(one,two);
		this.Elist.add(e);
		one.addEdge(e);
		two.addEdge(e);
	}
	
	public void addEdge(String s1, String s2){
		addEdge(getVertexFromLabel(s1),getVertexFromLabel(s2));
	}
	
	public Vertex getVertexFromLabel(String label){
		
		for(Vertex v:this.Vlist){
			if(v.label.equalsIgnoreCase(label))
				return v;
		}
		return null;
	}
}
