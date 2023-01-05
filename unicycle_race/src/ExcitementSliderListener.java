import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Listener for excitementSlider
 * 
 * @author YeongWoo Kim
 * @author John R. Kender
 * @author Cay Horstmann
 * 
 */
public class ExcitementSliderListener {
	
	public void cheer() {
		final int DELAY = 200;
		PelotonStructurer.getExcitementSlider().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent ce) {
				excitement = PelotonStructurer.getExcitementSlider().getValue();
	        }
		});
		Timer myTimer = new Timer(DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				for (int i = 0; i < PelotonStructurer.getCrowd().getSize(); i++) {
					((Person) PelotonStructurer.getCrowd().get(i)).jitter(0, -excitement / 2);
					PelotonStructurer.getCrowdLabel(i).repaint();
				}
			}
		});
		myTimer.start();
	}
	
	static int excitement = 5;
	
}
