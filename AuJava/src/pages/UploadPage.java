/**
 * 
 */
package pages;

import javax.swing.JLabel;

/**
 * <code>UploadPage</code> to upload audio file.
 * not in use due to refactoring.
 * 
 * @author Pietro Passarelli 
 *
 */
public class UploadPage extends Page {
	
	/**
	 * default constructor.
	 */
	public UploadPage(){
		setLayout(null);
		JLabel uploadLabel = new JLabel("Upload Label");
		uploadLabel.setBounds(206, 94, 137, 140);
		this.add(uploadLabel);
	}
	
}
