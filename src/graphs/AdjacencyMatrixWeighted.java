package graphs;

import java.util.Scanner;
import java.util.Stack;

public class AdjacencyMatrixWeighted {
	private int[][] matrix;

	public AdjacencyMatrixWeighted(int vertices) {
		this.matrix = new int[vertices][vertices];
		initialize();
	}

	private void initialize() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = -1;
			}
		}
	}

	private void printMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of vertices and edges <number_vertices> <number_edges>");
		int vertices = scanner.nextInt();
		int edges = scanner.nextInt();
		AdjacencyMatrixWeighted adjMat = new AdjacencyMatrixWeighted(vertices);
		int count = 0;
		int v, u, w;
		System.out.println("Enter the edges format: <start_vertex> <end_vertex> <weight>");
		while (count < edges) {
			v = scanner.nextInt();
			u = scanner.nextInt();
			w = scanner.nextInt();
			adjMat.matrix[v - 1][u - 1] = w;
			adjMat.matrix[u - 1][v - 1] = w;
			count++;
		}
		adjMat.printMatrix();
		DFS dfs = new DFS();
		 System.out.println("The DFS Traversal for the graph is given by ");
        dfs.dfs(adjMat.matrix, 0);
		scanner.close();
	}

	static class DFS {
		private Stack<Integer> stack;

		public DFS() {
			stack = new Stack<Integer>();
		}

		public void dfs(int adjacency_matrix[][], int source) {
			int number_of_nodes = adjacency_matrix[source].length - 1;

			int visited[] = new int[number_of_nodes + 1];
			int element = source;
			int i = source;
			System.out.print(element + "\t");
			visited[source] = 1;
			stack.push(source);

			while (!stack.isEmpty()) {
				element = stack.peek();
				i = element;
				while (i <= number_of_nodes) {
					if (adjacency_matrix[element][i] != -1 && visited[i] == 0) {
						stack.push(i);
						visited[i] = 1;
						element = i;
						i = 1;
						System.out.print(element + "\t");
						continue;
					}
					i++;
				}
				stack.pop();
			}

		}

	}
}
