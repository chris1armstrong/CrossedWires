import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CrossedWires {
	private ArrayList<Wire> firstPath;
	private ArrayList<Wire> secondPath;
	
	public CrossedWires(String line1, String line2) {
		String[] steps1 = line1.split(",");
		String[] steps2 = line2.split(",");
		
		this.firstPath = generatePath(steps1);
		this.secondPath = generatePath(steps2);
	}

	private ArrayList<Wire> generatePath(String[] steps) {
		ArrayList<Wire> result = new ArrayList<Wire>();
		Coord current = new Coord(0,0);
		Integer previousTotal = 0;
		
		for(String i : steps) {
			char c = i.charAt(0);
			Integer dist = Integer.parseInt(i.substring(1));
			Integer x = current.getX();
			Integer y = current.getY();
			switch (c) {
			case 'U':
				y = y + dist;
				break;
			case 'D':
				y = y - dist;
				break;
			case 'L':
				x = x - dist;
				break;
			case 'R':
				x = x + dist;
				break;
			default:
				break;
			}
			
			Coord end = new Coord(x,y);
			Wire wire = new Wire(current,end,previousTotal);

			result.add(wire);
			current = end;
			previousTotal = previousTotal + dist;
		}
		
		return result;
	}

	public static void main(String[] args) throws FileNotFoundException {
		File input = new File("input.txt");
		Scanner reader = new Scanner(input);
		String line1 = reader.nextLine();
		String line2 = reader.nextLine();
		reader.close();
		CrossedWires system = new CrossedWires(line1, line2);
		ArrayList<CrossingPoint> cpoints = system.findCrossings();
		CrossingPoint result = findShortestManhat(cpoints);
		System.out.println(result);
		Integer steps = findSteps(cpoints);
		System.out.println(steps);
	}

	private static Integer findSteps(ArrayList<CrossingPoint> cpoints) {
		Integer minDist = Integer.MAX_VALUE;
		Integer current = null;
		for (CrossingPoint i : cpoints) {
			current = i.steps();
			if (current < minDist) {
				minDist = current;
			}
		}
		return minDist;
	}

	private static CrossingPoint findShortestManhat(ArrayList<CrossingPoint> cpoints) {
		CrossingPoint result = null;
		for (CrossingPoint i : cpoints) {
			if (result == null) {
				result = i;
			} else if (i.getManhattanDist() < result.getManhattanDist()) {
				result = i;
			}
		}
		return result;
	}

	private ArrayList<CrossingPoint> findCrossings() {
		ArrayList<CrossingPoint> crossingPoints = new ArrayList<CrossingPoint>();
		for(Wire i : this.firstPath) {
			for(Wire j : this.secondPath) {
				Coord crossing = i.intersect(j);
				if (crossing != null) {
					CrossingPoint cpoint = new CrossingPoint(crossing.getX(),crossing.getY(),i,j);
					crossingPoints.add(cpoint);
				}
			}
		}
		return crossingPoints;
	}

}
