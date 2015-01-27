package utilities;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import albumHierarchy.Album;

/**
 * Reads a from the XML DB and generates and arraylist of albums for that data.
 * @author SamiStart
 *
 */
public class AlbumDOMReader {
	
	private static final String XMLDATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	@SuppressWarnings("deprecation")
	public ArrayList<Album> getDataFromXML() {
		
		ArrayList<Album> data = new ArrayList<>();
		
		File xmlFile = new File(Album.ALBUMFILE);
		Document doc = null;
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(xmlFile);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		NodeList list = doc.getElementsByTagName("album");
		
		for (int i = 0; i < list.getLength(); i++) {
			Album album = new Album();
			data.add(album);
			
			Element albElement = (Element) list.item(i);
			String idAsString = albElement.getAttribute(Album.ID);
			album.setId(Integer.parseInt(idAsString));
			String content = getTextFromElement(albElement,Album.TITLE);
			album.setTitle(content);
			content = getTextFromElement(albElement, Album.DESCRIPTION);
			album.setDescription(content);
			content = getTextFromElement(albElement, Album.PICLOCATION);
			album.setPicFileLocation(content);
			
			String added = getTextFromElement(albElement, Album.ADDED);
			try {
				album.setAdded(new SimpleDateFormat(XMLDATEFORMAT).parse(added));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return data;	
	}

	/**
	 * Factored out from <code>getDataFromXML</code>
	 * @param albElement
	 * @param elementName
	 * @return
	 */
	private String getTextFromElement(Element albElement, String elementName) {
		Element node = (Element) albElement.getElementsByTagName(elementName).item(0);
		String content = node.getTextContent();
		return content;
	}

}
