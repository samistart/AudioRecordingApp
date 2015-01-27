package pages;
import jComponents.MenuBar;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * <code>ShareTrack</code> creates a dummy URL to mock sharable link feature.
 * not in currently in use due to refactoring.
 * @author Pietro Passarelli 
 *
 */
public class ShareTrack extends Page {
	private JTextField emailField;
	
	/**
	 * default constructor
	 */
	public ShareTrack(){
		MenuBar menuBar = new MenuBar("user");
		add(menuBar);

		JPanel shareTrackPanel = new JPanel();
		shareTrackPanel.setLayout(null);
		getRootPane().add(shareTrackPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Or send link by e-mail to:");
		lblNewLabel.setBounds(92, 186, 294, 16);
		shareTrackPanel.add(lblNewLabel);
		
		JTextField uRLTextField = new JTextField();
		uRLTextField.setText("Http://audava.com/xDj58xc");
		uRLTextField.setBounds(154, 116, 223, 28);
		uRLTextField.setEditable(false);
		shareTrackPanel.add(uRLTextField);
		
		JLabel lblTrackUrl = new JLabel("Track URL:");
		lblTrackUrl.setBounds(83, 122, 74, 16);
		shareTrackPanel.add(lblTrackUrl);
		
		emailField = new JTextField();
		emailField.setText("john@email.com");
		emailField.setBounds(144, 201, 242, 28);
		shareTrackPanel.add(emailField);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setBounds(92, 241, 294, 16);
		shareTrackPanel.add(lblMessage);
		
		JButton btnSend = new JButton("Send");
		btnSend.setBounds(260, 405, 117, 29);
		shareTrackPanel.add(btnSend);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(102, 405, 117, 29);
		shareTrackPanel.add(btnCancel);
		
		JTextArea messageTextArea = new JTextArea();
		messageTextArea.setText("Hi John, \n Here is the track I was telling you about. \n Enjoy! \n\n B");
		messageTextArea.setBounds(92, 269, 285, 124);
		shareTrackPanel.add(messageTextArea);

		uRLTextField.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String urlPrefix ="Http://aduva.com/";
				String  urlGenerated= "5uXgH74";
				uRLTextField.setText(urlPrefix+urlGenerated);
				
			};
		});
	}
}
