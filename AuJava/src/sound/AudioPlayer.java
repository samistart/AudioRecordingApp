package sound;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Audioplayer with minimal GUI for Playing and Stopping an audio file.
 * 
 * Resources used were: 
 * <a href="https://docs.oracle.com/javase/tutorial/sound/playing.html">Oracle Sound Tutorial</a> 
 * <a href="http://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java">http://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java</a> 
 * 
 * @author Axel Striesow
 */
public class AudioPlayer extends JPanel {
	
	private final String AUDIOPATH = System.getProperty("user.dir")+"/audava/audio/" ;
	private Clip clip = null;
	
	/**
	 * 
	 * @param filename  needs to include the file extension: e.g. name.wav
	 */
	public AudioPlayer(String filename){
		
		this.setSize(360, 107);
		this.setLayout(null);
		
		/* Buttons */
		JButton btnStop = new JButton("Stop");
		JButton btnPlay = new JButton("Play");
		btnPlay.setEnabled(true);
		btnStop.setEnabled(false);
		
		/* Play Button */
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnPlay.setEnabled(false);
				btnStop.setEnabled(true);
				try {
					File file = new File(AUDIOPATH+filename);
					if (file.exists()) {
						 AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
					       clip = AudioSystem.getClip();
					       clip.open(inputStream);	
					       clip.setFramePosition(0);
					       clip.start(); 
					} else { System.out.println("file does not exist.");}
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getMessage());
				}
			}
		});
		btnPlay.setBounds(49, 39, 117, 29);
		this.add(btnPlay);
		
		/* Stop Button */
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnPlay.setEnabled(true);
				btnStop.setEnabled(false);
				clip.setFramePosition(0);
				clip.stop();
			}
		});
		btnStop.setBounds(191, 39, 117, 29);
		this.add(btnStop);
		
		/* not in use due to scope reduction.
		JButton btnPause = new JButton("Pause");
		btnPause.setBounds(40, 121, 117, 29);
		this.add(btnPause);
		*/
	}
	
}
