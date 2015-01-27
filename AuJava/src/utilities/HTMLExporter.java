package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import albumHierarchy.Track;

/**
 * HTMlExporter class to enable exporting/sharing of individual tracks.
 * 
 * @author Axel Striesow
 */
public class HTMLExporter {
	
	public static void export (Track track) {
		
		BufferedWriter writer = null;
		String filepath = System.getProperty("user.home") + "/Desktop/" + track.getTitle() + ".html" ;
		
		/* Create a new file on the users desktop using the track name. */ 
		File file = new File(filepath);
		try {
			if (file.createNewFile()){
				System.out.println("File was created.");
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/* Fill the newly created file with track info encapsulated in HTML tags. */
		try {
			writer = new BufferedWriter(new FileWriter(filepath));
			writer.write(
						"<!DOCTYPE HTML>"
				+"\n"+	"<html>"
				+"\n"+	"<head>\n  <title>" + track.getTitle() + "</title>\n</head>"
				+"\n"+	"<body>"
				//+"\n"+	"  <h3>Album: " + track.getAlbumId() + "</h3>"
				+"\n"+	"  <h1>Track Title: " + track.getTitle() + "</h1>"
				+"\n"+	"  <p>"
				+"\n"+	"    Description:\n" + track.getDescription()
				+"\n"+	"  </p>"
				+"\n"+	"  <p>"
				+"\n"+	"    Image: " + track.getPicFileLocation()
				+"\n"+	"  </p>"
				+"\n"+	"  <p>"
				+"\n"+	"    File Location: " + track.getAudioFileLocation()
				+"\n"+	"  </p>"
				+"\n"+	"</body>"
				+"\n"+	"</html>"
			);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace(); 
			System.err.println(e);
		}
		
	}
	
}
