package travel;

public class Bus extends Transportation {

	@Override
	public Transportation copy() {
		return new Bus(this);
	}
	
	
}
