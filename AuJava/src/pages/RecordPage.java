package pages;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Timer;

import albumHierarchy.Track;
import sound.Recorder;

/**
 * <code>RecordPage</code> to record an audio track, with record button and stop button.
 * includes a time for measuring recording time, and give feedback to user that audio is being recorded.
 * @author Pietro Passarelli
 *
 */
public class RecordPage extends Page{
	
	/** measuring recording time, and give feedback to user that audio is being recorded */
	long startTime = System.currentTimeMillis();

	public static Recorder rec ;
	
	private JTextField timerTextField;
	
	private static Calendar cal;
	private static Date timeNow ;
	private static SimpleDateFormat ft ;
	static String outputFilename;

	/**
	 * default constructor	
	 */
	public RecordPage(){
		/** initialises GUI */
		
		BufferedImage recImg = null;
		 try {
			 recImg = ImageIO.read(getClass().getResource("/rec.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 BufferedImage stopImg = null;
		 try {
			 stopImg = ImageIO.read(getClass().getResource("/stop.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ImageIcon  recButtonIcon = new ImageIcon(recImg);
		ImageIcon  stopButtonIcon = new ImageIcon(stopImg);
		setLayout(null);

		JButton btnRec = new JButton(recButtonIcon);
		btnRec.setBounds(36, 58, 258, 260);
		add(btnRec);

		JButton btnStop = new JButton(stopButtonIcon);
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStop.setBounds(365, 58, 258, 260);
		add(btnStop);

		btnRec.setEnabled(true);
		btnStop.setEnabled(false);

		timerTextField = new JTextField();
		timerTextField.setBounds(264, 414, 134, 28);
		add(timerTextField);
		timerTextField.setEditable(false);
		timerTextField.setColumns(10);
		
		/** timer action listener */
		ActionListener actListner = new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent event) {

				long elapsedTime = System.currentTimeMillis() - startTime;

				long elapsedSeconds = elapsedTime / 1000;
				long elapsedMinutes = elapsedSeconds / 60;
				timerTextField.setText(Long.toString(elapsedMinutes)+":"+Long.toString(elapsedSeconds));
			}

		};
		/** Timer */
		Timer timer = new Timer(500, actListner);
		
		/** record button action listener */
		btnRec.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Track.loadTracks();
				/** adds date to filename to make them all different */
				 Calendar cal = Calendar.getInstance();
				 Date timeNow = cal.getTime();
				 SimpleDateFormat ft = new SimpleDateFormat ("HH.mm.ss_dd:MM:yyyy");
			
				btnRec.setEnabled(false);
				btnStop.setEnabled(true);
				/* starts recording */
				outputFilename = ft.format(timeNow) +"_AuJava"+".wav" ;
				rec = new sound.Recorder(outputFilename);
				
				rec.startRecording();

				timer.start();
			}
		});

		/** stop button action listener */
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnRec.setEnabled(true);
				btnStop.setEnabled(false);
				rec.stopRecording();
				/* stops timer*/
				timer.stop();
				/** creating a track object with the audio file name constructor*/
				Track recordedTrack = new Track(outputFilename);
				/** creating track page that takes the newly recorded track in as an argument*/
				 IndividualTrackPage trackCard = new IndividualTrackPage(recordedTrack);
				 /** adding track page to cards group*/
				 ApplicationView.cards.add(ApplicationView.TRACKPAGE, trackCard);
				 /** defining card layout var card layout from TrackView */
				 CardLayout cardLayout = (CardLayout) ApplicationView.cards.getLayout();
				 /** show/changes to the newly created Track page*/
				 cardLayout.show( ApplicationView.cards, ApplicationView.TRACKPAGE);	
				 Track.saveTracks();
				 TracksPage tracksCard = new TracksPage(Track.getAllTracks());
				 ApplicationView.cards.add(ApplicationView.TRACKSPAGE, tracksCard);
			}
		});
	}
}