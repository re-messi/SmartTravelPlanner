package travel;

public class Hostel extends Accommodation {


	// Attributes
	private int sharedBedsPerRoom;

	// Default constructor
	public Hostel() {
		super();
		this.sharedBedsPerRoom = 0;
	}

	// Parameterized constructor
	public Hostel(String name, String location, double pricePerNight, int sharedBedsPerRoom) {
		super(name, location, pricePerNight);
		this.sharedBedsPerRoom = sharedBedsPerRoom;
	}

	// Copy constructor
	public Hostel(Hostel other) {
		super(other);
		this.sharedBedsPerRoom = other.sharedBedsPerRoom;
	}

	// Accessor
	public int getSharedBedsPerRoom() {
		return sharedBedsPerRoom;
	}

	// Mutator
	public void setSharedBedsPerRoom(int sharedBedsPerRoom) {
		this.sharedBedsPerRoom = sharedBedsPerRoom;
	}

	@Override
	public double calculateCost(int numberOfDays) {
		return getPricePerNight() * numberOfDays; // Cost based on price per night and number of days
	}

	@Override
	public String toString() {
		return "Hostel: " + 
			"\n" + super.toString() +
			"\n Shared Beds per Room: " + sharedBedsPerRoom;
	}

	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == null)
	        return false;

	    if (getClass() != otherObject.getClass())
				return false;

		Hostel other = (Hostel) otherObject;

	    	return super.equals(other) && this.sharedBedsPerRoom == other.sharedBedsPerRoom;

	}




	
}
