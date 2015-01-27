package pages;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import utilities.HTMLReader;

/**
 * AboutUs page utilizing the HTMLReader to display a pre-written HTML file.
 * 
 * @author Axel Striesow
 */
public class AboutUsPage extends Page {

	public AboutUsPage(){
		
		setLayout(null);
		
		String htmlPath = System.getProperty("user.dir")+"/audava/html/" + "AboutUs.html";
		
		BufferedImage imageImran = null;
		 try {
			 imageImran = ImageIO.read(getClass().getResource("/duke-java.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedImage imageUsman = null;
		 try {
			 imageUsman = ImageIO.read(getClass().getResource("/duke-java.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblAboutUs = new JLabel(HTMLReader.read(htmlPath));
		lblAboutUs.setBounds(39, 41, 295, 450);
		this.add(lblAboutUs);
		
		JLabel imranPicture = new JLabel("Imran Pic");
		imranPicture.setIcon(new ImageIcon(imageImran));
		imranPicture.setBounds(471, 37, 189, 150);
		add(imranPicture);
		
		JLabel usmanPicture = new JLabel("Usman Pic");
		usmanPicture.setIcon(new ImageIcon(imageUsman));
		usmanPicture.setBounds(465, 220, 195, 132);
		add(usmanPicture);
		
	}
}
