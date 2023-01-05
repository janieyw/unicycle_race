/**
 * Runner for the unicycle race.
 * 
 * @author YeongWoo Kim
 *
 */
public class Runner {
	
	public static void main(String[] args) {
		PelotonStructurer structurer = new PelotonStructurer();
		ExcitementSliderListener eListener = new ExcitementSliderListener();
		SpeedSliderListener sListener = new SpeedSliderListener();
		
		structurer.createWindow();
		eListener.cheer();
		sListener.startRace();
	}
	
}
