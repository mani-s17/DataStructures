package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 8/2/13
 * Time: 10:40 AM
 */
public class GraphUsingArrayList
{
	private int numberOfVertices;
	private int numberOfEdges;
	private List<Integer>[] adjacencyList;


	public GraphUsingArrayList(int numberOfVertices)
	{
		this.numberOfVertices = numberOfVertices;
		this.numberOfEdges = 0;
		adjacencyList = (List<Integer>[]) new List[numberOfVertices];
		for(int v=0; v<numberOfVertices; v++)
			adjacencyList[v] = new ArrayList<Integer>();
	}

	public void addEdge(int v, int w)
	{
		adjacencyList[v-1].add(w-1);
		adjacencyList[w-1].add(v-1);
		numberOfEdges++;
	}

	public int getNumberOfVertices()
	{
		return numberOfVertices;
	}

	public int getNumberOfEdges()
	{
		return numberOfEdges;
	}

	public void displayAdjacencyList()
	{
		for(int i=0; i<getNumberOfVertices(); i++)
		{
			System.out.println((i) + " -> " + adjacencyList[i]);
		}
	}

	public static void main(String[] args)
	{
		GraphUsingArrayList g = new GraphUsingArrayList(4);
		g.addEdge(1,2);
		g.addEdge(1,3);
		g.addEdge(2,3);
		g.addEdge(2,4);
		g.addEdge(3,4);
		g.displayAdjacencyList();
	}

}
