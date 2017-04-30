package graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private String name;
	private List<Edge> neighbours = new ArrayList<>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Edge> getNeighbours() {
		return neighbours;
	}
	public void setNeighbours(List<Edge> neighbours) {
		this.neighbours = neighbours;
	}
	@Override
	public String toString() {
		return "Node [name=" + name + ", neighbours=" + neighbours + "]";
	}
	
}
