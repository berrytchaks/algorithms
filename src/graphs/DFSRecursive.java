package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFSRecursive {
	private List<Integer> adjList[];
	Queue<Integer> queue;
	public DFSRecursive(int nodes){
		adjList = new List[nodes];
		for (int i = 0; i < nodes; i++){
			adjList[i] = new LinkedList<>();
		}
	}
	private void dfs(int v, boolean[] visited){
		visited[v] = true;
		System.out.print(v+" ");
		//Get all neighbours of v
		List<Integer> neighbours = adjList[v];
		for (int neighbour : neighbours){
			if (!visited[neighbour]){
				dfs(neighbour, visited);
			}
		}
	}
	private void dfsUtils(int nodes, int start){
		boolean[] visited = new boolean[nodes];
		dfs(start, visited);
	}
	
	private void addEdge(int source, int destination){
		adjList[source].add(destination);
		// Uncomment this for undirect graph
//		adjList[destination].add(source);
	}

	public static void main(String[] args) {
		DFSRecursive g = new DFSRecursive(5);
//		g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 4);
		
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.dfsUtils(5,3);
	}

}
