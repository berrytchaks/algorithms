package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AdjacencyListWeighted {
	private Map<Integer, List<WeightedVertex>> adjacencyList;

	public AdjacencyListWeighted(int vertices) {
		this.adjacencyList = new HashMap<>();
		for (int i = 1; i <= vertices; i++) {
			adjacencyList.put(i, new LinkedList<>());
		}
	}

	public void setEdge(WeightedVertex source, WeightedVertex dest) {
		if (source.getVertex() > adjacencyList.size() || dest.getVertex() > adjacencyList.size()) {
			System.out.println("Not such edge");
			return;
		}
		List<WeightedVertex> sList = adjacencyList.get(source.getVertex());
		sList.add(dest);
		List<WeightedVertex> dList = adjacencyList.get(dest.getVertex());
		dList.add(source);
	}

	public List<WeightedVertex> getEdge(int source) {
		if (source > adjacencyList.size()) {
			System.out.println("Not such edge");
			return null;
		}
		return adjacencyList.get(source);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of vertices and edges <number_vertices> <number_edges>");
		int vertices = scanner.nextInt();
		int edges = scanner.nextInt();
		AdjacencyListWeighted adjacencyList = new AdjacencyListWeighted(vertices);
		int count = 0,weight;
		System.out.println("Enter the edges in graph Format : <source index> <destination index>");
		while (count < edges) {
			WeightedVertex source = new WeightedVertex();
			WeightedVertex destination = new WeightedVertex();
			source.setVertex(scanner.nextInt());
			destination.setVertex(scanner.nextInt());
			weight = scanner.nextInt();
			source.setWeight(weight);
			destination.setWeight(weight);
			adjacencyList.setEdge(source, destination);
			count++;
		}
		System.out.println("the given Adjacency List for the graph \n");
		for (int i = 1; i <= vertices; i++) {
			System.out.print(i + "->");
			List<WeightedVertex> edgeList = adjacencyList.getEdge(i);
			for (int j = 1;; j++) {
				if (j != edgeList.size()) {
					System.out.print(edgeList.get(j - 1) + "->");
				} else {
					System.out.print(edgeList.get(j - 1));
					break;
				}
			}
			System.out.println();
		}
		scanner.close();
	}

}
