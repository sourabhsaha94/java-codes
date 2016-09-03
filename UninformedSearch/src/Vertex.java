import java.util.ArrayList;

public class Vertex {
	String label;	//the data of the vertex is stored as label
	ArrayList <Edge> Elist;	//this stores number of outgoing and incoming edges
	
	public Vertex(String l){	//initialize vertex with own label and list of edges
		this.label = l;
		this.Elist = new ArrayList<Edge>();		
	}
	
	public void addEdge(Edge e){	//add an edge to the list of the current vertex
		if(this.Elist.contains(e))
			return;
		else
			this.Elist.add(e);
	}
	
	public boolean containsEdge(Edge e){	//check if the list contains a particular edge
		return this.Elist.contains(e);
	}
	
	public ArrayList<Edge> getElist(){	//return all the edges associated with the vertex
		return Elist;
	}
	
	public int getEdgeCount(){	//return the total count of the edges
		return Elist.size();
	}
	
	public ArrayList<Vertex> getAdjacentVertexList(){	//get the list of vertices on the other end of all the connected edges
		
		ArrayList<Vertex> v = new ArrayList<Vertex>();
		
		for(Edge e:Elist){
			v.add(e.getAdjacentVertex(this));
		}
		
		return v;
	}
	
}
