import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Listener for speedSlider.
 * 
 * @author YeongWoo Kim
 * @author John R. Kender
 * @author Cay horstmann 
 * 								 
 */
public class SpeedSliderListener {
	
	public void startRace() {
		final int DELAY = 80;
		
		PelotonStructurer.getSpeedSlider().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent ce) {
				speed = PelotonStructurer.getSpeedSlider().getValue();
	        }
		});
		Timer myTimer = new Timer(DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				for (int i = 0; i < PelotonStructurer.getPeloton().getSize(); i++) {
					PelotonStructurer.getPeloton().get(i).translate(speed, 0);
					PelotonStructurer.getPelotonLabel(i).repaint();
				}
			}
		});
		myTimer.start();
	}
	
	private int speed;
	
}
