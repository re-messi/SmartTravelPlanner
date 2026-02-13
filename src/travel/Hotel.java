package travel;

public class Hotel extends Accommodation {

	@Override
	public Accommodation copy() {
		return new Hotel(this);
	}
	
}
