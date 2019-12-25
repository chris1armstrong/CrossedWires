
public class Wire {
	private Coord start;
	private Coord end;
	private String orientation;
	
	public Wire(Coord start, Coord end) {
		this.start = start;
		this.end = end;
		if (start.getX() == end.getX()) {
			this.orientation = "H";
		} else {
			this.orientation = "V";
		}
	}

	public Coord getStart() {
		return start;
	}

	public Coord getEnd() {
		return end;
	}

	public String getOrientation() {
		return orientation;
	}

	public Coord intersect(Wire j) {
		// TODO Auto-generated method stub
		return null;
	}

}