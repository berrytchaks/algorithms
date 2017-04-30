package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class AdjacencyMatrix {
	private int[][] matrix;

	public AdjacencyMatrix(int vertices) {
		// create a matrix where all elements content zero
		this.matrix = new int[vertices][vertices];
	}

	private void printMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of vertices and edges <number_vertices> <number_edges>");
		int vertices = scanner.nextInt();
		int edges = scanner.nextInt();
		AdjacencyMatrix adjMat = new AdjacencyMatrix(vertices);
		int count = 0;
		int v, u;
		System.out.println("Enter the edges format: <start_vertex> <end_vertex>");
		while (count < edges) {
			v = scanner.nextInt()-1;
			u = scanner.nextInt()-1;
			adjMat.matrix[v][u] = 1;
			adjMat.matrix[u][v] = 1;
			count++;
		}
		adjMat.printMatrix();
		DFS dfs = new DFS();
		System.out.println("The DFS Traversal for the graph is given by ");
//		for (int i = 0; i < vertices; i++){
			dfs.dfs(adjMat.matrix, 0);
			System.out.println();
//		}
		for(Map.Entry<Integer, List<Integer>>edge: edgeRepresentation.entrySet()){
			System.out.println(edge);
		}
		scanner.close();
	}
	static Map<Integer,List<Integer>> edgeRepresentation;

	static class DFS {
		private Stack<Integer> stack;
		private Stack<Integer> copyStack;

		public DFS() {
			stack = new Stack<Integer>();
			copyStack = new Stack<Integer>();
		}

		public void dfs(int adjacency_matrix[][], int source) {
			int number_of_nodes = adjacency_matrix[source].length - 1;
			edgeRepresentation = new HashMap<>();
			int visited[] = new int[number_of_nodes + 1];
			int element = source;
			int i = source;
			System.out.print(element + 1 + "\t");
			visited[source] = 1;
			stack.push(source);
			int counter = 0;
			while (!stack.isEmpty()) {
				element = stack.peek();
				i = element;
				while (i <= number_of_nodes) {
					if (adjacency_matrix[element][i] == 1 && visited[i] == 0) {
						stack.push(i);
						visited[i] = 1;
						element = i;
						i = 1;
						System.out.print(element + 1 + "\t");
						continue;
					}
					i++;
				}
				int copyElement = stack.pop();
				copyStack.push(copyElement);
				while (!stack.isEmpty()) {
					copyElement = stack.pop();
					copyStack.push(copyElement);
				}
				int index = 0;
				copyElement = copyStack.pop();
				stack.push(copyElement);
				List<Integer> listElement = new LinkedList<>();
				edgeRepresentation.put(counter, listElement);
				listElement.add(copyElement);
				index++;
				while (!copyStack.isEmpty()) {
					copyElement = copyStack.pop();
					stack.push(copyElement);
					listElement.add(copyElement);
					index++;
				}
				counter++;
				stack.pop();

			}

		}

	}

}
