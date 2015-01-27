package pages;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import albumHierarchy.Album;

/**
 * Contains a form for user input to create a new album.
 * @author SamiStart
 *
 */
public class CreateNewAlbumPage extends CreateNewAlbumOrTrackPage {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CreateNewAlbumPage() {
		lblCreateNewTrackalbum.setText("Create New Album");
		
		super.btnCreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				writeInfoToFile();
			}
		});
		
	}
	
	/**Saves the user input once the "Create New Album" button has been pressed*/
	private void writeInfoToFile(){
		Album album = new Album(super.textField_ttl.getText(),
				super.textField_dscrptn.getText(),
				super.textField_pic.getText());	}
}
