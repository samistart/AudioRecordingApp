package albumHierarchy;

import java.util.Date;

/**
 * This is an abstract class to hold the common members for albums and tracks.
 * Albums and tracks should extend this class.
 * 
 * @author SamiStart
 */
public abstract class AlbumOrTrack {

	// data item names from JSON file
	public static final String ID = "id", TITLE = "name",
			DESCRIPTION = "description", PICLOCATION = "picture",
			ADDED = "added";

	private int id;
	private String title;
	private String description;
	private String picFileLocation;
	private Date added;

	/**
	 * Default constructor
	 */
	public AlbumOrTrack() {
		this.title = "default constructor title";
		this.description = "default constructor description";
		this.picFileLocation = "default constructor pic location";
		this.added = new Date();

	}

	/**
	 * A constructor for when the user specifies the params.
	 * @param ttl
	 * @param dsc
	 * @param pic
	 */
	public AlbumOrTrack(String ttl, String dsc, String pic) {
		this.title = ttl;
		this.description = dsc;
		this.picFileLocation = pic;
		this.added = new Date();
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPicFileLocation(String picFileLocation) {
		this.picFileLocation = picFileLocation;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getPicFileLocation() {
		return picFileLocation;
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	public String toString() {
		return this.id + ". " + this.title + " added " + this.added;
	}
}
