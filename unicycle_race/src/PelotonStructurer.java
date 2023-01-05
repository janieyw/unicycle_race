import java.awt.Color;
import java.awt.Dimension;
import java.util.Hashtable;

import javax.swing.*;

/**
 * Structurer for the unicycle race.
 * 
 * @author YeongWoo Kim
 *
 */
public class PelotonStructurer {

	public void createWindow() {
		JFrame frame = new JFrame("Unicycle Road Race");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Populator populator = new Populator();
		peloton = populator.fillPeloton();
		crowd = populator.fillCrowd();
		createSpeedSlider();
		createExcitementSlider();
		createUI(frame);
		frame.setLocationRelativeTo(null);
		frame.pack();
	    frame.setVisible(true);
	}
	
	public void createUI(final JFrame frame) {
		JPanel pelotonPanel = new JPanel();
		JPanel crowdPanel = new JPanel();
		JPanel container = new JPanel();
		
		pelotonPanel.setLayout(new BoxLayout(pelotonPanel, BoxLayout.Y_AXIS));
		
		// add peloton to pelotonPanel
		for (int i = 0; i < peloton.getSize(); i++)
			pelotonLabel[i] = new JLabel(new MyIcon(peloton.get(i), UNICYCLE_ICON_W, UNICYCLE_ICON_H));
		for (int i = 0; i < pelotonLabel.length; i++)
			pelotonPanel.add(pelotonLabel[i]);
		
		// add crowd to crowdPanel
		for (int i = 0; i < crowd.getSize(); i++)
			crowdLabel[i] = new JLabel(new MyIcon(crowd.get(i), PERSON_ICON_W, PERSON_ICON_H));
		for (int i = 0; i < crowdLabel.length; i++)
			crowdPanel.add(crowdLabel[i]);
		
		pelotonPanel.add(speedSlider);
		crowdPanel.add(excitementSlider);
		
		// add crowdPanel and pelotonPanel to container
		container.add(crowdPanel);
		container.add(pelotonPanel);
		
		// set race background color to grey
		pelotonPanel.setBackground(new Color(169, 169, 169));
		// set crowd background color to green
		crowdPanel.setBackground(new Color(107, 142, 100));
		
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		frame.getContentPane().add(container);
	}
	
	private static void createSpeedSlider() {
		speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 30, 0);
		
		// set tick spacing on slider
		speedSlider.setMinorTickSpacing(1);
		speedSlider.setMajorTickSpacing(6);
		speedSlider.setPaintTicks(true);
		
		// label the slider
		speedSlider.setBorder(BorderFactory.createTitledBorder("Speed Slider"));
		Hashtable<Integer, JLabel> labels = new Hashtable<>();
        labels.put(0, new JLabel("Stationary"));
        labels.put(15, new JLabel("Moderate"));
        labels.put(30, new JLabel("Fast"));
        speedSlider.setLabelTable(labels);
        speedSlider.setPaintLabels(true);
	}
	
	private static void createExcitementSlider() {
		excitementSlider = new JSlider(JSlider.VERTICAL, 0, 10, 5);
		excitementSlider.setPreferredSize(new Dimension(150, 100));
		
		// label the slider
		excitementSlider.setBorder(BorderFactory.createTitledBorder("Excitement Slider"));
		Hashtable<Integer, JLabel> labels = new Hashtable<>();
        labels.put(0, new JLabel("Bored"));
        labels.put(5, new JLabel("Excited"));
        labels.put(10, new JLabel("Crazy!"));
        excitementSlider.setLabelTable(labels);
        excitementSlider.setPaintLabels(true);
	}
	
	public static Peloton getPeloton() {
		return peloton;
	}
	public static Crowd getCrowd() {
		return crowd;
	}
	public static JSlider getSpeedSlider() {
		return speedSlider;
	}
	public static JSlider getExcitementSlider() {
		return excitementSlider;
	}
	public static JLabel getPelotonLabel(int i) {
		if (i > pelotonLabel.length)
			return null;
		return pelotonLabel[i];
	}
	public static JLabel getCrowdLabel(int i) {
		if (i > crowdLabel.length)
			return null;
		return crowdLabel[i];
	}
	
	private static Peloton peloton;
	private static Crowd crowd;
	private static JSlider speedSlider;
	private static JSlider excitementSlider;
	private static JLabel[] pelotonLabel = new JLabel[5];
	private static JLabel[] crowdLabel = new JLabel[15];
	private static final int UNICYCLE_ICON_W = 1430;
	private static final int UNICYCLE_ICON_H = 140;
	private static final int PERSON_ICON_W = 50;
	private static final int PERSON_ICON_H = 105;
	
}
