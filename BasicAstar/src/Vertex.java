import java.util.ArrayList;
import java.util.LinkedList;

public class Vertex {
	String label;	//the data of the vertex is stored as label
	ArrayList <Edge> Elist;	//this stores number of outgoing and incoming edges
	LinkedList<Vertex> Path;
	int x,y;
	Double h_cost;
	Double priority;
	int path_cost;
	
	public Vertex(String l){	//initialize vertex with own label and list of edges
		this.label = l;
		this.Elist = new ArrayList<Edge>();
		this.Path = new LinkedList<Vertex>();
		this.Path.add(this);
		this.path_cost=0;
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
			e.getAdjacentVertex(this).path_cost+=e.weight;
		}
		
		return v;
	}
	
	public Edge getEdge(Vertex v){
		
		for(Edge e:this.Elist){
			if(e.getAdjacentVertex(this).label.equalsIgnoreCase(v.label)){
				return e;
			}
		}
		
		return null;
	}
	
	
	public int getTotCost(){
		
		int tot_cost=0;
		return tot_cost;
	}
	
	/*public int getPathCost(Vertex v){
		
		for(Vertex v:Path){
			path_cost=
		}
		
		return 0;	
	}*/
}
