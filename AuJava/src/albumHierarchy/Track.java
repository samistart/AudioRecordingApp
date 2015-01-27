package albumHierarchy;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import utilities.TrackCreateXMLWithDOM;
import utilities.TrackDOMReader;

/**
 * A track class holds all the fields you might expect from an audio file with
 * meta data, along with getter and setter methods and methods for saving and
 * loading to the xml database
 * 
 * @author SamiStart
 *
 */
public class Track extends AlbumOrTrack {

	/** The name of the file for the xml database */
	public static final String TRACKFILE = "tracks.xml";

	/**
	 * The album id of the album that this track belongs to (not used for this
	 * version)
	 */
	public static final String ALBUMID = "albumid";

	/***/
	public static final String AUDIOLOCATION = "audiolocation";

	/**
	 * The location of the audio file is saved to the track, rather than the
	 * audio file itself. Audio is stored in the audio folder
	 */
	private String audioFileLocation;
	/** ID for the track in the DB */
	private int id;
	/**
	 * The ID of the album that this track belongs to (not used for this
	 * version)
	 */
	private int AlbumId;
	/**
	 * A static arraylist to hold all the tracks in order throughout the session
	 */
	private static ArrayList<Track> allTracks = new ArrayList<Track>();
	
	static String dsc = "A default track description";
	static String pic = System.getProperty("user.dir")+"/audava/img/" +"Track.png";

	public Track() {
		super();
		this.AlbumId = 0;
		this.audioFileLocation = "default constructor audio location";
		this.id = allTracks.size();
		allTracks.add(this);
	}

	public Track(String ttl, String dsc, String pic, String aud) {
		super(ttl, dsc, pic);
		this.audioFileLocation = aud;
		this.id = allTracks.size();
		allTracks.add(this);
		saveTracks();
	}

	/**
	 * Constructor for track which puts the time of creation as title. Used in record page.
	 * @param outputFilename
	 */
	public Track(String outputFilename) {
		super(outputFilename, dsc, pic);
		this.audioFileLocation = outputFilename;
		allTracks.add(this);
		saveTracks();
	}


	/**
	 * 
	 * @return the location of the file with the audio for this track
	 */
	public String getAudioFileLocation() {
		return audioFileLocation;
	}

	/**
	 * 
	 * @param audioFileLocation
	 *            set this file location as the audio file for this track
	 */
	public void setAudioFileLocation(String audioFileLocation) {
		this.audioFileLocation = audioFileLocation;
	}

	/**
	 * Used for saving to the XML database
	 * 
	 * @return all the tracks as an arraylist
	 */
	public static ArrayList<Track> getAllTracks() {
		return allTracks;
	}

	/**
	 * Used for loading from the DB
	 * 
	 * @param allTracks
	 */
	public static void setAllTracks(ArrayList<Track> allTracks) {
		Track.allTracks = allTracks;
	}

	/**
	 * 
	 * @param index
	 * @return Album at specified position in ArrayList
	 */
	public static Track getTrack(int index) {
		return allTracks.get(index);
	}

	public int getAlbumId() {
		return AlbumId;
	}

	public void setAlbumId(int albumId) {
		AlbumId = albumId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Save all tracks to the DB. This should be called at least once per
	 * session.
	 */
	public static void saveTracks() {
		try {
			TrackCreateXMLWithDOM.createXmlAllTracks(allTracks);
		} catch (FileNotFoundException | ParserConfigurationException
				| TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Load tracks from DB. Should be called at the start of the session.
	 */
	static public void loadTracks() {
		TrackDOMReader reader = new TrackDOMReader();
		setAllTracks(reader.getDataFromXML());
	}

}