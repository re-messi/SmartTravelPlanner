package travel;

public class Hostel extends Accommodation {


	// Attributes
	private int bedsPerRoom;


	// 




	@Override
	public Accommodation copy() {
		return new Hostel(this);
	}
	
}
