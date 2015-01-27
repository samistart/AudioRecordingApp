package jComponents;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import pages.ApplicationView;

/**
 * The <code>MenuBar</code> class provides basic navigation for the 
 * AuJava application and is a common component on every page of the app.
 * 
 * @author Axel Striesow
 */
public class MenuBar extends JMenuBar{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String username = "Username"; 
	
	/** define card layout local var, calling tack view card layout */
	private static CardLayout cardLayout = (CardLayout) ApplicationView.cards.getLayout();
	
	/**
	 * Cascading constructors. If MenuBar is called without a username the default "Username" is used.
	 * This is not used in the current application, because the application starts without sign up/in.
	 */
	public MenuBar () {
		this(username);
	}
	
	/**
	 * Populates the <code>Menubar</code>
	 * @param username	Unused, because application starts without sign up/in.
	 */
	public MenuBar (String username) {
		
		this.username = username;
		
		JMenuItem audava = new JMenuItem("AUDAVA");
		JMenuItem record = new JMenuItem("Record");
		JMenuItem tracks = new JMenuItem("Tracks");
		JMenuItem aboutUs = new JMenuItem("AboutUs");
   
		/* Add all MenuItems to the Menubar. */
		this.add(audava);
		this.add(record);
		this.add(tracks);
		this.add(aboutUs);
	
		record.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				/* Brings the clicked card to the front in the GUI. */
		        cardLayout.show( ApplicationView.cards, ApplicationView.RECORDPAGE);
			} 
		});
		
		tracks.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				/* Brings the clicked card to the front in the GUI. */
		        cardLayout.show( ApplicationView.cards, ApplicationView.TRACKSPAGE);
			} 
		});	
		
		audava.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				/* Brings the clicked card to the front in the GUI. */
		        cardLayout.show( ApplicationView.cards, ApplicationView.HOMEPAGE);	
			} 
			});	
		
		aboutUs.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				/* Brings the clicked card to the front in the GUI. */
		        cardLayout.show( ApplicationView.cards, ApplicationView.ABOUTUSPAGE);	
			} 
		});
		
	}
	
}