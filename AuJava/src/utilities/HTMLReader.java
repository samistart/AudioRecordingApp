package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Basic reader reading an HTML file to String. 
 * 
 * @author Axel Striesow
 */
public class HTMLReader {
	
	/**
	 * 
	 * @param filepath   HTML files are contained within the apps html folder.
	 * @return   returns the HTML file content as a String.
	 */
	public static String read (String filepath) {
		
		/* Create an empty String to read the HTML file in. */
		String fileContent = "";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filepath));
			String line = "";
			
			/* Read the HTML file line by line and then append a line feed before 
			   adding a line to fileContent. */
			while ( (line = reader.readLine()) != null ) {
				line += "\n";
				fileContent += line;
			}
			reader.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return fileContent;
	}
}
