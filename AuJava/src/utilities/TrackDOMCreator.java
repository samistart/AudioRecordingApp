package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import albumHierarchy.Track;

/**
 * {@link}
 * http://www.lynda.com/Java-tutorials/Adding-data-elements-attributes-DOM/
 * Sets up the Document Object Model for tracks
 * @author SamiStart
 *
 */
public class TrackDOMCreator {

	private static final String XMLDATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	Document doc = null;

	public TrackDOMCreator() {
	}

	/**
	 * Takes a tracklist and creates an XML doc with all metadata as nodes.
	 * @param data
	 * @return
	 * @throws ParserConfigurationException
	 */
	public Document createXMLDoc(List<Track> data)
			throws ParserConfigurationException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		doc = builder.newDocument();

		Element root = doc.createElement("tracks");
		doc.appendChild(root);

		for (Track track : data) {
			Element albumElement = addElement(root, "track", "");
			String idAsString = Integer.toString(track.getId());
			albumElement.setAttribute(Track.ID, idAsString);

			addElement(albumElement, Track.TITLE, track.getTitle());

			addElement(albumElement, Track.ALBUMID,
					Integer.toString(track.getId()));

			Element description = addElement(albumElement, Track.DESCRIPTION,
					"");
			CDATASection cdata = doc.createCDATASection(track.getDescription());
			description.appendChild(cdata);

			addElement(albumElement, Track.PICLOCATION,
					track.getPicFileLocation());

			addElement(albumElement, Track.AUDIOLOCATION,
					track.getAudioFileLocation());

			DateFormat df = new SimpleDateFormat(XMLDATEFORMAT);
			addElement(albumElement, Track.ADDED, df.format(track.getAdded()));

		}

		return doc;
	}

	/**
	 * Factored out this method to from <code>createXMLDOC</code> where many elements are added.
	 * @param parent
	 * @param elementName
	 * @param textValue
	 * @return
	 */
	private Element addElement(Element parent, String elementName,
			String textValue) {
		Element childElement = doc.createElement(elementName);
		childElement.setTextContent(textValue);
		parent.appendChild(childElement);
		return childElement;
	}

}
