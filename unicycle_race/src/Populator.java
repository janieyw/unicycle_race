/**
 * Populator for peloton and crowd that peloton with unicycles and crowd 
 * with people.
 * 
 * @author YeongWoo Kim
 *
 */
public class Populator {
	
	public Peloton fillPeloton() {
		peloton = new Peloton();
		
		for (UnicycleSize size : UnicycleSize.values())
			peloton.add(new Unicycle(0, 0, size.getSize(size)));
		return peloton;
	}
	
	public Crowd fillCrowd() {
		crowd = new Crowd(5);
		return crowd;
	}
	
	public Peloton peloton;
	public Crowd crowd;
	
}
