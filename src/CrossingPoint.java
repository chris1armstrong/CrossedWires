
public class CrossingPoint extends Coord{
	private Wire firstWire;
	private Wire secondWire;
	
	public CrossingPoint(Integer x, Integer y, Wire firstWire, Wire secondWire) {
		super(x, y);
		this.firstWire = firstWire;
		this.secondWire = secondWire;
	}

	public Integer getManhattanDist() {
		return Math.abs(this.getX()) + Math.abs(this.getY());
	}

	public String toString() {
		String prev = super.toString();
		return prev + " Mnht Dist = " + this.getManhattanDist();
	}

	public Integer steps() {
		Integer firstSoFar = this.firstWire.getPreviousTotal();
		Integer secondSoFar = this.secondWire.getPreviousTotal();
		Integer result = firstSoFar + secondSoFar;
		
		if (this.firstWire.getOrientation() == "V") {
			result = result + Math.abs(this.firstWire.getStart().getY() - this.getY());
			result = result + Math.abs(this.secondWire.getStart().getX() - this.getX());
		} else {
			result = result + Math.abs(this.secondWire.getStart().getY() - this.getY());
			result = result + Math.abs(this.firstWire.getStart().getX() - this.getX());
		}
		
		return result;
	}
}
