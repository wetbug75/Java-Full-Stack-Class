import java.util.Scanner;

/**
 * Simulates an album collection which can display the favorite track of each album and some other Album info.
 * The user can also change the genre of each album/favorite song.
 * @author Andrew Krause
 * @version 1.0
 *
 */
public class MusicCollection {
	static Scanner myScanner = new Scanner(System.in);
	
	/**
	 * Displays a collection of albums and allows the user to select which to interact with
	 * @param args
	 */
	public static void main(String[] args) {
		Song songA = new Song("Slow Ride","Foghat","Classic Rock");
		Song songB = new Song("Purple Lamborghini","Skrillex","Dubstep");
		Song songC = new Song("Uptown Funk","Mark Ronson");
		Album albumA = new Album("Fool for the City", songA);
		Album albumB = new Album("Suicide Squad: The Album", songB, 2);
		Album albumC = new Album("Uptown Special", songC, 3);
		int albumSelection = 1;
		
		while(albumSelection != 0)
		{
			System.out.println("Music Collection:");
			System.out.println("[" + albumA.getTrackNumber() + "] " + albumA.getTitle());
			System.out.println("[" + albumB.getTrackNumber() + "] " + albumB.getTitle());
			System.out.println("[" + albumC.getTrackNumber() + "] " + albumC.getTitle());
			System.out.print("Select an Album (0 to quit): ");
			albumSelection = myScanner.nextInt();
			
			if(albumSelection == 1)
				albumOptions(albumA);
			else if(albumSelection == 2)
				albumOptions(albumB);
			else if(albumSelection == 3)
				albumOptions(albumC);
		}
		System.out.println("Goodbye");
	}
	
	/**
	 * Displays album info and prompts the user into seeing the favorite track, editing the genre, or returning to the previous menu
	 * @param theAlbum the Album object the user wishes to interact with
	 */
	public static void albumOptions(Album theAlbum)
	{
		System.out.println();
		int selection = 1;
		while(selection != 0)
		{
			System.out.println(theAlbum.toString());
			System.out.println();
			System.out.println("Album options:");
			System.out.println("[1] Get Favorite Track");
			System.out.println("[2] Change genre");
			System.out.println("[0] return");
			System.out.println("Selection: ");
			selection = myScanner.nextInt();
			
			if(selection == 1)
			{
				System.out.println("Track No. " + theAlbum.getTrackNumber() + ": " + theAlbum.getFavoriteTrack().toString());
			}
			else if(selection == 2)
			{
				System.out.println("New genre: ");
				myScanner.nextLine();//bug fix
				String newGenre = myScanner.nextLine();
				theAlbum.setGenre(newGenre);
			}
			System.out.println();
		}
	}
}
