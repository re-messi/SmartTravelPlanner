//-----------------------------------------------------
// Assignment 1
// Written by: Rebecca Messier (40338041) and Taminda Ait Ouazzou (40344517)
//
// This class represents a hotel accommodation in the
// SmartTravel system. It extends Accommodation and
// includes the hotel star rating.
//-----------------------------------------------------
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
	// Cost calculation based on price per night and number of days
	public double calculateCost(int numberOfDays) {
		return getPricePerNight() * numberOfDays; // Cost based on price per night and number of days
	}

	@Override
	public Accommodation copy() {
    return new Hotel(this);
}

	@Override
	// Returns a string representation of the Hotel
	public String toString() {
		return "Hotel: " + 
			"\n" + super.toString() +
			"\nStar Rating: " + starRating;
	}

	@Override
	// Checks equality between Hotels
	public boolean equals(Object otherObject) {
		if (otherObject == null)
	        return false;

	    if (getClass() != otherObject.getClass())
	        return false;

		if (!super.equals(otherObject)) // compare parent attributes first
    		return false;

		Hotel other = (Hotel) otherObject;

	    	return this.starRating == other.starRating;
			
	}	//call the super first, then cast
}
