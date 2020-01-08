
public class Wire {
	private Coord start;
	private Coord end;
	private String orientation;
	
	public Wire(Coord start, Coord end) {
		this.start = start;
		this.end = end;
		if (start.getX() == end.getX()) {
			this.orientation = "V";
		} else {
			this.orientation = "H";
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
		Coord crossing = null;
		if (this.getOrientation() == j.getOrientation()) {
			//System.out.println("Same orientation");
			return null;
		} else {
			Coord hStart;
			Coord hEnd;
			Coord vStart;
			Coord vEnd;
			if (this.getOrientation() == "H") {
				hStart = this.getStart();
				hEnd = this.getEnd();
				vStart = j.getStart();
				vEnd = j.getEnd();
			} else {
				hStart = j.getStart();
				hEnd = j.getEnd();
				vStart = this.getStart();
				vEnd = this.getEnd();
			}
			
			Integer startX;
			Integer endX;
			Integer vertX = vStart.getX();
			if (hStart.getX() > hEnd.getX()) {
				startX = hEnd.getX();
				endX = hStart.getX();
			} else {
				startX = hStart.getX();
				endX = hEnd.getX();
			}
			
			if (vertX <= endX && vertX >= startX) {
				//Good, continue
			} else {
				//System.out.println("X axis won't intersect: " + this + " " + j);
				return null;
			}
			

			Integer startY;
			Integer endY;
			Integer horzY = hStart.getY();
			if (vStart.getY() > vEnd.getY()) {
				startY = vEnd.getY();
				endY = vStart.getY();
			} else {
				startY = vStart.getY();
				endY = vEnd.getY();
			}
			
			if (horzY <= endY && horzY >= startY) {
				//Good, continue
			} else {
				//System.out.println("Y axis won't intersect");
				return null;
			}
			
			crossing = new Coord(vertX, horzY);
		}
		//System.out.println("Found intersection: " + crossing);
		return crossing;
	}
	
	public Integer weight() {
		Integer weight = 0;
		if (this.orientation == "V") {
			weight = this.getEnd().getY() - this.getStart().getY();
		} else {
			weight = this.getEnd().getX() - this.getStart().getX();
		}
		return weight;
	}

	public String toString() {
		return orientation + " " + this.getStart() + " " + this.getEnd();
	}
	
}
