package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
	private List<Integer> adjList[];
	public BFS(int nodes){
		adjList = new List[nodes];
		for (int i = 0; i < nodes; i++){
			adjList[i] = new LinkedList<>();
		}
	}
	private void bfs(int v,int nodes){
		boolean[] visited = new boolean[nodes];
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v] = true;
		while (queue.size() != 0){
			v = queue.poll();
			System.out.print(v+" ");
			//Get all neighbours of v
			List<Integer> neighbours = adjList[v];
			for (int neighbour : neighbours){
				if (!visited[neighbour]){
					queue.add(neighbour);
					visited[neighbour] = true;
				}
			}
		}
	}
	
	private void addEdge(int source, int destination){
		adjList[source].add(destination);
		// Uncomment this for undirect graph
//		adjList[destination].add(source);
	}
	public static void print(BFS g){
		for(int i =0; i < g.adjList.length; i++){
			System.out.print(i +"->");
			System.out.println(g.adjList[i]);
		}
	}

	public static void main(String[] args) {
		BFS g = new BFS(7);
//		g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 5);
        g.addEdge(5, 6);
        g.addEdge(2, 4);
        g.addEdge(1,0);
        g.addEdge(2,0);
        g.addEdge(3,0);
        g.addEdge(5,1);
        g.addEdge(6,5);
        g.addEdge(4,2);
		print(g);
 
//        System.out.println("Following is Breadth First Traversal "+
//                           "(starting from vertex 2)");
// 
        g.bfs(0,7);
	}

}
