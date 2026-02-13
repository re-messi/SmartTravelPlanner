package travel;

public class Hostel extends Accommodation {

	@Override
	public Accommodation copy() {
		return new Hostel(this);
	}
	
}
