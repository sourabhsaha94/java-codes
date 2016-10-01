import java.util.ArrayList;

public class SearchMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Vertex> vlist = new ArrayList<Vertex>();
		
		Vertex a = new Vertex("a");
		a.x=0;
		a.y=0;
		Vertex b = new Vertex("b");
		b.x=1;
		b.y=0;
		Vertex c = new Vertex("c");
		c.x=0;
		c.y=1;
		Vertex d = new Vertex("d");
		d.x=1;
		d.y=1;
		Vertex e = new Vertex("e");
		e.x=0;
		e.y=2;
		Vertex f = new Vertex("f");
		f.x=2;
		f.y=0;
		Vertex g = new Vertex("g");
		g.x=1;
		g.y=2;
		Vertex h = new Vertex("h");
		h.x=2;
		h.y=1;
		Vertex i = new Vertex("i");
		i.x=2;
		i.y=2;
		
		vlist.add(a);
		vlist.add(b);
		vlist.add(c);
		vlist.add(d);
		vlist.add(e);
		vlist.add(f);
		vlist.add(g);
		vlist.add(h);
		vlist.add(i);
		
		Graph graph = new Graph(vlist);
		
		graph.addEdge("a", "b", 2);
		graph.addEdge("a", "c", 1);
		graph.addEdge("a", "d", 2);
		graph.addEdge("b", "d", 1);
		graph.addEdge("b", "f", 1);
		graph.addEdge("c", "d", 3);
		graph.addEdge("c", "e", 1);
		graph.addEdge("d", "f", 3);
		graph.addEdge("d", "e", 5);
		graph.addEdge("d", "h", 4);
		graph.addEdge("d", "g", 6);
		graph.addEdge("d", "i", 1);
		graph.addEdge("e", "g", 2);
		graph.addEdge("f", "h", 2);
		graph.addEdge("g", "i", 3);
		graph.addEdge("h", "i", 5);
		
		String start="a",goal="i";
		
		Astar astar = new Astar(graph,start,goal);
		astar.executeAlgo();
		
	}

}
