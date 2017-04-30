package graphs;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Graph {

	private List<Node> graph;
	public Graph(){
		graph = new ArrayList<>();
	}
	
	public Graph(int numberOfNodes){
		graph = new ArrayList<>();
		for(int i = 0; i <= numberOfNodes; i++){
			graph.add(new Node());
		}
	}
	public void addNode(String name){
		for (Node node: graph){
			if (node.getName().equals(name)){
				return;
			}
		}
		Node node = new Node();
		node.setName(name);
		graph.add(node);
		
	}
	public void addNeighbour(String name, Edge edge){
		int index = 0;
		for (Node node: graph){
			if (node.getName().equals(name)){
				graph.get(index).getNeighbours().add(edge);
			}
			index++;
		}
	}
	public Edge addEdge(int start, int end, int weight){
		Edge edge = new Edge();
		edge.setWeight(weight);
		edge.setStartNodeName(start);
		edge.setEndNodeName(end);
		return edge;
	}
	public List<Edge> getEdges(String nodeName){
		int index = 0;
		List<Edge> edges = new ArrayList<>();
		for (Node node : graph){
			if (node.getName().equals(nodeName)){
				edges= graph.get(index).getNeighbours();
				break;
			}
			index++;
		}
		return edges;
	}
	public static void main(String[] args) {
		
		int numberOfEdges, numberOfVertices;
		Scanner scan = new Scanner(System.in);
		int source, destination;
		int count = 1,weight;
		try{
//			System.out.println("Enter the number of vertices and edges in graph");
			numberOfVertices = scan.nextInt();
//			numberOfEdges = scan.nextInt();
			numberOfEdges = numberOfVertices-1;
			Graph myGraph = new Graph();
//			System.out.println("Enter the edges in graph format : <source index> <destination index> <weight>");
			while(count <= numberOfEdges){
				source = scan.nextInt();
				destination = scan.nextInt();
				weight = scan.nextInt();
				Edge edge =myGraph.addEdge(source, destination, weight);
				myGraph.addNode(""+source);		
				myGraph.addNeighbour(""+source, edge);
				count++;
			}
			System.out.println("Print the graph");
			for (int i = 1; i <= numberOfVertices; i++){
				System.out.print(i+"-");
                List<Edge> edgeList = myGraph.getEdges(""+i);
                for (Edge edge : edgeList){
                	System.out.print("w="+edge.getWeight()+"->"+edge.getEndNodeName());
                }
                System.out.println();	
			}
		}catch(InputMismatchException e){
			System.out.println("Error in Input Format. \nFormat : <source index> <destination index> <weight>");
		}
		scan.close();
		
					
	}

	@Override
	public String toString() {
		return "Graph [graph=" + graph + "]";
	}
	
	

}
