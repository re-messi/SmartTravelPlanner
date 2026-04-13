//-----------------------------------------------------
// Assignment 2
// Written by: Rebecca Messier (40338041) and Taminda Ait Ouazzou (40344517)
//
// This class represents a hotel accommodation in the
// SmartTravel system. It extends Accommodation and
// includes the hotel star rating.
//-----------------------------------------------------
package travel;

import exceptions.InvalidAccommodationDataException;

public class Hotel extends Accommodation {

	private int starRating;

	// Parameterized constructor
	public Hotel(String name, String location, double pricePerNight, int starRating) throws InvalidAccommodationDataException {
		super(name, location, pricePerNight) ;
		setStarRating(starRating);
	}

	// parameterized constructor with accommodationID for loading from file
	public Hotel(String accommodationID, String name, String location, double pricePerNight, int starRating) throws InvalidAccommodationDataException {
    super(accommodationID, name, location, pricePerNight);
    setStarRating(starRating);
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
	public void setStarRating(int starRating) throws InvalidAccommodationDataException {
		if (starRating < 1 || starRating > 5) 
			throw new InvalidAccommodationDataException("Star rating must be 1-5.");
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
	public String toCsvRow() {
    	return "HOTEL;" + getAccommodationID() + ";" +
           	getName() + ";" +
           	getLocation() + ";" +
           	getPricePerNight() + ";" +
           	starRating;
	}

	public static Hotel fromCsvRow(String line) throws InvalidAccommodationDataException {
    String[] parts = line.split(";");

    return new Hotel(
        parts[1], parts[2], parts[3], 
        Double.parseDouble(parts[4]),
        Integer.parseInt(parts[5])
    );
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
