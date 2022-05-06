/**
 * Very simple class representing an Album. Also tracks total number of Albums created.
 * @author Andrew Krause
 * @version 1.0
 *
 */
public class Album {
	private String title;
	private String artist;
	private String genre;
	private Song favoriteTrack;
	private int trackNumber;
	static int numAlbums = 0;
	
	/**
	 * The full constructor for the Album class
	 * @param title Album's title
	 * @param favoriteTrack user's favorite track in the Album
	 * @param trackNumber the index of the user's favorite track
	 */
	public Album(String title, Song favoriteTrack, int trackNumber)
	{
		this.title = title;
		this.favoriteTrack = favoriteTrack;
		this.trackNumber = trackNumber;
		this.artist = favoriteTrack.getArtist();
		this.genre = favoriteTrack.getGenre();
		numAlbums++;
	}
	
	/**
	 * Constructor for the Album class without the trackNumber parameter
	 * @param title Album's title
	 * @param favoriteTrack user's favorite track in the Album
	 */
	public Album(String title, Song favoriteTrack)
	{
		this(title, favoriteTrack, 1);
	}
	
	/**
	 * Outputs the title
	 * @return the title of the album
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * Outputs the favorite track as a Song object
	 * @return the favorite track of the Album
	 */
	public Song getFavoriteTrack()
	{
		return favoriteTrack;
	}
	
	/**
	 * Outputs the track number of the favorite track
	 * @return the track number of the favorite track
	 */
	public int getTrackNumber()
	{
		return trackNumber;
	}
	
	/**
	 * setter for Album genre and the also sets the favorite track genre
	 * @param genre new song/album genre
	 */
	public void setGenre(String genre)
	{
		this.genre = genre;
		favoriteTrack.setGenre(genre);
	}
	
	/**
	 * returns the Album's title, artist, and genre as one string
	 */
	public String toString()
	{
		return title + " by " + artist + ": " + genre;
	}
}