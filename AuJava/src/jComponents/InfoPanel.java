package jComponents;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import albumHierarchy.Track;

/**
 * <code>InfoPanel</code> class JPanel, displays <code>title</code>, <code>description</code> and <code>image</code> for an album or track object.
 * @author Pietro Passarelli  
 *
 */
public class InfoPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * default constructor 
	 * @param title
	 * @param description
	 * @param albumImage
	 */
	public InfoPanel(String title, String description, String albumImage) {
		populatePanel(title,description,albumImage);
	}
	
	/**
	 * adds following params and creates <code>InfoPanel</code>
	 * @param title
	 * @param description
	 * @param albumImage
	 */
	private void populatePanel(String title, String description,String albumImage){
		/** album title */
		TextArea albumTitleLabel = new TextArea(title,1,1, TextArea.SCROLLBARS_NONE);
		albumTitleLabel.setBounds(59, 10, 215, 29);
		albumTitleLabel.setEditable(false);
		/** album description */
		TextArea albumDescriptionLabel = new TextArea(description,1,10,TextArea.SCROLLBARS_NONE);
		albumDescriptionLabel.setEditable(false);
		albumDescriptionLabel.setBounds(20, 80, 256, 198);
		
		setLayout(null);
		add(albumTitleLabel);
		add(albumDescriptionLabel);
		/** album title heading */
		JLabel lblAlbumTitle = new JLabel("<html><h3>Title</h3></html>");
		lblAlbumTitle.setBounds(20, 23, 112, 16);
		add(lblAlbumTitle);
		
		/** album description heading */
		JLabel albulmDescription = new JLabel("<html><h4>Description</h4></html>");
		albulmDescription.setBounds(20, 58, 131, 16);
		add(albulmDescription);
		/** album image */
		ImageIcon  albumPictureIcon = new ImageIcon(albumImage);
		JLabel alblAlbumImage = new JLabel(albumPictureIcon);
		alblAlbumImage.setBounds(298, 10, 196, 136);
		add(alblAlbumImage);
		
		/** edit and save buttons*/
		JButton btnEdit = new JButton("edit");
		btnEdit.setBounds(298, 225, 75, 29);
		add(btnEdit);
		
		JButton btnSave = new JButton("save");
		btnSave.setBounds(385, 225, 75, 29);
		add(btnSave);
		
		btnSave.setEnabled(false);
		btnEdit.setEnabled(true);
		
		/** action listeners for edit button*/
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEdit.setEnabled(false);
				btnSave.setEnabled(true);
				albumDescriptionLabel.setEditable(true);
				albumTitleLabel.setEditable(true);
			}
		});
		
		/** action listeners for edit button*/
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEdit.setEnabled(true);
				btnSave.setEnabled(false);
				albumDescriptionLabel.setEditable(false);
				albumTitleLabel.setEditable(false);
				Track.saveTracks();
				Track.loadTracks();
			}
		});		
	}
}
