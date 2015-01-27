package pages;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import jComponents.MenuBar;

import javax.swing.JTextField;
import javax.swing.JButton;


/**
 * An abstract class to hold similarities between the create a track page and
 * the create an album page. Should be extended by these pages.
 * 
 * @author SamiStart
 *
 */
public abstract class CreateNewAlbumOrTrackPage extends Page {

	private JPanel contentPane;

	
	protected int lblCount = 3;
	protected JTextField textField_ttl;
	protected JTextField textField_dscrptn;
	protected JTextField textField_pic;
	protected JButton btnCreate;
	protected MenuBar menuBar;
	protected JLabel lblCreateNewTrackalbum;

	/**
	 * Create the frame.
	 */
	public CreateNewAlbumOrTrackPage() {
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		
		lblCreateNewTrackalbum = new JLabel("Create new track/album (edit this text in subclass!!)");
		GridBagConstraints gbc_lblCreateNewTrackalbum = new GridBagConstraints();
		gbc_lblCreateNewTrackalbum.gridwidth = 2;
		gbc_lblCreateNewTrackalbum.insets = new Insets(0, 0, 5, 0);
		gbc_lblCreateNewTrackalbum.gridx = 0;
		gbc_lblCreateNewTrackalbum.gridy = 1;
		gbc_lblCreateNewTrackalbum.gridheight=2;
		gbc_lblCreateNewTrackalbum.anchor=GridBagConstraints.NORTH;
		add(lblCreateNewTrackalbum, gbc_lblCreateNewTrackalbum);	
		
		JLabel lblTitle = new JLabel("Title");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.EAST;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 2;
		add(lblTitle, gbc_lblTitle);
		
		textField_ttl = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		add(textField_ttl, gbc_textField);
		textField_ttl.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.EAST;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 3;
		add(lblDescription, gbc_lblDescription);
		
		textField_dscrptn = new JTextField();
		GridBagConstraints gbc_textField_dscrptn = new GridBagConstraints();
		gbc_textField_dscrptn.insets = new Insets(0, 0, 5, 0);
		gbc_textField_dscrptn.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_dscrptn.gridx = 1;
		gbc_textField_dscrptn.gridy = 3;
		add(textField_dscrptn, gbc_textField_dscrptn);
		textField_dscrptn.setColumns(10);
		
		JLabel lblChooseAPicture = new JLabel("Choose a picture");
		GridBagConstraints gbc_lblChooseAPicture = new GridBagConstraints();
		gbc_lblChooseAPicture.anchor = GridBagConstraints.EAST;
		gbc_lblChooseAPicture.insets = new Insets(0, 0, 5, 5);
		gbc_lblChooseAPicture.gridx = 0;
		gbc_lblChooseAPicture.gridy = 4;
		add(lblChooseAPicture, gbc_lblChooseAPicture);
		
		textField_pic = new JTextField();
		GridBagConstraints gbc_textField_pic = new GridBagConstraints();
		gbc_textField_pic.insets = new Insets(0, 0, 5, 0);
		gbc_textField_pic.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_pic.gridx = 1;
		gbc_textField_pic.gridy = 4;
		add(textField_pic, gbc_textField_pic);
		textField_pic.setColumns(10);
		
		btnCreate = new JButton("Create");
		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.gridx = 1;
		gbc_btnCreate.gridy = 6;
		gbc_btnCreate.weighty=1.0;
		add(btnCreate, gbc_btnCreate);
		
		

	}

}
