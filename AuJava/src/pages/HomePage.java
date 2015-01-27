package pages;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import utilities.HTMLReader;

/**
 * Homepage utilizing the HTMLReader to display a pre-written HTML file.
 * 
 * @author Axel Striesow
 */
public class HomePage extends Page {
	
	public HomePage() {
		
		setLayout(null);
		
		String htmlPath = System.getProperty("user.dir")+"/audava/html/" +"Homepage.html";
		
		BufferedImage imagePath = null;
		 try {
			imagePath = ImageIO.read(getClass().getResource("/duke-java.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblHome = new JLabel(HTMLReader.read(htmlPath));
		lblHome.setBounds(39, 41, 295, 400);
		this.add(lblHome);
		
		JLabel homeImg = new JLabel();
		homeImg.setIcon(new ImageIcon(imagePath));
		homeImg.setBounds(396, 80, 252, 252);
		this.add(homeImg);
		
	}
}
