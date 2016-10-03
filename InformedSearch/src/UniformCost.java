/*Definition of expanded as mentioned by the homework assignment corresponds to the Visited arrayList below*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class UniformCost {

	Graph gh;

	String s, g;

	PriorityQueue<LinkedList<Vertex>> pq;
	ArrayList<String> Visited, Expanded; // expanded is open list, visited is
											// closed list

	UniformCost(Graph gh, String start, String goal) {
		this.gh = gh;
		this.s = start;
		this.g = goal;
		Comparator<LinkedList<Vertex>> comparator = new VertexComparator();
		pq = new PriorityQueue<LinkedList<Vertex>>(comparator);
		Visited = new ArrayList<String>();
		Expanded = new ArrayList<String>();
	}

	void executeAlgo() {

		ArrayList<Vertex> succList = new ArrayList<Vertex>();

		boolean minFlag; // true if there is value in queue lower than current
							// value

		pq.add(gh.getVertexFromLabel(this.s).Path); // add start state path to
													// priority queue

		Expanded.add(this.s); // add start state to list of expanded nodes

		while (!pq.isEmpty()) {

			LinkedList<Vertex> temp = pq.poll(); // get top path with minimum
													// cost from queue

			Vertex curr = temp.peek(); // get path head

			Visited.add(curr.label); // add path head to visited array

			if (curr.label.equalsIgnoreCase(g)) // goal check
			{
				System.out.println("goal reached");
				int count = printPath(gh.getVertexFromLabel(g), 0);
				System.out.println("Visited nodes:" + count);
				System.out.println("Expanded nodes:" + Visited.size());
				break;
			}

			else {

				minFlag = true;
				
				succList = curr.getAdjacentVertexList(); // generate successor
															// list for path
															// head

				for (Vertex v : succList) {

					// check if node has been visited by a path
					if (!itContains(v.label, Visited)) {

						//check if there exists already a path which has lower cost
						for (LinkedList<Vertex> l : pq) {
							if (v.label.equalsIgnoreCase(l.peek().label)
									&& curr.path_cost + v.getEdge(curr).weight > l.peek().path_cost)
								minFlag = false;
						}

						if (minFlag) {
							
							v.Path.add(curr);

							v.path_cost = curr.path_cost + v.getEdge(curr).weight;

							// check if node has been previously expanded by
							// others
							if (!itContains(v.label, Expanded)) {

								Expanded.add(v.label);
							}

							v.priority = (double) v.path_cost;

							pq.add(v.Path);
						}
					}
				}
			}
		}
		for (String s:Expanded) {
			System.out.print(s+" ");
		}
	}

	boolean itContains(String s, ArrayList<String> list) {

		if (list.contains(s))
			return true;

		return false;
	}

	int printPath(Vertex v, int count) {
		System.out.print(v.label + " ");
		count = count + 1;
		if (!v.label.equalsIgnoreCase(s))
			count = printPath(v.Path.removeLast(), count);
		return count;
	}

}
