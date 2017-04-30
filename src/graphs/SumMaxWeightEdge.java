package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SumMaxWeightEdge {
	private Map<Integer, List<MyNode>> adjacencyList;
	static class MyNode{
		int vertex;
		int weight;
		public int getVertex() {
			return vertex;
		}
		public void setVertex(int node) {
			this.vertex = node;
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		@Override
		public String toString() {
			return " vextex " + vertex + " weight " + weight;
		}
	}
	public void setEdge(MyNode source, MyNode dest) {
		if (source.getVertex() > adjacencyList.size() || dest.getVertex() > adjacencyList.size()) {
			System.out.println("Not such edge");
			return;
		}
		List<MyNode> sList = adjacencyList.get(source.getVertex());
		sList.add(dest);
		List<MyNode> dList = adjacencyList.get(dest.getVertex());
		dList.add(source);
	}

	public List<MyNode> getEdge(int source) {
		if (source > adjacencyList.size()) {
			System.out.println("Not such edge");
			return null;
		}
		return adjacencyList.get(source);
	}
	
	public SumMaxWeightEdge(int vertices) {
		this.adjacencyList = new HashMap<>();
		for (int i = 1; i <= vertices; i++) {
			adjacencyList.put(i, new LinkedList<>());
		}
	}
	public Integer maxWeight(int i, int j){
		int max=0;
		int current = -1;
		while(i <j){
			List<MyNode> edgeList = getEdge(i);
			for (MyNode myNode : edgeList){
				if (max < myNode.getWeight() && myNode.getVertex() <=j && i<myNode.getVertex()){
					max = myNode.getWeight();
				}
				current = myNode.getVertex();
			}
			i = current;
		}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testcases = scanner.nextInt();
		int times = 1;
		while (times <=testcases){
			int vertices = scanner.nextInt();
			SumMaxWeightEdge sumMaxWeightEdge = new SumMaxWeightEdge(vertices);
			int count = 0,weight;
			while (count < vertices-1) {
				MyNode source = new MyNode();
				MyNode destination = new MyNode();
				source.setVertex(scanner.nextInt());
				destination.setVertex(scanner.nextInt());
				weight = scanner.nextInt();
				source.setWeight(weight);
				destination.setWeight(weight);
				sumMaxWeightEdge.setEdge(source, destination);
				count++;
			}
			System.out.println("the given Adjacency List for the graph \n");
			for (int i = 1; i <= vertices; i++) {
				System.out.print(i + "->");
				List<MyNode> edgeList = sumMaxWeightEdge.getEdge(i);
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
//			System.out.println(sumMaxWeightEdge.maxWeight(1, 8));
			long sum = 0;
			for (int i = 1; i <= vertices; i++){
				for (int j = i+1; j <= vertices; j++ ){
					System.out.println("F("+i+","+j+")="+sumMaxWeightEdge.maxWeight(i, j));
					sum = sum +sumMaxWeightEdge.maxWeight(i, j);
					System.out.println("sum "+sum);
				}
			}
//			System.out.println(sum);
			times++;
		}
		scanner.close();
	}

}
