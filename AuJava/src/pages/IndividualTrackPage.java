package pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jComponents.InfoPanel;
import jComponents.PictureLabel;

import javax.sound.sampled.Clip;
import javax.swing.JPanel;

import sound.AudioPlayer;
import utilities.HTMLExporter;

import javax.swing.JLabel;
import javax.swing.JButton;

import albumHierarchy.Track;

/**
 * Displays one track with detailed information and the audio player to play the track.
 * 
 * @author Axel Striesow
 * @author Pietro Passarelli
 */
public class IndividualTrackPage extends Page {

	/**
	 * Takes in a track object and populates the page with its information and attached
	 * files, picture and audio file.
	 * 
	 * @param track   Track object containing information and attached files.
	 */
	public IndividualTrackPage(Track track) {
		this.setLayout(null);

		InfoPanel infoPanel = new InfoPanel(track.getTitle(), track.getDescription(), track.getPicFileLocation());
		infoPanel.setBounds(200, 23, 480, 282);
		add(infoPanel);
		
		/* Create a new AudioPlayer for the current track. */
		AudioPlayer ap = new AudioPlayer(track.getAudioFileLocation()); 
		ap.setLocation(200,308);
		this.add(ap);
		
		/* Enables sharing the track via an html file utilizing the HTMLExporter. */
		JButton btnExportToHtml = new JButton("Export to HTML");
		btnExportToHtml.setBounds(563, 332, 117, 57);
		add(btnExportToHtml);

		btnExportToHtml.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/* Calling the HTMLExporter to create an html file for sharing the track. */
				HTMLExporter.export(track);
			}
		});
	}
}
