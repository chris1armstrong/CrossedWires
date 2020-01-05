import java.util.ArrayList;

public class Coord {
	private Integer x;
	private Integer y;
	private ArrayList<Wire> connected;
	
	public Coord(Integer x, Integer y) {
		this.x = x;
		this.y = y;
		this.connected = new ArrayList<Wire>();
	}
	
	public Integer getX() {
		return this.x;
	}
	
	public Integer getY() {
		return this.y;
	}
	
	public ArrayList<Wire> getConnected() {
		return this.connected;
	}
	
	public String toString() {
		return "(" + this.getX() + "," + this.getY() + ")";
	}
}
