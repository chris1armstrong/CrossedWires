
public class CrossingPoint extends Coord{
	private Integer manhattanDist;
	
	public CrossingPoint(Integer x, Integer y, Integer dist) {
		super(x, y);
		this.manhattanDist = dist;
	}

	public Integer getManhattanDist() {
		return manhattanDist;
	}

	public String toString() {
		String prev = super.toString();
		return prev + " Mnht Dist = " + this.getManhattanDist();
	}
}
