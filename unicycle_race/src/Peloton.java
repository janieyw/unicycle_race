import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Aggregate of Unicycles; implements composite pattern. 
 * 
 * @author YeongWoo Kim
 *
 */
public class Peloton implements MoveableObject {

	Peloton() {
		peloton = new ArrayList<MoveableObject>();
	}
	
	@Override
	public void translate(int xChange, int yChange) {
		for (MoveableObject u : peloton) {
			u.translate(xChange, yChange);
		}
	}

	@Override
	public void draw(Graphics2D g2d) {
		for (MoveableObject u : peloton) {
			u.draw(g2d);
		}
	}

	public void add(MoveableObject unicycle) {
		peloton.add(unicycle);
	}
	
	public MoveableObject get(int index) {
		return peloton.get(index);
	}
	
	public int getSize() {
		return peloton.size();
	}
	
	private ArrayList<MoveableObject> peloton;
	
}
