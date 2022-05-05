/**
 * Very simple class representing a song. Contains a title, artist and genre.
 * @author Andrew Krause
 * @version 1.0
 *
 */
public class Song {
	private String title;
	private String artist;
	private String genre;
	
	/**
	 * the full constructor for Song class
	 * @param title Song's title
	 * @param artist Song's artist
	 * @param genre Song's genre
	 */
	public Song(String title, String artist, String genre)
	{
		this.title = title;
		this.artist = artist;
		this.genre = genre;
	}
	
	/**
	 * Song class constructor without the genre parameter
	 * @param title Song's title
	 * @param artist Song's artist
	 */
	public Song(String title, String artist)
	{
		this(title, artist, "unknown");
	}
	
	/**
	 * Outputs the title
	 * @return the title of the song
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * Outputs the artist
	 * @return the artist of the song
	 */
	public String getArtist()
	{
		return artist;
	}
	
	/**
	 * Outputs the genre
	 * @return the genre of the song
	 */
	public String getGenre()
	{
		return genre;
	}
	
	/**
	 * setter for title
	 * @param title new song title
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * setter for artist
	 * @param artist new song artist
	 */
	public void setArtist(String artist)
	{
		this.artist = artist;
	}

	/**
	 * setter for genre
	 * @param genre new song genre
	 */
	public void setGenre(String genre)
	{
		this.genre = genre;
	}
	
	/**
	 * returns the Song's title, artist, and genre in that order as one string
	 */
	public String toString()
	{
		return title + ", " + artist + ", " + genre;
	}
}
