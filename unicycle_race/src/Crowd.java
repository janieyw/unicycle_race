import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Aggregate of Persons; implements composite pattern.
 * 
 * @author YeongWoo Kim
 *
 */
public class Crowd implements MoveableObject {

	Crowd(int unit) {
		crowd = new ArrayList<MoveableObject>();
		
		Person p1 = new Person(10, 4, 17, 0.5);
		Person p2 = new Person(10, 5, 18, 0.4);
		Person p3 = new Person(10, 3, 17, 0.6);
		
		for (int i = 0; i < unit; i++) {
			crowd.add(p1);
			crowd.add(p2);
			crowd.add(p3);
		}
	}
	
	@Override
	public void translate(int xChange, int yChange) {
		for (MoveableObject p : crowd) {
			p.translate(xChange, yChange);
		}
	}

	@Override
	public void draw(Graphics2D g2d) {
		for (MoveableObject p : crowd) {
			p.draw(g2d);
		}
	}
	
	public MoveableObject get(int index) {
		return crowd.get(index);
	}
	
	public int getSize() {
		return crowd.size();
	}
	
	private ArrayList<MoveableObject> crowd;
	
}
