/**
 * Sizes of unicyles.
 * 
 * @author YeongWoo Kim
 * 
 */
public enum UnicycleSize {
	
	XSMALL, SMALL, MEDIUM, LARGE, XLARGE;
	
	/**
	 * Returns an int value that corresponds to the enum. Returns 30 that 
	 * corresponds to MEIDUM, if an invalid value gets passed as argument.
	 * 
	 * @param UnicycleSize enum
	 * @return int value of size
	 */
	public int getSize(UnicycleSize size) {
		switch(size) {
			case XSMALL:
				return 20;
			case SMALL:
				return 25;
			case MEDIUM:
				return 30;
			case LARGE:
				return 35;
			case XLARGE:
				return 40;
		}
		// return what corresponds to MEDIUM if else.
		return 30;
	}
	
}
