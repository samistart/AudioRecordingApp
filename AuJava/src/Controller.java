import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import pages.ApplicationView;
import albumHierarchy.Track;

/**
 * Contains main method that runs the application.
 * Sets the look and feel of the GUI.
 * @author Pietro Passarelli 
 * 
 */
public class Controller {

	public static void main(String[] args) {

		Track.loadTracks();
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		/* Turns off metal's use of bold fonts */
		UIManager.put("swing.boldMetal", Boolean.FALSE);

		/* Schedule a job for the event dispatch thread:
		   creating and showing this application's GUI. */
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ApplicationView.createAndShowGUI();
			}
		});

	}
}


