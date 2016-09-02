import java.util.ArrayList;

public class Vertex {
	String label;
	ArrayList <Edge> Elist;
	
	public Vertex(String l){
		this.label = l;
		this.Elist = new ArrayList<Edge>();		
	}
	
	public void addEdge(Edge e){
		if(this.Elist.contains(e))
			return;
		else
			this.Elist.add(e);
	}
	
	public boolean containsEdge(Edge e){
		return this.Elist.contains(e);
	}
	
	public ArrayList<Edge> getElist(){
		return Elist;
	}
	
	public int getEdgeCount(){
		return Elist.size();
	}
	
	public ArrayList<Vertex> getAdjacentVertexList(){
		
		ArrayList<Vertex> v = new ArrayList<Vertex>();
		
		for(Edge e:Elist){
			v.add(e.getAdjacentVertex(this));
		}
		
		return v;
	}
	
}
