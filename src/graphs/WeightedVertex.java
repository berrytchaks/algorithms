package graphs;

public class WeightedVertex {
	private Integer vertex;
	private Integer weight;
	public Integer getVertex() {
		return vertex;
	}
	public void setVertex(Integer vertex) {
		this.vertex = vertex;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Vextex " + vertex + " weight " + weight;
	}
	
}
