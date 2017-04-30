package graphs;

public class Edge {
	
	private int startNodeName;
	private int endNodeName;
	private int weight;
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getStartNodeName() {
		return startNodeName;
	}
	public void setStartNodeName(int startNodeName) {
		this.startNodeName = startNodeName;
	}
	public int getEndNodeName() {
		return endNodeName;
	}
	public void setEndNodeName(int endNodeName) {
		this.endNodeName = endNodeName;
	}
	@Override
	public String toString() {
		return "(" + startNodeName + "," + endNodeName + ": weight=" +  weight+ ")";
	}
}
