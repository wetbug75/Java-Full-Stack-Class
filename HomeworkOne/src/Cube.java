/**
 * This is HW1, problem 3.
 * This class represents a very simple cube
 * @author Andrew Krause
 */
public class Cube {
	double sideLength;
	
	public Cube(double sideLength){
		this.sideLength = sideLength;
	}
	
	public double surfaceArea() {
		return sideLength * sideLength * 6;
	}
	
	public double volume() {
		return sideLength * sideLength * sideLength;
	}
}
