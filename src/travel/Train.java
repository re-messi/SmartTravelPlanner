package travel;

public class Train extends Transportation {

	@Override
	public Transportation copy() {
		return new Train(this);
	}
	
}
