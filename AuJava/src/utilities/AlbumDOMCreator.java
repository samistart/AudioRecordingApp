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

import albumHierarchy.Album;

/**
 * {@link}http://www.lynda.com/Java-tutorials/Adding-data-elements-attributes-DOM/
 * @author SamiStart
 *Creates the Document Object Model for albums.
 */
public class AlbumDOMCreator {

	private static final String XMLDATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	Document doc = null;
	
	public AlbumDOMCreator() {
	}

	/**
	 * Converts the List of all albums into an XML doc
	 * @param data
	 * @return XML doc for albums
	 * @throws ParserConfigurationException
	 */
	public Document createXMLDoc(List<Album> data) throws ParserConfigurationException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		doc = builder.newDocument();
		
		Element root = doc.createElement("albums");
		doc.appendChild(root);
		
		for (Album album : data) {
			Element albumElement = addElement(root,"album","");
			String idAsString = Integer.toString(album.getId());
			albumElement.setAttribute(Album.ID, idAsString);
			
			addElement(albumElement, Album.TITLE, album.getTitle());
			
			
			Element description = addElement(albumElement, Album.DESCRIPTION, "");
			CDATASection cdata = doc.createCDATASection(album.getDescription());
			addElement(albumElement, Album.PICLOCATION, album.getPicFileLocation());
			description.appendChild(cdata);

			DateFormat df = new SimpleDateFormat(XMLDATEFORMAT);
			addElement(albumElement, Album.ADDED, df.format(album.getAdded()));

			
		}
		
		return doc;
	}

	/**
	 * Factored out from <code>createXMLDoc</code> where many elements are added.
	 * @param parent
	 * @param elementName
	 * @param textValue
	 * @return
	 */
	private Element addElement(Element parent, String elementName, String textValue) {
		Element childElement = doc.createElement(elementName);
		childElement.setTextContent(textValue);
		parent.appendChild(childElement);
		return childElement;
	}

}
