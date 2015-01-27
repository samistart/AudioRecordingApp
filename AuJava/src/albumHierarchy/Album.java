package albumHierarchy;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import utilities.AlbumCreateXMLWithDOM;
import utilities.AlbumDOMReader;

/**
 * An album is an object that holds an arraylist of tracks. It is used in the
 * album hierarchy for organisation. It has not been implemented in this
 * version, therefore this class is not used. It has been left in to show our
 * work anyway.
 * 
 * @author SamiStart
 *
 */
public class Album extends AlbumOrTrack {

	public static final String ALBUMFILE = "db/albums.xml";

	private static ArrayList<Album> allAlbums = new ArrayList<Album>();
	private ArrayList<Track> tracksInAlbum = new ArrayList<Track>();
	private int id;

	/**
	 * Default constructor for album
	 */
	public Album() {
		super();
		this.id = allAlbums.size();
		allAlbums.add(this);
		for (int i = 0; i < Track.getAllTracks().size(); i++) {
			if (Track.getTrack(i).getAlbumId() == this.id) {
				tracksInAlbum.add(Track.getTrack(i));
			}
		}
	}

	/**
	 * A constructor for the album when the params need to be specified by the
	 * user
	 * 
	 * @param ttl
	 * @param dsc
	 * @param pic
	 */
	public Album(String ttl, String dsc, String pic) {
		super(ttl, dsc, pic);
		this.id = allAlbums.size();
		allAlbums.add(this);
		for (int i = 0; i < Track.getAllTracks().size(); i++) {
			if (Track.getTrack(i).getAlbumId() == this.id) {
				tracksInAlbum.add(Track.getTrack(i));
			}
		}
	}

	/**
	 * Load albums from the XML database into the Arraylist. Should be called at
	 * the start of a session.
	 */
	static public void loadAlbums() {
		AlbumDOMReader reader = new AlbumDOMReader();
		allAlbums = reader.getDataFromXML();
	}

	/**
	 * Save all albums from the arraylist to the XML database. Should be used at
	 * least once per session
	 */
	static public void saveAlbums() {
		try {
			AlbumCreateXMLWithDOM.createXmlAllAlbums(allAlbums);
		} catch (FileNotFoundException | ParserConfigurationException
				| TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Append a track to the end of the ArrayList of tracks held in this album
	 * 
	 * @param track
	 */
	public void addTrack(Track track) {
		tracksInAlbum.add(track);
	}

	/**
	 * Returns a track at a specified position in the arraylist
	 * 
	 * @param index
	 *            the index of the ArrayList of tracks for this album that you
	 *            want to access (starts at 0!)
	 * @return Track
	 * 
	 */
	public Track getTrackAt(int index) {
		// TODO get tracks from database
		return tracksInAlbum.get(index);
	}

	/**
	 * Return all tracks as an arraylist
	 * 
	 * @return
	 */
	public ArrayList<Track> getTracks() {
		// TODO get tracks from database
		return tracksInAlbum;
	}

	/**
	 * Return all albums as an arraylist
	 * 
	 * @return Arraylist of all currently stored albums.
	 */
	public static ArrayList<Album> getAllAlbums() {

		return allAlbums;
	}

	/**
	 * Get an album from the arraylist of albums
	 * 
	 * @param index
	 * @return Album at specified position in ArrayList
	 */
	public static Album getAlbum(int index) {

		return allAlbums.get(index);
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void delete(Album album) {

	}

	public static void setAllAlbums(ArrayList<Album> allAlbums) {
		Album.allAlbums = allAlbums;
	}

}