package travel;

public class Hotel extends Accommodation {

	private int starRating;

	// Default constructor
	public Hotel() {
		super();
		this.starRating = 0;
	}

	// Parameterized constructor
	public Hotel(String name, String location, double pricePerNight, int starRating) {
		super(name, location, pricePerNight);
		this.starRating = starRating;
	}

	// Copy constructor
	public Hotel(Hotel other) {
		super(other);
		this.starRating = other.starRating;
	}

	// Accessor
	public int getStarRating() {
		return starRating;
	}

	// Mutator
	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}

	@Override
	public double calculateCost(int numberOfDays) {
		return getPricePerNight() * numberOfDays; // Cost based on price per night and number of days
	}

	@Override
	public String toString() {
		return "Hotel: " + 
			"\n" + super.toString() +
			"\n Star Rating: " + starRating;
	}

	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == null)
	        return false;

	    if (getClass() != otherObject.getClass())
	        return false;

		Hotel other = (Hotel) otherObject;

	    	return super.equals(other) && this.starRating == other.starRating;
	
	}	
}
