import java.awt.Graphics2D;

/**
 * Interface for a MoveableObject.
 * Specifies a method to draw it, and a method to move it. 
 * 
 * @author John R. Kender
 * @author Cay Horstmann
 * 
 */
public interface MoveableObject {
	
	void translate(int xChange, int yChange);
	void draw(Graphics2D g2D);
	
}