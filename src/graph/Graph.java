package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 8/2/13
 * Time: 4:03 PM
 */
public class Graph
{
	List<Vertex> vertices;
	List<Edge> edges;

	public Graph()
	{
		vertices = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
	}

	public void addVertex(Vertex vertex)
	{
		vertices.add(vertex);
	}

	public void addEdge(Edge edge)
	{
		edges.add(edge);
	}

	public int getVerticesCount()
	{
		return vertices.size();
	}

	public int getEdgesCount()
	{
		return edges.size();
	}

	public static void main(String[] args)
	{
		Graph g = new Graph();
		Vertex v = new Vertex(1);
		Vertex w = new Vertex(2);
		Edge e = new Edge(v,w);
		v.setEdgesConnected(e);
		w.setEdgesConnected(e);

		g.addVertex(v);
		g.addVertex(w);
		g.addEdge(e);

		System.out.println( g.vertices.get(0).getLabel() + " -> " +g.vertices.get(0).getEdgesConnected().get(0).getConnectedVertex(g.vertices.get(0)).getLabel());
		System.out.println( g.vertices.get(1).getLabel() + " -> " +g.vertices.get(1).getEdgesConnected().get(0).getConnectedVertex(g.vertices.get(1)).getLabel());
	}
}
