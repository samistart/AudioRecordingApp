package jComponents;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * PictureLabel provides a reusable component for putting 
 * pictures into a JLabel, in case many more picture would be used. 
 * The current version of this app does not use it.
 * 
 * @author Axel Striesow
 */
public class PictureLabel extends JLabel {

	/**
	 * If only picture location is provided, size and location in GUI 
	 * is set to default values and the Constructor that actually does 
	 * do the work is called.
	 * @param picLocation	File path of picture.
	 */
	public PictureLabel (String picLocation) {
		this(picLocation,20,50,20,20);
	}

	/**
	 * Populates the PictureLabel and puts it onto the GUI.
	 * 
	 * @param picLocation	File path of picture.
	 * @param x  X-coordinate picture in GUI.
	 * @param y  Y-coordinate picture in GUI.
	 * @param width		Width of picture in GUI.
	 * @param height	Height of picture in GUI.
	 */
	public PictureLabel (String picLocation, int x, int y, int width, int height) {
		this.setIcon(new ImageIcon(picLocation));
		this.setBounds(x,y,width,height);
		
		
	}

}
