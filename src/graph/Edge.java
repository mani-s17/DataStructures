package graph;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 8/2/13
 * Time: 3:31 PM
 */
public class Edge
{
	Vertex v;
	Vertex w;

	public Edge(Vertex v, Vertex w)
	{
		this.v = v;
		this.w = w;
	}

	public Vertex getConnectedVertex(Vertex vertex)
	{
		return v == vertex ? w : v;
	}
}
