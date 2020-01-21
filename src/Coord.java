
public class Coord {
	private Integer x;
	private Integer y;
	private Boolean visited;
	
	public Coord(Integer x, Integer y) {
		this.x = x;
		this.y = y;
		this.visited = false;
	}
	
	public Integer getX() {
		return this.x;
	}
	
	public Integer getY() {
		return this.y;
	}
	
	public Boolean isVisited() {
		return this.visited;
	}
	
	public void setVisited() {
		this.visited = true;
	}
	
	public String toString() {
		return "(" + this.getX() + "," + this.getY() + ")";
	}
}
