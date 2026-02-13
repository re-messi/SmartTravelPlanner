package travel;

public class Flight extends Transportation {

	
	@Override
	public Transportation copy() {
		return new Flight(this);
	}
	
}
