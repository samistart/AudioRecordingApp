package utilities;
/**
 * Timer to visualise record time in record page.
 * @author Pietro Passarelli 
 *
 */
public class Stopwatch {

	private long start;
	private String label;
	
	/**
	 * starts timers
	 * @param label
	 * @return
	 */
	public Stopwatch start(String label) {
		this.start = System.currentTimeMillis();
		this.label = label;
		return this;
	}

	/**
	 * stop timer
	 * @return
	 */
	public long stop() {
		long end = System.currentTimeMillis();
		long result = end - start;
		System.out.println(label + ": " + result + " milliseconds");
		return result;
	}
	
}
