package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AdjacencyList {
	private Map<Integer, List<Integer>> adjacencyList;

	public AdjacencyList(int vertices) {
		this.adjacencyList = new HashMap<>();
		for (int i = 1; i <= vertices; i++) {
			adjacencyList.put(i, new LinkedList<>());
		}
	}

	public void setEdge(int source, int dest) {
		if (source > adjacencyList.size() || dest > adjacencyList.size()) {
			System.out.println("Not such edge");
			return;
		}
		List<Integer> sList = adjacencyList.get(source);
		sList.add(dest);
		List<Integer> dList = adjacencyList.get(dest);
		dList.add(source);
	}

	public List<Integer> getEdge(int source) {
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
		AdjacencyList adjacencyList = new AdjacencyList(vertices);
		int count = 0;
		int source, destination;
		System.out.println("Enter the edges in graph Format : <source index> <destination index>");
		while (count < edges) {
			source = scanner.nextInt();
			destination = scanner.nextInt();
			adjacencyList.setEdge(source, destination);
			count++;
		}
		System.out.println("the given Adjacency List for the graph \n");
		for (int i = 1; i <= vertices; i++) {
			System.out.print(i + "->");
			List<Integer> edgeList = adjacencyList.getEdge(i);
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
