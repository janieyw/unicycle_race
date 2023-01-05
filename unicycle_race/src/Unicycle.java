import java.awt.*;
import java.awt.geom.*;

/**
 * Represents a unicycle, which can be drawn and moved as a MoveableObject.
 * 
 * @author YeongWoo Kim
 * @author John R. Kender
 * @author Cay Horstmann
 * 
 */
public class Unicycle implements MoveableObject {

	public Unicycle(int x, int y, int unit) {
		this.x = x;
		this.y = y;
		this.unit = unit; // unit is in pixels
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
		
		// seat
		int seatXUpLeft = x;
		int seatYUpLeft = y;
		int seatLength = unit * 2;
		int seatHeight = (int) (unit / 2.5);
		Rectangle2D.Double seat = new Rectangle2D.Double(seatXUpLeft,
														 seatYUpLeft, 
														 seatLength , 
														 seatHeight );
		int seatYBot = seatYUpLeft + seatHeight;
		
		// seat post
		int postXTop = xCenter + (unit / 5 * 2);
		int postYTop = seatYBot;
		int postLength = unit / 5;
		int postHeight =  unit * 2;
		Rectangle2D.Double post = new Rectangle2D.Double(postXTop  , 
														 postYTop  , 
														 postLength, 
														 postHeight);
		int postYBot = seatYBot + postHeight;
		
		// wheel, consists of outer ellipse and inner ellipse
		int out_wheelXUpLeft = postXTop - unit + (postLength / 2);
		int out_wheelYUpLeft = postYBot - unit;
		int out_wheelSize = unit * 2;
		Ellipse2D.Double out_wheel = new Ellipse2D.Double(out_wheelXUpLeft, 
													  	  out_wheelYUpLeft, 
													  	  out_wheelSize   , 
													  	  out_wheelSize   );
		int in_wheelXUpLeft = postXTop - unit / 2 + (postLength / 2);
		int in_wheelYUpLeft = out_wheelYUpLeft + unit / 2;
		int in_wheelSize = unit;
		Ellipse2D.Double in_wheel = new Ellipse2D.Double(in_wheelXUpLeft, 
													   	 in_wheelYUpLeft, 
													   	 in_wheelSize   , 
													   	 in_wheelSize   );
		
		GeneralPath unicycle = new GeneralPath();
		unicycle.append(seat, false);
		unicycle.append(post, false);
		unicycle.append(out_wheel, false);
		unicycle.append(in_wheel, false);
		
		// paint wheel dark gray
		g2D.setColor(Color.DARK_GRAY);
		g2D.fill(out_wheel);
		g2D.setColor(new Color(169, 169, 169));
		g2D.fill(in_wheel);
		
		// paint post light gray
		g2D.setColor(Color.LIGHT_GRAY);
		g2D.fill(post);
		
		// paint seat black
		g2D.setColor(Color.BLACK);
		g2D.fill(seat);
		
		// draw unicycle with black stroke
		g2D.draw(unicycle);
	}
	
	private int x;
	private int y;
	private int unit;
	
}
