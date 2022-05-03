import java.util.Scanner;

/**
 * This is HW1, problem 4.
 * This application confirms that the Cube class is working properly
 * @author Andrew Krause
 */
public class CubeDriver {
	
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		System.out.print("Your cube's side length: ");
		double sideLength = myScanner.nextDouble();
		myScanner.close();
		
		Cube myCube = new Cube(sideLength);
		System.out.println("Cube surface area: " + myCube.surfaceArea());
		System.out.println("Cube volume: " + myCube.volume());
	}
}
