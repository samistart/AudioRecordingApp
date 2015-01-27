package pages;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import albumHierarchy.Track;

/**
 * JPanel with a form and submission for creating new tracks
 * @author SamiStart
 *
 */
public class CreateNewTrackPage extends CreateNewAlbumOrTrackPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2621082381564582247L;
	private JTextField textField_aud;

	/**
	 * Create the frame.
	 */
	public CreateNewTrackPage() {
		lblCreateNewTrackalbum.setText("Create New Track");

		JLabel lblChooseAnAudio = new JLabel("Choose an audio file");
		GridBagConstraints gbc_lblChooseAnAudio = new GridBagConstraints();
		gbc_lblChooseAnAudio.anchor = GridBagConstraints.EAST;
		gbc_lblChooseAnAudio.insets = new Insets(0, 0, 0, 5);
		gbc_lblChooseAnAudio.gridx = 0;
		gbc_lblChooseAnAudio.gridy = 5;
		add(lblChooseAnAudio, gbc_lblChooseAnAudio);

		textField_aud = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 5;
		add(textField_aud, gbc_textField);
		textField_aud.setColumns(10);
		
//		Creates a space between the fields and the create button
		JLabel spacerComponent = new JLabel("");
		GridBagConstraints gbc_spacerComponent = new GridBagConstraints();
		gbc_spacerComponent.anchor = GridBagConstraints.EAST;
		gbc_spacerComponent.insets = new Insets(0, 0, 0, 5);
		gbc_spacerComponent.gridx = 0;
		gbc_spacerComponent.gridy = 6;
		gbc_spacerComponent.gridwidth=GridBagConstraints.REMAINDER;
		add(spacerComponent, gbc_spacerComponent);

		super.btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				writeInfoToFile();
			}
		});

	}

	private void writeInfoToFile() {

		Track track = new Track(super.textField_ttl.getText(),
				super.textField_dscrptn.getText(),
				super.textField_pic.getText(), textField_aud.getText());
	}

}
