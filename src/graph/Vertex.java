package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 8/2/13
 * Time: 3:30 PM
 */
public class Vertex
{
	int label;
	boolean isExplored;
	List<Edge> edgesConnected;

	public Vertex(int label)
	{
		this.label = label;
		this.edgesConnected = new ArrayList<Edge>();
		this.isExplored = false;
	}

	public void setEdgesConnected(Edge edge)
	{
		edgesConnected.add(edge);
	}

	public List<Edge> getEdgesConnected()
	{
		return edgesConnected;
	}

	public void setExplored(boolean isExplored)
	{
		this.isExplored = isExplored;
	}

	public boolean getExplored()
	{
		return isExplored;
	}

	public int getLabel()
	{
		return label;
	}
}
