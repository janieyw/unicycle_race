import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;

/**
 * Represents a person with a stick figure, which can be drawn and moved as a 
 * MoveableObject.
 * 
 * @author YeongWoo Kim
 * @author John R. Kender
 * @author Cay Horstmann
 * 
 */
public class Person implements MoveableObject {

	public Person(int x, int y, int unit, double angle) {
		this.x = x;
		this.y = y;
		this.unit = unit; // unit is in pixels
		this.angle = angle; // angle is in radians
	}

	@Override
	public void translate(int xChange, int yChange) {
		x += xChange;
		y += yChange;
	}
	
	@Override
	public void draw(Graphics2D g2D) {

		// basic x symmetry
		int xCenter = x + unit / 2;

		// head
		int headXUpLeft = x;
		int headYUpLeft = y;
		int headSize = unit;
		Ellipse2D.Double head = new Ellipse2D.Double(headXUpLeft, 
													 headYUpLeft, 
													 headSize   , 
													 headSize   );
		int headYBot = headYUpLeft + unit;

		// body
		int bodyXTop = xCenter;
		int bodyYTop = headYBot;
		int bodyXBot = xCenter;
		int bodyYBot = headYBot + (int) (BODYLENGTH * unit);
		Line2D.Double body = new Line2D.Double(bodyXTop, 
											   bodyYTop, 
											   bodyXBot, 
											   bodyYBot);

		// arms, assumed symmetric
		int armsXTop = xCenter;
		int armsYTop = bodyYTop + (int) (NECKLENGTH * unit);
		int armsXoffset =         (int) (ARMSLENGTH * unit * Math.sin(angle));
		int armsXLBot = armsXTop - armsXoffset;
		int armsXRBot = armsXTop + armsXoffset;
		int armsYBot = armsYTop + (int) (ARMSLENGTH * unit * Math.cos(angle));
		Line2D.Double armL = new Line2D.Double(armsXTop , 
											   armsYTop , 
											   armsXLBot, 
											   armsYBot );
		Line2D.Double armR = new Line2D.Double(armsXTop , 
											   armsYTop , 
											   armsXRBot, 
											   armsYBot );

		// legs, assumed symmetric
		int legsXTop = xCenter;
		int legsYTop = bodyYBot;
		int legsXoffset =         (int) (LEGSLENGTH * unit * Math.sin(angle));
		int legsXLBot = legsXTop - legsXoffset;
		int legsXRBot = legsXTop + legsXoffset;
		int legsYBot = legsYTop + (int) (LEGSLENGTH * unit * Math.cos(angle));
		Line2D.Double legL = new Line2D.Double(legsXTop , 
											   legsYTop ,
											   legsXLBot, 
											   legsYBot );
		Line2D.Double legR = new Line2D.Double(legsXTop , 
											   legsYTop , 
											   legsXRBot, 
											   legsYBot );

		// aggregate body, arms, legs, using one GeneralPath
		GeneralPath torso = new GeneralPath();
		torso.append(body, false);
		torso.append(armL, false);
		torso.append(armR, false);
		torso.append(legL, false);
		torso.append(legR, false);

		// fill head, then draw person
		g2D.fill(head);
		g2D.draw(torso);
	}
	
	/**
	 * Produces "jitter" effect on the object; the frequency and intensity of
	 * the motion depends on argument.
	 * 
	 * @param xChange change in person's x-coordinate
	 * @param yChange change in person's y-coordinate
	 */
	public void jitter(int xChange, int yChange) {
		x += xChange;
		
		if (yChange == 0) {
			flag = 1;
		}
		if (y < -20) {
			flag = 0;
		}
		if (y > 10) {
			flag = 1;
		}
		if (flag == 1) {
			y += yChange;
		} 
		else {
			y -= yChange;
		}
	}
	
	private int x;
	private int y;
	private int unit;
	private int flag = -1;
	private double angle;
	private final double BODYLENGTH = 2.0;
	private final double NECKLENGTH = 0.3;
	private final double ARMSLENGTH = 2.0;
	private final double LEGSLENGTH = 2.2;
	
}
