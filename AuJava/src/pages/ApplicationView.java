package pages;

import jComponents.MenuBar;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * <code>TrackView</code> contains <code>createAndShowGUI</code> method to initialise GUI 
 * and other creates cards for card layout out of pages.
 * @author Pietro Passarelli 
 *
 */
public class ApplicationView {
	
	public static JPanel cards;
	public static CardLayout cardLayout;
	public static JPanel containerPanel = new JPanel();
	/** declaring variable Strings to name the cards */
	public final static String HOMEPAGE = "AuJava";
	public final static String ABOUTUSPAGE = "About Us";
	public final static String RECORDPAGE = "Record";
	public final static String TRACKSPAGE = "Tracks";
	public final static String TRACKPAGE = "Track";
    
    /** declaring var width of the app */
    final static int extraWindowWidth = 700 ;
    final static int extraWindowHeight = 600;
   
    /** creating cards of pages  */
    public static Component addComponentToPane() {
       
    	cards = new JPanel();
    	cards.setLayout(new CardLayout());
    	
        /** Home Page*/
        HomePage homeCard = new HomePage() {
            /** Make the panel wider than it really needs to be, so
            	that the window is wide enough for the tabs to stay
            	in one row. */
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                size.height += extraWindowHeight;
                return size;
            }
        };
        /** about us page*/
        AboutUsPage aboutUsCard = new AboutUsPage(){
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                size.height += extraWindowHeight;
                return size;
            }
        };
        
        /** Record Page */
        RecordPage recordCard = new RecordPage() 
        {
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                size.height += extraWindowHeight;
                return size;
            }
        };
     
        /** Tracks page*/
        TracksPage tracksCard = new TracksPage();
        
        /** add to cards*/
        
        cards.add(HOMEPAGE, homeCard);
        cards.add( RECORDPAGE, recordCard);
        cards.add(TRACKSPAGE, tracksCard);
        cards.add(ABOUTUSPAGE, aboutUsCard);
        
        /** adding cards from card layout to centre element of panel*/
//        pane.add(cards);
//        pane.setVisible(true);
           
        /** card layout showing home page*/
        CardLayout cardLayout = (CardLayout) cards.getLayout();
        cardLayout.show(cards, HOMEPAGE);
		return cards;    
    }

	/**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    public static void createAndShowGUI() {
    	JFrame frame = new JFrame("AuJava - Demo");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
       	frame.add(addComponentToPane());
    	 /** adding menu bar, to north element of panel*/
        MenuBar menu = new MenuBar();
        frame.add(menu, BorderLayout.NORTH);
         /** Displays the window. */
         frame.pack();
         frame.setVisible(true);        
    }
}
