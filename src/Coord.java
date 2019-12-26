
public class Coord {
	private Integer x;
	private Integer y;
	
	public Coord(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	
	public Integer getX() {
		return this.x;
	}
	
	public Integer getY() {
		return this.y;
	}
	
	public String toString() {
		return "(" + this.getX() + "," + this.getY() + ")";
	}
}
