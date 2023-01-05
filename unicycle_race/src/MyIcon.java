import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Icon;

/**
 * Implementation of Icon for drawing MoveableObjects.
 * 
 * @author John R. Kender
 * @author Cay Horstman
 * 
 */
public class MyIcon implements Icon {
	
	/**
	 * Constructs a MyIcon using MoveableObject
	 * @param obj
	 * @param w
	 * @param h
	 */
	public MyIcon(MoveableObject obj, int w, int h) {
		this.obj = obj;
		this.w = w;
		this.h = h;
	}
	
	@Override
	public int getIconWidth() {
		return w;
	}
	
	@Override
	public int getIconHeight() {
		return h;
	}
	
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2D = (Graphics2D) g;
		obj.draw(g2D);
	}
	
	private int w;
	private int h;
	private MoveableObject obj;
	
}
 