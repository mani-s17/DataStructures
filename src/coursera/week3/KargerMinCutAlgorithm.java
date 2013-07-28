package coursera.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import helper.StopWatch;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 7/27/13
 * Time: 11:43 PM
 */
public class KargerMinCutAlgorithm
{
	private HashMap<Integer, List<Integer>> graph;
	private List<Integer> vertices;
	private List<List<Integer>> edges;

	private String inputFileName;
	private String delimiter;
	private List<String> lines;

	public KargerMinCutAlgorithm(String inputFileName, String delimiter) throws IOException
	{
		this.inputFileName = inputFileName;
		this.delimiter = delimiter;
		this.lines = loadFileIntoMemory();
	}

	private List<String> loadFileIntoMemory() throws IOException
	{
		List<String> lines = new ArrayList<String>();
		InputStream inputStream = GraphMinCut.class.getResourceAsStream(inputFileName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line = "";
		while ((line = reader.readLine()) != null )
			lines.add(line);
		return lines;
	}

	private HashMap<Integer, List<Integer>> createGraph()
	{
		HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		for(String line : lines)
		{
			String[] splits = line.split(delimiter);
			Integer vertex = Integer.parseInt(splits[0]);
			List<Integer> edges = new ArrayList<Integer>();
			for(int i=1; i<splits.length; i++)
			{
				edges.add(Integer.parseInt(splits[i]));
			}
			graph.put(vertex, edges);
		}
		return graph;
	}

	private List<Integer> createVertices()
	{
		List<Integer> vertices = new ArrayList<Integer>();
		for(String line : lines)
		{
			String[] splits = line.split(delimiter);
			Integer vertex = Integer.parseInt(splits[0]);
			vertices.add(vertex);
		}
		return vertices;
	}

	private List<List<Integer>> getEdges()
	{
		List<List<Integer>> edges = new ArrayList<List<Integer>>();
		for(Map.Entry<Integer, List<Integer>> entry : graph.entrySet())
		{
			List<Integer> edge = new ArrayList<Integer>();
			edge.add(entry.getKey());
			edge.addAll(entry.getValue());
			edges.add(edge);
		}
		return edges;
	}

	public int countMinCut() throws IOException
	{
		int minCut = Integer.MAX_VALUE;
		int numberOfTrials = lines.size()*lines.size();
		for(int i=0; i<100; i++)
		{
			graph = createGraph();
			vertices = createVertices();

			int kargerMinCut = kargerMinCut();
			if(kargerMinCut < minCut)
				minCut = kargerMinCut;
		}
		return minCut;
	}

	private int kargerMinCut()
	{
		Random r = new Random();
		while(graph.size()>2)
		{
			edges = getEdges();
			List<Integer> randomSelectedEdges = edges.get(r.nextInt(edges.size()));
			int node1 = randomSelectedEdges.get(0);
			int node2 = randomSelectedEdges.get(1);
			edgeContraction(node1,node2);
		}
		return graph.get(vertices.get(0)).size();
	}

	private void edgeContraction(Integer n1, Integer n2)
	{
		List<Integer> n1Edges = graph.get(n1);
		List<Integer> n2Edges = graph.get(n2);

		updateEdges(n1Edges,n1,n2);
		updateEdges(n2Edges,n1,n2);

		// Creating new Edges after contraction
		List<Integer> newEdges = new ArrayList<Integer>();
		newEdges.addAll(n1Edges);
		newEdges.addAll(n2Edges);

		// Recreating Graph with contracted edges
		graph.remove(n2);
		graph.put(n1, newEdges);
		vertices.remove(n2);

		for(Map.Entry<Integer, List<Integer>> entry : graph.entrySet())
		{
			Integer vertex = entry.getKey();
			List<Integer> edges = entry.getValue();

			// Updating full graph edges with contracted node label
			updateEdges(edges,n1,n2);

			// Removing self loop
			removeSelfLoop(edges,vertex);
		}
	}

	private void updateEdges(List<Integer> edges, Integer n1, Integer n2)
	{
		while(edges.contains(n2))
			edges.set(edges.indexOf(n2),n1);
	}

	private void removeSelfLoop(List<Integer> edges, Integer node)
	{
		while(edges.contains(node))
			edges.remove(node);
	}

	public static void main(String[] args) throws IOException
	{
		KargerMinCutAlgorithm obj = new KargerMinCutAlgorithm("kargerMinCut.txt","\t");
		StopWatch sw = new StopWatch();
		System.out.println(obj.countMinCut());
		System.out.println(sw.elapsedTime());
	}
}
