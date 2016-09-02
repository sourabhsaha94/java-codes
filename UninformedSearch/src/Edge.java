
public class Edge {

	Vertex one,two;
	
	public Edge(Vertex one,Vertex two){
		this.one=one;
		this.two=two;
	}
	
	public Vertex getAdjacentVertex(Vertex v){
		return (v.equals(one))?two:one;
	}
	
}
